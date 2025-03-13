package net.lowis.tutorialmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class newGrenadeProjectileEntity extends TntEntity {

    public newGrenadeProjectileEntity(World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(world, x, y, z, igniter);
    }

    public newGrenadeProjectileEntity(EntityType<? extends TntEntity> entityType, World world) {
        super(entityType, world);
    }



}
