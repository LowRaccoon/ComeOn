package net.lowis.tutorialmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BoneNeedleItem extends Item {

    public BoneNeedleItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (target instanceof HostileEntity) {
            target.kill();
        }
        return super.postHit(stack, target, attacker);
    }
}
