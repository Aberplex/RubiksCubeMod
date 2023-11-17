package net.aredd.firstmod.entity.client;

import net.aredd.firstmod.entity.animation.ModAnimations;
import net.aredd.firstmod.entity.custom.CubeGolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class CubeGolemModel<T extends CubeGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart CubeGolem;
	private final ModelPart head;

	public CubeGolemModel(ModelPart root) {
		this.CubeGolem = root.getChild("CubeGolem");
		this.head = CubeGolem.getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData CubeGolem = modelPartData.addChild("CubeGolem", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 14.0F, 0.0F));

		ModelPartData arm = CubeGolem.addChild("arm", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 10.0F, 0.0F));

		ModelPartData leftarm = arm.addChild("leftarm", ModelPartBuilder.create().uv(50, 0).cuboid(-3.0F, -1.0F, -2.0F, 5.0F, 19.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-10.0F, -28.0F, 0.0F));

		ModelPartData rightarm = arm.addChild("rightarm", ModelPartBuilder.create().uv(47, 50).cuboid(-3.0F, -1.0F, -2.0F, 5.0F, 19.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(11.0F, -28.0F, -1.0F));

		ModelPartData body = CubeGolem.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 10.0F, 0.0F));

		ModelPartData torso = body.addChild("torso", ModelPartBuilder.create(), ModelTransform.pivot(-6.0F, -22.0F, -2.0F));

		ModelPartData cube_r1 = torso.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-10.0F, -14.0F, -2.0F, 17.0F, 16.0F, 8.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData leg = CubeGolem.addChild("leg", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 10.0F, 0.0F));

		ModelPartData rightleg = leg.addChild("rightleg", ModelPartBuilder.create().uv(0, 40).cuboid(-3.0F, -1.0F, -4.0F, 5.0F, 15.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(6.0F, -14.0F, 0.0F));

		ModelPartData leftleg = leg.addChild("leftleg", ModelPartBuilder.create().uv(26, 32).cuboid(-3.0F, -5.0F, -4.0F, 5.0F, 15.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(-5.0F, -10.0F, 0.0F));

		ModelPartData head = CubeGolem.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 10.0F, 0.0F));

		ModelPartData face = head.addChild("face", ModelPartBuilder.create().uv(0, 24).cuboid(-5.0F, -40.0F, -4.0F, 9.0F, 8.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData righteye = head.addChild("righteye", ModelPartBuilder.create().uv(0, 24).cuboid(1.0F, -38.0F, 4.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData lefteye = head.addChild("lefteye", ModelPartBuilder.create().uv(0, 3).cuboid(-4.0F, -38.0F, 4.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -35.0F, 4.0F, 3.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(CubeGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);

		this.animateMovement(ModAnimations.WALKING, limbSwing, limbSwingAmount, 2f, 2.5f);

	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0f, 30.0f);
		headPitch = MathHelper.clamp(headPitch,-25.0f,45.0f);

		this.head.yaw = headYaw * 0.017453292f;
		this.head.pitch = headPitch * 0.017453292f;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		CubeGolem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return CubeGolem;
	}
}