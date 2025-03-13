package net.lowis.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.item.custom.*;
import net.lowis.tutorialmod.item.custom.GlassBottleItem;
import net.lowis.tutorialmod.sound.ModSounds;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class ModItems {

    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item BANANA = registerItem("banana", new Item(new Item.Settings().food(ModFoodComponent.BANANA).rarity(Rarity.EPIC)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponent.CAULIFLOWER)));
    public static final Item DORITOS = registerItem("doritos", new Item(new Item.Settings().food(ModFoodComponent.DORITOS).rarity(Rarity.RARE)));
    public static final Item DORITOS_PACK = registerItem("doritos_pack", new DoritosPackItem(new Item.Settings().rarity(Rarity.RARE).maxDamage(32)));
    public static final Item WINE = registerItem("wine", new DrinkItem(new Item.Settings().food(ModFoodComponent.WINE).rarity(Rarity.RARE)));
    public static final Item JAGERMEISTER = registerItem("jagermeister", new DrinkItem(new Item.Settings().food(ModFoodComponent.JAGERMEISTER).rarity(Rarity.RARE)));
    public static final Item BAGUETTE = registerItem("baguette", new Item(new Item.Settings().food(ModFoodComponent.BAGUETTE)));
    public static final Item BUTTON = registerItem("button_off", new ButtonItem(new Item.Settings().maxDamage(128)));
    public static final Item BEER_PINT = registerItem("beer_pint", new DrinkItem(new Item.Settings().food(ModFoodComponent.BEER_PINT)));
    public static final Item GLASS_SHARD = registerItem("glass_shard", new Item(new Item.Settings().rarity(Rarity.UNCOMMON).maxDamage(1)));
    public static final Item GOLD_TRANSMUTER = registerItem("gold_transmuter", new GoldTransmuterItem(new Item.Settings().rarity(Rarity.RARE).maxCount(1).maxDamage(16)));
    public static final Item GLASS_BOTTLE = registerItem("glass_bottle", new GlassBottleItem(new Item.Settings().maxDamage(1)));
    public static final Item BROKEN_GLASS_BOTTLE = registerItem("broken_glass_bottle", new Item(new Item.Settings().maxDamage(16)));
    public static final Item DOOM_REMOTE = registerItem("doom_remote", new DoomRemoteItem(new Item.Settings()));
    public static final Item MOD_MUSIC_DISK = registerItem("mod_music_disk", new Item(new Item.Settings().jukeboxPlayable(ModSounds.BAR_BRAWL_KEY).maxCount(1)));
    public static final Item BONE_NEEDLE = registerItem("bone_needle", new BoneNeedleItem(new Item.Settings().maxDamage(64)));
    public static final Item KILLER = registerItem("killer", new KillerItem(new Item.Settings()));
    public static final Item DEMON_EYE = registerItem("demon_eye", new Item(new Item.Settings().food(ModFoodComponent.DEMON_EYE)));
    public static final Item GRENADE = registerItem("grenade", new GrenadeItem(new Item.Settings()));

    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds", new AliasedBlockItem(ModBlocks.CAULIFLOWER_CROP, new Item.Settings()));
    public static final Item HONEY_BERRIES = registerItem("honey_berries", new AliasedBlockItem(ModBlocks.HONEY_BERRY_BUSH, new Item.Settings().food(ModFoodComponent.HONEY_BERRY)));

    public static final Item URANIUM_SWORD = registerItem("uranium_sword", new SwordItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.URANIUM, 3, -2.4f))));
    public static final Item URANIUM_PICKAXE = registerItem("uranium_pickaxe", new PickaxeItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.URANIUM, 1, -2.8f))));
    public static final Item URANIUM_SHOVEL = registerItem("uranium_shovel", new ShovelItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.URANIUM, 1.5f, -3.0f))));
    public static final Item URANIUM_AXE = registerItem("uranium_axe", new AxeItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.URANIUM, 6, -3.2f))));
    public static final Item URANIUM_HOE = registerItem("uranium_hoe", new HoeItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.URANIUM, 0, -3.0f))));

    public static final Item URANIUM_HAMMER = registerItem("uranium_hammer", new HammerItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.URANIUM, 7, -3.4f))));



    public static final Item STAR_REMAINS = registerItem("star_remains", new Item(new Item.Settings().rarity(Rarity.RARE)));
    public static final Item URANIUM_INGOT = registerItem("uranium_ingot", new Item(new Item.Settings()));


    public static final Item PINK_GARNET_HELMET = registerItem("pink_garnet_helmet", new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item PINK_GARNET_LEGGINGS = registerItem("pink_garnet_leggings", new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(15))));
    public static final Item PINK_GARNET_CHESTPLATE = registerItem("pink_garnet_chestplate", new ModArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(15))));
    public static final Item PINK_GARNET_BOOTS = registerItem("pink_garnet_boots", new ArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(15))));

    public static final Item PINK_GARNET_HORSE_ARMOR = registerItem("pink_garnet_horse_armor", new AnimalArmorItem(ModArmorMaterials.PINK_GARNET_ARMOR_MATERIAL,
            AnimalArmorItem.Type.EQUESTRIAN, false, new Item.Settings().maxCount(1)));


    public static final Item KAUPEN_BOW = registerItem("kaupen_bow",
            new BowItem(new Item.Settings().maxDamage(500)));

    public static final Item MANTIS_SPAWN_EGG = registerItem("mantis_spawn_egg", new SpawnEggItem(ModEntities.MANTIS, 0x9dc783, 0xbfaf5f, new Item.Settings()));
    public static final Item GOBOZO_SPAWN_EGG = registerItem("gobozo_spawn_egg", new SpawnEggItem(ModEntities.GOBOZO, 0x548629, 0x462d16, new Item.Settings()));

    public static final Item TOMAHAWK = registerItem("tomahawk", new TomahawkItem(new Item.Settings().maxCount(1)));
    public static final Item GIANT_SEED = registerItem("giant_seed", new GiantSeedItem(new Item.Settings()));

    public static final Item SPECTRE_STAFF = registerItem("spectre_staff", new Item(new Item.Settings().maxCount(1)));
    public static final Item TREE_STAFF = registerItem("tree_staff", new TreeStaffItem(new Item.Settings().maxCount(1)));


    public static final Item ANCIENT_GEM = registerItem("ancient_gem", new Item(new Item.Settings()));
    public static final Item ANCIENT_SWORD = registerItem("ancient_sword", new SwordItem(ModToolMaterials.ANCIENT, new Item.Settings()
            .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.ANCIENT, 7, -2.4f))));
    public static final Item ANCIENT_PICKAXE = registerItem("ancient_pickaxe", new PickaxeItem(ModToolMaterials.ANCIENT, new Item.Settings()
            .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.ANCIENT, 1, -2.8f))));
    public static final Item ANCIENT_SHOVEL = registerItem("ancient_shovel", new ShovelItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.URANIUM, 1.5f, -3.0f))));
    public static final Item ANCIENT_AXE = registerItem("ancient_axe", new AxeItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.URANIUM, 6, -3.2f))));
    public static final Item ANCIENT_HOE = registerItem("ancient_hoe", new HoeItem(ModToolMaterials.URANIUM, new Item.Settings()
            .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.URANIUM, 0, -3.0f))));






    private static Item registerItem (String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(BANANA);
        });
    }
}
