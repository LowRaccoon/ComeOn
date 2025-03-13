package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.newGrenadeProjectileEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class newGrenadeProjectileRenderer extends EntityRenderer<newGrenadeProjectileEntity> {

    protected GrenadeProjectileModel model;


    public newGrenadeProjectileRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new GrenadeProjectileModel(ctx.getPart(GrenadeProjectileModel.GRENADE));
    }

    @Override
    public void render(newGrenadeProjectileEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        matrices.push();

        VertexConsumer vertexconsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumers,
                this.model.getLayer(Identifier.of(TutorialMod.MOD_ID, "textures/entity/grenade/grenade.png")), false, false);
        this.model.render(matrices, vertexconsumer, light, OverlayTexture.DEFAULT_UV);

        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public Identifier getTexture(newGrenadeProjectileEntity entity) {
        return Identifier.of(TutorialMod.MOD_ID, "textures/entity/grenade/grenade.png");
    }
}
