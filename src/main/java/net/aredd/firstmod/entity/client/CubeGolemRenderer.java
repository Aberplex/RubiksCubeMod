package net.aredd.firstmod.entity.client;

import net.aredd.firstmod.FirstMod;
import net.aredd.firstmod.entity.custom.CubeGolemEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CubeGolemRenderer extends MobEntityRenderer<CubeGolemEntity, CubeGolemModel<CubeGolemEntity>> {
    private static final Identifier TEXTURE = new Identifier(FirstMod.MOD_ID, "textures/entity/rubiks_cube_golem.png");

    public CubeGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new CubeGolemModel<>(context.getPart(ModModelLayers.CUBE_GOLEM)), 2f);
    }

    @Override
    public Identifier getTexture(CubeGolemEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(CubeGolemEntity mobEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
