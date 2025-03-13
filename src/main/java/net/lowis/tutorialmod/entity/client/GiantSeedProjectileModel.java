package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.GiantSeedProjectileEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GiantSeedProjectileModel extends EntityModel<GiantSeedProjectileEntity> {

    public static final EntityModelLayer GIANT_SEED = new EntityModelLayer(Identifier.of(TutorialMod.MOD_ID, "giant_seed"), "main");
    private final ModelPart giant_seed;

    public GiantSeedProjectileModel(ModelPart root) {
        this.giant_seed = root.getChild("giant_seed");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData giant_seed = modelPartData.addChild("giant_seed", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -7.0F, -2.0F, 4.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

        ModelPartData cube_r1 = giant_seed.addChild("cube_r1", ModelPartBuilder.create().uv(17, 4).cuboid(0.0F, -2.5F, 0.0F, 1.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.0F, -1.0F, -2.3931F, 0.7568F, -2.5835F));

        ModelPartData cube_r2 = giant_seed.addChild("cube_r2", ModelPartBuilder.create().uv(16, 11).cuboid(1.0F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, -4.0F, 0.0F, -0.2618F, 0.0F, 0.0436F));

        ModelPartData cube_r3 = giant_seed.addChild("cube_r3", ModelPartBuilder.create().uv(0, 13).cuboid(-1.0F, -5.0F, 1.0F, 3.0F, 5.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -4.0F, -3.0F, 0.0436F, 0.0F, 0.2618F));

        ModelPartData cube_r4 = giant_seed.addChild("cube_r4", ModelPartBuilder.create().uv(8, 10).cuboid(1.0F, -5.0F, -2.0F, 0.0F, 5.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(-3.0F, -4.0F, 0.0F, 0.4363F, 0.0F, -0.0436F));
        return TexturedModelData.of(modelData, 32, 32);
    }
    @Override
    public void setAngles(GiantSeedProjectileEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        giant_seed.render(matrices, vertexConsumer, light, overlay, color);
    }

}
