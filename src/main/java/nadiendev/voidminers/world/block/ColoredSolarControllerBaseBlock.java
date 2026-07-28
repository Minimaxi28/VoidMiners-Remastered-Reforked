package nadiendev.voidminers.world.block;

import nadiendev.voidminers.util.CustomColorUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;

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

    public CustomColorUtil getColor() {
        return color;
    }
}