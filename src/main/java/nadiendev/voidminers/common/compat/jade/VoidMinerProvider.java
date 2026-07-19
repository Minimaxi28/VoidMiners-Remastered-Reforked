package nadiendev.voidminers.common.compat.jade;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.util.MiscUtil;
import nadiendev.voidminers.world.block.entity.ControllerBaseBE;
import nadiendev.voidminers.world.block.entity.HaltReason;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum VoidMinerProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        if (!(accessor.getBlockEntity() instanceof ControllerBaseBE)) {
            return;
        }

        CompoundTag serverData = accessor.getServerData();
        
        if (serverData.contains("Tier")) {
            int tier = serverData.getInt("Tier");
            tooltip.add(Component.translatable("jade." + VoidMiners.MODID + ".tier", tier));
        }

        if (serverData.contains("Energy") && serverData.contains("MaxEnergy")) {
            int energy = serverData.getInt("Energy");
            int maxEnergy = serverData.getInt("MaxEnergy");
            tooltip.add(Component.translatable("jade." + VoidMiners.MODID + ".energy",
                String.format("%,d", energy), 
                String.format("%,d", maxEnergy)));
        }

        if (serverData.contains("MaxStorageUpgradeTier")) {
            int maxStorageUpgradeTier = serverData.getInt("MaxStorageUpgradeTier");
            tooltip.add(Component.translatable("jade." + VoidMiners.MODID + ".max_storage_upgrade_tier", maxStorageUpgradeTier));
        }

        if (serverData.contains("HaltReason")) {
            int haltReasonInt = serverData.getInt("HaltReason");
            HaltReason haltReason = HaltReason.getHaltReasonFromInt(haltReasonInt);
            Component reason;

            if (haltReason != HaltReason.NONE) {
                tooltip.add(Component.translatable("jade." + VoidMiners.MODID + ".status.idle"));

                switch (haltReason) {
                    case NO_RECIPES_IN_DIMENSION -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.no_recipes_in_dimension");
                    case STRUCTURE_NOT_FOUND -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.structure_not_found");
                    case TOO_MUCH_ITEM_MULTIPLIER -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.too_much_item_multiplier");
                    case NOT_ENOUGH_EMPTY_SLOTS -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.not_enough_empty_slots");
                    case NO_BEDROCK_OR_VOID_VIEW -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.no_bedrock_or_void_view");
                    case NOT_ENOUGH_POWER -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.not_enough_power");
                    default -> reason = Component.translatable("jade." + VoidMiners.MODID + ".halt_reason.halt_reason_not_found");
                }
            } else {
                reason = Component.translatable("jade." + VoidMiners.MODID + ".status.working");
            }

            tooltip.add(reason);
        }

        if (serverData.contains("Progress") && serverData.contains("MaxProgress")) {
            int progress = serverData.getInt("Progress");
            int maxProgress = serverData.getInt("MaxProgress");
            
            if (maxProgress > 0) {
                int percentage = (int) ((progress / (float) maxProgress) * 100);
                tooltip.add(Component.translatable("jade." + VoidMiners.MODID + ".progress", percentage));
            }
        }
    }

    @Override
    public void appendServerData(CompoundTag tag, BlockAccessor accessor) {
        if (!(accessor.getBlockEntity() instanceof ControllerBaseBE miner)) {
            return;
        }

        if (miner.getStructure() != null) {
            Integer tier = MiscUtil.tierMap.get(miner.getStructure().getPath());
            if (tier != null) {
                tag.putInt("Tier", tier);
            }
        }

        tag.putInt("Energy", miner.getEnergyStorage().getEnergyStored());
        tag.putInt("MaxEnergy", miner.getEnergyStorage().getMaxEnergyStored());

        tag.putInt("MaxStorageUpgradeTier", miner.getUpgradeTier());

        tag.putInt("HaltReason", HaltReason.getIntFromHaltReason(miner.getHaltReason()));

        tag.putInt("Progress", miner.getProgress());
        tag.putInt("MaxProgress", miner.getMaxProgress());
    }

    @Override
    public ResourceLocation getUid() {
        return ResourceLocation.fromNamespaceAndPath(VoidMiners.MODID, "void_miner");
    }
}