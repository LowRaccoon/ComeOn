package net.lowis.tutorialmod.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        ModOreGeneration.generateOres();

        ModTreeGeneration.generateTrees();

        ModEntitySpawns.addSpawns();
    }



}
/*
World Generation Steps in order from first to last
try to follow it to be sure

RAW_GENERATION
LAKES
LOCAL_MODIFICATIONS
UNDERGROUND_STRUCTURES
SURFACE_STRUCTURES
STRONGHOLDS
UNDERGROUND_ORES
UNDERGROUND_DECORATION
FLUID_SPRINGS
VEGETAL_DECORATION
TOP_LAYER_MODIFICATION

*/
