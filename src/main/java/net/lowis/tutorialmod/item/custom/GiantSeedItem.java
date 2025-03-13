package net.lowis.tutorialmod.item.custom;

import net.lowis.tutorialmod.entity.custom.GiantSeedProjectileEntity;
import net.lowis.tutorialmod.entity.custom.GrenadeProjectileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GiantSeedItem extends Item {

    public GiantSeedItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!world.isClient) {
            GiantSeedProjectileEntity giant_seed = new GiantSeedProjectileEntity(world, user);
            giant_seed.setVelocity(user, user.getPitch(), user.getYaw(), 5.0f, 1.5f, 5.0f);
            world.spawnEntity(giant_seed);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }

        return TypedActionResult.success(itemStack, world.isClient());
    }



}
