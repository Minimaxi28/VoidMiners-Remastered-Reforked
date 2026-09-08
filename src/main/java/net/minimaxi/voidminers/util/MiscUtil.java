package net.minimaxi.voidminers.util;

import net.minimaxi.voidminers.init.CrystalSet;
import net.minecraft.locale.Language;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minimaxi.voidminers.world.multiblock.MultiblockPattern;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiscUtil {
    public static final Map<String, Integer> TIER_MAP = new HashMap<>();

    public record PatternPair(
            MultiblockPattern primary,
            MultiblockPattern alternate
    ) {}

    public static final Map<String, PatternPair> PATTERNS = new HashMap<>();

    public static final Map<String, Integer> GLASS_HEIGHT = new HashMap<>();

    static {
        for (int i = 0; i < CrystalSet.sets().size(); i++) {
            CrystalSet set = CrystalSet.sets().get(i);

            TIER_MAP.put("miner_" + set.name, i + 1);
        }

        GLASS_HEIGHT.put("miner_rubetine", 2);
        GLASS_HEIGHT.put("miner_aurantium", 3);
        GLASS_HEIGHT.put("miner_citrinetine", 4);
        GLASS_HEIGHT.put("miner_verdium", 4);
        GLASS_HEIGHT.put("miner_azurine", 4);
        GLASS_HEIGHT.put("miner_caerium", 5);
        GLASS_HEIGHT.put("miner_amethystine", 5);
        GLASS_HEIGHT.put("miner_rosarium", 6);
        GLASS_HEIGHT.put("miner_ultimate", 6);
    }

    public static Map<String, Integer> getNeededBlocks(List<List<List<BlockState>>> structure) {
        Map<String, Integer> blocks = new HashMap<>();

        for (List<List<BlockState>> l1 : structure) {
            for (List<BlockState> l2 : l1) {
                for (BlockState state : l2) {
                    if (!state.getBlock().equals(Blocks.AIR)) {
                        String name = Language.getInstance().getOrDefault(state.getBlock().getDescriptionId());

                        if (!blocks.containsKey(name)) {
                            blocks.put(name, 1);
                        } else {
                            //noinspection DataFlowIssue
                            blocks.compute(name, (k, i) -> i + 1);
                        }
                    }
                }
            }
        }

        return blocks;
    }
}
