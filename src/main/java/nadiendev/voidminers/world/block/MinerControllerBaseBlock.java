package nadiendev.voidminers.world.block;

import nadiendev.voidminers.init.ModDataComponents;
import nadiendev.voidminers.world.block.entity.MinerControllerBaseBE;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class MinerControllerBaseBlock extends TransparentBlock implements EntityBlock {
    final ResourceLocation structure;
    final String name;

    public MinerControllerBaseBlock(Properties pProperties, ResourceLocation structure, String name) {
        super(pProperties);
        this.structure = structure;
        this.name = name;
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof MinerControllerBaseBE controllerBE) {
                controllerBE.drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MinerControllerBaseBE(blockPos, blockState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        MinerControllerBaseBE blockEntity = (MinerControllerBaseBE) pLevel.getBlockEntity(pPos);

        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (pPlayer.isCrouching()) {
            if (blockEntity != null && !blockEntity.foundStructure) {
                blockEntity.updateShowStructure();
            }
            return InteractionResult.CONSUME;
        }

        if (blockEntity != null) {
            for (Component component : blockEntity.getInteractionTooltip()) {
                pPlayer.displayClientMessage(component, false);
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        MinerControllerBaseBE blockEntity = (MinerControllerBaseBE) pLevel.getBlockEntity(pPos);

        if (pLevel.isClientSide) {
            return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
        }

        handleUpgrade(blockEntity, pPlayer, pStack, pHand, pLevel, pState, pPos);

        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }

    private void handleUpgrade(MinerControllerBaseBE blockEntity, Player pPlayer, ItemStack pStack, InteractionHand pHand, Level pLevel, BlockState pState, BlockPos pPos) {
        Item currentUpgradeItem = blockEntity.getUpgradeItem();
        Item newUpgradeItem = pStack.getItem();

        if (currentUpgradeItem == newUpgradeItem) {
            pPlayer.displayClientMessage(Component.translatable("client_message.voidminers.max_storage_upgrades.upgrade_already_applied"), true);
            return;
        }

        int newAddedSlots = 0;

        if(newUpgradeItem.components().get(ModDataComponents.MAX_STORAGE_UPGRADE_SLOTS.get()) != null) {
            newAddedSlots = newUpgradeItem.components().get(ModDataComponents.MAX_STORAGE_UPGRADE_SLOTS.get());
        } else {
            return;
        }

        int currentAddedSlots = 0;

        if(currentUpgradeItem.components().get(ModDataComponents.MAX_STORAGE_UPGRADE_SLOTS.get()) != null) {
            currentAddedSlots = currentUpgradeItem.components().get(ModDataComponents.MAX_STORAGE_UPGRADE_SLOTS.get());
        }

        if (currentAddedSlots > newAddedSlots) {
            pPlayer.displayClientMessage(Component.translatable("client_message.voidminers.max_storage_upgrades.upgrade_already_applied_is_higher_tier"), true);
            return;
        }

        blockEntity.setAppliedUpgradeItem(newUpgradeItem);

        if (!pPlayer.getAbilities().instabuild) {
            pStack.shrink(1);
            pPlayer.setItemInHand(pHand, pStack);
        }

        if (!(currentUpgradeItem == Items.AIR)) {
            boolean added = pPlayer.getInventory().add(new ItemStack(currentUpgradeItem));
            if (!added) {
                ItemEntity drop = new ItemEntity(pLevel, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), new ItemStack(currentUpgradeItem));
                pLevel.addFreshEntity(drop);
            }
        }

        if (blockEntity.getLevel() != null) {
            blockEntity.getLevel().sendBlockUpdated(pPos, pState, pState, 3);
        }

        pPlayer.displayClientMessage(Component.translatable("client_message.voidminers.max_storage_upgrades.upgrade_applied", newAddedSlots), true);
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);

        MinerControllerBaseBE controller = ((MinerControllerBaseBE) pLevel.getBlockEntity(pPos));
        if (controller == null) {
            controller = ((MinerControllerBaseBE) this.newBlockEntity(pPos, pState));
        }

        if (controller != null) {
            controller.setup(structure, name);
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) {
            return null;
        }

        return ((level, blockPos, blockState, be) -> {
            if (be instanceof MinerControllerBaseBE controllerBE) {
                controllerBE.tick(pLevel, blockPos, blockState, structure, name);
            }
        });
    }
}