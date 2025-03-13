package net.lowis.tutorialmod.block;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.block.custom.*;
import net.lowis.tutorialmod.sound.ModSounds;
import net.lowis.tutorialmod.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
                    .instrument(NoteBlockInstrument.BELL)));

    public static final Block RAW_PINK_GARNET_BLOCK = registerBlock("raw_pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block PINK_GARNET_ORE = registerBlock("pink_garnet_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()));
    public static final Block PINK_GARNET_DEEPSLATE_ORE = registerBlock("pink_garnet_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), AbstractBlock.Settings.create()
                    .strength(1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block CRATE = registerBlock("crate",
            new Block(AbstractBlock.Settings.create()
                    .strength(2f)
                    .sounds(BlockSoundGroup.WOOD)
                    .requiresTool()
                    .burnable()));
    public static final Block GILDED_GLASS = registerBlock("gilded_glass",
            new Block(AbstractBlock.Settings.create()
                    .strength(1f)
                    .sounds(BlockSoundGroup.GLASS)
                    .instrument(NoteBlockInstrument.HAT)
                    .nonOpaque()));
    public static final Block TRANSMUTATOR_BLOCK = registerBlock("transmutator_block",
            new TransmutatorBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.NETHER_WOOD)
                    .strength(1f)
                    .luminance(state -> 15)
                    .sounds(ModSounds.TRANSMUTATOR_BLOCK_SOUNDS)));           //add light

    public static final Block URANIUM_BLOCK = registerBlock("uranium_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .sounds(BlockSoundGroup.NETHERITE)
                    .requiresTool()));

    public static final Block GREEN_LAMP = registerBlock("green_lamp",
            new UraniumLampBlock(AbstractBlock.Settings.create()
                    .strength(4f)
                    .luminance(state -> state.get(UraniumLampBlock.CLICKED) ? 15 : 0)));

    public static final Block URANIUM_LAMP = registerBlock("uranium_lamp",
            new UraniumLampBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()
                    .luminance(state -> state.get(UraniumLampBlock.CLICKED) ? 15 : 0)));


    public static final Block URANIUM_STAIRS = registerBlock("uranium_stairs",
            new StairsBlock(ModBlocks.URANIUM_BLOCK.getDefaultState(), AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()));
    public static final Block URANIUM_SLAB = registerBlock("uranium_slab",
            new SlabBlock(AbstractBlock.Settings.create()
                    .strength(2f)
                    .requiresTool()));


    public static final Block URANIUM_BUTTON = registerBlock("uranium_button",
            new ButtonBlock(BlockSetType.IRON, 2, AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .noCollision()));
    public static final Block URANIUM_PRESSURE_PLATE = registerBlock("uranium_pressure_plate",
            new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .noCollision()
                    .nonOpaque()));


    public static final Block URANIUM_FENCE = registerBlock("uranium_fence",
            new FenceBlock(AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()));
    public static final Block URANIUM_FENCE_GATE = registerBlock("uranium_fence_gate",
            new FenceGateBlock(WoodType.ACACIA, AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()));
    public static final Block URANIUM_WALL = registerBlock("uranium_wall",
            new WallBlock(AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()));


    public static final Block URANIUM_DOOR = registerBlock("uranium_door",
            new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .nonOpaque()));
    public static final Block URANIUM_TRAPDOOR = registerBlock("uranium_trapdoor",
            new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create()
                    .strength(2)
                    .requiresTool()
                    .nonOpaque()));


    public static final Block CAULIFLOWER_CROP = registerBlockWithoutBlockItem("cauliflower_crop",
            new CaulifowerCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)));

    public static final Block HONEY_BERRY_BUSH = registerBlockWithoutBlockItem("honey_berry_bush",
            new HoneyBerryBushBlock(AbstractBlock.Settings
                    .copy(Blocks.SWEET_BERRY_BUSH)));

    public static final Block PINK_GARNET_END_ORE = registerBlock("pink_garnet_end_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8),
                    AbstractBlock.Settings.create().strength(7f).requiresTool()));
    public static final Block PINK_GARNET_NETHER_ORE = registerBlock("pink_garnet_nether_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(1, 5),
                    AbstractBlock.Settings.create().strength(3f).requiresTool()));

    public static final Block DRIFTWOOD_LOG = registerBlock("driftwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));
    public static final Block DRIFTWOOD_WOOD = registerBlock("driftwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));
    public static final Block STRIPPED_DRIFTWOOD_LOG = registerBlock("stripped_driftwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final Block STRIPPED_DRIFTWOOD_WOOD = registerBlock("stripped_driftwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block DRIFTWOOD_PLANKS = registerBlock("driftwood_planks",
            new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)));
    public static final Block DRIFTWOOD_LEAVES = registerBlock("driftwood_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)));

    public static final Block DRIFTWOOD_SAPLING = registerBlock("driftwood_sapling",
            new SaplingBlock(ModSaplingGenerators.DRIFTWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)));

    public static final Block CHAIR = registerBlock("chair", new ChairBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.WOOD)));
    public static final Block PEDESTAL = registerBlock("pedestal", new PedestalBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.STONE)));
    public static final Block EATER = registerBlock("eater", new EaterBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.FROGLIGHT)));
    public static final Block BEER_PINT = registerBlock("beer_pint", new BeerPintBlock(AbstractBlock.Settings.create().nonOpaque().sounds(BlockSoundGroup.WOOD)));



    private static Block registerBlock (String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }

    private static Block registerBlockWithoutBlockItem (String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TutorialMod.MOD_ID, name), block);
    }


    private static void registerBlockItem (String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

    }
}
