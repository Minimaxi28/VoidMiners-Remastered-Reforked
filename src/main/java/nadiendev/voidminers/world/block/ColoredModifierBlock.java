package nadiendev.voidminers.world.block;

import nadiendev.voidminers.util.CustomColorUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

public class ColoredModifierBlock extends ModifierBlock {
    private final CustomColorUtil color;

    public ColoredModifierBlock(Properties pProperties, String set, CustomColorUtil color) {
        super(pProperties, set);
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