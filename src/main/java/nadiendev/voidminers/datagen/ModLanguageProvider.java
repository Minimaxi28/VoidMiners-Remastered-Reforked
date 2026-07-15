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
        this.add(VoidMiners.MODID + ".itemGroup.items", "Items");

        this.add(ModItems.STRUCTURE_HELPER.get(), "Structure Helper");
        this.add(ModItems.ULTIMATE_STELLAR_CORE.get(), "Ultimate Stellar Core");

        this.add(ModItems.MAX_STORAGE_UPGRADE_T1.get(), "Storage Upgrade T1");
        this.add(ModItems.MAX_STORAGE_UPGRADE_T2.get(), "Storage Upgrade T2");
        this.add(ModItems.MAX_STORAGE_UPGRADE_T3.get(), "Storage Upgrade T3");

        this.add("tooltip." + VoidMiners.MODID + ".max_storage_upgrades", "Right-click a miner with this upgrade to apply it.\nIncreases the miner's output inventory by +%s slots.\nOnly the highest installed tier is applied\nNon-cumulative.\nConsumed on use.");

        this.add("gui." + VoidMiners.MODID + ".miner", "Tier %d Miner");
        this.add("gui." + VoidMiners.MODID + ".miners", "Miners");

        this.add("tooltip." + VoidMiners.MODID + ".controller.working", "Miner is working correctly.");

        this.add("tooltip." + VoidMiners.MODID + ".controller.energy", "Energy: %d rf/t");

        this.add("tooltip." + VoidMiners.MODID + ".controller.duration", "Duration: %d ticks");

        this.add("tooltip." + VoidMiners.MODID + ".controller.not_working", "Miner is not working correctly!\nCheck if the miner has at least 1 empty slot, and that the required energy is smaller than the total energy storage");

        this.add("tooltip." + VoidMiners.MODID + ".controller.not_active", "Miner is assembled correctly, but is not active.\nMake sure that the miner can see the void / bedrock!\nThe distance between bedrock and miner does NOT matter, only that the center block can see bedrock!");

        this.add("tooltip." + VoidMiners.MODID + ".controller.missing_structure", "Miner is not assembled correctly, shift right-click the block for a guide. Total needed blocks: ");

        this.add("tooltip." + VoidMiners.MODID + ".controller.dimension_not_ok", "This Miner has no recipes in this dimension!");

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
        this.add("tooltip." + VoidMiners.MODID + ".structure_helper.instructions", "Sneak + right-click on a Miner to complete it. Blocks in the way will be voided");

        this.add("minecraft.overworld", "Overworld");
        this.add("minecraft.the_nether", "The Nether");
        this.add("minecraft.the_end", "The End");

        this.add("config.jade.plugin_voidminers.void_miner", "VoidMiners");
        this.add("jade.voidminers.tier", "Tier: %s");
        this.add("jade.voidminers.energy", "Energy: %s / %s FE");
        this.add("jade.voidminers.status.working", "Status: Working");
        this.add("jade.voidminers.status.idle", "Status: Idle");
        this.add("jade.voidminers.progress", "Progress: %s%%");
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