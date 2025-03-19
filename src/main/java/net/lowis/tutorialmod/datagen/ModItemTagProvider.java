package net.lowis.tutorialmod.datagen;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.item.ModItems;
import net.lowis.tutorialmod.util.ModTags;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(Items.COAL)
                .add(Items.CHARCOAL)
                .add(ModItems.RAW_PINK_GARNET);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.URANIUM_SWORD)
                .add(ModItems.ANCIENT_SWORD)
                .add(ModItems.ALEXANDRITE_SWORD)
                .add(ModItems.PINK_GARNET_SWORD)
                .add(ModItems.BISMUTH_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.URANIUM_PICKAXE)
                .add(ModItems.URANIUM_HAMMER)
                .add(ModItems.ANCIENT_PICKAXE)
                .add(ModItems.ALEXANDRITE_PICKAXE)
                .add(ModItems.ALEXANDRITE_HAMMER)
                .add(ModItems.PINK_GARNET_PICKAXE)
                .add(ModItems.PINK_GARNET_HAMMER)
                .add(ModItems.BISMUTH_PICKAXE)
                .add(ModItems.BISMUTH_HAMMER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.URANIUM_AXE)
                .add(ModItems.ANCIENT_AXE)
                .add(ModItems.ALEXANDRITE_AXE)
                .add(ModItems.PINK_GARNET_AXE)
                .add(ModItems.BISMUTH_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.URANIUM_SHOVEL)
                .add(ModItems.ANCIENT_SHOVEL)
                .add(ModItems.ALEXANDRITE_SHOVEL)
                .add(ModItems.PINK_GARNET_SHOVEL)
                .add(ModItems.BISMUTH_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.URANIUM_HOE)
                .add(ModItems.ANCIENT_HOE)
                .add(ModItems.ALEXANDRITE_HOE)
                .add(ModItems.PINK_GARNET_HOE)
                .add(ModItems.BISMUTH_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)     //FOR TRIMMING
                .add(ModItems.PINK_GARNET_HELMET)
                .add(ModItems.PINK_GARNET_CHESTPLATE)
                .add(ModItems.PINK_GARNET_LEGGINGS)
                .add(ModItems.PINK_GARNET_BOOTS);

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.DRIFTWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_LOG.asItem())
                .add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.DRIFTWOOD_PLANKS.asItem());

    }
}
