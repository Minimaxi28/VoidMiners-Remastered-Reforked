package net.minimaxi.voidminers.event;

import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.init.ModBlockEntities;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;

@EventBusSubscriber(modid = VoidMiners.MODID)
public class ModBusEvent {
    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
            Capabilities.EnergyStorage.BLOCK,
            ModBlockEntities.MINER_CONTROLLER_BE.get(),
            ((o, direction) -> o.getEnergyStorage())
        );

        event.registerBlockEntity(
            Capabilities.ItemHandler.BLOCK,
            ModBlockEntities.MINER_CONTROLLER_BE.get(),
            (be, side) -> be.getItemHandler()
        );

        event.registerBlockEntity(
                Capabilities.EnergyStorage.BLOCK,
                ModBlockEntities.SOLAR_CONTROLLER_BE.get(),
                ((o, direction) -> o.getEnergyStorage())
        );
    }
}