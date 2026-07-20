package nadiendev.voidminers.world.item;

import nadiendev.voidminers.config.ConfigLoader;
import nadiendev.voidminers.init.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class MaxStorageUpgradeItem extends Item {
    public MaxStorageUpgradeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        ConfigLoader cfg = ConfigLoader.getInstance();
        Item item = stack.getItem();
        int slots;

        if (item == ModItems.MAX_STORAGE_UPGRADE_T1.get()) {
            slots = cfg.UPGRADE_T1_SLOTS;
        } else if (item == ModItems.MAX_STORAGE_UPGRADE_T2.get()) {
            slots = cfg.UPGRADE_T2_SLOTS;
        } else {
            slots = cfg.UPGRADE_T3_SLOTS;
        }

        tooltipComponents.add(Component.translatable("tooltip.voidminers.max_storage_upgrades", slots));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
