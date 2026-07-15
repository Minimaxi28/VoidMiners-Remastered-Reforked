package nadiendev.voidminers.datagen;

import nadiendev.voidminers.VoidMiners;
import nadiendev.voidminers.init.ModBlocks;
import nadiendev.voidminers.init.CrystalSet;
import nadiendev.voidminers.init.ModItems;
import nadiendev.voidminers.server.recipe.MinerRecipe;
import nadiendev.voidminers.server.recipe.WeightedStack;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput pWriter) {

        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC,
                ModBlocks.STRUCTURE_PANEL.get(),
                1
            )
            .pattern("IGI")
            .pattern("GRG")
            .pattern("IGI")
            .define('R', Items.REDSTONE)
            .define('G', Items.GOLD_NUGGET)
            .define('I', Items.IRON_INGOT)
            .unlockedBy("hasItem", has(Items.IRON_INGOT))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC,
                ModBlocks.FRAME_BASE.get(),
                1
            )
            .pattern("GIG")
            .pattern("ISI")
            .pattern("GIG")
            .define('S', ModBlocks.STRUCTURE_PANEL.get())
            .define('G', Items.GOLD_NUGGET)
            .define('I', Items.IRON_INGOT)
            .unlockedBy("hasItem", has(Items.IRON_INGOT))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC,
                ModBlocks.NULL_MOD.get(),
                1
            )
            .pattern("OIO")
            .pattern("IGI")
            .pattern("OIO")
            .define('O', Blocks.OBSIDIAN)
            .define('G', ModBlocks.STRUCTURE_PANEL.get())
            .define('I', Items.IRON_INGOT)
            .unlockedBy("hasItem", has(Items.IRON_INGOT))
            .save(pWriter);

        ShapelessRecipeBuilder.shapeless(
                RecipeCategory.MISC,
                ModBlocks.GLASS_PANEL.get(),
                1
            )
            .requires(ModBlocks.STRUCTURE_PANEL.get())
            .requires(Items.GLASS)
            .unlockedBy("hasItem", has(ModBlocks.STRUCTURE_PANEL.get()))
            .save(pWriter);

        ShapedRecipeBuilder.shaped(
                RecipeCategory.MISC,
                CrystalSet.RUBETINE.CRYSTAL.get(),
                4
            )
            .pattern("RBR")
            .pattern("BDB")
            .pattern("RBR")
            .define('R', Items.REDSTONE)
            .define('B', Items.BLAZE_POWDER)
            .define('D', Items.DIAMOND)
            .unlockedBy("hasItem", has(Items.DIAMOND))
            .save(pWriter);

        List<CrystalSet> allSets = CrystalSet.sets();
        for (int i = 0; i < allSets.size(); i++) {
            CrystalSet set = allSets.get(i);

            // Skip sets without crystals (like ultimate set)
            if (set.CRYSTAL == null) {
                continue;
            }

            ShapedRecipeBuilder.shaped(
                    RecipeCategory.MISC,
                    set.MINER_CONTROLLER.get(),
                    1
                )
                .pattern("GGG")
                .pattern("GCG")
                .pattern("BOB")
                .define('G', Items.GLASS)
                .define('B', set.CRYSTAL_BLOCK.get())
                .define('O', Blocks.OBSIDIAN)
                .define('C', i > 0 ? allSets.get(i - 1).MINER_CONTROLLER.get() : Items.DIAMOND)
                .unlockedBy("hasItem", has(set.CRYSTAL_BLOCK.get()))
                .save(pWriter);

            ShapedRecipeBuilder.shaped(
                    RecipeCategory.MISC,
                    set.SPEED_MOD.get(),
                    1
                )
                .pattern("CcC")
                .pattern("cMc")
                .pattern("CcC")
                .define('C', set.CRYSTAL.get())
                .define('c', Items.SUGAR)
                .define('M', i > 0 ? allSets.get(i - 1).SPEED_MOD.get() : ModBlocks.NULL_MOD.get())
                .unlockedBy("hasItem", has(ModBlocks.NULL_MOD.get()))
                .save(pWriter);

            ShapedRecipeBuilder.shaped(
                    RecipeCategory.MISC,
                    set.FRAME.get(),
                    1
                )
                .pattern("COC")
                .pattern("OFO")
                .pattern("COC")
                .define('C', set.CRYSTAL.get())
                .define('O', Blocks.OBSIDIAN)
                .define('F', i > 0 ? allSets.get(i - 1).FRAME.get() : ModBlocks.FRAME_BASE.get())
                .unlockedBy("hasItem", has(ModBlocks.FRAME_BASE.get()))
                .save(pWriter);

            ShapedRecipeBuilder.shaped(
                    RecipeCategory.MISC,
                    set.ENERGY_MOD.get(),
                    1
                )
                .pattern("CcC")
                .pattern("cMc")
                .pattern("CcC")
                .define('C', set.CRYSTAL.get())
                .define('c', Items.REDSTONE)
                .define('M', i > 0 ? allSets.get(i - 1).ENERGY_MOD.get() : ModBlocks.NULL_MOD.get())
                .unlockedBy("hasItem", has(ModBlocks.NULL_MOD.get()))
                .save(pWriter);

            ShapedRecipeBuilder.shaped(
                    RecipeCategory.MISC,
                    set.ITEM_MOD.get(),
                    1
                )
                .pattern("CcC")
                .pattern("cMc")
                .pattern("CcC")
                .define('C', set.CRYSTAL.get())
                .define('c', Items.DIAMOND)
                .define('M', i > 0 ? allSets.get(i - 1).ITEM_MOD.get() : ModBlocks.NULL_MOD.get())
                .unlockedBy("hasItem", has(ModBlocks.NULL_MOD.get()))
                .save(pWriter);

            ShapelessRecipeBuilder.shapeless(
                    RecipeCategory.MISC,
                    set.CRYSTAL_BLOCK.get(),
                    1
                )
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .requires(set.CRYSTAL.get())
                .unlockedBy("hasItem", has(set.CRYSTAL.get()))
                .save(pWriter);

            ShapelessRecipeBuilder.shapeless(
                    RecipeCategory.MISC,
                    set.CRYSTAL.get(),
                    9
                )
                .requires(set.CRYSTAL_BLOCK.get())
                .unlockedBy("hasItem", has(set.CRYSTAL_BLOCK.get()))
                .save(pWriter, ResourceLocation.fromNamespaceAndPath(VoidMiners.MODID, set.name + "_crystal_from_block"));
        }

        // Custom ultimate recipes (no standalone crystal item available)
        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        CrystalSet.ULTIMATE.MINER_CONTROLLER.get(),
                        1
                )
                .pattern("GGG")
                .pattern("GCG")
                .pattern("BOB")
                .define('G', Items.GLASS)
                .define('B', CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get())
                .define('O', Blocks.OBSIDIAN)
                .define('C', CrystalSet.ROSARIUM.MINER_CONTROLLER.get())
                .unlockedBy("hasItem", has(CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get(),
                        1
                )
                .pattern("RRR")
                .pattern("RNR")
                .pattern("RRR")
                .define('R', CrystalSet.ROSARIUM.CRYSTAL_BLOCK.get())
                .define('N', Items.NETHER_STAR)
                .unlockedBy("hasItem", has(CrystalSet.ROSARIUM.CRYSTAL_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        CrystalSet.ULTIMATE.FRAME.get(),
                        1
                )
                .pattern("BOB")
                .pattern("OFO")
                .pattern("BNB")
                .define('B', CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get())
                .define('O', Blocks.OBSIDIAN)
                .define('N', Items.NETHER_STAR)
                .define('F', CrystalSet.ROSARIUM.FRAME.get())
                .unlockedBy("hasItem", has(CrystalSet.ROSARIUM.FRAME.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        CrystalSet.ULTIMATE.SPEED_MOD.get(),
                        1
                )
                .pattern("CcC")
                .pattern("cMc")
                .pattern("CcC")
                .define('C', CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get())
                .define('c', Items.SUGAR)
                .define('M', CrystalSet.ROSARIUM.SPEED_MOD.get())
                .unlockedBy("hasItem", has(CrystalSet.ROSARIUM.SPEED_MOD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        CrystalSet.ULTIMATE.ENERGY_MOD.get(),
                        1
                )
                .pattern("CcC")
                .pattern("cMc")
                .pattern("CcC")
                .define('C', CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get())
                .define('c', Items.REDSTONE)
                .define('M', CrystalSet.ROSARIUM.ENERGY_MOD.get())
                .unlockedBy("hasItem", has(CrystalSet.ROSARIUM.ENERGY_MOD.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        CrystalSet.ULTIMATE.ITEM_MOD.get(),
                        1
                )
                .pattern("CcC")
                .pattern("cMc")
                .pattern("CcC")
                .define('C', CrystalSet.ULTIMATE.CRYSTAL_BLOCK.get())
                .define('c', Items.DIAMOND)
                .define('M', CrystalSet.ROSARIUM.ITEM_MOD.get())
                .unlockedBy("hasItem", has(CrystalSet.ROSARIUM.ITEM_MOD.get()))
                .save(pWriter);

        List<WeightedStack> OVERWORLD = List.of(
            new WeightedStack(
                Items.EMERALD_ORE,
                1f
            ),
            new WeightedStack(
                Items.DIAMOND_ORE,
                2f
            ),
            new WeightedStack(
                Items.GOLD_ORE,
                4f
            ),
            new WeightedStack(
                Items.REDSTONE_ORE,
                6f
            ),
            new WeightedStack(
                Items.LAPIS_ORE,
                6f
            ),
            new WeightedStack(
                Items.IRON_ORE,
                8f
            ),
            new WeightedStack(
                Items.COPPER_ORE,
                12f
            ),
            new WeightedStack(
                Items.COAL_ORE,
                16f
            ),
            new WeightedStack(
                CrystalSet.RUBETINE.CRYSTAL.get(),
                2f
            ),
            new WeightedStack(
                CrystalSet.AURANTIUM.CRYSTAL.get(),
                2f
            )
        );

        for (WeightedStack stack : OVERWORLD) {
            MinerRecipe.Builder.builder(
                stack,
                1,
                Level.OVERWORLD
            ).save(pWriter);
        }

        List<WeightedStack> NETHER = List.of(
            new WeightedStack(
                Items.NETHER_QUARTZ_ORE,
                10f
            ),
            new WeightedStack(
                Items.NETHER_GOLD_ORE,
                5f
            ),
            new WeightedStack(
                Items.ANCIENT_DEBRIS,
                0.1f
            ),
            new WeightedStack(
                CrystalSet.RUBETINE.CRYSTAL.get(),
                2f
            ),
            new WeightedStack(
                CrystalSet.AURANTIUM.CRYSTAL.get(),
                2f
            )
        );

        for (WeightedStack stack : NETHER) {
            MinerRecipe.Builder.builder(
                stack,
                1,
                Level.NETHER
            ).save(pWriter);
        }

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.CITRINETINE.CRYSTAL.get(),
                2f
            ),
            2,
            Level.OVERWORLD
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.CITRINETINE.CRYSTAL.get(),
                4f
            ),
            2,
            Level.NETHER
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.VERDIUM.CRYSTAL.get(),
                2f
            ),
            3,
            Level.OVERWORLD
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.VERDIUM.CRYSTAL.get(),
                4f
            ),
            3,
            Level.NETHER
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.AZURINE.CRYSTAL.get(),
                2f
            ),
            4,
            Level.OVERWORLD
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.AZURINE.CRYSTAL.get(),
                4f
            ),
            4,
            Level.NETHER
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.CAERIUM.CRYSTAL.get(),
                2f
            ),
            5,
            Level.OVERWORLD
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.CAERIUM.CRYSTAL.get(),
                4f
            ),
            5,
            Level.NETHER
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.AMETHYSTINE.CRYSTAL.get(),
                2f
            ),
            6,
            Level.OVERWORLD
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.AMETHYSTINE.CRYSTAL.get(),
                4f
            ),
            6,
            Level.NETHER
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.ROSARIUM.CRYSTAL.get(),
                2f
            ),
            7,
            Level.OVERWORLD
        ).save(pWriter);

        MinerRecipe.Builder.builder(
            new WeightedStack(
                CrystalSet.ROSARIUM.CRYSTAL.get(),
                4f
            ),
            7,
            Level.NETHER
        ).save(pWriter);

        // Ultimate Stellar Core as miner output for rosarium (8) and ultimate tier (9)
        MinerRecipe.Builder.builder(
                new WeightedStack(
                        ModItems.ULTIMATE_STELLAR_CORE.get(),
                        0.000005f
                ),
                8,
                false,
                Level.END
        ).save(pWriter);

        MinerRecipe.Builder.builder(
                new WeightedStack(
                        ModItems.ULTIMATE_STELLAR_CORE.get(),
                        1.0f
                ),
                9,
                false,
                Level.END
        ).save(pWriter);


        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        ModItems.MAX_STORAGE_UPGRADE_T1.get(),
                        1
                )
                .pattern("GGG")
                .pattern("GDG")
                .pattern("GGG")
                .define('D', Items.DIAMOND_BLOCK)
                .define('G', CrystalSet.CITRINETINE.CRYSTAL.get())
                .unlockedBy("hasItem", has(CrystalSet.CITRINETINE.CRYSTAL.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        ModItems.MAX_STORAGE_UPGRADE_T2.get(),
                        1
                )
                .pattern("CTC")
                .pattern("TST")
                .pattern("CCC")
                .define('S', Items.NETHERITE_BLOCK)
                .define('T', ModItems.MAX_STORAGE_UPGRADE_T2.get())
                .define('C', CrystalSet.CAERIUM.CRYSTAL.get())
                .unlockedBy("hasItem", has(ModItems.MAX_STORAGE_UPGRADE_T2.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(
                        RecipeCategory.MISC,
                        ModItems.MAX_STORAGE_UPGRADE_T3.get(),
                        1
                )
                .pattern("CTC")
                .pattern("TST")
                .pattern("CCC")
                .define('S', Items.NETHER_STAR)
                .define('T', ModItems.MAX_STORAGE_UPGRADE_T3.get())
                .define('C', ModItems.ULTIMATE_STELLAR_CORE.get())
                .unlockedBy("hasItem", has(ModItems.MAX_STORAGE_UPGRADE_T3.get()))
                .save(pWriter);

    }
}