package net.minimaxi.voidminers.init;

import net.minimaxi.voidminers.VoidMiners;
import net.minimaxi.voidminers.server.recipe.MinerRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = 
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, VoidMiners.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MinerRecipe>> MINER_RECIPE_SERIALIZER =
        SERIALIZERS.register("miner", () -> MinerRecipe.Serializer.INSTANCE);
}