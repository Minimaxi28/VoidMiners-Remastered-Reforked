package nadiendev.voidminers.world.block;

import nadiendev.voidminers.util.CustomColorUtil;
import nadiendev.voidminers.world.block.entity.MinerControllerBaseBE;
import nadiendev.voidminers.world.block.entity.SolarControllerBaseBE;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class ColoredSolarControllerBaseBlock extends SolarControllerBaseBlock {
    private final CustomColorUtil color;

    public ColoredSolarControllerBaseBlock(Properties pProperties, ResourceLocation structure, String name, CustomColorUtil color) {
        super(pProperties, structure, name);
        this.color = color;
    }

    @Override
    public MutableComponent getName() {
        return Component.literal(super.getName().getString())
                .setStyle(Style.EMPTY.withColor(color.getTextColor()));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SolarControllerBaseBE(blockPos, blockState);
    }

    public CustomColorUtil getColor() {
        return color;
    }
}