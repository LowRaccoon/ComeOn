package net.lowis.tutorialmod.item;

import com.google.common.base.Suppliers;
import net.lowis.tutorialmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;


import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {

    URANIUM(ModTags.Blocks.INCORRECT_FOR_URANIUM_TOOL, 1300, 6.0F, 5.0F, 12, () -> Ingredient.ofItems(ModItems.URANIUM_INGOT)),
    ANCIENT(ModTags.Blocks.INCORRECT_FOR_ANCIENT_TOOL, 2000, 8.0F, 8.0F, 15, () -> Ingredient.ofItems(ModItems.ANCIENT_GEM));         //light blue #19859f    dark blue #197a9f


    private final TagKey<Block> inverseTag;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(
            final TagKey<Block> inverseTag,
            final int itemDurability,
            final float miningSpeed,
            final float attackDamage,
            final int enchantability,
            final Supplier<Ingredient> repairIngredient) {

        this.inverseTag = inverseTag;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public TagKey<Block> getInverseTag() {
        return this.inverseTag;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }
}
