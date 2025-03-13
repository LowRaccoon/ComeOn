package net.lowis.tutorialmod.entity.custom;

import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class GiantSeedProjectileEntity extends PersistentProjectileEntity{

    private float rotation;
    public Vector2f groundedOffset;

    public GiantSeedProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public GiantSeedProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.GIANT_SEED, player, world, new ItemStack(ModItems.GIANT_SEED), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.GIANT_SEED);
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
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 3);

        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.discard();
        }
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
    }
}
