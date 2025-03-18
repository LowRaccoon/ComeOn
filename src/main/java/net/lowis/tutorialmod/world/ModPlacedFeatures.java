package net.lowis.tutorialmod.world;

import net.lowis.tutorialmod.TutorialMod;

import net.lowis.tutorialmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PINK_GARNET_ORE_PLACED_KEY = registerKey("pink_garnet_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_PINK_GARNET_ORE_PLACED_KEY = registerKey("nether_pink_garnet_ore_placed");
    public static final RegistryKey<PlacedFeature> END_PINK_GARNET_ORE_PLACED_KEY = registerKey("end_pink_garnet_ore_placed");

    public static final RegistryKey<PlacedFeature> ALEXANDRITE_ORE_PLACED_KEY = registerKey("alexandrite_ore_placed");

    public static final RegistryKey<PlacedFeature> BISMUTH_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final RegistryKey<PlacedFeature> NETHER_BISMUTH_ORE_PLACED_KEY = registerKey("nether_bismuth_ore_placed");


    public static final RegistryKey<PlacedFeature> DRIFTWOOD_PLACED_KEY = registerKey("driftwood_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, PINK_GARNET_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINK_GARNET_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, END_PINK_GARNET_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_PINK_GARNET_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, NETHER_PINK_GARNET_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_PINK_GARNET_ORE_KEY ),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, ALEXANDRITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALEXANDRITE_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BISMUTH_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));
        register(context, NETHER_BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BISMUTH_ORE_KEY),
                ModOrePlacement.modifiersWithCount(14, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80))));

        register(context, DRIFTWOOD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DRIFTWOOD_KEY),
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
                        PlacedFeatures.createCountExtraModifier(10, 1f, 4), ModBlocks.DRIFTWOOD_SAPLING));

    }


    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(TutorialMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
