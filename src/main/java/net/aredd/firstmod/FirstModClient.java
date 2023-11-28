package net.aredd.firstmod;

import net.aredd.firstmod.entity.ModEntities;
import net.aredd.firstmod.entity.client.CubeGolemModel;
import net.aredd.firstmod.entity.client.CubeGolemRenderer;
import net.aredd.firstmod.entity.client.ModModelLayers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class FirstModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.register(ModEntities.CUBE_GOLEM, CubeGolemRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.CUBE_GOLEM, CubeGolemModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.SWORD_PROJECTILE, FlyingItemEntityRenderer::new);

    }
}
