package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.component.ModDataComponentTypes;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.WaitTask;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;

import java.util.List;

public class ButtonItem extends Item {

    public ButtonItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        BlockPos clickedBlockPos = context.getBlockPos();


        if(!world.isClient() && !(clickedBlock instanceof PlantBlock)) {             //needs to be on a server to work, that's "!world.isClient"

            //world.setBlockState(context.getBlockPos(), Blocks.BASALT.getDefaultState());     //change the block

            world.createExplosion(null, clickedBlockPos.getX() + 0.5 , clickedBlockPos.getY(), clickedBlockPos.getZ() + 0.5, 4f, World.ExplosionSourceType.BLOCK);


            context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
                    }

        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {

        World world =  user.getWorld();
        if(!world.isClient())  {

            world.createExplosion(null, entity.getX(), entity.getY(), entity.getZ(), 4.0f, World.ExplosionSourceType.TNT);
            
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {
            tooltip.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }


        super.appendTooltip(stack, context, tooltip, type);
    }
}
