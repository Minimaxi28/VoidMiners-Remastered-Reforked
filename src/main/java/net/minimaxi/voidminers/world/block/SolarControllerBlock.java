package net.minimaxi.voidminers.world.block;

import net.minecraft.ChatFormatting;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minimaxi.voidminers.config.SolarConfigLoader;
import net.minimaxi.voidminers.util.CustomColorUtil;
import net.minimaxi.voidminers.world.block.entity.SolarControllerBE;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SolarControllerBlock extends ColoredBlock implements EntityBlock {
    final ResourceLocation structure;
    final String name;

    public SolarControllerBlock(Properties pProperties, ResourceLocation structure, String name, CustomColorUtil color) {
        super(pProperties, color);
        this.structure = structure;
        this.name = name;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new SolarControllerBE(blockPos, blockState);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHit) {
        SolarControllerBE blockEntity = (SolarControllerBE) pLevel.getBlockEntity(pPos);

        if (pLevel.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (pPlayer.isCrouching()) {
            if (blockEntity != null && !blockEntity.foundStructure) {
                blockEntity.updateShowStructure();
            }
            return InteractionResult.CONSUME;
        }

        if (blockEntity != null) {
            for (Component component : blockEntity.getInteractionTooltip()) {
                pPlayer.displayClientMessage(component, false);
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void setPlacedBy(@NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @Nullable LivingEntity pPlacer, @NotNull ItemStack pStack) {
        super.setPlacedBy(pLevel, pPos, pState, pPlacer, pStack);

        SolarControllerBE controller = ((SolarControllerBE) pLevel.getBlockEntity(pPos));
        if (controller == null) {
            controller = ((SolarControllerBE) this.newBlockEntity(pPos, pState));
        }

        if (controller != null) {
            controller.setup(structure, name);
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide()) {
            return null;
        }

        return ((level, blockPos, blockState, be) -> {
            if (be instanceof SolarControllerBE controllerBE) {
                controllerBE.tick(pLevel, blockPos, blockState, structure, name);
            }
        });
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        SolarConfigLoader.ControllerConfig config = SolarConfigLoader.getInstance().getControllerConfig(name);

        tooltipComponents.add(Component.literal(String.format("Generation Per Tick: %s", formatEnergy(config.energyGenerationPerTick()))).withStyle(ChatFormatting.YELLOW));
        tooltipComponents.add(Component.literal(String.format("Energy Capacity: %s", formatEnergy(config.energyStorage()))).withStyle(ChatFormatting.GOLD));

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    private static String formatEnergy(long value) {
        if (value < 1000) {
            return value + " FE";
        }

        String[] units = {"FE", "KFE", "MFE", "GFE", "TFE", "PFE", "EFE"};
        double scaled = value;
        int unitIndex = 0;

        while (scaled >= 1000.0 && unitIndex < units.length - 1) {
            scaled /= 1000.0;
            unitIndex++;
        }

        double rounded = Math.round(scaled * 100.0) / 100.0;
        if (rounded >= 1000.0 && unitIndex < units.length - 1) {
            scaled = rounded / 1000.0;
            unitIndex++;
        } else {
            scaled = rounded;
        }

        return String.format("%.2f %s", scaled, units[unitIndex]);
    }
}
