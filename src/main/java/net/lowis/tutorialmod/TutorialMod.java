package net.lowis.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.*;
import net.fabricmc.fabric.mixin.object.builder.client.ModelPredicateProviderRegistrySpecificAccessor;
import net.lowis.tutorialmod.block.ModBlocks;
import net.lowis.tutorialmod.block.entity.ModBlockEntities;
import net.lowis.tutorialmod.component.ModDataComponentTypes;
import net.lowis.tutorialmod.effect.ModEffects;
import net.lowis.tutorialmod.enchantment.ModEnchantmentEffects;
import net.lowis.tutorialmod.entity.ModEntities;
import net.lowis.tutorialmod.entity.custom.GobozoEntity;
import net.lowis.tutorialmod.entity.custom.MantisEntity;
import net.lowis.tutorialmod.item.FuelItems;
import net.lowis.tutorialmod.item.ModItemGroups;
import net.lowis.tutorialmod.item.ModItems;
import net.lowis.tutorialmod.particle.ModParticles;
import net.lowis.tutorialmod.potion.ModPotions;
import net.lowis.tutorialmod.screen.ModScreenHandlers;
import net.lowis.tutorialmod.sound.ModSounds;
import net.lowis.tutorialmod.util.HammerUsageEvent;
import net.lowis.tutorialmod.util.ModLootTableModifiers;
import net.lowis.tutorialmod.world.gen.ModWorldGeneration;
import net.minecraft.client.particle.AshParticle;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	@Override
	public void onInitialize() {

		ModWorldGeneration.generateModWorldGen();
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModDataComponentTypes.registerDataComponentTypes();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModParticles.registerParticles();
		ModEnchantmentEffects.registerEnchantmentEffects();
		FuelItems.registerFuel();
		ModEntities.registerModEntities();
		ModLootTableModifiers.modifyLootTables();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();

		FabricDefaultAttributeRegistry.register(ModEntities.MANTIS, MantisEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.GOBOZO, GobozoEntity.createAttributes());


		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		AttackEntityCallback.EVENT.register(((playerEntity, world, hand, entity, entityHitResult) -> {
			if(entity instanceof SheepEntity sheepEntity && world.isClient){		//is client cause else it sends 2 times, one for the client and one for the server
				playerEntity.sendMessage(Text.literal("YOOOOO THIS WORKS"));
				playerEntity.getMainHandStack().decrement(1);		//decrements the item by "1"
				sheepEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 600, 4));
				return ActionResult.PASS;
			}

			return ActionResult.PASS;
		}));

		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.SLIME_BALL, ModPotions.SLIMEY_POTION);
		});
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(Potions.AWKWARD, Items.COOKED_BEEF, ModPotions.FULLNESS_POTION);
		});

		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.CAULIFLOWER_SEEDS, 0.25f);

		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_LOG, ModBlocks.STRIPPED_DRIFTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.DRIFTWOOD_WOOD, ModBlocks.STRIPPED_DRIFTWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DRIFTWOOD_LEAVES, 30, 60);

	}
}