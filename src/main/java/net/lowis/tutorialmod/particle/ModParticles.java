package net.lowis.tutorialmod.particle;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.lowis.tutorialmod.TutorialMod;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModParticles {

    public static final SimpleParticleType MAGIC_CIRCLE_PARTICLE = registerParticle("magic_circle_particle", FabricParticleTypes.simple());



    private static SimpleParticleType registerParticle(String name, SimpleParticleType particleType) {
        return Registry.register(Registries.PARTICLE_TYPE, Identifier.of(TutorialMod.MOD_ID, name), particleType);
    }


    public static void registerParticles() {
        TutorialMod.LOGGER.info("Registering Particles for " + TutorialMod.MOD_ID);
    }

}
