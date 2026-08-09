package net.minimaxi.voidminers.world.item;

import net.minimaxi.voidminers.util.CustomColorUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;

public class ColoredItem extends Item {
    private final CustomColorUtil color;

    public ColoredItem(Properties properties, CustomColorUtil color) {
        super(properties);
        this.color = color;
    }

    @Override
    public Component getName(ItemStack stack) {
        String name = super.getName(stack).getString();
        return Component.literal(name)
                .setStyle(Style.EMPTY.withColor(color.getTextColor()));
    }
}