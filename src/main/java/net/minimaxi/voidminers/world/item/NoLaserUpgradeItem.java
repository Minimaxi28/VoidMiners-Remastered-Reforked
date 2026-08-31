package net.minimaxi.voidminers.world.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class NoLaserUpgradeItem extends Item {
    public NoLaserUpgradeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.voidminers.no_laser_upgrade"));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
