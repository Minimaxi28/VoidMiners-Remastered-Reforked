package nadiendev.voidminers.world.block;

import nadiendev.voidminers.util.CustomColorUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.level.block.Block;

public class ColoredBlock extends Block {
    private final CustomColorUtil color;

    public ColoredBlock(Properties properties, CustomColorUtil color) {
        super(properties);
        this.color = color;
    }

    @Override
    public MutableComponent getName() {
        return Component.literal(super.getName().getString())
                .setStyle(Style.EMPTY.withColor(color.getTextColor()));
    }

    // This method is used for item tooltips and display names
    @Override
    public String getDescriptionId() {
        return super.getDescriptionId();
    }

    public CustomColorUtil getColor() {
        return color;
    }
}