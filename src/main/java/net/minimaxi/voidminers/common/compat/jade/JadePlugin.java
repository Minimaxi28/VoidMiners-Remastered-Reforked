package net.minimaxi.voidminers.common.compat.jade;

import net.minimaxi.voidminers.world.block.entity.MinerControllerBE;
import net.minimaxi.voidminers.world.block.entity.SolarControllerBE;
import net.minecraft.world.level.block.Block;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    
    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(MinerProvider.INSTANCE, MinerControllerBE.class);
        registration.registerBlockDataProvider(SolarProvider.INSTANCE, SolarControllerBE.class);
    }
    
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MinerProvider.INSTANCE, Block.class);
        registration.registerBlockComponent(SolarProvider.INSTANCE, Block.class);
    }
}