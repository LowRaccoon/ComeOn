package net.lowis.tutorialmod.util;

import net.lowis.tutorialmod.TutorialMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_URANIUM_TOOL = createTag("needs_uranium_tool");
        public static final TagKey<Block> INCORRECT_FOR_URANIUM_TOOL = createTag("incorrect_for_uranium_tool");
        public static final TagKey<Block> NEEDS_ANCIENT_TOOL = createTag("needs_ancient_tool");
        public static final TagKey<Block> INCORRECT_FOR_ANCIENT_TOOL = createTag("incorrect_for_ancient_tool");

        public static final TagKey<Block> INCORRECT_FOR_PINK_GARNET_TOOL = createTag("incorrect_for_pink_garnet_tool");
        public static final TagKey<Block> NEEDS_PINK_GARNET_TOOL = createTag("needs_pink_garnet_tool");
        public static final TagKey<Block> INCORRECT_FOR_ALEXANDRITE_TOOL = createTag("incorrect_for_alexandrite_tool");
        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = createTag("needs_alexandrite_tool");
        public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = createTag("incorrect_for_bismuth_tool");
        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = createTag("needs_bismuth_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        }


    }

    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        }


    }



}
