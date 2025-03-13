package net.lowis.tutorialmod.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FuelItems {

    public static void registerFuel() {
        FuelRegistry.INSTANCE.add(ModItems.STAR_REMAINS, 20000);
        FuelRegistry.INSTANCE.add(ModItems.JAGERMEISTER, 1600);

    }
}
