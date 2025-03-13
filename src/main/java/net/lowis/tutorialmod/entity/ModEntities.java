package net.lowis.tutorialmod.entity;

import net.lowis.tutorialmod.TutorialMod;
import net.lowis.tutorialmod.entity.custom.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {


    public static final EntityType<MantisEntity> MANTIS = Registry.register(Registries.ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "mantis"),
            EntityType.Builder.create(MantisEntity::new, SpawnGroup.CREATURE)
                    .dimensions(2.5f, 2.5f).build());

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "tomahawk"),
            EntityType.Builder.<TomahawkProjectileEntity>create(TomahawkProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 1.5f).build());
    public static final EntityType<GrenadeProjectileEntity> GRENADE = Registry.register(Registries.ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "grenade"),
            EntityType.Builder.<GrenadeProjectileEntity>create(GrenadeProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());
    public static final EntityType<GiantSeedProjectileEntity> GIANT_SEED = Registry.register(Registries.ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "giant_seed"),
            EntityType.Builder.<GiantSeedProjectileEntity>create(GiantSeedProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());

    public static final EntityType<GobozoEntity> GOBOZO = Registry.register(Registries.ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "gobozo"),
            EntityType.Builder.create(GobozoEntity::new, SpawnGroup.CREATURE)
                    .dimensions(0.5f, 0.5f).build());

    public static final EntityType<ChairEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "chair"),
            EntityType.Builder.create(ChairEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.5f).build());



    public static void registerModEntities() {
        TutorialMod.LOGGER.info("Registering Mod Entities for " + TutorialMod.MOD_ID);
    }


}
