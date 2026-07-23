package nadiendev.voidminers.world.block;

import nadiendev.voidminers.config.ConfigLoader;
import nadiendev.voidminers.init.CrystalSet;
import nadiendev.voidminers.util.CustomColorUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class ColoredModifierBlock extends ModifierBlock {
    private final CustomColorUtil color;
    private final CrystalSet.ModifierType type;

    public ColoredModifierBlock(Properties pProperties, String set, CustomColorUtil color, CrystalSet.ModifierType type) {
        super(pProperties, set);
        this.color = color;
        this.type = type;
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        ConfigLoader.ModifierConfig modConfig = ConfigLoader.getInstance().getModifierConfig(this);

        final String energy = String.format(modConfig.energy() >= 1 ? "+%.0f" : "%.0f", -(1 - modConfig.energy()) * 100);
        final String speed = String.format(modConfig.speed() >= 1 ? "+%.0f" : "%.0f", -(1 - modConfig.speed()) * 100);
        final String item = String.format(modConfig.item() >= 1 ? "+%.0f" : "%.0f",  -(1 - modConfig.item()) * 100);

        if(modConfig.speed() != 1f) {
            tooltipComponents.add(Component.translatable("tooltip.voidminers.speed",
                    speed).withStyle(ChatFormatting.GREEN));
        }
        if(modConfig.item() != 1f) {
            tooltipComponents.add(Component.translatable("tooltip.voidminers.item",
                    item).withStyle(ChatFormatting.AQUA));
        }
        if(modConfig.energy() != 1f) {
            tooltipComponents.add(Component.translatable("tooltip.voidminers.energy",
                    energy).withStyle(ChatFormatting.GOLD));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
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