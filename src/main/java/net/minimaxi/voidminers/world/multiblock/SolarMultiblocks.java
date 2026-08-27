package net.minimaxi.voidminers.world.multiblock;

import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.datagen.ModBlockTagGenerator;
import net.minimaxi.voidminers.init.ModBlocks;
import net.minimaxi.voidminers.init.SolarSet;
import net.minimaxi.voidminers.util.MiscUtil;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SolarMultiblocks {

    public static final MultiblockPattern RUBETINE = createAccessiblePattern(
            List.of(
                    List.of(
                            " FFF ",
                            "FPPPF",
                            "FPPPF",
                            "FPPPF",
                            " FFF "
                    ),
                    List.of(
                            "  F  ",
                            "     ",
                            "F   F",
                            "     ",
                            "  F  "
                    ),
                    List.of(
                            "     ",
                            "  F  ",
                            " F F ",
                            "  F  ",
                            "     "
                    ),
                    List.of(
                            "     ",
                            "     ",
                            "  *  ",
                            "     ",
                            "     "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.RUBETINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.RUBETINE.FRAME.get())
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.RUBETINE.FRAME.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AURANTIUM1 = createAccessiblePattern(
            List.of(
                    List.of(
                            " FFFFF ",
                            "FPPMPPF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FPPMPPF",
                            " FFFFF "
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
                            "       ",
                            "   F   ",
                            "   F   ",
                            " FF FF ",
                            "   F   ",
                            "   F   ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.AURANTIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.AURANTIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.AURANTIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AURANTIUM2 = createAccessiblePattern(
            List.of(
                    List.of(
                            " FFFFF ",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FMPPPMF",
                            "FPPPPPF",
                            "FPPPPPF",
                            " FFFFF "
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
                            "       ",
                            "   F   ",
                            "   F   ",
                            " FF FF ",
                            "   F   ",
                            "   F   ",
                            "       "
                    ),
                    List.of(
                            "       ",
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.AURANTIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.AURANTIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.AURANTIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern CITRINETINE = createAccessiblePattern(
            List.of(
                    List.of(
                            " FFFFF ",
                            "FMPPPMF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FPPPPPF",
                            "FMPPPMF",
                            " FFFFF "
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
                            "       ",
                            "   F   ",
                            "       ",
                            " F   F ",
                            "       ",
                            "   F   ",
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
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.CITRINETINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.CITRINETINE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.CITRINETINE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern VERDIUM1 = createAccessiblePattern(
            List.of(
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
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.VERDIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.VERDIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.VERDIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern VERDIUM2 = createAccessiblePattern(
            List.of(
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
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.VERDIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.VERDIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.VERDIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AZURINE = createAccessiblePattern(
            List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.AZURINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.AZURINE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.AZURINE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern CAERIUM1 = createAccessiblePattern(
            List.of(
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
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.CAERIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.CAERIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.CAERIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern CAERIUM2 = createAccessiblePattern(
            List.of(
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
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.CAERIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.CAERIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.CAERIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern AMETHYSTINE = createAccessiblePattern(
            List.of(
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
                            "         ",
                            "         ",
                            "         ",
                            "    *    ",
                            "         ",
                            "         ",
                            "         ",
                            "         "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.AMETHYSTINE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.AMETHYSTINE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.AMETHYSTINE.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern ROSARIUM = createAccessiblePattern(
            List.of(
                    List.of(
                            " FFFFF ",
                            "FMPMPMF",
                            "FPPPPPF",
                            "FMPPPMF",
                            "FPPPPPF",
                            "FMPMPMF",
                            " FFFFF "
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
                            " F   F ",
                            "F     F",
                            "       ",
                            "       ",
                            "       ",
                            "F     F",
                            " F   F "
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
                            "   F   ",
                            "       ",
                            "       ",
                            "F     F",
                            "       ",
                            "       ",
                            "   F   "
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
                            "       ",
                            "       ",
                            "   *   ",
                            "       ",
                            "       ",
                            "       "
                    )
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.ROSARIUM.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.ROSARIUM.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.ROSARIUM.FRAME.get()::defaultBlockState,
                    'M', ModBlocks.NULL_MOD.get()::defaultBlockState
            )
    );

    public static final MultiblockPattern ULTIMATE = createAccessiblePattern(
            List.of(
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
            ),
            Map.of(
                    '*', a -> a.getState().is(SolarSet.ULTIMATE.CONTROLLER.get()),
                    'P', a -> a.getState().is(ModBlocks.GLASS_PANEL.get()),
                    'F', a -> a.getState().is(SolarSet.ULTIMATE.FRAME.get()),
                    'M', a -> a.getState().is(ModBlockTagGenerator.SOLAR_MODIFIERS)
            ),
            Map.of(
                    'P', ModBlocks.GLASS_PANEL.get()::defaultBlockState,
                    'F', SolarSet.ULTIMATE.FRAME.get()::defaultBlockState,
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
        VoidMiners.LOGGER.info("Initializing SolarMultiblocks...");

        MiscUtil.PATTERNS.put("solar_rubetine", new MiscUtil.PatternPair(RUBETINE, RUBETINE));
        MiscUtil.PATTERNS.put("solar_aurantium", new MiscUtil.PatternPair(AURANTIUM1, AURANTIUM2));
        MiscUtil.PATTERNS.put("solar_citrinetine", new MiscUtil.PatternPair(CITRINETINE, CITRINETINE));
        MiscUtil.PATTERNS.put("solar_verdium", new MiscUtil.PatternPair(VERDIUM1, VERDIUM2));
        MiscUtil.PATTERNS.put("solar_azurine", new MiscUtil.PatternPair(AZURINE, AZURINE));
        MiscUtil.PATTERNS.put("solar_caerium", new MiscUtil.PatternPair(CAERIUM1, CAERIUM2));
        MiscUtil.PATTERNS.put("solar_amethystine", new MiscUtil.PatternPair(AMETHYSTINE, AMETHYSTINE));
        MiscUtil.PATTERNS.put("solar_rosarium", new MiscUtil.PatternPair(ROSARIUM, ROSARIUM));
        MiscUtil.PATTERNS.put("solar_ultimate", new MiscUtil.PatternPair(ULTIMATE, ULTIMATE));

        VoidMiners.LOGGER.info("SolarMultiblocks initialized successfully!");
    }
}