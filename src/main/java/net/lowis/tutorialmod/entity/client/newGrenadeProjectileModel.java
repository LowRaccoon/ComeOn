package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.newGrenadeProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class newGrenadeProjectileModel extends EntityModel<newGrenadeProjectileEntity> {
    public static final EntityModelLayer GRENADE = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "grenade"), "main");
    private final ModelPart grenade;
    public newGrenadeProjectileModel(ModelPart root) {
        this.grenade = root.getChild("grenade");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData grenade = modelPartData.addChild("grenade", ModelPartBuilder.create().uv(0, 7).cuboid(-0.9896F, -0.8556F, -2.3333F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(-0.4896F, -1.8556F, -0.8333F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0104F, 19.8556F, 0.3333F));

        ModelPartData cube_r1 = grenade.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.5208F, -0.2888F, 0.1667F, 0.0F, 0.0F, 0.3927F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        grenade.render(matrices, vertexConsumer, light, overlay, color);
    }

    @Override
    public void setAngles(newGrenadeProjectileEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }
}
