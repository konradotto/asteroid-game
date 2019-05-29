package src.model;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Java class to load and play the sounds.
 * Implemented according to the Singleton pattern to prevent frequent loading.
 */
public final class Sounds {

    // static instance of Sounds to be handed to the controller
    private static Sounds sounds_instance = null;

    // Sound clips - used to load and store the sounds
    /*private static Clip crashSound;
    private static Clip explosionSound;
    private static Clip fireSound;
    private static Clip missileSound;
    private static Clip saucerSound;
    private static Clip thrustersSound;
    private static Clip warpSound;*/
    private static List<Clip> clips;

    // Counter and total used to track the loading of the sound clips.
    private static int clipTotal   = 0;
    private static int clipsLoaded = 0;


    /**
     * Private constructor which can only be called from within this class.
     * This ensures that sounds are only loaded once.
     */
    private Sounds() {
        loadSounds();
    }

    private void loadSounds() {
        /**
         * Load all sound clips by playing and immediately stopping them. Update
         * counter and total for display.
         */
        clips = new ArrayList<>();

        try {
            for (int i = 0; i < SoundEnum.values().length; i++) {
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new File(SoundEnum.values()[i].getPath())));
                clips.add(clip);
                clipTotal++;
            }
            /*
            crashSound = AudioSystem.getClip();
            crashSound.open(AudioSystem.getAudioInputStream(new File("sounds/crash.wav")));
            clipTotal++;

            explosionSound = AudioSystem.getClip();
            explosionSound.open(AudioSystem.getAudioInputStream(new File("sounds/explosion.wav")));
            clipTotal++;

            fireSound = AudioSystem.getClip();
            fireSound.open(AudioSystem.getAudioInputStream(new File("sounds/fire.wav")));
            clipTotal++;

            missileSound = AudioSystem.getClip();
            missileSound.open(AudioSystem.getAudioInputStream(new File("sounds/missle.wav")));
            clipTotal++;

            saucerSound = AudioSystem.getClip();
            saucerSound.open(AudioSystem.getAudioInputStream(new File("sounds/saucer.wav")));
            clipTotal++;

            thrustersSound = AudioSystem.getClip();
            thrustersSound.open(AudioSystem.getAudioInputStream(new File("sounds/thrusters.wav")));
            clipTotal++;

            warpSound = AudioSystem.getClip();
            warpSound.open(AudioSystem.getAudioInputStream(new File("warp.wav")));
            clipTotal++;*/
        } catch (Exception e) {
            System.err.println("Exception loading sounds from their sources.");
            e.printStackTrace();
        }

        try {

            for (int i = 0; i < SoundEnum.values().length; i++) {
                Clip clip = clips.get(i);
                clip.start();
                clip.stop();
                clipsLoaded++;
            }
            /*
            crashSound.start();     crashSound.stop();     clipsLoaded++;
            explosionSound.start(); explosionSound.stop(); clipsLoaded++;
            fireSound.start();      fireSound.stop();      clipsLoaded++;
            missileSound.start();    missileSound.stop();    clipsLoaded++;
            saucerSound.start();    saucerSound.stop();    clipsLoaded++;
            thrustersSound.start(); thrustersSound.stop(); clipsLoaded++;
            warpSound.start();      warpSound.stop();      clipsLoaded++;
            */
        } catch (Exception e) {
            System.err.print("Exception testing sound clips.");
            e.printStackTrace();
        }
    }

    /**
     * Instantiate and load the sound clips if not done already.
     */
    public static void init() {
        if (sounds_instance == null) {
            sounds_instance = new Sounds();
            sounds_instance.loadSounds();
        }
    }

    public static void startClip(SoundEnum clip) {
        clips.get(clip.ordinal()).setFramePosition(0);
        clips.get(clip.ordinal()).start();
    }

    public static void stopClip(SoundEnum clip) {
        clips.get(clip.ordinal()).stop();
    }

    public static void loop(SoundEnum clip) {
        clips.get(clip.ordinal()).setFramePosition(0);
        clips.get(clip.ordinal()).start();
        clips.get(clip.ordinal()).loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void stopAll() {
        for (Clip clip:clips) {
            clip.stop();
        }
    }

    public static int getClipTotal() {
        return clipTotal;
    }

    public static int getClipsLoaded() {
        return clipsLoaded;
    }
}
