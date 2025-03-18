package net.lowis.tutorialmod.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;

public class FuelItems {

    public static void registerFuel() {
        FuelRegistry.INSTANCE.add(ModItems.STAR_REMAINS, 2000);
        FuelRegistry.INSTANCE.add(ModItems.FROSTFIRE_ICE, 2000);
        FuelRegistry.INSTANCE.add(ModItems.AURORA_ASHES, 2000);

    }
}
