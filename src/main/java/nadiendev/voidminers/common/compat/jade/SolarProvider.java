package nadiendev.voidminers.common.compat.jade;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.util.MiscUtil;
import nadiendev.voidminers.world.block.entity.MinerControllerBaseBE;
import nadiendev.voidminers.world.block.entity.HaltReason;
import nadiendev.voidminers.world.block.entity.SolarControllerBaseBE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum SolarProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        if (!(accessor.getBlockEntity() instanceof SolarControllerBaseBE)) {
            return;
        }

        CompoundTag serverData = accessor.getServerData();

        if (serverData.contains("Tier")) {
            int tier = serverData.getInt("Tier");
            tooltip.add(Component.translatable("jade.voidminers.tier", tier));
        }

        if (serverData.contains("Energy") && serverData.contains("MaxEnergy")) {
            int energy = serverData.getInt("Energy");
            int maxEnergy = serverData.getInt("MaxEnergy");
            tooltip.add(Component.translatable("jade.voidminers.energy",
                    String.format("%,d", energy),
                    String.format("%,d", maxEnergy)));
        }

        if (serverData.contains("HaltReason")) {
            int haltReasonInt = serverData.getInt("HaltReason");
            HaltReason haltReason = HaltReason.getHaltReasonFromInt(haltReasonInt);
            Component reason;

            if (haltReason != HaltReason.NONE) {
                tooltip.add(Component.translatable("jade.voidminers.status.idle"));

                switch (haltReason) {
                    case STRUCTURE_NOT_FOUND -> reason = Component.translatable("jade.voidminers.halt_reason.structure_not_found");
                    case NO_SKY_VIEW -> reason = Component.translatable("jade.voidminers.halt_reason.no_sky_view");
                    case POWER_FULL -> reason = Component.translatable("jade.voidminers.halt_reason.power_full");
                    default -> reason = Component.translatable("jade.voidminers.halt_reason.halt_reason_not_found");
                }
            } else {
                reason = Component.translatable("jade.voidminers.status.working");
            }

            tooltip.add(reason);
        }
    }

    @Override
    public void appendServerData(CompoundTag tag, BlockAccessor accessor) {
        if (!(accessor.getBlockEntity() instanceof SolarControllerBaseBE solar)) {
            return;
        }

        if (solar.getStructure() != null) {
            Integer tier = MiscUtil.tierMap.get(solar.getStructure().getPath());
            if (tier != null) {
                tag.putInt("Tier", tier);
            }
        }

        tag.putLong("Energy", solar.getEnergyStorage().getLongEnergyStored());
        tag.putLong("MaxEnergy", solar.getEnergyStorage().getLongMaxEnergyStored());

        tag.putInt("HaltReason", HaltReason.getIntFromHaltReason(solar.getHaltReason()));
    }

    @Override
    public ResourceLocation getUid() {
        return ResourceLocation.fromNamespaceAndPath(VoidMiners.MODID, "solars");
    }
}