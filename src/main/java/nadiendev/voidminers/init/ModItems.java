package nadiendev.voidminers.init;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.world.item.MaxStorageUpgradeItem;
import nadiendev.voidminers.world.item.StructureHelperItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(VoidMiners.MODID);

    public static final DeferredItem<Item> STRUCTURE_HELPER = ITEMS.register("structure_helper",
        () -> new StructureHelperItem(new Item.Properties()));

    public static final DeferredItem<Item> ULTIMATE_STELLAR_CORE = ITEMS.register("ultimate_stellar_core",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T1 = ITEMS.register("max_storage_upgrade_t1",
            () -> new MaxStorageUpgradeItem(new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T2 = ITEMS.register("max_storage_upgrade_t2",
            () -> new MaxStorageUpgradeItem(new Item.Properties().rarity(Rarity.RARE)));
    public static final DeferredItem<Item> MAX_STORAGE_UPGRADE_T3 = ITEMS.register("max_storage_upgrade_t3",
            () -> new MaxStorageUpgradeItem(new Item.Properties().rarity(Rarity.EPIC)));
}