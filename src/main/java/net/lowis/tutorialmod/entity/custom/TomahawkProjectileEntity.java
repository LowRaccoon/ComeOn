package net.lowis.tutorialmod.entity.custom;

import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class TomahawkProjectileEntity extends PersistentProjectileEntity {

    private float rotation;
    public Vector2f groundedOffset;

    public TomahawkProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public TomahawkProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.TOMAHAWK, player, world, new ItemStack(ModItems.TOMAHAWK), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.TOMAHAWK);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public boolean isGrounded() {
        return inGround;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 7);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }

        playSound(SoundEvents.ITEM_TRIDENT_HIT, 1, 1);
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

        if(result.getSide() == Direction.SOUTH) {
            groundedOffset = new Vector2f(215f, this.getBodyYaw());
        }
        if(result.getSide() == Direction.NORTH) {
            groundedOffset = new Vector2f(215f,  this.getBodyYaw());
        }
        if(result.getSide() == Direction.EAST) {
            groundedOffset = new Vector2f(215f, this.getBodyYaw());
        }
        if(result.getSide() == Direction.WEST) {
            groundedOffset = new Vector2f(215f, this.getBodyYaw());
        }

        if(result.getSide() == Direction.DOWN) {
            groundedOffset = new Vector2f(115f, this.getBodyYaw());
        }
        if(result.getSide() == Direction.UP) {
            groundedOffset = new Vector2f(285f, this.getBodyYaw());
        }

        playSound(SoundEvents.ITEM_TRIDENT_HIT_GROUND, 1, 1);
    }

    @Override
    public void playSound(SoundEvent sound, float volume, float pitch) {
        super.playSound(sound, volume, pitch);
    }
}
