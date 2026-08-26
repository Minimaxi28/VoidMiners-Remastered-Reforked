package net.minimaxi.voidminers.init;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.config.MinerConfigLoader;
import net.minimaxi.voidminers.world.block.ModifierBlock;
import net.minimaxi.voidminers.world.item.MaxStorageUpgradeItem;
import net.minimaxi.voidminers.world.item.StructureBuilderItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minimaxi.voidminers.world.multiblock.MinerMultiblocks;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidMiners.MODID);

    public static final DeferredItem<Item> STRUCTURE_BUILDER = ITEMS.register("structure_builder",
        () -> new StructureBuilderItem(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> ULTIMATE_STELLAR_CORE = ITEMS.register("ultimate_stellar_core",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T1 = ITEMS.register("max_storage_upgrade_t1",
            () -> new MaxStorageUpgradeItem(MinerConfigLoader.getInstance().UPGRADE_T1_SLOTS, new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T2 = ITEMS.register("max_storage_upgrade_t2",
            () -> new MaxStorageUpgradeItem(MinerConfigLoader.getInstance().UPGRADE_T2_SLOTS, new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T3 = ITEMS.register("max_storage_upgrade_t3",
            () -> new MaxStorageUpgradeItem(MinerConfigLoader.getInstance().UPGRADE_T3_SLOTS, new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> TEST_ITEM = ITEMS.register("test_item",
            () -> new Item(new Item.Properties().stacksTo(1)) {
                @Override
                public InteractionResult useOn(UseOnContext useOnContext) {
                    Level level = useOnContext.getLevel();
                    BlockPos blockPos = useOnContext.getClickedPos();
                    BlockState blockState = useOnContext.getLevel().getBlockState(blockPos);

                    MinerMultiblocks.PatternPair pair = MinerMultiblocks.PATTERNS.get("miner_aurantium");

                    if (pair == null) {
                        VoidMiners.LOGGER.warn("Could not find pair");
                        return InteractionResult.SUCCESS;
                    }

                    BlockPattern.BlockPatternMatch match = pair.primary().find(level, blockPos);

                    if (match == null) {
                        match = pair.alternate().find(level, blockPos);
                    }

                    if (match == null) {
                        VoidMiners.LOGGER.warn("Could not find match for " + blockPos);
                        return InteractionResult.SUCCESS;
                    }

                    VoidMiners.LOGGER.warn("Found Structure");

                    for (int x = 0; x < match.getWidth(); x++) {
                        for (int y = 0; y < match.getHeight(); y++) {
                            for (int z = 0; z < match.getDepth(); z++) {
                                var info = match.getBlock(x, y, z); // CachedBlockInfo, acts like BlockInWorld
                                if (info.getState().getBlock() instanceof ModifierBlock block) {
                                    VoidMiners.LOGGER.warn(block.name);
                                }
                            }
                        }
                    }

                    return InteractionResult.SUCCESS;
                }
            });
}