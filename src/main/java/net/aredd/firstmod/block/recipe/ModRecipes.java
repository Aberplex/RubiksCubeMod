package net.aredd.firstmod.block.recipe;

import net.aredd.firstmod.FirstMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(FirstMod.MOD_ID, CubeCraftRecipe.Serializer.ID),
                CubeCraftRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(FirstMod.MOD_ID, CubeCraftRecipe.Type.ID),
                CubeCraftRecipe.Type.INSTANCE);
    }

}
