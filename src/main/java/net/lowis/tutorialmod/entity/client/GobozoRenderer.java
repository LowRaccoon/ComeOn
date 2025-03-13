package net.lowis.tutorialmod.entity.client;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.GobozoEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class GobozoRenderer extends MobEntityRenderer<GobozoEntity, GobozoModel<GobozoEntity>> {


    public GobozoRenderer(EntityRendererFactory.Context context) {
        super(context, new GobozoModel<>(context.getPart(GobozoModel.GOBOZO)), 0.30f);      //shadow
    }

    @Override
    public Identifier getTexture(GobozoEntity entity) {
        return Identifier.of(TutorialMod.MOD_ID, "textures/entity/gobozo/gobozo.png");
    }


    @Override
    public void render(GobozoEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
