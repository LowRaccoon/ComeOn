package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.component.ModDataComponentTypes;
import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.entity.custom.GiantSeedProjectileEntity;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;

public class TreeStaffItem extends Item {

    public TreeStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        GiantSeedProjectileEntity seed = new GiantSeedProjectileEntity(world, user);
        seed.setVelocity(user, user.getPitch(), user.getYaw(), 5.0f, 1.0f, 5.0f);
        world.spawnEntity(seed);

        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        context.getStack().set(ModDataComponentTypes.COORDINATES, context.getBlockPos());
        return super.useOnBlock(context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {

        if(stack.get(ModDataComponentTypes.COORDINATES) != null) {

            tooltip.add(Text.literal("Last Block Changed at " + stack.get(ModDataComponentTypes.COORDINATES)));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
