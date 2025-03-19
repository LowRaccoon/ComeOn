package net.lowis.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup TUTORIAL_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BEER_PINT))
                    .displayName(Text.translatable("itemgroup.tutorialmod.tutorial_mod_items"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModItems.PINK_GARNET);
                        entries.add(ModItems.RAW_PINK_GARNET);
                        entries.add(ModItems.ALEXANDRITE);
                        entries.add(ModItems.RAW_ALEXANDRITE);
                        entries.add(ModItems.BISMUTH);
                        entries.add(ModItems.RAW_BISMUTH);
                        entries.add(ModItems.URANIUM_INGOT);

                        entries.add(ModItems.BANANA);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.DORITOS);
                        entries.add(ModItems.DORITOS_PACK);
                        entries.add(ModItems.WINE);
                        entries.add(ModItems.JAGERMEISTER);
                        entries.add(ModItems.BEER_PINT);
                        entries.add(ModItems.GLASS_SHARD);
                        entries.add(ModItems.GOLD_TRANSMUTER);
                        entries.add(ModItems.BAGUETTE);
                        entries.add(ModItems.BUTTON);
                        entries.add(ModItems.DOOM_REMOTE);
                        entries.add(ModItems.GLASS_BOTTLE);
                        entries.add(ModItems.BROKEN_GLASS_BOTTLE);
                        entries.add(ModItems.MOD_MUSIC_DISK);
                        entries.add(ModItems.BONE_NEEDLE);
                        entries.add(ModItems.KILLER);
                        entries.add(ModItems.DEMON_EYE);
                        entries.add(ModItems.GRENADE);
                        entries.add(ModItems.CAULIFLOWER_SEEDS);
                        entries.add(ModItems.HONEY_BERRIES);

                        entries.add(ModItems.STAR_REMAINS);
                        entries.add(ModItems.FROSTFIRE_ICE);
                        entries.add(ModItems.AURORA_ASHES);

                        entries.add(ModItems.URANIUM_SWORD);
                        entries.add(ModItems.URANIUM_PICKAXE);
                        entries.add(ModItems.URANIUM_SHOVEL);
                        entries.add(ModItems.URANIUM_AXE);
                        entries.add(ModItems.URANIUM_HOE);
                        entries.add(ModItems.URANIUM_HAMMER);

                        entries.add(ModItems.PINK_GARNET_SWORD);
                        entries.add(ModItems.PINK_GARNET_PICKAXE);
                        entries.add(ModItems.PINK_GARNET_SHOVEL);
                        entries.add(ModItems.PINK_GARNET_AXE);
                        entries.add(ModItems.PINK_GARNET_HOE);
                        entries.add(ModItems.PINK_GARNET_HAMMER);

                        entries.add(ModItems.ALEXANDRITE_SWORD);
                        entries.add(ModItems.ALEXANDRITE_PICKAXE);
                        entries.add(ModItems.ALEXANDRITE_SHOVEL);
                        entries.add(ModItems.ALEXANDRITE_AXE);
                        entries.add(ModItems.ALEXANDRITE_HOE);
                        entries.add(ModItems.ALEXANDRITE_HAMMER);

                        entries.add(ModItems.BISMUTH_SWORD);
                        entries.add(ModItems.BISMUTH_PICKAXE);
                        entries.add(ModItems.BISMUTH_SHOVEL);
                        entries.add(ModItems.BISMUTH_AXE);
                        entries.add(ModItems.BISMUTH_HOE);
                        entries.add(ModItems.BISMUTH_HAMMER);

                        entries.add(ModItems.ANCIENT_SWORD);
                        entries.add(ModItems.ANCIENT_PICKAXE);
                        entries.add(ModItems.ANCIENT_AXE);
                        entries.add(ModItems.ANCIENT_SHOVEL);
                        entries.add(ModItems.ANCIENT_HOE);
                        //entries.add(ModItems.ANCIENT_SCYTHE);

                        entries.add(ModItems.PINK_GARNET_HELMET);
                        entries.add(ModItems.PINK_GARNET_CHESTPLATE);
                        entries.add(ModItems.PINK_GARNET_LEGGINGS);
                        entries.add(ModItems.PINK_GARNET_BOOTS);
                        entries.add(ModItems.PINK_GARNET_HORSE_ARMOR);

                        entries.add(ModItems.KAUPEN_BOW);

                        entries.add(ModItems.MANTIS_SPAWN_EGG);
                        entries.add(ModItems.GOBOZO_SPAWN_EGG);

                        entries.add(ModItems.TOMAHAWK);
                        entries.add(ModItems.SPECTRE_STAFF);
                        entries.add(ModItems.TREE_STAFF);
                        entries.add(ModItems.GIANT_SEED);


                    }).build());

    public static final ItemGroup TUTORIAL_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(TutorialMod.MOD_ID, "tutorial_mod_blocks"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.TRANSMUTATOR_BLOCK))
                    .displayName(Text.translatable("itemgroup.tutorialmod.tutorial_mod_blocks"))
                    .entries((displayContext, entries) -> {

                        entries.add(ModBlocks.PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
                        entries.add(ModBlocks.PINK_GARNET_ORE);
                        entries.add(ModBlocks.PINK_GARNET_DEEPSLATE_ORE);
                        entries.add(ModBlocks.PINK_GARNET_NETHER_ORE);
                        entries.add(ModBlocks.PINK_GARNET_END_ORE);

                        entries.add(ModBlocks.ALEXANDRITE_BLOCK);
                        entries.add(ModBlocks.RAW_ALEXANDRITE_BLOCK);
                        entries.add(ModBlocks.ALEXANDRITE_ORE);
                        entries.add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
                        entries.add(ModBlocks.ALEXANDRITE_NETHER_ORE);
                        entries.add(ModBlocks.ALEXANDRITE_END_ORE);

                        entries.add(ModBlocks.BISMUTH_BLOCK);
                        entries.add(ModBlocks.RAW_BISMUTH_BLOCK);
                        entries.add(ModBlocks.BISMUTH_ORE);
                        entries.add(ModBlocks.BISMUTH_DEEPSLATE_ORE);
                        entries.add(ModBlocks.BISMUTH_NETHER_ORE);
                        entries.add(ModBlocks.BISMUTH_END_ORE);


                        entries.add(ModBlocks.URANIUM_BLOCK);


                        entries.add(ModBlocks.CRATE);
                        entries.add(ModBlocks.GILDED_GLASS);
                        entries.add(ModBlocks.TRANSMUTATOR_BLOCK);
                        entries.add(ModBlocks.URANIUM_LAMP);
                        entries.add(ModBlocks.URANIUM_STAIRS);
                        entries.add(ModBlocks.URANIUM_SLAB);
                        entries.add(ModBlocks.URANIUM_BUTTON);
                        entries.add(ModBlocks.URANIUM_PRESSURE_PLATE);
                        entries.add(ModBlocks.URANIUM_FENCE);
                        entries.add(ModBlocks.URANIUM_FENCE_GATE);
                        entries.add(ModBlocks.URANIUM_WALL);
                        entries.add(ModBlocks.URANIUM_DOOR);
                        entries.add(ModBlocks.URANIUM_TRAPDOOR);
                        entries.add(ModBlocks.GREEN_LAMP);

                        entries.add(ModBlocks.DRIFTWOOD_LOG);
                        entries.add(ModBlocks.DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
                        entries.add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
                        entries.add(ModBlocks.DRIFTWOOD_PLANKS);
                        entries.add(ModBlocks.DRIFTWOOD_SAPLING);
                        entries.add(ModBlocks.DRIFTWOOD_LEAVES);

                        entries.add(ModBlocks.CHAIR);
                        entries.add(ModBlocks.PEDESTAL);
                        entries.add(ModBlocks.EATER);
                        entries.add(ModBlocks.BEER_PINT_BLOCK);
                        entries.add(ModBlocks.GROWTH_CAMBER);

                    }).build());



    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }

}


































