import greenfoot.GreenfootSound;

/**
 * Write a description of class MusicPlayer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MusicPlayer  
{
    // instance variables -s replace the example below with your own
    private static GreenfootSound current_mus;
    private static String current_mus_str = "";

    public static void PlayMus(String filename) {
        // Don't play same song again
        if (current_mus_str.equals(filename)) { return; }
        StopMus();
        current_mus = new GreenfootSound(filename);
        current_mus.playLoop();
        current_mus_str = filename;
    }
    public static void StopMus() {
        current_mus_str = "";
        if (current_mus != null) {
            current_mus.stop();
            current_mus = null;
        }
    }
}
