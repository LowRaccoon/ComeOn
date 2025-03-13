package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;

public class DoomRemoteItem extends Item {

    public DoomRemoteItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(!world.isClient()) {             //needs to be on a server to work, that's "!world.isClient"

            world.setBlockState(context.getBlockPos(), Blocks.BASALT.getDefaultState());     //change the block, TODO to be deleted

            context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
            world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_DISPENSER_FAIL, SoundCategory.BLOCKS);

        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }
    }
}
