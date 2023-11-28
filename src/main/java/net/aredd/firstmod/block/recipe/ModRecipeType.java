package net.aredd.firstmod.block.recipe;

import net.aredd.firstmod.FirstMod;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipeType {
    public static final RecipeType<CubeCraftRecipe> CUBE_CRAFT_STATION = register("cube_crafting");

    private static <T extends Recipe<?>> RecipeType<T> register(final String id) {
        return Registry.register(Registries.RECIPE_TYPE, new Identifier(FirstMod.MOD_ID, id), new RecipeType<T>() {
            public String toString() {
                return id;
            }
        });
    }

    public static void registerModRecipeType() {
        FirstMod.LOGGER.info("Registering ModRecipeType for " + FirstMod.MOD_ID);
    }
}