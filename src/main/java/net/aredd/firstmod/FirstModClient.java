package net.aredd.firstmod;

import net.aredd.firstmod.block.ModBlocks;
import net.aredd.firstmod.screen.CubeCraftStationScreen;
import net.aredd.firstmod.screen.ModScreenHandlerType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class FirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CUBE_CRAFTING_STATION, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlerType.CUBE_CRAFT_STATION, CubeCraftStationScreen::new);
    }
}
