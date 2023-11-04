package net.aredd.firstmod.screen;

import net.aredd.firstmod.FirstMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureFlag;
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlerType {
    public static final ScreenHandlerType<CubeCraftStationScreenHandler> CUBE_CRAFT_STATION = register("cube_crafting", CubeCraftStationScreenHandler::new);

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(FirstMod.MOD_ID, id), new ScreenHandlerType<T>(factory, FeatureFlags.VANILLA_FEATURES));
    }

    private static <T extends ScreenHandler> ScreenHandlerType<T> register(String id, ScreenHandlerType.Factory<T> factory, FeatureFlag... requiredFeatures) {
        return Registry.register(Registries.SCREEN_HANDLER, new Identifier(FirstMod.MOD_ID, id), new ScreenHandlerType<T>(factory, FeatureFlags.FEATURE_MANAGER.featureSetOf(requiredFeatures)));
    }

    public static void registerModScreenHandlerType() {
        FirstMod.LOGGER.info("Registering ModScreenHandlerType for " + FirstMod.MOD_ID);
    }
}