package net.minimaxi.voidminers.world.multiblock;

import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.datagen.ModBlockTagGenerator;
import net.minimaxi.voidminers.init.ModBlocks;
import net.minimaxi.voidminers.init.CrystalSet;
import net.minimaxi.voidminers.util.MiscUtil;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MinerMultiblocks {

    public static final MultiblockPattern RUBETINE = createAccessiblePattern(
            List.of(
                    List.of(
                            "     ",
                            "     ",
                            "  *  ",
                            "     ",
                            "     "
                    ),
                    List.of(
                            "     ",
                            "  F  ",
                            " F F ",
                            "  F  ",
                            "     "
                    ),
                    List.of(
                            "  F  ",
                            "     ",
                            "F   F",
                            "     ",
                            "  F  "
                    ),
                    List.of(
                            " FFF ",
                            "FPPPF",
                            "FPPPF",
                            "FPPPF",
                            " FFF "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.RUBETINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.RUBETINE.FRAME.get())
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.RUBETINE.FRAME.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AURANTIUM1 = createAccessiblePattern(
            List.of(
                    List.of(
                            "       ",
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "   F   ",
                            "   F   ",
                            " FF FF ",
                            "   F   ",
                            "   F   ",
                            "       "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            " FFFFF ",
                            "FPPMPPF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FPPMPPF",
                            " FFFFF "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.AURANTIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.AURANTIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.AURANTIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AURANTIUM2 = createAccessiblePattern(
            List.of(
                    List.of(
                            "       ",
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "   F   ",
                            "   F   ",
                            " FF FF ",
                            "   F   ",
                            "   F   ",
                            "       "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            " FFFFF ",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FMPPPMF",
                            "FPPPPPF",
                            "FPPPPPF",
                            " FFFFF "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.AURANTIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.AURANTIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.AURANTIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern CITRINETINE = createAccessiblePattern(
            List.of(
                    List.of(
                            "       ",
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "       ",
                            "   F   ",
                            "  F F  ",
                            "   F   ",
                            "       ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "   F   ",
                            "       ",
                            " F   F ",
                            "       ",
                            "   F   ",
                            "       "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            " FFFFF ",
                            "FMPPPMF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FMPPPMF",
                            " FFFFF "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.CITRINETINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.CITRINETINE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.CITRINETINE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern VERDIUM1 = createAccessiblePattern(
            List.of(
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "    F    ",
                            "    F    ",
                            "  FF FF  ",
                            "    F    ",
                            "    F    ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "         ",
                            "         ",
                            " F     F ",
                            "         ",
                            "         ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.VERDIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.VERDIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.VERDIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern VERDIUM2 = createAccessiblePattern(
            List.of(
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "    F    ",
                            "    F    ",
                            "  FF FF  ",
                            "    F    ",
                            "    F    ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "         ",
                            "         ",
                            " F     F ",
                            "         ",
                            "         ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.VERDIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.VERDIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.VERDIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AZURINE = createAccessiblePattern(
            List.of(
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "    F    ",
                            "    F    ",
                            " FFF FFF ",
                            "    F    ",
                            "    F    ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.AZURINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.AZURINE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.AZURINE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern CAERIUM1 = createAccessiblePattern(
            List.of(
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "    F    ",
                            "   F F   ",
                            "    F    ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "    F    ",
                            "         ",
                            "  F   F  ",
                            "         ",
                            "    F    ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "         ",
                            "         ",
                            " F     F ",
                            "         ",
                            "         ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.CAERIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.CAERIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.CAERIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern CAERIUM2 = createAccessiblePattern(
            List.of(
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "    F    ",
                            "   F F   ",
                            "    F    ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "    F    ",
                            "         ",
                            "  F   F  ",
                            "         ",
                            "    F    ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "         ",
                            "         ",
                            " F     F ",
                            "         ",
                            "         ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.CAERIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.CAERIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.CAERIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AMETHYSTINE = createAccessiblePattern(
            List.of(
                    List.of(
                            "         ",
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "         ",
                            "    F    ",
                            "    F    ",
                            "  FF FF  ",
                            "    F    ",
                            "    F    ",
                            "         ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "         ",
                            "         ",
                            " F     F ",
                            "         ",
                            "         ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "         ",
                            "    F    ",
                            "         ",
                            "         ",
                            " F     F ",
                            "         ",
                            "         ",
                            "    F    ",
                            "         "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
                            "    F    ",
                            "         ",
                            "         ",
                            "         ",
                            "F       F",
                            "         ",
                            "         ",
                            "         ",
                            "    F    "
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.AMETHYSTINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.AMETHYSTINE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.AMETHYSTINE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern ROSARIUM = createAccessiblePattern(
            List.of(
                    List.of(
                            "       ",
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "       ",
                            "   F   ",
                            "  F F  ",
                            "   F   ",
                            "       ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "   F   ",
                            "       ",
                            " F   F ",
                            "       ",
                            "   F   ",
                            "       "
                    ),
                    List.of(
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
                    ),
                    List.of(
                            "  FFF  ",
                            " FPMPF ",
                            "FPMPMPF",
                            "FMPPPMF",
                            "FPMPMPF",
                            " FPMPF ",
                            "  FFF  "
                    ),
                    List.of(
                            " F   F ",
                            "F     F",
                            "       ",
                            "       ",
                            "       ",
                            "F     F",
                            " F   F "
                    ),
                    List.of(
                            "F     F",
                            "       ",
                            "       ",
                            "       ",
                            "       ",
                            "       ",
                            "F     F"
                    ),
                    List.of(
                            " FFFFF ",
                            "FMPMPMF",
                            "FPPPPPF",
                            "FMPPPMF",
                            "FPPPPPF",
                            "FMPMPMF",
                            " FFFFF "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.ROSARIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.ROSARIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.ROSARIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern ULTIMATE = createAccessiblePattern(
            List.of(
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
                    ),
                    List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(CrystalSet.ULTIMATE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(CrystalSet.ULTIMATE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.MINER_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', CrystalSet.ULTIMATE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static MultiblockPattern createAccessiblePattern(List<List<String>> stringPattern, Map<Character, Predicate<BlockInWorld>> lookup, Map<Character, Supplier<BlockState>> blockProvider) {
        MultiblockPatternBuilder pattern = MultiblockPatternBuilder.start();

        for (List<String> strings : stringPattern) {
            pattern.aisle(strings.toArray(new String[]{}));
        }

        lookup.forEach(pattern::where);
        blockProvider.forEach(pattern::block);

        return pattern.build();
    }

    public static void init() {
        VoidMiners.LOGGER.info("Initializing MinerMultiblocks...");

        MiscUtil.PATTERNS.put("miner_rubetine", new MiscUtil.PatternPair(RUBETINE, RUBETINE));
        MiscUtil.PATTERNS.put("miner_aurantium", new MiscUtil.PatternPair(AURANTIUM1, AURANTIUM2));
        MiscUtil.PATTERNS.put("miner_citrinetine", new MiscUtil.PatternPair(CITRINETINE, CITRINETINE));
        MiscUtil.PATTERNS.put("miner_verdium", new MiscUtil.PatternPair(VERDIUM1, VERDIUM2));
        MiscUtil.PATTERNS.put("miner_azurine", new MiscUtil.PatternPair(AZURINE, AZURINE));
        MiscUtil.PATTERNS.put("miner_caerium", new MiscUtil.PatternPair(CAERIUM1, CAERIUM2));
        MiscUtil.PATTERNS.put("miner_amethystine", new MiscUtil.PatternPair(AMETHYSTINE, AMETHYSTINE));
        MiscUtil.PATTERNS.put("miner_rosarium", new MiscUtil.PatternPair(ROSARIUM, ROSARIUM));
        MiscUtil.PATTERNS.put("miner_ultimate", new MiscUtil.PatternPair(ULTIMATE, ULTIMATE));

        VoidMiners.LOGGER.info("MinerMultiblocks initialized successfully!");
    }
}