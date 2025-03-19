package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class GlassBottleItem extends Item {

    public GlassBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();

        context.getPlayer().getStackInHand(context.getHand()).decrement(1);

        world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_GLASS_BREAK, SoundCategory.BLOCKS);

        context.getPlayer().giveItemStack(ModItems.GLASS_SHARD.getDefaultStack());
        //BROKEN GLASS BOTTLE


        return ActionResult.SUCCESS;
    }
}
