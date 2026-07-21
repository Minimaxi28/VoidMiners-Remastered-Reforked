package nadiendev.voidminers.world.block;

import nadiendev.voidminers.util.ShapeUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BaseTransparentBlock extends TransparentBlock {
    public BaseTransparentBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() instanceof BaseTransparentBlock;
    }

    @Override
    protected VoxelShape getOcclusionShape(BlockState p_60578_, BlockGetter p_60579_, BlockPos p_60580_) {
        return ShapeUtil.shapeFromDimension(0.01f, 0.01f, 0.01f, 15.88f, 15.88f, 15.88f);
    }
}
