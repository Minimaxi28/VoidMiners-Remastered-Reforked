package nadiendev.voidminers.init;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.world.item.StructureHelper;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidMiners.MODID);

    public static final DeferredItem<Item> STRUCTURE_HELPER = ITEMS.register("structure_helper",
        () -> new StructureHelper(new Item.Properties()) {
            @Override
            public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip." + VoidMiners.MODID + ".structure_helper.creative_only").withStyle(ChatFormatting.RED));
                tooltipComponents.add(Component.translatable("tooltip." + VoidMiners.MODID + ".structure_helper.instructions").withStyle(ChatFormatting.LIGHT_PURPLE));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredItem<Item> ULTIMATE_STELLAR_CORE = ITEMS.register("ultimate_stellar_core",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T1 = ITEMS.register("max_storage_upgrade_t1",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip." + VoidMiners.MODID + ".max_storage_upgrades"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T2 = ITEMS.register("max_storage_upgrade_t2",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip." + VoidMiners.MODID + ".max_storage_upgrades"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T3 = ITEMS.register("max_storage_upgrade_t3",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip." + VoidMiners.MODID + ".max_storage_upgrades"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });
}