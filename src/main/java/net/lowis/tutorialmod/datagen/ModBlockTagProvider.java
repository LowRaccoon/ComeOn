package net.lowis.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.util.ModTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {


    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GILDED_GLASS)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_END_ORE)
                .add(ModBlocks.PINK_GARNET_NETHER_ORE)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.URANIUM_BLOCK)
                .add(ModBlocks.URANIUM_LAMP)
                .add(ModBlocks.URANIUM_STAIRS)
                .add(ModBlocks.URANIUM_SLAB)
                .add(ModBlocks.URANIUM_BUTTON)
                .add(ModBlocks.URANIUM_PRESSURE_PLATE)
                .add(ModBlocks.URANIUM_FENCE)
                .add(ModBlocks.URANIUM_FENCE_GATE)
                .add(ModBlocks.URANIUM_WALL)
                .add(ModBlocks.URANIUM_DOOR)
                .add(ModBlocks.URANIUM_TRAPDOOR);


        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.PINK_GARNET_END_ORE)
                .add(ModBlocks.PINK_GARNET_NETHER_ORE)
                .add(ModBlocks.URANIUM_BLOCK)
                .add(ModBlocks.URANIUM_LAMP)
                .add(ModBlocks.URANIUM_STAIRS)
                .add(ModBlocks.URANIUM_SLAB)
                .add(ModBlocks.URANIUM_BUTTON)
                .add(ModBlocks.URANIUM_PRESSURE_PLATE)
                .add(ModBlocks.URANIUM_FENCE)
                .add(ModBlocks.URANIUM_FENCE_GATE)
                .add(ModBlocks.URANIUM_WALL)
                .add(ModBlocks.URANIUM_DOOR)
                .add(ModBlocks.URANIUM_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.PINK_GARNET_BLOCK)
                .add(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .add(ModBlocks.PINK_GARNET_ORE)
                .add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE)
                .add(ModBlocks.PINK_GARNET_END_ORE)
                .add(ModBlocks.PINK_GARNET_NETHER_ORE)
                .add(ModBlocks.URANIUM_BLOCK)
                .add(ModBlocks.URANIUM_LAMP)
                .add(ModBlocks.URANIUM_STAIRS)
                .add(ModBlocks.URANIUM_SLAB)
                .add(ModBlocks.URANIUM_BUTTON)
                .add(ModBlocks.URANIUM_PRESSURE_PLATE)
                .add(ModBlocks.URANIUM_FENCE)
                .add(ModBlocks.URANIUM_FENCE_GATE)
                .add(ModBlocks.URANIUM_WALL)
                .add(ModBlocks.URANIUM_DOOR)
                .add(ModBlocks.URANIUM_TRAPDOOR);



        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.CRATE)
                .add(ModBlocks.TRANSMUTATOR_BLOCK);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.URANIUM_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.URANIUM_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.URANIUM_WALL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_URANIUM_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_ANCIENT_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)     //cause else leaves do not count the log as support and decay
                .add(ModBlocks.DRIFTWOOD_LOG)
                .add(ModBlocks.DRIFTWOOD_WOOD)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG)
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);



    }
}
