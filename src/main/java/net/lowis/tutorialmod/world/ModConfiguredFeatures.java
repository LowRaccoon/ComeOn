package net.lowis.tutorialmod.world;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.JungleFoliagePlacer;
import net.minecraft.world.gen.foliage.RandomSpreadFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.*;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_GARNET_ORE_KEY = registerKey("pink_garnet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_PINK_GARNET_ORE_KEY = registerKey("nether_pink_garnet_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> END_PINK_GARNET_ORE_KEY = registerKey("end_pink_garnet_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> BISMUTH_ORE_KEY = registerKey("bismut_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_BISMUTH_ORE_KEY = registerKey("nether_bismuth_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> ALEXANDRITE_ORE_KEY = registerKey("alexandrite_ore");

    public static final RegistryKey<ConfiguredFeature<?, ?>> DRIFTWOOD_KEY = registerKey("driftwood");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplaceables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> overworldPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.PINK_GARNET_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.PINK_GARNET_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldAlexandriteOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.ALEXANDRITE_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> overworldBismuthOres =
                List.of(OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.BISMUTH_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.BISMUTH_DEEPSLATE_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> netherPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.PINK_GARNET_NETHER_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherBismuthOres =
                List.of(OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.BISMUTH_NETHER_ORE.getDefaultState()));


        List<OreFeatureConfig.Target> endPinkGarnetOres =
                List.of(OreFeatureConfig.createTarget(endReplaceables, ModBlocks.PINK_GARNET_END_ORE.getDefaultState()));

        register(context, PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldPinkGarnetOres, 12));
        register(context, NETHER_PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherPinkGarnetOres, 9));
        register(context, END_PINK_GARNET_ORE_KEY, Feature.ORE, new OreFeatureConfig(endPinkGarnetOres, 9));

        register(context, ALEXANDRITE_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldAlexandriteOres, 12));

        register(context, BISMUTH_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldBismuthOres, 12));
        register(context, NETHER_BISMUTH_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherBismuthOres, 9));

        register(context, DRIFTWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DRIFTWOOD_LOG),
                new StraightTrunkPlacer(5, 6, 3),
                BlockStateProvider.of(ModBlocks.DRIFTWOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(1), 3),             //run datagen when you modify!!
                new TwoLayersFeatureSize(1, 0, 2)).build());



    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}









