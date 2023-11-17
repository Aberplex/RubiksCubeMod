package net.aredd.firstmod;

import net.aredd.firstmod.block.ModBlocks;
import net.aredd.firstmod.entity.ModEntities;
import net.aredd.firstmod.entity.client.CubeGolemModel;
import net.aredd.firstmod.entity.client.CubeGolemRenderer;
import net.aredd.firstmod.entity.client.ModModelLayers;
import net.aredd.firstmod.screen.CubeCraftStationScreen;
import net.aredd.firstmod.screen.ModRecipeType;
import net.aredd.firstmod.screen.ModScreenHandlerType;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

public class FirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CUBE_CRAFTING_STATION, RenderLayer.getCutout());
        HandledScreens.register(ModScreenHandlerType.CUBE_CRAFT_STATION, CubeCraftStationScreen::new);
        ModRecipeType.registerModRecipeType();

        EntityRendererRegistry.register(ModEntities.CUBE_GOLEM, CubeGolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CUBE_GOLEM, CubeGolemModel::getTexturedModelData);
    }
}
