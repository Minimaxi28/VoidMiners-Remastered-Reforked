package nadiendev.voidminers.common.compat.jade;

import nadiendev.voidminers.world.block.entity.MinerControllerBaseBE;
import nadiendev.voidminers.world.block.entity.SolarControllerBaseBE;
import net.minecraft.world.level.block.Block;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadePlugin implements IWailaPlugin {
    
    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(MinerProvider.INSTANCE, MinerControllerBaseBE.class);
        registration.registerBlockDataProvider(SolarProvider.INSTANCE, SolarControllerBaseBE.class);
    }
    
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MinerProvider.INSTANCE, Block.class);
        registration.registerBlockComponent(SolarProvider.INSTANCE, Block.class);
    }
}