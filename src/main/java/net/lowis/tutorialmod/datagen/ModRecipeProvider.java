package net.lowis.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModItems.RAW_PINK_GARNET, ModBlocks.PINK_GARNET_ORE, ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
        List<ItemConvertible> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE, ModBlocks.ALEXANDRITE_ORE, ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
        List<ItemConvertible> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE, ModBlocks.BISMUTH_DEEPSLATE_ORE);

        offerSmelting(recipeExporter, PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModItems.PINK_GARNET, 0.25f, 200, "pink_garnet");
        offerBlasting(recipeExporter, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE, 0.25f, 100, "alexandrite");
        offerBlasting(recipeExporter, BISMUTH_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH, 0.25f, 100, "bismuth");

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.ALEXANDRITE, RecipeCategory.DECORATIONS, ModBlocks.ALEXANDRITE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BISMUTH, RecipeCategory.DECORATIONS, ModBlocks.BISMUTH_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.URANIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.URANIUM_BLOCK);

        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_PINK_GARNET, RecipeCategory.DECORATIONS, ModBlocks.RAW_PINK_GARNET_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_ALEXANDRITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_ALEXANDRITE_BLOCK);
        offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_BISMUTH, RecipeCategory.DECORATIONS, ModBlocks.RAW_BISMUTH_BLOCK);

        /*ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RAW_PINK_GARNET_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_PINK_GARNET)
                .criterion(hasItem(ModItems.RAW_PINK_GARNET), conditionsFromItem(ModItems.RAW_PINK_GARNET))
                .offerTo(recipeExporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_PINK_GARNET, 9)
                .input(ModBlocks.RAW_PINK_GARNET_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_PINK_GARNET_BLOCK), conditionsFromItem(ModBlocks.RAW_PINK_GARNET_BLOCK))
                .offerTo(recipeExporter);*/



        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GOLD_INGOT)
                .input(ModItems.GOLD_TRANSMUTER)
                .input(Items.COAL)
                .criterion(hasItem(ModItems.GOLD_TRANSMUTER), conditionsFromItem(ModItems.GOLD_TRANSMUTER))
                .offerTo(recipeExporter, "gold_ingot_from_transmuted_coal");

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, Items.GOLD_INGOT)
                .input(ModItems.GOLD_TRANSMUTER)
                .input(Items.CHARCOAL)
                .criterion(hasItem(ModItems.GOLD_TRANSMUTER), conditionsFromItem(ModItems.GOLD_TRANSMUTER))
                .offerTo(recipeExporter, "gold_ingot_from_transmuted_charcoal");

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.TRANSMUTATOR_BLOCK)
                .pattern("QQQ")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', Blocks.OAK_PLANKS)
                .input('Q', ModItems.GOLD_TRANSMUTER)
                .criterion(hasItem(ModItems.GOLD_TRANSMUTER), conditionsFromItem(ModItems.GOLD_TRANSMUTER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BAGUETTE)
                .pattern("RRR")
                .input('R', Items.BREAD)
                .criterion(hasItem(Items.BREAD), conditionsFromItem(Items.BREAD))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.URANIUM_LAMP)
                .pattern("RRR")
                .pattern("RQR")
                .pattern("RRR")
                .input('R', ModItems.URANIUM_INGOT)
                .input('Q', Items.REDSTONE)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BUTTON)
                .pattern("RQR")
                .pattern("RRR")
                .input('R', Items.IRON_INGOT)
                .input('Q', Items.REDSTONE)
                .criterion(hasItem(Items.REDSTONE), conditionsFromItem(Items.REDSTONE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GLASS_BOTTLE, 6)     //da fare un tavolo da lavorazione per il vetro**
                .pattern(" R ")
                .pattern("R R")
                .pattern("RRR")
                .input('R', Items.GLASS)
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.GRENADE)
                .pattern(" R ")
                .pattern("RQR")
                .pattern(" R ")
                .input('R', Items.IRON_NUGGET)
                .input('Q', Items.GUNPOWDER)
                .criterion(hasItem(Items.GUNPOWDER), conditionsFromItem(Items.GUNPOWDER))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ANCIENT_SWORD)
                .pattern("R")
                .pattern("R")
                .pattern("Q")
                .input('R', ModItems.ANCIENT_GEM)
                .input('Q', Items.IRON_INGOT)
                .criterion(hasItem(ModItems.ANCIENT_GEM), conditionsFromItem(ModItems.ANCIENT_GEM))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ANCIENT_PICKAXE)
                .pattern("RRR")
                .pattern(" Q ")
                .pattern(" Q ")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.ANCIENT_GEM)
                .criterion(hasItem(ModItems.ANCIENT_GEM), conditionsFromItem(ModItems.ANCIENT_GEM))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ANCIENT_AXE)
                .pattern("RR")
                .pattern("RQ")
                .pattern(" Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.ANCIENT_GEM)
                .criterion(hasItem(ModItems.ANCIENT_GEM), conditionsFromItem(ModItems.ANCIENT_GEM))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ANCIENT_HOE)
                .pattern("RR")
                .pattern(" Q")
                .pattern(" Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.ANCIENT_GEM)
                .criterion(hasItem(ModItems.ANCIENT_GEM), conditionsFromItem(ModItems.ANCIENT_GEM))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ANCIENT_SHOVEL)
                .pattern("R")
                .pattern("Q")
                .pattern("Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.ANCIENT_GEM)
                .criterion(hasItem(ModItems.ANCIENT_GEM), conditionsFromItem(ModItems.ANCIENT_GEM))
                .offerTo(recipeExporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.URANIUM_SWORD)
                .pattern("R")
                .pattern("R")
                .pattern("Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.URANIUM_INGOT)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.URANIUM_PICKAXE)
                .pattern("RRR")
                .pattern(" Q ")
                .pattern(" Q ")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.URANIUM_INGOT)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.URANIUM_AXE)
                .pattern("RR")
                .pattern("RQ")
                .pattern(" Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.URANIUM_INGOT)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.URANIUM_SHOVEL)
                .pattern("R")
                .pattern("Q")
                .pattern("Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.URANIUM_INGOT)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.URANIUM_HOE)
                .pattern("RR")
                .pattern(" Q")
                .pattern(" Q")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.URANIUM_INGOT)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.URANIUM_HAMMER)
                .pattern("RRR")
                .pattern("RQR")
                .pattern(" Q ")
                .input('Q', Items.IRON_INGOT)
                .input('R', ModItems.URANIUM_INGOT)
                .criterion(hasItem(ModItems.URANIUM_INGOT), conditionsFromItem(ModItems.URANIUM_INGOT))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PINK_GARNET_SWORD)
                .pattern("R")
                .pattern("R")
                .pattern("Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_PICKAXE)
                .pattern("RRR")
                .pattern(" Q ")
                .pattern(" Q ")
                .input('Q', Items.STICK)
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_AXE)
                .pattern("RR")
                .pattern("RQ")
                .pattern(" Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_SHOVEL)
                .pattern("R")
                .pattern("Q")
                .pattern("Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HOE)
                .pattern("RR")
                .pattern(" Q")
                .pattern(" Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.PINK_GARNET_HAMMER)
                .pattern("RRR")
                .pattern("RQR")
                .pattern(" Q ")
                .input('Q', Items.STICK)
                .input('R', ModItems.PINK_GARNET)
                .criterion(hasItem(ModItems.PINK_GARNET), conditionsFromItem(ModItems.PINK_GARNET))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ALEXANDRITE_SWORD)
                .pattern("R")
                .pattern("R")
                .pattern("Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.ALEXANDRITE)
                .criterion(hasItem(ModItems.ALEXANDRITE), conditionsFromItem(ModItems.ALEXANDRITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_PICKAXE)
                .pattern("RRR")
                .pattern(" Q ")
                .pattern(" Q ")
                .input('Q', Items.STICK)
                .input('R', ModItems.ALEXANDRITE)
                .criterion(hasItem(ModItems.ALEXANDRITE), conditionsFromItem(ModItems.ALEXANDRITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_AXE)
                .pattern("RR")
                .pattern("RQ")
                .pattern(" Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.ALEXANDRITE)
                .criterion(hasItem(ModItems.ALEXANDRITE), conditionsFromItem(ModItems.ALEXANDRITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_SHOVEL)
                .pattern("R")
                .pattern("Q")
                .pattern("Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.ALEXANDRITE)
                .criterion(hasItem(ModItems.ALEXANDRITE), conditionsFromItem(ModItems.ALEXANDRITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_HOE)
                .pattern("RR")
                .pattern(" Q")
                .pattern(" Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.ALEXANDRITE)
                .criterion(hasItem(ModItems.ALEXANDRITE), conditionsFromItem(ModItems.ALEXANDRITE))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ALEXANDRITE_HAMMER)
                .pattern("RRR")
                .pattern("RQR")
                .pattern(" Q ")
                .input('Q', Items.STICK)
                .input('R', ModItems.ALEXANDRITE)
                .criterion(hasItem(ModItems.ALEXANDRITE), conditionsFromItem(ModItems.ALEXANDRITE))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BISMUTH_SWORD)
                .pattern("R")
                .pattern("R")
                .pattern("Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BISMUTH_PICKAXE)
                .pattern("RRR")
                .pattern(" Q ")
                .pattern(" Q ")
                .input('Q', Items.STICK)
                .input('R', ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BISMUTH_AXE)
                .pattern("RR")
                .pattern("RQ")
                .pattern(" Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BISMUTH_SHOVEL)
                .pattern("R")
                .pattern("Q")
                .pattern("Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BISMUTH_HOE)
                .pattern("RR")
                .pattern(" Q")
                .pattern(" Q")
                .input('Q', Items.STICK)
                .input('R', ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(recipeExporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.BISMUTH_HAMMER)
                .pattern("RRR")
                .pattern("RQR")
                .pattern(" Q ")
                .input('Q', Items.STICK)
                .input('R', ModItems.BISMUTH)
                .criterion(hasItem(ModItems.BISMUTH), conditionsFromItem(ModItems.BISMUTH))
                .offerTo(recipeExporter);



    }

}
