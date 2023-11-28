package net.aredd.firstmod.block.recipe;

import net.aredd.firstmod.FirstMod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeSerializer {
    public static final RecipeSerializer<CubeCraftRecipe> CUBE_CRAFT_STATION = register("cube_crafting", new CubeCraftRecipe.Serializer());

    private static <S extends RecipeSerializer<? extends Recipe<?>>> S register(String id, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(FirstMod.MOD_ID, id), serializer);
    }
}