package nadiendev.voidminers.init;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.world.block.ColoredBlock;
import nadiendev.voidminers.world.block.ColoredControllerBaseBlock;
import nadiendev.voidminers.world.block.ColoredModifierBlock;
import nadiendev.voidminers.world.block.ControllerBaseBlock;
import nadiendev.voidminers.world.block.ModifierBlock;
import nadiendev.voidminers.util.CustomColorUtil;
import nadiendev.voidminers.world.item.ColoredItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;

public class CrystalSet {
    public static CrystalSet RUBETINE;
    public static CrystalSet AURANTIUM;
    public static CrystalSet CITRINETINE;
    public static CrystalSet VERDIUM;
    public static CrystalSet AZURINE;
    public static CrystalSet CAERIUM;
    public static CrystalSet AMETHYSTINE;
    public static CrystalSet ROSARIUM;
    public static CrystalSet ULTIMATE;

    public final String name;
    public final DeferredHolder<Item, Item> CRYSTAL;
    public final DeferredHolder<Block, Block> CRYSTAL_BLOCK;
    public final DeferredHolder<Block, ? extends Block> MINER_CONTROLLER;
    public final DeferredHolder<Block, Block> FRAME;
    public final DeferredHolder<Block, ? extends Block> SPEED_MOD;
    public final DeferredHolder<Block, ? extends Block> ENERGY_MOD;
    public final DeferredHolder<Block, ? extends Block> ITEM_MOD;
    public final CustomColorUtil color;

    CrystalSet(String name, DeferredHolder<Item, Item> crystal, DeferredHolder<Block, Block> crystalBlock,
               DeferredHolder<Block, ? extends Block> minerController, DeferredHolder<Block, Block> frame,
               DeferredHolder<Block, ? extends Block> energyMod, DeferredHolder<Block, ? extends Block> speedMod,
               DeferredHolder<Block, ? extends Block> itemMod, CustomColorUtil color) {
        this.name = name;
        CRYSTAL = crystal;
        CRYSTAL_BLOCK = crystalBlock;
        MINER_CONTROLLER = minerController;
        FRAME = frame;
        SPEED_MOD = speedMod;
        ENERGY_MOD = energyMod;
        ITEM_MOD = itemMod;
        this.color = color;
    }

    public static DeferredHolder<Item, Item> fastCreateItem(String name, Rarity rarity, CustomColorUtil color) {
        return ModItems.ITEMS.register(name, () -> new ColoredItem(
                new Item.Properties().rarity(rarity), color
        ));
    }

    public static DeferredHolder<Block, Block> fastCreateBlock(String name, float hardness, float resistance, Rarity rarity, CustomColorUtil color) {
        return ModBlocks.registerColoredBlock(name,
                () -> new ColoredBlock(
                        BlockBehaviour.Properties.of()
                                .strength(hardness, resistance)
                                .requiresCorrectToolForDrops(),
                        color
                ),
                rarity,
                color
        );
    }

    public static DeferredHolder<Block, ModifierBlock> fastCreateModifier(String name, float hardness, float resistance, Rarity rarity, ModifierType type, CustomColorUtil color) {
        return ModBlocks.registerColoredBlock(name + "_" + type.type + "_modifier",
                () -> new ColoredModifierBlock(
                        BlockBehaviour.Properties.of()
                                .strength(hardness, resistance)
                                .requiresCorrectToolForDrops(),
                        name,
                        color
                ),
                rarity,
                color
        );
    }

    public static DeferredHolder<Block, ControllerBaseBlock> fastCreateController(String name, float hardness, float resistance, Rarity rarity, ResourceLocation structure, CustomColorUtil color) {
        return ModBlocks.registerColoredBlock(name + "_miner",
                () -> new ColoredControllerBaseBlock(
                        BlockBehaviour.Properties.of()
                                .strength(hardness, resistance)
                                .requiresCorrectToolForDrops(),
                        structure,
                        name,
                        color
                ),
                rarity,
                color
        );
    }

    public static void initSets() {
        RUBETINE = createSet("rubetine", ModRarities.RUBETINE, ModRarities.RUBETINE_COLOR);
        AURANTIUM = createSet("aurantium", ModRarities.AURANTIUM, ModRarities.AURANTIUM_COLOR);
        CITRINETINE = createSet("citrinetine", ModRarities.CITRINETINE, ModRarities.CITRINETINE_COLOR);
        VERDIUM = createSet("verdium", ModRarities.VERDIUM, ModRarities.VERDIUM_COLOR);
        AZURINE = createSet("azurine", ModRarities.AZURINE, ModRarities.AZURINE_COLOR);
        CAERIUM = createSet("caerium", ModRarities.CAERIUM, ModRarities.CAERIUM_COLOR);
        AMETHYSTINE = createSet("amethystine", ModRarities.AMETHYSTINE, ModRarities.AMETHYSTINE_COLOR);
        ROSARIUM = createSet("rosarium", ModRarities.ROSARIUM, ModRarities.ROSARIUM_COLOR);
        ULTIMATE = createSet("ultimate", ModRarities.ULTIMATE, ModRarities.ULTIMATE_COLOR);
    }

    public static CrystalSet createSet(String name, Rarity rarity, CustomColorUtil color) {
        return new CrystalSet(
                name,
                name.equals("ultimate") ? null : fastCreateItem(name, rarity, color),
                fastCreateBlock(name + "_block", 10, 5, rarity, color),
                fastCreateController(name, 10, 50, rarity, ResourceLocation.fromNamespaceAndPath(VoidMiners.MODID, name), color),
                fastCreateBlock(name + "_frame", 10, 50, rarity, color),
                fastCreateModifier(name, 10, 50, rarity, ModifierType.ENERGY, color),
                fastCreateModifier(name, 10, 50, rarity, ModifierType.SPEED, color),
                fastCreateModifier(name, 10, 50, rarity, ModifierType.ITEM, color),
                color
        );
    }

    public static List<CrystalSet> sets() {
        List<CrystalSet> sets = new ArrayList<>();
        sets.add(RUBETINE);
        sets.add(AURANTIUM);
        sets.add(CITRINETINE);
        sets.add(VERDIUM);
        sets.add(AZURINE);
        sets.add(CAERIUM);
        sets.add(AMETHYSTINE);
        sets.add(ROSARIUM);
        sets.add(ULTIMATE);
        return sets;
    }

    public enum ModifierType {
        ENERGY("energy"),
        SPEED("speed"),
        ITEM("item"),
        NULL("null");

        public final String type;

        ModifierType(String type) {
            this.type = type;
        }

        public static ModifierType getFromName(String name) {
            return switch (name.toLowerCase()) {
                case "energy" -> ENERGY;
                case "speed" -> SPEED;
                case "item" -> ITEM;
                default -> null;
            };
        }
    }
}