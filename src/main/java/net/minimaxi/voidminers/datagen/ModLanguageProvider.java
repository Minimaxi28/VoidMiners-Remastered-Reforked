package net.minimaxi.voidminers.datagen;

import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.init.ModBlocks;
import net.minimaxi.voidminers.init.ModItems;
import net.minimaxi.voidminers.init.CrystalSet;
import net.minimaxi.voidminers.init.SolarSet;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, VoidMiners.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("creativetab.voidminers.title", "VoidMiners");

        this.add(ModItems.STRUCTURE_BUILDER.get(), "Structure Builder");
        this.add(ModItems.ULTIMATE_STELLAR_CORE.get(), "Ultimate Stellar Core");

        this.add(ModItems.MAX_STORAGE_UPGRADE_T1.get(), "Max Storage Upgrade T1");
        this.add(ModItems.MAX_STORAGE_UPGRADE_T2.get(), "Max Storage Upgrade T2");
        this.add(ModItems.MAX_STORAGE_UPGRADE_T3.get(), "Max Storage Upgrade T3");

        this.add("tooltip.voidminers.max_storage_upgrades", "Right-click a miner with this upgrade to apply it.\nIncreases the miner's output inventory by +%s slots.\nOnly the highest installed tier is applied\nNon-cumulative.\nConsumed on use.");

        this.add("gui.voidminers.miner", "Tier %d Miner");
        this.add("gui.voidminers.miners", "Miners");

        this.add("tooltip.voidminers.controller.halt_reason.dimension_not_ok", "§eThis miner doesn't have any recipes available for this dimension : %s§d)§e.\nCheck JEI for available recipes / dimensions.");
        this.add("tooltip.voidminers.controller.halt_reason.structure_not_found", "Structure is not correct, sneak + right-click the Controller for a guide.\nTotal needed blocks: ");
        this.add("tooltip.voidminers.controller.halt_reason.too_much_item_multiplier", "§eItem Multiplier too high, remove some of the blocks that add Item Multiplier.\nMax Item Multiplier: %d×");
        this.add("tooltip.voidminers.controller.halt_reason.not_enough_empty_slots", "All slots are full, the miner can't mine until it has been emptied.");
        this.add("tooltip.voidminers.controller.halt_reason.no_bedrock_or_void_view", "Make sure that the miner can see the void / bedrock!\nThe distance does NOT matter, only that the center block can see void / bedrock.");

        this.add("tooltip.voidminers.controller.halt_reason.no_sky_view", "Unable to see the sky, make sure there are no blocks above the Solar Panel\nDimension could also not have a \"day\" ie. The Nether / The End");

        this.add("tooltip.voidminers.controller.progress", "§e⏳ PROGRESS: ");
        this.add("tooltip.voidminers.controller.item_boost", "§d📦 ITEM BOOST: ");
        this.add("tooltip.voidminers.controller.duration", "§9⏱ DURATION: ");
        this.add("tooltip.voidminers.controller.consumption", "§c⚡ CONSUMPTION: ");
        this.add("tooltip.voidminers.controller.energy", "§e⚡ ENERGY: ");
        this.add("tooltip.voidminers.controller.max_storage_upgrade_tip", "If a better one is available, you could also add a better Max Storage Upgrade");

        this.add("tooltip.voidminers.controller.generation", "⚡ GENERATION: ");
        this.add("tooltip.voidminers.controller.efficiency", "☀ EFFICIENCY: ");
        this.add("tooltip.voidminers.controller.upgrade", "⚙ UPGRADE: ");
        this.add("tooltip.voidminers.controller.upgrade.no_upgrage", "No upgrades applied.");
        this.add("tooltip.voidminers.controller.upgrade.slots", " (+%d slots)");
        this.add("tooltip.voidminers.controller.information", "Information : ");
        this.add("tooltip.voidminers.controller.information.auto_export", "The outputs will be sent to adjacent inventories or voided if none are found / all are full.");

        this.add("tooltip.voidminers.controller.status.status", "⚠ STATUS: ");

        this.add("tooltip.voidminers.controller.status.mining_slow", "MINING SLOW");
        this.add("tooltip.voidminers.controller.status.not_enough_power_for_next_operation", "Not enough power for next operation.");
        this.add("tooltip.voidminers.controller.status.mining_impossible", "MINING IMPOSSIBLE");
        this.add("tooltip.voidminers.controller.status.mining_stopped", "MINING STOPPED");
        this.add("tooltip.voidminers.controller.status.not_enough_power", "Not enough power.");
        this.add("tooltip.voidminers.controller.status.not_enough_power_buffer", "Not enough power buffer.\nEither use less Modifiers or use Energy Modifiers.");

        this.add("tooltip.voidminers.controller.status.structure_incomplete", "STRUCTURE INCOMPLETE");
        this.add("tooltip.voidminers.controller.status.working", "WORKING");
        this.add("tooltip.voidminers.controller.status.power_full", "POWER BUFFER FULL");
        this.add("tooltip.voidminers.controller.efficiency_limited_by_rain", "Efficiency limited because of Rain.");
        this.add("tooltip.voidminers.controller.efficiency_limited_by_thunder", "Efficiency limited because of Thunder.");
        this.add("tooltip.voidminers.controller.efficiency_limited_by_time_of_day", "Efficiency limited because of the current time.");

        this.add("tooltip.voidminers.controller.status.no_sky_view", "NO SKY VIEW / DIMENSION DOES NOT HAVE A \"DAY\"");

        this.add(ModBlocks.FRAME_BASE.get(), "Frame Base");

        this.add(ModBlocks.STRUCTURE_PANEL.get(), "Structure Panel");

        this.add(ModBlocks.GLASS_PANEL.get(), "Glass Panel");

        this.add(ModBlocks.NULL_MOD.get(), "Null Modifier");

        for (CrystalSet set : CrystalSet.sets()) {
            if (set.CRYSTAL != null) {
                this.add(set.CRYSTAL.get(), cFL(set.name));
                this.add(set.CRYSTAL_BLOCK.get(), cFL(set.name) + " Block");
                this.add(set.CONTROLLER.get(), cFL(set.name) + " Miner Controller");
                this.add(set.FRAME.get(), cFL(set.name) + " Frame");
                this.add(set.ENERGY_MOD.get(), cFL(set.name) + " Energy Modifier");
                this.add(set.SPEED_MOD.get(), cFL(set.name) + " Speed Modifier");
                this.add(set.ITEM_MOD.get(), cFL(set.name) + " Item Modifier");
            } else {
                this.add(CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get(), cFL(CrystalSet.ULTIMATE.name) + " Block");
                this.add(CrystalSet.ULTIMATE.CONTROLLER.get(), cFL(CrystalSet.ULTIMATE.name) + " Miner Controller");
                this.add(CrystalSet.ULTIMATE.FRAME.get(), cFL(CrystalSet.ULTIMATE.name) + " Frame");
                this.add(CrystalSet.ULTIMATE.ENERGY_MOD.get(), cFL(CrystalSet.ULTIMATE.name) + " Energy Modifier");
                this.add(CrystalSet.ULTIMATE.SPEED_MOD.get(), cFL(CrystalSet.ULTIMATE.name) + " Speed Modifier");
                this.add(CrystalSet.ULTIMATE.ITEM_MOD.get(), cFL(CrystalSet.ULTIMATE.name) + " Item Modifier");
            }
        }

        for (SolarSet set : SolarSet.sets()) {
            if (set.CRYSTAL != null) {
                this.add(set.CRYSTAL.get(), "Solar " + cFL(set.name));
                this.add(set.CRYSTAL_BLOCK.get(), "Solar " + cFL(set.name) + " Block");
                this.add(set.CONTROLLER.get(), "Solar " + cFL(set.name) + " Panel Controller");
                this.add(set.FRAME.get(), "Solar " + cFL(set.name) + " Frame");
                this.add(set.WEATHER_MOD.get(), "Solar " + cFL(set.name) + " Weather Modifier");
                this.add(set.EFFICIENCY_MOD.get(), "Solar " + cFL(set.name) + " Efficiency Modifier");
            } else {
                this.add(SolarSet.ULTIMATE.CRYSTAL_BLOCK.get(), "Solar " + cFL(SolarSet.ULTIMATE.name) + " Block");
                this.add(SolarSet.ULTIMATE.CONTROLLER.get(), cFL(SolarSet.ULTIMATE.name) + " Solar Panel Controller");
                this.add(SolarSet.ULTIMATE.FRAME.get(), "Solar " + cFL(SolarSet.ULTIMATE.name) + " Frame");
                this.add(SolarSet.ULTIMATE.WEATHER_MOD.get(), "Solar " + cFL(SolarSet.ULTIMATE.name) + " Weather Modifier");
                this.add(SolarSet.ULTIMATE.EFFICIENCY_MOD.get(), "Solar " + cFL(SolarSet.ULTIMATE.name) + " Efficiency Modifier");
            }
        }

        this.add("tooltip.voidminers.energy", "Energy Consumption: %s%%");
        this.add("tooltip.voidminers.speed", "Mining Speed: %s%%");
        this.add("tooltip.voidminers.item", "Item Multiplier: %s%%");
        this.add("tooltip.voidminers.efficiency", "Solar Efficiency: %s%%");
        this.add("tooltip.voidminers.weatherResistance", "Weather Resistance: %s%%");

        this.add("tooltip.voidminers.structure_builder.instructions", "Sneak + right-click on a Controller to automatically build the Multiblock.");

        this.add("minecraft.overworld", "Overworld");
        this.add("minecraft.the_nether", "The Nether");
        this.add("minecraft.the_end", "The End");

        this.add("config.jade.plugin_voidminers.void_miner", "VoidMiners");
        this.add("jade.voidminers.halt_reason.halt_reason_not_found", "Reason not found");
        this.add("jade.voidminers.halt_reason.not_enough_power", "Reason: Not enough power");
        this.add("jade.voidminers.halt_reason.not_enough_power_buffer", "Reason: Not enough power buffer");
        this.add("jade.voidminers.tier", "Tier: %s");
        this.add("jade.voidminers.storage_upgrade", "Storage Upgrade: %s");
        this.add("jade.voidminers.energy", "Energy: %s / %s FE");
        this.add("jade.voidminers.status.working", "Status: Working");
        this.add("jade.voidminers.status.idle", "Status: Idle");
        this.add("jade.voidminers.halt_reason.no_recipes_in_dimension", "Reason: No recipes in dimension");
        this.add("jade.voidminers.halt_reason.structure_not_found", "Reason: Structure not found");
        this.add("jade.voidminers.halt_reason.too_much_item_multiplier", "Reason: Item Multiplier too high");
        this.add("jade.voidminers.halt_reason.not_enough_empty_slots", "Reason: Not enough empty slots");
        this.add("jade.voidminers.halt_reason.no_bedrock_or_void_view", "Reason: Can't see Bedrock or Void");

        this.add("jade.voidminers.halt_reason.no_sky_view", "Reason: Can't see the sky");
        this.add("jade.voidminers.halt_reason.power_full", "Reason: Power buffer full");

        this.add("jade.voidminers.progress", "Progress: %s%%");

        this.add("client_message.voidminers.max_storage_upgrades.upgrade_already_applied", "Same Upgrade already applied");
        this.add("client_message.voidminers.max_storage_upgrades.upgrade_already_applied_is_higher_tier", "Cannot apply an upgrade with less slots then the current upgrade.");
        this.add("client_message.voidminers.max_storage_upgrades.upgrade_applied", "Upgrade applied, added slots : %d");

        this.add("tooltip.voidminers.structure_builder.unable_to_place_multiblock.1", "Unable to place the multiblock because other blocks are in the way.");
        this.add("tooltip.voidminers.structure_builder.unable_to_place_multiblock.2", "Please clear the area where the multiblock will be made, you can sneak + right-click the Controller for a guide.");
        this.add("tooltip.voidminers.structure_builder.missing_block_in_inventory", "Unable to place some blocks because they are not in your inventory.\nMissing Blocks:");

        this.add("gui.voidminers.block_underneath", "Place this block at any Y level under the Miner Controller");
        this.add("gui.voidminers.accepts_any", "Accepts any: %s");
        this.add("gui.voidminers.weight", "Weight: %d");
    }


    /**
     * Capitalizes first letter of a string
     *
     * @param input the string to capitalize e.g. "alpha"
     * @return the string capitalized e.g. "Alpha"
     */
    public static String cFL(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }
}