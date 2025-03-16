package net.lowis.tutorialmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.block.entity.ModBlockEntities;
import net.lowis.tutorialmod.block.entity.renderer.PedestalBlockEntityRenderer;
import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.entity.client.*;
import net.lowis.tutorialmod.particle.MagicCircleParticle;
import net.lowis.tutorialmod.particle.ModParticles;
import net.lowis.tutorialmod.screen.ModScreenHandlers;
import net.lowis.tutorialmod.screen.custom.GrowthChamberScreen;
import net.lowis.tutorialmod.screen.custom.PedestalScreen;
import net.lowis.tutorialmod.util.ModModelPredicates;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class TutorialModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DRIFTWOOD_SAPLING, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.URANIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.URANIUM_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GILDED_GLASS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HONEY_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CAULIFLOWER_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.EATER, RenderLayer.getCutout());

        ModModelPredicates.registerModelPredicates();

        EntityModelLayerRegistry.registerModelLayer(MantisModel.MANTIS, MantisModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.MANTIS, MantisRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GobozoModel.GOBOZO, GobozoModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GOBOZO, GobozoRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GiantSeedProjectileModel.GIANT_SEED, GiantSeedProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GIANT_SEED, GiantSeedProjectileRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(GrenadeProjectileModel.GRENADE, GrenadeProjectileModel::getTexturedModelData);
        EntityRendererRegistry.register(ModEntities.GRENADE, GrenadeProjectileRenderer::new);
        EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

        ParticleFactoryRegistry.getInstance().register(ModParticles.MAGIC_CIRCLE_PARTICLE, MagicCircleParticle.Factory::new);

        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);

        HandledScreens.register(ModScreenHandlers.GROWTH_CHAMBER_SCREEN_HANDLER, GrowthChamberScreen::new);
    }
}
