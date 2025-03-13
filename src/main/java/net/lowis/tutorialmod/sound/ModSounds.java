package net.lowis.tutorialmod.sound;

import net.lowis.tutorialmod.TutorialMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    //the sound files should be in .ogg and mono to not hear it globally, else stereo

    public static final SoundEvent TRANSMUTATOR_USE = registeringSoundEvent("transmutator_use");
    public static final SoundEvent TRANSMUTATOR_BLOCK_BREAK = registeringSoundEvent("transmutator_block_break");
    public static final SoundEvent TRANSMUTATOR_BLOCK_STEP = registeringSoundEvent("transmutator_block_step");
    public static final SoundEvent TRANSMUTATOR_BLOCK_PLACE = registeringSoundEvent("transmutator_block_place");
    public static final SoundEvent TRANSMUTATOR_BLOCK_HIT = registeringSoundEvent("transmutator_block_hit");
    public static final SoundEvent TRANSMUTATOR_BLOCK_FALL = registeringSoundEvent("transmutator_block_fall");

    public static final BlockSoundGroup TRANSMUTATOR_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f, TRANSMUTATOR_BLOCK_BREAK,
                                    TRANSMUTATOR_BLOCK_STEP, TRANSMUTATOR_BLOCK_PLACE, TRANSMUTATOR_BLOCK_HIT, TRANSMUTATOR_BLOCK_FALL);

    public static final SoundEvent BAR_BRAWL = registeringSoundEvent("bar_brawl");
    public static final RegistryKey<JukeboxSong> BAR_BRAWL_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TutorialMod.MOD_ID, "bar_brawl"));


    private static SoundEvent registeringSoundEvent(String name) {
        Identifier id = Identifier.of(TutorialMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }


    public static void registerSounds() {
        TutorialMod.LOGGER.info("Registering Mod Sounds for " + TutorialMod.MOD_ID);
    }
}
