package net.minimaxi.voidminers.event;

import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.client.render.block.MinerControllerRenderer;
import net.minimaxi.voidminers.client.render.block.SolarControllerRenderer;
import net.minimaxi.voidminers.init.ModBlockEntities;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = VoidMiners.MOD_ID, value = Dist.CLIENT)
public class ModBusClientEvent {

    @SubscribeEvent
    public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(ModBlockEntities.MINER_CONTROLLER_BE.get(), MinerControllerRenderer::new);
        event.registerBlockEntityRenderer(ModBlockEntities.SOLAR_CONTROLLER_BE.get(), SolarControllerRenderer::new);
    }
}