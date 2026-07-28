package nadiendev.voidminers.world.block;

import nadiendev.voidminers.util.ShapeUtil;
import nadiendev.voidminers.world.block.entity.SolarControllerBaseBE;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SolarControllerBaseBlock extends TransparentBlock implements EntityBlock {
    final ResourceLocation structure;
    final String name;

    public SolarControllerBaseBlock(Properties pProperties, ResourceLocation structure, String name) {
        super(pProperties);
        this.structure = structure;
        this.name = name;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new SolarControllerBaseBE(blockPos, blockState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
        SolarControllerBaseBE blockEntity = (SolarControllerBaseBE) pLevel.getBlockEntity(pPos);

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
    public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @Nullable LivingEntity pPlacer, @NotNull ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);

        SolarControllerBaseBE controller = ((SolarControllerBaseBE) pLevel.getBlockEntity(pPos));
        if (controller == null) {
            controller = ((SolarControllerBaseBE) this.newBlockEntity(pPos, pState));
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
            if (be instanceof SolarControllerBaseBE controllerBE) {
                controllerBE.tick(pLevel, blockPos, blockState, structure, name);
            }
        });
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return Shapes.or(
            ShapeUtil.shapeFromDimension(0, 14, 0, 16, 2, 16),
            ShapeUtil.shapeFromDimension(2, 2, 2, 12, 12, 12),
            ShapeUtil.shapeFromDimension(7, 1, 1, 2, 15f, 14),
            ShapeUtil.shapeFromDimension(1, 7, 9, 6, 2, 6),
            ShapeUtil.shapeFromDimension(1, 7, 1, 6, 2, 6),
            ShapeUtil.shapeFromDimension(9, 7, 9, 6, 2, 6),
            ShapeUtil.shapeFromDimension(9, 7, 1, 6, 2, 6),
            ShapeUtil.shapeFromDimension(1, 1, 7, 6, 15f, 2),
            ShapeUtil.shapeFromDimension(9, 1, 7, 6, 15f, 2)
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

    @Override
    protected boolean propagatesSkylightDown(BlockState p_309084_, BlockGetter p_309133_, BlockPos p_309097_) {
        return false;
    }
}
