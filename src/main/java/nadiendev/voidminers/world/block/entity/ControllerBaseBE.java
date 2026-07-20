package nadiendev.voidminers.world.block.entity;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.init.ModItems;
import nadiendev.voidminers.world.block.ModifierBlock;
import nadiendev.voidminers.config.ConfigLoader;
import nadiendev.voidminers.common.energy.ModEnergyStorage;
import nadiendev.voidminers.init.ModBlockEntities;
import nadiendev.voidminers.server.recipe.MinerRecipe;
import nadiendev.voidminers.server.recipe.WeightedStack;
import nadiendev.voidminers.util.ListUtil;
import nadiendev.voidminers.util.MiscUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.mangorage.mangomultiblock.core.manager.MultiBlockManager;
import org.mangorage.mangomultiblock.core.manager.RegisteredMultiBlockPattern;
import org.mangorage.mangomultiblock.core.misc.MultiblockMatchResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerBaseBE extends BlockEntity {

    public static final int ENERGY_CAPACITY = 1000000;
    private static final int BASE_OUTPUT_SLOTS = 9;
    private int upgradeTier = 0;

    private ModEnergyStorage energyHandler = new ModEnergyStorage(ENERGY_CAPACITY, ENERGY_CAPACITY, 0, 0);
    private ItemStackHandler itemHandler = createItemHandler();

    private final ConfigLoader cfg =  ConfigLoader.getInstance();

    public boolean foundStructure = false;
    private int progress = 0;

    public boolean showStructure = false;

    private final Map<BlockInWorld, ConfigLoader.ModifierConfig> modifierMap = new HashMap<>();

    private ResourceLocation structure;
    private String name;

    public boolean canSeeBedrockOrVoid = false;
    public boolean enoughPower = false;
    public int missingPower = 0; // TODO use this

    private HaltReason haltReason = HaltReason.NONE;

    private static ItemStackHandler createItemHandler() {
        return new ItemStackHandler(BASE_OUTPUT_SLOTS) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
            }
        };
    }

    private void recalculateStorageFromUpgrades() {
        int tier = this.upgradeTier;

        int extraSlots = 0;
        if (tier == 3) {
            extraSlots = cfg.UPGRADE_T3_SLOTS;
        } else if (tier == 2) {
            extraSlots = cfg.UPGRADE_T2_SLOTS;
        } else if (tier == 1) {
            extraSlots = cfg.UPGRADE_T1_SLOTS;
        }

        int desiredSlots = BASE_OUTPUT_SLOTS + extraSlots;
        if (desiredSlots != itemHandler.getSlots()) {
            replaceItemHandler(desiredSlots);
        }
    }

    private void replaceItemHandler(int newSlots) {
        ItemStackHandler newHandler = new ItemStackHandler(newSlots) {
            @Override
            protected void onContentsChanged(int slot) {
                super.onContentsChanged(slot);
                if (ControllerBaseBE.this.level != null) {
                    ControllerBaseBE.this.level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
            }
        };

        // Copy existing stacks into new handler
        int copySlots = Math.min(itemHandler.getSlots(), newHandler.getSlots());
        for (int i = 0; i < copySlots; i++) {
            newHandler.setStackInSlot(i, itemHandler.getStackInSlot(i));
        }

        this.itemHandler = newHandler;
    }
    
    public ControllerBaseBE(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CONTROLLER_BASE_BE.get(), pPos, pBlockState);
    }
    
    public ControllerBaseBE(BlockEntityType<?> type, BlockPos pPos, BlockState pBlockState) {
        super(type, pPos, pBlockState);
    }

    public void setup(ResourceLocation structure, String name) {
        this.structure = structure;
        this.name = name;
        setupEnergyStorage();
    }

    public void setupEnergyStorage() {
        int storage = cfg.getMinerConfig(name).energyStorage();

        if (!cfg.ALLOW_NO_ENERGY_MINERS && storage <= 0) storage = ENERGY_CAPACITY;

        int currentEnergy = energyHandler != null ? energyHandler.getEnergyStored() : 0;

        if (energyHandler != null) {
            energyHandler.setCapacity(storage);
            if (currentEnergy > storage) {
                energyHandler.setEnergy(storage);
            }
        } else {
            energyHandler = new ModEnergyStorage(storage, storage, 0, currentEnergy);
        }
    }

    public int getBeamColor() {
        return MiscUtil.colorMap.getOrDefault(structure.getPath(), 0xFFFFFFFF);
    }

    public List<Component> getInteractionTooltip() {
        List<Component> toReturn = new ArrayList<>();

        switch (haltReason) {
            case NONE:
                // TODO add chat message builder
                return List.of(Component.translatable("tooltip." + VoidMiners.MODID + ".controller.enoughRF"),
                        Component.translatable("tooltip." + VoidMiners.MODID + ".controller.energy", getRfTick()),
                        Component.translatable("tooltip." + VoidMiners.MODID + ".controller.duration", getMaxProgress()));
            case NO_RECIPES_IN_DIMENSION:
                return List.of(
                        Component.translatable("tooltip." + VoidMiners.MODID + ".controller.halt_reason.dimension_not_ok").withStyle(ChatFormatting.YELLOW)
                );
            case STRUCTURE_NOT_FOUND: {
                toReturn.add(Component.translatable("tooltip." + VoidMiners.MODID + ".controller.halt_reason.structure_not_found_1").withStyle(ChatFormatting.YELLOW));

                if (structure != null && MiscUtil.structureMap.containsKey(structure.toString())) {
                    toReturn.add(Component.translatable("tooltip." + VoidMiners.MODID + ".controller.halt_reason.structure_not_found_2").withStyle(ChatFormatting.YELLOW));
                    MiscUtil.getNeededBlocks(MiscUtil.structureMap.get(structure.toString())).forEach((string, integer) -> {
                        toReturn.add(Component.literal(string + ": " + integer));
                    });
                }
                break;
            }
            case TOO_MUCH_ITEM_MULTIPLIER:
                return List.of(
                        Component.translatable("tooltip." + VoidMiners.MODID + ".controller.halt_reason.too_much_item_multiplier").withStyle(ChatFormatting.YELLOW)
                );
            case NOT_ENOUGH_EMPTY_SLOTS:
                return List.of(
                        Component.translatable("tooltip." + VoidMiners.MODID + ".controller.halt_reason.not_enough_empty_slots").withStyle(ChatFormatting.YELLOW)
                );
            case NO_BEDROCK_OR_VOID_VIEW:
                return List.of(
                        Component.translatable("tooltip." + VoidMiners.MODID + ".controller.halt_reason.no_bedrock_or_void_view").withStyle(ChatFormatting.YELLOW)
                );
        }

        return toReturn;
    }

    public void updateShowStructure() {
        showStructure = !showStructure;
        if (level != null) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);

        CompoundTag data = new CompoundTag();
        if (energyHandler != null) data.put("energy", energyHandler.serializeNBT(pRegistries));
        data.put("items", itemHandler.serializeNBT(pRegistries));
        data.putInt("upgradeTier", this.upgradeTier);
        data.putInt("progress", this.progress);
        if (name != null) data.putString("name", this.name);
        if (structure != null) data.putString("structure", structure.toString());
        data.putBoolean("showStructure", showStructure);
        data.putBoolean("canSeeBedrockOrVoid", canSeeBedrockOrVoid);
        data.putBoolean("foundStructure", foundStructure);
        data.putBoolean("enoughPower", enoughPower);
        pTag.put(VoidMiners.MODID, data);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        CompoundTag data = pTag.getCompound(VoidMiners.MODID);
        if (data.isEmpty())
            return;

        if (data.contains("energy")) {
            energyHandler.deserializeNBT(pRegistries, data.get("energy"));
        }

        if (data.contains("items")) {
            itemHandler.deserializeNBT(pRegistries, data.getCompound("items"));
        }

        if (data.contains("upgradeTier")) {
            this.upgradeTier = data.getInt("upgradeTier");
        }

        if (data.contains("progress")) {
            progress = data.getInt("progress");
        }

        if (data.contains("name")) {
            name = data.getString("name");
        }

        if (data.contains("structure")) {
            structure = ResourceLocation.parse(data.getString("structure"));
        }

        if (data.contains("showStructure")) {
            showStructure = data.getBoolean("showStructure");
        }

        if (data.contains("canSeeBedrockOrVoid")) {
            canSeeBedrockOrVoid = data.getBoolean("canSeeBedrockOrVoid");
        }

        if (data.contains("foundStructure")) {
            foundStructure = data.getBoolean("foundStructure");
        }

        if (data.contains("enoughRF")) {
            enoughPower = data.getBoolean("enoughRF");
        }

        recalculateStorageFromUpgrades();
    }

    @Override
    public void onLoad() {
        super.onLoad();
        setupEnergyStorage();
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        CompoundTag tag = super.getUpdateTag(pRegistries);
        saveAdditional(tag, pRegistries);
        return tag;
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public void handleUpdateTag(CompoundTag tag, HolderLookup.Provider pRegistries) {
        super.handleUpdateTag(tag, pRegistries);
        this.loadAdditional(tag, pRegistries);
    }

    public ModEnergyStorage getEnergyStorage() {
        return energyHandler;
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public int getProgress() {
        return progress;
    }

    private long lastProcessedGameTime = Long.MIN_VALUE;

    public void tick(Level pLevel, BlockPos pPos, BlockState pState, ResourceLocation structure, String name) {
        if (level == null || level.isClientSide) return;

        if (!cfg.ALLOW_TICK_ACCELERATION_MINERS) {
            long gameTime = level.getGameTime();
            if (this.lastProcessedGameTime == gameTime) return;
            this.lastProcessedGameTime = gameTime;
        }

        // TODO check if this is laggy
        // Check that a recipe exists for the dimension
        if (allRecipes().isEmpty()) {
            haltReason = HaltReason.NO_RECIPES_IN_DIMENSION;
            return;
        }

        if(getStructure() == null) {
            setup(structure, name);
        }

        checkStructure(level, pPos);
        sync();

        if (!foundStructure) {
            haltReason = HaltReason.STRUCTURE_NOT_FOUND;
            return;
        }

        if (showStructure) {
            updateShowStructure();
        }

        int itemModMultMultiplier = getItemModifierMultiplier();

        if (!cfg.MINERS_FILL_ALL_SLOTS) {
            if (itemModMultMultiplier > itemHandler.getSlots() * 64) {
                haltReason = HaltReason.TOO_MUCH_ITEM_MULTIPLIER;
                return;
            }
            if(itemModMultMultiplier > getNumberOfEmptySlots() * 64) {
                haltReason = HaltReason.NOT_ENOUGH_EMPTY_SLOTS;
                return;
            }
        }

        if(isItemHandlerFull()) {
            haltReason = HaltReason.NOT_ENOUGH_EMPTY_SLOTS;
            return;
        }

        canSeeBedrockOrVoid = hasViewOnBedrockOrVoid(pPos);
        sync();

        if(!canSeeBedrockOrVoid) {
            haltReason = HaltReason.NO_BEDROCK_OR_VOID_VIEW;
            return;
        }

        int rfPerTick = getRfTick();

        enoughPower = rfPerTick <= energyHandler.getEnergyStored();

        sync();

        if (!enoughPower) {
            haltReason = HaltReason.NOT_ENOUGH_POWER;
            return;
        }

        haltReason = HaltReason.NONE;

        progress++;
        energyHandler.removeEnergy(rfPerTick);
        sync();

        if (progress < getMaxProgress()) {
            return;
        }

        List<WeightedStack> allOutputs = new ArrayList<>();

        for (MinerRecipe recipe : allRecipes()) {
            allOutputs.add(recipe.output().copy());
        }

        ItemStack output = getBoostedStack(getWeightedItem(allOutputs, level.random));
        ItemStack remaining;

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            if (!isItemValid(output, itemHandler.getStackInSlot(i))) continue;
            remaining = itemHandler.insertItem(i, output.copy(), false);
            if (remaining.isEmpty()) break;
            output = remaining;
        }

        progress = 0;
        sync();
    }

    private int getNumberOfEmptySlots() {
        int numberOfEmptySlots = 0;
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            if (itemHandler.getStackInSlot(i).isEmpty()) {
                numberOfEmptySlots++;
            }
        }
        return numberOfEmptySlots;
    }

    private void sync() {
        assert level != null;
        setChanged(level, getBlockPos(), getBlockState());
        level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), Block.UPDATE_ALL);
    }

    public int getRfTick() {
        float mod = 1;

        for (Map.Entry<BlockInWorld, ConfigLoader.ModifierConfig> entry : modifierMap.entrySet()) {
            mod *= entry.getValue().energy();
        }

        return (int) (cfg.getMinerConfig(name).energyTick() * mod);
    }

    public int getMaxProgress() {
        float mod = 1;

        for (Map.Entry<BlockInWorld, ConfigLoader.ModifierConfig> entry : modifierMap.entrySet()) {
            mod *= entry.getValue().speed();
        }

        return (int) (cfg.getMinerConfig(name).duration() / mod);
    }

    public int getItemModifierMultiplier() {
        float mod = 1;
        for (Map.Entry<BlockInWorld, ConfigLoader.ModifierConfig> entry : modifierMap.entrySet()) {
            mod *= entry.getValue().item();
        }
        return (int) mod;
    }

    public ItemStack getBoostedStack(ItemStack base) {
        int count = (base.getCount() * getItemModifierMultiplier());
        return base.copyWithCount(count);
    }

    private boolean hasViewOnBedrockOrVoid(BlockPos pos) {
        for (int i = 0; i < 320; i++) {
            BlockPos check = pos.below(i);

            assert level != null;
            if(level.getBlockState(check).is(Blocks.BEDROCK)) return true;

            if (level.getBlockState(check).propagatesSkylightDown(level, check) || level.isFluidAtPosition(check, (fluidState -> !fluidState.isEmpty()))) continue;
            
            return false;
        }

        return true;
    }

    private boolean isItemHandlerFull() {
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            if (itemHandler.getStackInSlot(i).getCount() < itemHandler.getStackInSlot(i).getMaxStackSize()) {
                return false;
            }
        }

        return true;
    }

    private List<MinerRecipe> allRecipes() {
        if (level == null || level.isClientSide) {
            return new ArrayList<>();
        }

        if (structure == null) {
            return new ArrayList<>();
        }

        return level.getRecipeManager().getAllRecipesFor(MinerRecipe.Type.INSTANCE)
            .stream()
            .map(RecipeHolder::value)
            .filter(recipe -> {
                if (recipe.allowHigherTiers()) {
                    return recipe.minTier() <= MiscUtil.tierMap.get(structure.getPath());
                } else {
                    return recipe.minTier() == MiscUtil.tierMap.get(structure.getPath());
                }
            })
            .filter(recipe -> recipe.dimension().equals(this.level.dimension()))
            .toList();
    }

    private boolean isItemValid(ItemStack stack, ItemStack handler) {
        return handler.isEmpty() || handler.is(stack.getItem()) && stack.getCount() + handler.getCount() <= handler.getMaxStackSize();
    }

    public void drops() {
        SimpleContainer container = new SimpleContainer(itemHandler.getSlots());

        for (int i = 0; i < itemHandler.getSlots(); i++) {
            container.addItem(itemHandler.getStackInSlot(i));
        }

        container.addItem(getUpgradeStackFromTier(upgradeTier));

        assert level != null;
        Containers.dropContents(level, worldPosition, container);
    }

    public ItemStack getUpgradeStackFromTier(int tier) {
        return switch (tier) {
            case 1 -> ModItems.MAX_STORAGE_UPGRADE_T1.toStack();
            case 2 -> ModItems.MAX_STORAGE_UPGRADE_T2.toStack();
            case 3 -> ModItems.MAX_STORAGE_UPGRADE_T3.toStack();
            default -> ItemStack.EMPTY;
        };
    }

    public ItemStack getWeightedItem(List<WeightedStack> items, RandomSource random) {
        float totalWeight = ListUtil.getTotalWeight(items);

        float randomValue = random.nextFloat() * totalWeight;

        for (WeightedStack item : items) {
            randomValue -= item.getWeightAsFloat();
            if (randomValue <= 0) {
                return item.stack;
            }
        }

        return ItemStack.EMPTY;
    }

    public void checkStructure(Level pLevel, BlockPos pPos) {
        RegisteredMultiBlockPattern pattern = MultiBlockManager.findAnyStructure(pLevel, pPos, Rotation.NONE);
        
        if (pattern == null) {
            foundStructure = false;
            return;
        }

        MultiblockMatchResult result = pattern.pattern().matchesWithResult(pLevel, pPos, Rotation.NONE);
        
        if (result == null) {
            foundStructure = false;
            return;
        }
        
        if (!pattern.ID().equals(structure)) {
            foundStructure = false;
            return;
        }

        modifierMap.clear();
        foundStructure = true;
        result.blocks().stream()
            .filter(block -> block.getState().getBlock() instanceof ModifierBlock)
            .forEach(block -> {
                ConfigLoader.ModifierConfig modifier = cfg.getModifierConfig(block.getState().getBlock());
                if (!modifierMap.containsKey(block)) {
                    modifierMap.put(block, modifier);
                }
            });
    }

    public ResourceLocation getStructure() {
        return structure;
    }

    public void setAppliedUpgradeTier(int tier) {
        this.upgradeTier = tier;
        recalculateStorageFromUpgrades();
        setChanged();
    }

    public int getUpgradeTier() {
        return upgradeTier;
    }

    public HaltReason getHaltReason() {
        return haltReason;
    }
}