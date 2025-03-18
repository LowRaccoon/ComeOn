package net.lowis.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.block.custom.CaulifowerCropBlock;
import net.lowis.tutorialmod.block.custom.HoneyBerryBushBlock;
import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);


        addDrop(ModBlocks.PINK_GARNET_BLOCK);
        addDrop(ModBlocks.RAW_PINK_GARNET_BLOCK);
        addDrop(ModBlocks.ALEXANDRITE_BLOCK);
        addDrop(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        addDrop(ModBlocks.BISMUTH_BLOCK);
        addDrop(ModBlocks.RAW_BISMUTH_BLOCK);

        addDrop(ModBlocks.PINK_GARNET_ORE, oreDrops(ModBlocks.PINK_GARNET_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.PINK_GARNET_NETHER_ORE, oreDrops(ModBlocks.PINK_GARNET_NETHER_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.PINK_GARNET_END_ORE, oreDrops(ModBlocks.PINK_GARNET_END_ORE, ModItems.RAW_PINK_GARNET));
        addDrop(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.PINK_GARNET_DEEPSLATE_ORE, ModItems.RAW_PINK_GARNET, 3, 7));

        addDrop(ModBlocks.ALEXANDRITE_ORE, oreDrops(ModBlocks.ALEXANDRITE_ORE, ModItems.RAW_ALEXANDRITE));
        addDrop(ModBlocks.ALEXANDRITE_NETHER_ORE, oreDrops(ModBlocks.ALEXANDRITE_NETHER_ORE, ModItems.RAW_ALEXANDRITE));
        addDrop(ModBlocks.ALEXANDRITE_END_ORE, oreDrops(ModBlocks.ALEXANDRITE_END_ORE, ModItems.RAW_ALEXANDRITE));
        addDrop(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE, ModItems.RAW_ALEXANDRITE, 3, 7));

        addDrop(ModBlocks.BISMUTH_ORE, oreDrops(ModBlocks.BISMUTH_ORE, ModItems.RAW_BISMUTH));
        addDrop(ModBlocks.BISMUTH_NETHER_ORE, oreDrops(ModBlocks.BISMUTH_NETHER_ORE, ModItems.RAW_BISMUTH));
        addDrop(ModBlocks.BISMUTH_END_ORE, oreDrops(ModBlocks.BISMUTH_END_ORE, ModItems.RAW_BISMUTH));
        addDrop(ModBlocks.BISMUTH_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE, ModItems.RAW_BISMUTH, 3, 7));




        addDrop(ModBlocks.TRANSMUTATOR_BLOCK);
        addDrop(ModBlocks.CRATE);

        addDrop(ModBlocks.URANIUM_BLOCK);
        addDrop(ModBlocks.URANIUM_LAMP);
        addDrop(ModBlocks.URANIUM_STAIRS);
        addDrop(ModBlocks.URANIUM_SLAB, slabDrops(ModBlocks.URANIUM_SLAB));
        addDrop(ModBlocks.URANIUM_BUTTON);
        addDrop(ModBlocks.URANIUM_PRESSURE_PLATE);
        addDrop(ModBlocks.URANIUM_FENCE);
        addDrop(ModBlocks.URANIUM_FENCE_GATE);
        addDrop(ModBlocks.URANIUM_WALL);
        addDrop(ModBlocks.URANIUM_DOOR, doorDrops(ModBlocks.URANIUM_DOOR));
        addDrop(ModBlocks.URANIUM_TRAPDOOR);



        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.CAULIFLOWER_CROP)
                .properties(StatePredicate.Builder.create().exactMatch(CaulifowerCropBlock.AGE, CaulifowerCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.CAULIFLOWER_CROP, this.cropDrops(ModBlocks.CAULIFLOWER_CROP, ModItems.CAULIFLOWER, ModItems.CAULIFLOWER_SEEDS, builder2));

        this.addDrop(ModBlocks.HONEY_BERRY_BUSH, (block) -> {
            return (LootTable.Builder) this.applyExplosionDecay(block, LootTable.builder()
                    .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.HONEY_BERRY_BUSH)
                            .properties(StatePredicate.Builder.create().exactMatch(HoneyBerryBushBlock.AGE, 3)))
                            .with(ItemEntry.builder(ModItems.HONEY_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                            .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                    .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(ModBlocks.HONEY_BERRY_BUSH)
                            .properties(StatePredicate.Builder.create().exactMatch(HoneyBerryBushBlock.AGE, 2)))
                            .with(ItemEntry.builder(ModItems.HONEY_BERRIES)).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                            .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE)))));
        });

        addDrop(ModBlocks.DRIFTWOOD_LOG);
        addDrop(ModBlocks.DRIFTWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_DRIFTWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_DRIFTWOOD_WOOD);
        addDrop(ModBlocks.DRIFTWOOD_PLANKS);
        addDrop(ModBlocks.DRIFTWOOD_SAPLING);

        addDrop(ModBlocks.DRIFTWOOD_LEAVES, leavesDrops(ModBlocks.DRIFTWOOD_LEAVES, ModBlocks.DRIFTWOOD_SAPLING, 0.0625f));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
