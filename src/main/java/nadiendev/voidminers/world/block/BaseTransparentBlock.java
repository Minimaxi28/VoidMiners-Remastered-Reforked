package nadiendev.voidminers.world.block;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockState;

public class BaseTransparentBlock extends TransparentBlock {
    public BaseTransparentBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        return adjacentBlockState.getBlock() instanceof BaseTransparentBlock;
    }
}
