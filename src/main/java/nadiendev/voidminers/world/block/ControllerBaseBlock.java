package nadiendev.voidminers.world.block;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.init.ModItems;
import nadiendev.voidminers.world.block.entity.ControllerBaseBE;
import nadiendev.voidminers.util.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class ControllerBaseBlock extends BaseTransparentBlock implements EntityBlock {
    final ResourceLocation structure;
    final String name;

    public ControllerBaseBlock(Properties pProperties, ResourceLocation structure, String name) {
        super(pProperties);
        this.structure = structure;
        this.name = name;
    }

    @Override
    protected void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof ControllerBaseBE controllerBE) {
                controllerBE.drops();
            }
        }

        super.onRemove(pState, pLevel, pPos, pNewState, pMoving);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new ControllerBaseBE(blockPos, blockState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        ControllerBaseBE blockEntity = (ControllerBaseBE) pLevel.getBlockEntity(pPos);

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
        ControllerBaseBE blockEntity = (ControllerBaseBE) pLevel.getBlockEntity(pPos);

        if (pLevel.isClientSide) {
            return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
        }

        ItemStack held = pPlayer.getItemInHand(pHand);
        String itemId = BuiltInRegistries.ITEM.getKey(held.getItem()).getPath();

        assert blockEntity != null;
        switch (itemId) {
            case "max_storage_upgrade_t1" -> {
                return handleUpgrade(1, blockEntity, pPlayer, held, pHand, pLevel, pState, pPos);
            }
            case "max_storage_upgrade_t2" -> {
                return handleUpgrade(2, blockEntity, pPlayer, held, pHand, pLevel, pState, pPos);
            }
            case "max_storage_upgrade_t3" -> {
                return handleUpgrade(3, blockEntity, pPlayer, held, pHand, pLevel, pState, pPos);
            }
            default -> {
                return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
            }
        }
    }

    private ItemInteractionResult handleUpgrade(int tier, ControllerBaseBE blockEntity, Player pPlayer,  ItemStack held, InteractionHand pHand, Level pLevel, BlockState pState, BlockPos pPos) {
        int current = blockEntity.getCurrentUpgradeTier();
        if (current == tier) {
            pPlayer.displayClientMessage(Component.translatable("client_message." + VoidMiners.MODID + ".max_storage_upgrades.upgrade_already_applied"), true);
            return ItemInteractionResult.CONSUME;
        }

        if (current > tier) {
            pPlayer.displayClientMessage(Component.translatable("client_message." + VoidMiners.MODID + ".max_storage_upgrades.upgrade_already_applied_is_higher_tier"), true);
            return ItemInteractionResult.CONSUME;
        }

        ItemStack previousStack = ItemStack.EMPTY;
        if (current == 1) previousStack = new ItemStack(ModItems.MAX_STORAGE_UPGRADE_T1.get());
        if (current == 2) previousStack = new ItemStack(ModItems.MAX_STORAGE_UPGRADE_T2.get());

        blockEntity.setAppliedUpgradeTier(tier);

        if (!pPlayer.getAbilities().instabuild) {
            held.shrink(1);
            pPlayer.setItemInHand(pHand, held);
        }

        if (!previousStack.isEmpty()) {
            boolean added = pPlayer.getInventory().add(previousStack);
            if (!added) {
                ItemEntity drop = new ItemEntity(pLevel, pPlayer.getX(), pPlayer.getY(), pPlayer.getZ(), previousStack);
                pLevel.addFreshEntity(drop);
            }
        }

        if (blockEntity.getLevel() != null) {
            blockEntity.getLevel().sendBlockUpdated(pPos, pState, pState, 3);
        }

        pPlayer.displayClientMessage(Component.translatable("client_message." + VoidMiners.MODID + ".max_storage_upgrades.upgrade_applied", tier), true);
        return ItemInteractionResult.CONSUME;
    }

    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, @Nullable LivingEntity pPlacer, ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);

        ControllerBaseBE controller = ((ControllerBaseBE) pLevel.getBlockEntity(pPos));
        if (controller == null) {
            controller = ((ControllerBaseBE) this.newBlockEntity(pPos, pState));
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
            if (be instanceof ControllerBaseBE controllerBE) {
                controllerBE.tick(pLevel, blockPos, blockState, structure, name);
            }
        });
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.or(
            ShapeUtil.shapeFromDimension(0, 0, 0, 16, 2, 16),
            ShapeUtil.shapeFromDimension(2, 2, 2, 12, 12, 12),
            ShapeUtil.shapeFromDimension(7, 0f, 1, 2, 15f, 14),
            ShapeUtil.shapeFromDimension(1, 7, 9, 6, 2, 6),
            ShapeUtil.shapeFromDimension(1, 7, 1, 6, 2, 6),
            ShapeUtil.shapeFromDimension(9, 7, 9, 6, 2, 6),
            ShapeUtil.shapeFromDimension(9, 7, 1, 6, 2, 6),
            ShapeUtil.shapeFromDimension(1, 0f, 7, 6, 15f, 2),
            ShapeUtil.shapeFromDimension(9, 0f, 7, 6, 15f, 2)
        );
    }

    @Override
    protected void spawnDestroyParticles(Level pLevel, Player pPlayer, BlockPos pPos, BlockState pState) {
        if (pLevel.isClientSide) {
            RandomSource random = pLevel.random;

            pLevel.playLocalSound(
                    (double)pPos.getX() + 0.5D,
                    (double)pPos.getY() + 0.5D,
                    (double)pPos.getZ() + 0.5D,
                    pState.getSoundType().getBreakSound(),
                    SoundSource.BLOCKS,
                    (pState.getSoundType().getVolume() + 1.0F) / 2.0F,
                    pState.getSoundType().getPitch() * 0.8F,
                    false
            );

            int particleCount = 48;
            for (int i = 0; i < particleCount; i++) {
                double d0 = (double)pPos.getX() + random.nextDouble();
                double d1 = (double)pPos.getY() + random.nextDouble();
                double d2 = (double)pPos.getZ() + random.nextDouble();
                pLevel.addParticle(
                        new BlockParticleOption(
                                ParticleTypes.BLOCK,
                                pState
                        ),
                        d0, d1, d2,
                        (random.nextDouble() - 0.5D) * 0.5D,
                        (random.nextDouble() - 0.5D) * 0.5D,
                        (random.nextDouble() - 0.5D) * 0.5D
                );
            }
        }
    }
}