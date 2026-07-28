package nadiendev.voidminers.init;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.world.block.entity.MinerControllerBaseBE;
import nadiendev.voidminers.world.block.entity.SolarControllerBaseBE;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = 
        DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, VoidMiners.MODID);


    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MinerControllerBaseBE>> MINER_CONTROLLER_BASE_BE =
            BLOCK_ENTITIES.register("controller_base",
                    () -> BlockEntityType.Builder.of(
                            MinerControllerBaseBE::new,
                            CrystalSet.RUBETINE.CONTROLLER.get(),
                            CrystalSet.AURANTIUM.CONTROLLER.get(),
                            CrystalSet.CITRINETINE.CONTROLLER.get(),
                            CrystalSet.VERDIUM.CONTROLLER.get(),
                            CrystalSet.AZURINE.CONTROLLER.get(),
                            CrystalSet.CAERIUM.CONTROLLER.get(),
                            CrystalSet.AMETHYSTINE.CONTROLLER.get(),
                            CrystalSet.ROSARIUM.CONTROLLER.get(),
                            CrystalSet.ULTIMATE.CONTROLLER.get()
                    ).build(null)
            );

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarControllerBaseBE>> SOLAR_BASE_BE =
            BLOCK_ENTITIES.register("solar_base",
                    () -> BlockEntityType.Builder.of(
                            SolarControllerBaseBE::new,
                            SolarSet.RUBETINE.CONTROLLER.get(),
                            SolarSet.AURANTIUM.CONTROLLER.get(),
                            SolarSet.CITRINETINE.CONTROLLER.get(),
                            SolarSet.VERDIUM.CONTROLLER.get(),
                            SolarSet.AZURINE.CONTROLLER.get(),
                            SolarSet.CAERIUM.CONTROLLER.get(),
                            SolarSet.AMETHYSTINE.CONTROLLER.get(),
                            SolarSet.ROSARIUM.CONTROLLER.get(),
                            SolarSet.ULTIMATE.CONTROLLER.get()
                    ).build(null)
            );
}