package net.lowis.tutorialmod.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.util.math.MathHelper;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;

public class MagicCircleParticle extends SpriteBillboardParticle {
    public MagicCircleParticle(ClientWorld clientWorld, double x, double y, double z,
                               SpriteProvider spriteProvider, double xSpeed, double ySpeed, double zSpeed) {
        super(clientWorld, x, y, z, xSpeed, ySpeed, zSpeed);

        this.velocityMultiplier = 0.2f;

        this.scale = 10;

        this.maxAge = 40;

        this.setSpriteForAge(spriteProvider);
        this.red = 1f;
        this.green = 1f;
        this.blue = 1f;

    }

    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {

        Quaternionf quaternionf = new Quaternionf();
        quaternionf.rotationX(-1.0472F);
        this.method_60373(vertexConsumer, camera, quaternionf, tickDelta);
        quaternionf.rotationYXZ(-1.0472F, 1.0472F, 0.0F);
        this.method_60373(vertexConsumer, camera, quaternionf, tickDelta);

    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public @Nullable Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            return new MagicCircleParticle(world, x, y, z, this.spriteProvider, velocityX, velocityY, velocityZ);
        }
    }
}
