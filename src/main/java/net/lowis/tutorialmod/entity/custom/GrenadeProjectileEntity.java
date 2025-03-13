package net.lowis.tutorialmod.entity.custom;

import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.math.Vector2f;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ProjectileDeflection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.item.map.MapState;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkManager;
import net.minecraft.world.entity.EntityLookup;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.tick.QueryableTickScheduler;
import net.minecraft.world.tick.TickManager;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3d;

import java.util.List;

public class GrenadeProjectileEntity extends PersistentProjectileEntity {

    private float rotation;
    public Vector2f groundedOffset;

    public GrenadeProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    public GrenadeProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.GRENADE, player, world, new ItemStack(ModItems.GRENADE), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
        return new ItemStack(ModItems.GRENADE);
    }

    public float getRenderingRotation() {
        rotation += 3f;
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

        explode(entityHitResult.getPos().getX(), entityHitResult.getPos().getY(), entityHitResult.getPos().getZ());

    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        super.onBlockHit(result);

        explode(result.getPos().getX(), result.getPos().getY(), result.getPos().getZ());

    }

    @Override
    protected boolean tryPickup(PlayerEntity player) {
        return false;
    }

    public void explode(double xPos, double yPos, double zPos) {
        World world = this.getWorld();

        world.createExplosion(null, xPos, yPos, zPos, 4f, World.ExplosionSourceType.BLOCK);
        kill();
    }


}
