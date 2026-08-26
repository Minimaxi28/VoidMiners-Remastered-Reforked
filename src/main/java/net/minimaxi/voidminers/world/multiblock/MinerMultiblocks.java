package net.minimaxi.voidminers.world.multiblock;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.datagen.ModBlockTagGenerator;
import net.minimaxi.voidminers.init.ModBlocks;
import net.minimaxi.voidminers.init.CrystalSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinerMultiblocks {
    public record PatternPair(
            BlockPattern primary,
            BlockPattern alternate
    ) {}

    public static final Map<String, PatternPair> PATTERNS = new HashMap<>();

    public static BlockPattern RUBETINE = BlockPatternBuilder.start()
            .aisle("     ",
                    "     ",
                    "  *  ",
                    "     ",
                    "     ")
            .aisle("     ",
                    "  F  ",
                    " F F ",
                    "  F  ",
                    "     ")
            .aisle("  F  ",
                    "     ",
                    "F   F",
                    "     ",
                    "  F  ")
            .aisle(" FFF ",
                    "FGGGF",
                    "FGGGF",
                    "FGGGF",
                    " FFF ")
            .where('*', a -> a.getState().is(CrystalSet.RUBETINE.CRYSTAL_BLOCK.get()))
            .where('G', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.RUBETINE.FRAME.get()))
            .build();

    public static BlockPattern AURANTIUM1 = BlockPatternBuilder.start()
            .aisle("       ",
                    "       ",
                    "       ",
                    "   *   ",
                    "       ",
                    "       ",
                    "       ")
            .aisle("       ",
                    "   F   ",
                    "   F   ",
                    " FF FF ",
                    "   F   ",
                    "   F   ",
                    "       ")
            .aisle("   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   ")
            .aisle("   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   ")
            .aisle(" FFFFF ",
                    "FPPMPPF",
                    "FPPPPPF",
                    "FPPPPPF",
                    "FPPPPPF",
                    "FPPMPPF",
                    " FFFFF ")
            .where('*', a -> a.getState().is(CrystalSet.AURANTIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.AURANTIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern AURANTIUM2 = BlockPatternBuilder.start()
            .aisle("       ",
                    "       ",
                    "       ",
                    "   *   ",
                    "       ",
                    "       ",
                    "       ")
            .aisle("       ",
                    "   F   ",
                    "   F   ",
                    " FF FF ",
                    "   F   ",
                    "   F   ",
                    "       ")
            .aisle("   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   ")
            .aisle("   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   ")
            .aisle(" FFFFF ",
                    "FPPPPPF",
                    "FPPPPPF",
                    "FMPPPMF",
                    "FPPPPPF",
                    "FPPPPPF",
                    " FFFFF ")
            .where('*', a -> a.getState().is(CrystalSet.AURANTIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.AURANTIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern CITRINETINE = BlockPatternBuilder.start()
            .aisle("       ",
                    "       ",
                    "       ",
                    "   *   ",
                    "       ",
                    "       ",
                    "       ")
            .aisle("       ",
                    "       ",
                    "   F   ",
                    "  F F  ",
                    "   F   ",
                    "       ",
                    "       ")
            .aisle("       ",
                    "   F   ",
                    "       ",
                    " F   F ",
                    "       ",
                    "   F   ",
                    "       ")
            .aisle("   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   ")
            .aisle("   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   ")
            .aisle(" FFFFF ",
                    "FMPPPMF",
                    "FPPPPPF",
                    "FPPPPPF",
                    "FPPPPPF",
                    "FMPPPMF",
                    " FFFFF ")
            .where('*', a -> a.getState().is(CrystalSet.CITRINETINE.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.CITRINETINE.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern VERDIUM1 = BlockPatternBuilder.start()
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "         ",
                    "    *    ",
                    "         ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "    F    ",
                    "    F    ",
                    "  FF FF  ",
                    "    F    ",
                    "    F    ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "         ",
                    "         ",
                    " F     F ",
                    "         ",
                    "         ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "  FFFFF  ",
                    " FMPMPMF ",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    " FMPMPMF ",
                    "  FFFFF  "
            )
            .where('*', a -> a.getState().is(CrystalSet.VERDIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.VERDIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern VERDIUM2 = BlockPatternBuilder.start()
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "         ",
                    "    *    ",
                    "         ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "    F    ",
                    "    F    ",
                    "  FF FF  ",
                    "    F    ",
                    "    F    ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "         ",
                    "         ",
                    " F     F ",
                    "         ",
                    "         ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "  FFFFF  ",
                    " FPPPPPF ",
                    "FMPPPPPMF",
                    "FPPPPPPPF",
                    "FMPPPPPMF",
                    "FPPPPPPPF",
                    "FMPPPPPMF",
                    " FPPPPPF ",
                    "  FFFFF  "
            )
            .where('*', a -> a.getState().is(CrystalSet.VERDIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.VERDIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern AZURINE = BlockPatternBuilder.start()
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "         ",
                    "    *    ",
                    "         ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "    F    ",
                    "    F    ",
                    " FFF FFF ",
                    "    F    ",
                    "    F    ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "  FFFFF  ",
                    " FMPPPMF ",
                    "FMPPPPPMF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FMPPPPPMF",
                    " FMPPPMF ",
                    "  FFFFF  "
            )
            .where('*', a -> a.getState().is(CrystalSet.AZURINE.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.AZURINE.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern CAERIUM1 = BlockPatternBuilder.start()
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "         ",
                    "    *    ",
                    "         ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "    F    ",
                    "   F F   ",
                    "    F    ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "    F    ",
                    "         ",
                    "  F   F  ",
                    "         ",
                    "    F    ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "         ",
                    "         ",
                    " F     F ",
                    "         ",
                    "         ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "  FFFFF  ",
                    " FMMMMMF ",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    "FPPPPPPPF",
                    " FMMMMMF ",
                    "  FFFFF  "
            )
            .where('*', a -> a.getState().is(CrystalSet.CAERIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.CAERIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern CAERIUM2 = BlockPatternBuilder.start()
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "         ",
                    "    *    ",
                    "         ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "    F    ",
                    "   F F   ",
                    "    F    ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "    F    ",
                    "         ",
                    "  F   F  ",
                    "         ",
                    "    F    ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "         ",
                    "         ",
                    " F     F ",
                    "         ",
                    "         ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "  FFFFF  ",
                    " FPPPPPF ",
                    "FMPPPPPMF",
                    "FMPPPPPMF",
                    "FMPPPPPMF",
                    "FMPPPPPMF",
                    "FMPPPPPMF",
                    " FPPPPPF ",
                    "  FFFFF  "
            )
            .where('*', a -> a.getState().is(CrystalSet.CAERIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.CAERIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern AMETHYSTINE = BlockPatternBuilder.start()
            .aisle(
                    "         ",
                    "         ",
                    "         ",
                    "         ",
                    "    *    ",
                    "         ",
                    "         ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "         ",
                    "    F    ",
                    "    F    ",
                    "  FF FF  ",
                    "    F    ",
                    "    F    ",
                    "         ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "         ",
                    "         ",
                    " F     F ",
                    "         ",
                    "         ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "         ",
                    "    F    ",
                    "         ",
                    "         ",
                    " F     F ",
                    "         ",
                    "         ",
                    "    F    ",
                    "         "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "    F    ",
                    "         ",
                    "         ",
                    "         ",
                    "F       F",
                    "         ",
                    "         ",
                    "         ",
                    "    F    "
            )
            .aisle(
                    "   FFF   ",
                    "  FMMMF  ",
                    " FPPPPPF ",
                    "FMPPPPPMF",
                    "FMPPPPPMF",
                    "FMPPPPPMF",
                    " FPPPPPF ",
                    "  FMMMF  ",
                    "   FFF   "
            )
            .where('*', a -> a.getState().is(CrystalSet.AMETHYSTINE.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.AMETHYSTINE.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern ROSARIUM = BlockPatternBuilder.start()
            .aisle(
                    "       ",
                    "       ",
                    "       ",
                    "   *   ",
                    "       ",
                    "       ",
                    "       "
            )
            .aisle(
                    "       ",
                    "       ",
                    "   F   ",
                    "  F F  ",
                    "   F   ",
                    "       ",
                    "       "
            )
            .aisle(
                    "       ",
                    "   F   ",
                    "       ",
                    " F   F ",
                    "       ",
                    "   F   ",
                    "       "
            )
            .aisle(
                    "   F   ",
                    "       ",
                    "       ",
                    "F     F",
                    "       ",
                    "       ",
                    "   F   "
            )
            .aisle(
                    "  FFF  ",
                    " FPMPF ",
                    "FPMPMPF",
                    "FMPPPMF",
                    "FPMPMPF",
                    " FPMPF ",
                    "  FFF  "
            )
            .aisle(
                    " F   F ",
                    "F     F",
                    "       ",
                    "       ",
                    "       ",
                    "F     F",
                    " F   F "
            )
            .aisle(
                    "F     F",
                    "       ",
                    "       ",
                    "       ",
                    "       ",
                    "       ",
                    "F     F"
            )
            .aisle(
                    " FFFFF ",
                    "FMPMPMF",
                    "FPPPPPF",
                    "FMPPPMF",
                    "FPPPPPF",
                    "FMPMPMF",
                    " FFFFF "
            )
            .where('*', a -> a.getState().is(CrystalSet.ROSARIUM.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.ROSARIUM.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    public static BlockPattern ULTIMATE = BlockPatternBuilder.start()
            .aisle(
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "     *     ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "           "
            )
            .aisle(
                    "           ",
                    "           ",
                    "           ",
                    "     F     ",
                    "     F     ",
                    "   FF FF   ",
                    "     F     ",
                    "     F     ",
                    "           ",
                    "           ",
                    "           "
            )
            .aisle(
                    "           ",
                    "           ",
                    "     F     ",
                    "           ",
                    "           ",
                    "  F     F  ",
                    "           ",
                    "           ",
                    "     F     ",
                    "           ",
                    "           "
            )
            .aisle(
                    "           ",
                    "     F     ",
                    "           ",
                    "           ",
                    "           ",
                    " F       F ",
                    "           ",
                    "           ",
                    "           ",
                    "     F     ",
                    "           "
            )
            .aisle(
                    "     F     ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "F         F",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "     F     "
            )
            .aisle(
                    "     F     ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "F         F",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "     F     "
            )
            .aisle(
                    "     F     ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "F         F",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "     F     "
            )
            .aisle(
                    "   FFFFF   ",
                    "  FMMMMMF  ",
                    " FMPPPPPMF ",
                    "FMPPPPPPPMF",
                    "FMPPPPPPPMF",
                    "FMPPPPPPPMF",
                    "FMPPPPPPPMF",
                    "FMPPPPPPPMF",
                    " FMPPPPPMF ",
                    "  FMMMMMF  ",
                    "   FFFFF   "
            )
            .aisle(
                    " F       F ",
                    "F         F",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "           ",
                    "F         F",
                    " F       F "
            )
            .where('*', a -> a.getState().is(CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get()))
            .where('P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()))
            .where('F', a -> a.getState().is(CrystalSet.ULTIMATE.FRAME.get()))
            .where('M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS))
            .build();

    private static List<List<List<BlockState>>> extractStructureFromPattern(BlockPattern pattern) {

        pattern.getPattern();
        // Get the pattern builder's internal structure
        // Since BlockPattern doesn't expose its internal structure directly,
        // we need to rebuild it from the pattern's data

        // Create a 3D list to store block states
        List<List<List<BlockState>>> structure = new ArrayList<>();

        // The BlockPattern stores its data in a private field, but we can
        // recreate the structure from the pattern's aisle strings
        // We need to store the pattern data when building or extract it differently

        // One approach: store the pattern data separately when building
        // For now, we'll return an empty structure and you'll need to adapt
        return structure;
    }

    public static void init() {
        VoidMiners.LOGGER.info("Initializing MinerMultiblocks...");

        PATTERNS.put("miner_rubetine", new PatternPair(RUBETINE, RUBETINE));
        PATTERNS.put("miner_aurantium", new PatternPair(AURANTIUM1, AURANTIUM2));
        PATTERNS.put("miner_citrinetine", new PatternPair(CITRINETINE, CITRINETINE));
        PATTERNS.put("miner_verdium", new PatternPair(VERDIUM1, VERDIUM2));
        PATTERNS.put("miner_azurine", new PatternPair(AZURINE, AZURINE));
        PATTERNS.put("miner_caerium", new PatternPair(CAERIUM1, CAERIUM2));
        PATTERNS.put("miner_amethystine", new PatternPair(AMETHYSTINE, AMETHYSTINE));
        PATTERNS.put("miner_rosarium", new PatternPair(ROSARIUM, ROSARIUM));
        PATTERNS.put("miner_ultimate", new PatternPair(ULTIMATE, ULTIMATE));

        VoidMiners.LOGGER.info("MinerMultiblocks initialized successfully!");
    }
}