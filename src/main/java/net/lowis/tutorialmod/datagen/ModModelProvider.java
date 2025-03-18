package net.lowis.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.block.custom.CaulifowerCropBlock;
import net.lowis.tutorialmod.block.custom.HoneyBerryBushBlock;
import net.lowis.tutorialmod.block.custom.UraniumLampBlock;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_PINK_GARNET_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.PINK_GARNET_END_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ALEXANDRITE_END_ORE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BISMUTH_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_NETHER_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BISMUTH_END_ORE);




        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GILDED_GLASS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRATE);
        blockStateModelGenerator.registerSingleton(ModBlocks.TRANSMUTATOR_BLOCK, TexturedModel.CUBE_BOTTOM_TOP);


        BlockStateModelGenerator.BlockTexturePool uraniumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.URANIUM_BLOCK);
        uraniumPool.stairs(ModBlocks.URANIUM_STAIRS);
        uraniumPool.slab(ModBlocks.URANIUM_SLAB);
        uraniumPool.button(ModBlocks.URANIUM_BUTTON);
        uraniumPool.pressurePlate(ModBlocks.URANIUM_PRESSURE_PLATE);
        uraniumPool.fence(ModBlocks.URANIUM_FENCE);
        uraniumPool.fenceGate(ModBlocks.URANIUM_FENCE_GATE);
        uraniumPool.wall(ModBlocks.URANIUM_WALL);
        blockStateModelGenerator.registerDoor(ModBlocks.URANIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.URANIUM_TRAPDOOR);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.URANIUM_LAMP);


        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModBlocks.GREEN_LAMP, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModBlocks.GREEN_LAMP, "_on", Models.CUBE_ALL, TextureMap::all);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.GREEN_LAMP)
                .coordinate(BlockStateModelGenerator.createBooleanModelMap(UraniumLampBlock.CLICKED, lampOnIdentifier, lampOffIdentifier)));

        //This gives the possibility to put 2 different textures for the different states: ON and OFF

        //I could use this for like a nuclear reactor...


        blockStateModelGenerator.registerCrop(ModBlocks.CAULIFLOWER_CROP, CaulifowerCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerTintableCrossBlockStateWithStages(ModBlocks.HONEY_BERRY_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED,
                HoneyBerryBushBlock.AGE, 0, 1, 2, 3);

        blockStateModelGenerator.registerLog(ModBlocks.DRIFTWOOD_LOG).log(ModBlocks.DRIFTWOOD_LOG).wood(ModBlocks.DRIFTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_DRIFTWOOD_LOG).log(ModBlocks.STRIPPED_DRIFTWOOD_LOG).wood(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIFTWOOD_PLANKS);
        blockStateModelGenerator.registerSingleton(ModBlocks.DRIFTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DRIFTWOOD_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BEER_PINT_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GROWTH_CAMBER);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.PINK_GARNET, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PINK_GARNET, Models.GENERATED);

        itemModelGenerator.register(ModItems.ALEXANDRITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_ALEXANDRITE, Models.GENERATED);

        itemModelGenerator.register(ModItems.BISMUTH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BISMUTH, Models.GENERATED);

        itemModelGenerator.register(ModItems.URANIUM_INGOT, Models.GENERATED);

        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
        itemModelGenerator.register(ModItems.WINE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAGERMEISTER, Models.GENERATED);
        //itemModelGenerator.register(ModItems.BEER_PINT, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLD_TRANSMUTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTON, Models.GENERATED);
        itemModelGenerator.register(ModItems.DORITOS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLASS_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_GLASS_BOTTLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MOD_MUSIC_DISK, Models.GENERATED);

        itemModelGenerator.register(ModItems.STAR_REMAINS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROSTFIRE_ICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.AURORA_ASHES, Models.GENERATED);




        itemModelGenerator.register(ModItems.ANCIENT_GEM, Models.GENERATED);

        itemModelGenerator.register(ModItems.URANIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URANIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URANIUM_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URANIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URANIUM_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.URANIUM_HAMMER, Models.HANDHELD);



        itemModelGenerator.register(ModBlocks.DRIFTWOOD_SAPLING.asItem(), Models.HANDHELD);

        itemModelGenerator.register(ModItems.BONE_NEEDLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.KILLER, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.PINK_GARNET_BOOTS));

        itemModelGenerator.register(ModItems.PINK_GARNET_HORSE_ARMOR, Models.HANDHELD);

        itemModelGenerator.register(ModItems.MANTIS_SPAWN_EGG , new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GOBOZO_SPAWN_EGG , new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));


    }
}
