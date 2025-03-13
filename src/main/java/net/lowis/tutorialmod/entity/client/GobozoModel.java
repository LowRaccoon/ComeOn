package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.GobozoEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class GobozoModel<T extends GobozoEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer GOBOZO = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "gobozo"), "main");
    private final ModelPart gobozo;
    private final ModelPart head;

    public GobozoModel(ModelPart root) {
        this.gobozo = root.getChild("gobozo");
        this.head = this.gobozo.getChild("head");

    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData gobozo = modelPartData.addChild("gobozo", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 17.0F, 0.0F));

        ModelPartData body = gobozo.addChild("body", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 7.0F, 0.0F));

        ModelPartData uppebody = body.addChild("uppebody", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData torso = uppebody.addChild("torso", ModelPartBuilder.create().uv(0, 11).cuboid(-4.0F, -9.0F, -2.0F, 8.0F, 6.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightArm = uppebody.addChild("rightArm", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -8.0F, 0.0F));

        ModelPartData leftArm = uppebody.addChild("leftArm", ModelPartBuilder.create().uv(8, 0).cuboid(0.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(4.0F, -8.0F, 0.0F));

        ModelPartData rightLeg = body.addChild("rightLeg", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, -3.0F, 0.0F));

        ModelPartData leftLeg = body.addChild("leftLeg", ModelPartBuilder.create().uv(24, 5).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -3.0F, 0.0F));

        ModelPartData head = gobozo.addChild("head", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -4.5F, 0.0F));

        ModelPartData cranium = head.addChild("cranium", ModelPartBuilder.create().uv(0, 21).cuboid(-3.0F, -2.5F, -3.0F, 6.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData hair = head.addChild("hair", ModelPartBuilder.create().uv(24, 28).cuboid(-6.0F, -8.0F, -1.0F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 4.5F, 0.0F));

        ModelPartData rightEar = head.addChild("rightEar", ModelPartBuilder.create(), ModelTransform.pivot(-3.0F, -0.5F, 0.5F));

        ModelPartData rightEarbase = rightEar.addChild("rightEarbase", ModelPartBuilder.create().uv(26, 16).cuboid(-2.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData rightEarTip = rightEar.addChild("rightEarTip", ModelPartBuilder.create().uv(23, 21).cuboid(-1.0F, -2.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.0F, 0.0F, -0.5F));

        ModelPartData earring = rightEar.addChild("earring", ModelPartBuilder.create(), ModelTransform.pivot(-2.0F, 1.0F, 0.0F));

        ModelPartData earring_r1 = earring.addChild("earring_r1", ModelPartBuilder.create().uv(29, 25).cuboid(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0607F, 0.0607F, 0.0F, 0.0F, 0.0F, 0.7854F));

        ModelPartData leftEar = head.addChild("leftEar", ModelPartBuilder.create(), ModelTransform.pivot(3.0F, -0.5F, 0.5F));

        ModelPartData leftEarBase = leftEar.addChild("leftEarBase", ModelPartBuilder.create().uv(26, 12).cuboid(0.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData leftEarTip = leftEar.addChild("leftEarTip", ModelPartBuilder.create().uv(28, 21).cuboid(0.0F, -7.0F, 0.0F, 1.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, 5.0F, -0.5F));
        return TexturedModelData.of(modelData, 32, 32);
    }

    @Override
    public void setAngles(GobozoEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw, headPitch);

        this.animateMovement(GobozoAnimations.RUN, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, GobozoAnimations.IDLE, ageInTicks, 1f);
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
        headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = headPitch * 0.017453292F;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        gobozo.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public ModelPart getPart() {
        return gobozo;
    }
}
