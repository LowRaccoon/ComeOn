package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.GiantSeedProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;

public class GiantSeedProjectileRenderer extends EntityRenderer<GiantSeedProjectileEntity> {

    protected GiantSeedProjectileModel model;

    public GiantSeedProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new GiantSeedProjectileModel(ctx.getPart(GiantSeedProjectileModel.GIANT_SEED));
    }

    @Override
    public void render(GiantSeedProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        if(!entity.isGrounded()) {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(tickDelta, entity.prevYaw, entity.getYaw())));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.getRenderingRotation() * 5f));
            matrices.translate(0, -1.0f, 0);
        } else {
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.groundedOffset.getY()));
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(entity.groundedOffset.getX()));
            matrices.translate(0, -1.0f, 0);
        }

        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(TutorialMod.MOD_ID, "textures/entity/giant_seed/giant_seed.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }


    @Override
    public Identifier getTexture(GiantSeedProjectileEntity entity) {
        return Identifier.of(TutorialMod.MOD_ID, "textures/entity/giant_seed/giant_seed.png");
    }
}
