package net.lowis.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponent {

    public static final FoodComponent BANANA = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20000), 1f)
            .alwaysEdible()
            .build();

    public static final FoodComponent DEMON_EYE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 20000), 1f)
            .alwaysEdible()
            .build();

    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.35f)
            .build();

    public static final FoodComponent DORITOS = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20000), 1f)
            .alwaysEdible()
            .snack()
            .build();

    public static final FoodComponent BAGUETTE = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.75f)
            .build();

    public static final FoodComponent WINE = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20000), 1f)
            .alwaysEdible()
            .build();

    public static final FoodComponent JAGERMEISTER = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.OOZING, 2000), 1f)
            .alwaysEdible()
            .build();

    public static final FoodComponent BEER_PINT = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20000), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20000, 1), 1f)
            .alwaysEdible()
            .build();

    public static final FoodComponent HONEY_BERRY = new FoodComponent.Builder()
            .nutrition(6)
            .saturationModifier(0.1f)
            .snack()
            .build();


}
