package nadiendev.voidminers.datagen;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.init.ModBlocks;
import nadiendev.voidminers.init.ModItems;
import nadiendev.voidminers.init.CrystalSet;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider {

    public ModLanguageProvider(PackOutput output, String locale) {
        super(output, VoidMiners.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("creativetab." + VoidMiners.MODID + ".title", "VoidMiners");

        this.add(ModItems.STRUCTURE_HELPER.get(), "Structure Helper");
        this.add(ModItems.ULTIMATE_STELLAR_CORE.get(), "Ultimate Stellar Core");

        this.add(ModItems.MAX_STORAGE_UPGRADE_T1.get(), "Max Storage Upgrade T1");
        this.add(ModItems.MAX_STORAGE_UPGRADE_T2.get(), "Max Storage Upgrade T2");
        this.add(ModItems.MAX_STORAGE_UPGRADE_T3.get(), "Max Storage Upgrade T3");

        this.add("tooltip." + VoidMiners.MODID + ".max_storage_upgrades", "Right-click a miner with this upgrade to apply it.\nIncreases the miner's output inventory by +%s slots.\nOnly the highest installed tier is applied\nNon-cumulative.\nConsumed on use.");

        this.add("gui." + VoidMiners.MODID + ".miner", "Tier %d Miner");
        this.add("gui." + VoidMiners.MODID + ".miners", "Miners");

        this.add("tooltip." + VoidMiners.MODID + ".controller.enoughRF", "Miner is enoughRF correctly.");

        this.add("tooltip." + VoidMiners.MODID + ".controller.energy", "Energy: %d rf/t");

        this.add("tooltip." + VoidMiners.MODID + ".controller.duration", "Duration: %d ticks");

        this.add("tooltip." + VoidMiners.MODID + ".controller.halt_reason.dimension_not_ok", "This Miner has no recipes in this dimension.");
        this.add("tooltip." + VoidMiners.MODID + ".controller.halt_reason.structure_not_found_1", "Miner structure is not correct, sneak + right-click the Miner for a guide.");
        this.add("tooltip." + VoidMiners.MODID + ".controller.halt_reason.structure_not_found_2", "Total needed blocks: ");
        this.add("tooltip." + VoidMiners.MODID + ".controller.halt_reason.too_much_item_multiplier", "Item Multiplier too high, the miner doesn't have enough slots.\nAdd a Max Storage Upgrade or remove some blocks that add Item Multiplier.");
        this.add("tooltip." + VoidMiners.MODID + ".controller.halt_reason.not_enough_empty_slots", "All slots are full, the miner can't mine until it has been emptied.");
        this.add("tooltip." + VoidMiners.MODID + ".controller.halt_reason.no_bedrock_or_void_view", "Make sure that the miner can see the void / bedrock!\nThe distance does NOT matter, only that the center block can see void / bedrock.");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.halt_reason_not_found", "Reason not found");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.not_enough_power", "Not enough power");

        this.add("tooltip." + VoidMiners.MODID + ".structure.weight", "Weight: %d");

        this.add(ModBlocks.FRAME_BASE.get(), "Frame Base");

        this.add(ModBlocks.STRUCTURE_PANEL.get(), "Structure Panel");

        this.add(ModBlocks.GLASS_PANEL.get(), "Glass Panel");

        this.add(ModBlocks.NULL_MOD.get(), "Null Modifier");

        for (CrystalSet set : CrystalSet.sets()) {
            if (set.CRYSTAL != null) {
                this.add(set.CRYSTAL.get(), cFL(set.name));

                this.add(set.CRYSTAL_BLOCK.get(), cFL(set.name) + " Block");

                this.add(set.MINER_CONTROLLER.get(), cFL(set.name) + " Miner");

                this.add(set.FRAME.get(), cFL(set.name) + " Frame");

                this.add(set.ENERGY_MOD.get(), cFL(set.name) + " Energy Modifier");

                this.add(set.SPEED_MOD.get(), cFL(set.name) + " Speed Modifier");

                this.add(set.ITEM_MOD.get(), cFL(set.name) + " Item Modifier");
            } else {
                this.add(CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get(), cFL(CrystalSet.ULTIMATE.name) + " Block");

                this.add(CrystalSet.ULTIMATE.MINER_CONTROLLER.get(), cFL(CrystalSet.ULTIMATE.name) + " Miner");

                this.add(CrystalSet.ULTIMATE.FRAME.get(), cFL(CrystalSet.ULTIMATE.name) + " Frame");

                this.add(CrystalSet.ULTIMATE.ENERGY_MOD.get(), cFL(CrystalSet.ULTIMATE.name) + " Energy Modifier");

                this.add(CrystalSet.ULTIMATE.SPEED_MOD.get(), cFL(CrystalSet.ULTIMATE.name) + " Speed Modifier");

                this.add(CrystalSet.ULTIMATE.ITEM_MOD.get(), cFL(CrystalSet.ULTIMATE.name) + " Item Modifier");
            }
        }

        this.add("tooltip." + VoidMiners.MODID + ".energy", "Energy Consumption: %s%%");

        this.add("tooltip." + VoidMiners.MODID + ".speed", "Mining Speed: %s%%");

        this.add("tooltip." + VoidMiners.MODID + ".item", "Item Multiplier: %s%%");

        this.add("tooltip." + VoidMiners.MODID + ".structure_helper.creative_only", "Creative Only");
        this.add("tooltip." + VoidMiners.MODID + ".structure_helper.instructions", "Sneak + right-click on a Miner to complete it.\nBlocks in the way will be voided");

        this.add("minecraft.overworld", "Overworld");
        this.add("minecraft.the_nether", "The Nether");
        this.add("minecraft.the_end", "The End");

        this.add("config.jade.plugin_voidminers.void_miner", "VoidMiners");
        this.add("jade." + VoidMiners.MODID + ".tier", "Tier: %s");
        this.add("jade." + VoidMiners.MODID + ".max_storage_upgrade_tier", "Max Storage Upgrade Tier: %s");
        this.add("jade." + VoidMiners.MODID + ".energy", "Energy: %s / %s FE");
        this.add("jade." + VoidMiners.MODID + ".status.working", "Status: Working");
        this.add("jade." + VoidMiners.MODID + ".status.idle", "Status: Idle");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.no_recipes_in_dimension", "Reason: No recipes in dimension");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.structure_not_found", "Reason: Structure not found");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.too_much_item_multiplier", "Reason: Item Multiplier too high");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.not_enough_empty_slots", "Reason: Not enough empty slots");
        this.add("jade." + VoidMiners.MODID + ".halt_reason.no_bedrock_or_void_view", "Reason: Can't see Bedrock or Void");

        this.add("jade." + VoidMiners.MODID + ".progress", "Progress: %s%%");

        this.add("client_message." + VoidMiners.MODID + ".max_storage_upgrades.upgrade_already_applied", "Same Upgrade already applied");
        this.add("client_message." + VoidMiners.MODID + ".max_storage_upgrades.upgrade_already_applied_is_higher_tier", "Cannot apply lower-tier upgrade while a higher-tier upgrade is installed");
        this.add("client_message." + VoidMiners.MODID + ".max_storage_upgrades.upgrade_applied", "Upgrade applied, Tier : %d");
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