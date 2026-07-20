package nadiendev.voidminers.world.item;

import nadiendev.voidminers.world.block.entity.ControllerBaseBE;
import nadiendev.voidminers.world.multiblock.MinerMultiblocks;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.mangorage.mangomultiblock.core.manager.RegisteredMultiBlockPattern;

import java.util.List;

public class StructureHelperItem extends Item {
    public StructureHelperItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getPlayer() == null) return InteractionResult.PASS;

        BlockPos pos = pContext.getClickedPos();
        Level level = pContext.getLevel();

        if (!(level instanceof ServerLevel)) {
            return InteractionResult.PASS;
        }

        BlockEntity entity = level.getBlockEntity(pos);

        if(!(entity instanceof ControllerBaseBE controller)) return InteractionResult.PASS;
        ResourceLocation structure = controller.getStructure();
        RegisteredMultiBlockPattern multiBlock = MinerMultiblocks.MANAGER.getStructure(structure);

        if (!((ServerPlayer) pContext.getPlayer()).gameMode.isCreative()) {
            return InteractionResult.CONSUME;
        }

        assert multiBlock != null;
        multiBlock.pattern().construct(level, pos);
        return InteractionResult.CONSUME;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.translatable("tooltip.voidminers.structure_helper.creative_only").withStyle(ChatFormatting.RED)
                .append(Component.translatable("tooltip.voidminers.structure_helper.instructions").withStyle(ChatFormatting.LIGHT_PURPLE)));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
