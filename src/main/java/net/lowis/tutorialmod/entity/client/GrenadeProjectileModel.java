package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.GrenadeProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

//QUANTO ESPORTI UNA COSA DA BLOCKBENCH, GUARDA SE E LA VESIONE DEL PROJECT GIUSTA
//parlo x esperienza...

public class GrenadeProjectileModel extends EntityModel<GrenadeProjectileEntity> {
    public static final EntityModelLayer GRENADE = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "grenade"), "main");
    private final ModelPart grenade;
    public GrenadeProjectileModel(ModelPart root) {
        this.grenade = root.getChild("grenade");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData grenade = modelPartData.addChild("grenade", ModelPartBuilder.create().uv(0, 7).cuboid(-2.0F, -2.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F))
                .uv(8, 0).cuboid(-1.5F, -3.0F, -0.5F, 2.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 21.0F, 0.0F));

        ModelPartData cube_r1 = grenade.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -2.5F, 0.0F, 2.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-2.5313F, -1.4332F, 0.5F, 0.0F, 0.0F, 0.3927F));
        return TexturedModelData.of(modelData, 16, 16);
    }

    @Override
    public void setAngles(GrenadeProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        grenade.render(matrices, vertexConsumer, light, overlay, color);
    }
}
