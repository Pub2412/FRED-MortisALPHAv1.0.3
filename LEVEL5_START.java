import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL5_START here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_START extends Room
{

private GreenfootImage[] cutsceneImages;
    private int currentFrame = 0;
    private int frameDelay = 3; // Number of acts before advancing to next frame (adjust for speed)
    private int delayCount = 0;
    private GreenfootSound cutsceneMusic;

    public LEVEL5_START() {
        super();
        cutsceneMusic = new GreenfootSound("crepintro.wav"); // or .wav, use correct file extension
        cutsceneMusic.setVolume(100); // (optional) Adjust volume 0-100
        // Don't call prepare() - we skip all room setup for cutscene
        loadCutscene();
        showCurrentFrame();
        playCutsceneMusic();
    }
        private void playCutsceneMusic() {
        if (cutsceneMusic != null) {
            cutsceneMusic.playLoop(); // Play in loop or use .play() for one time
        }
    }
        private void stopCutsceneMusic() {
        if (cutsceneMusic != null) cutsceneMusic.stop();
        
    }

    // Load images from 123 to 184
    private void loadCutscene() {
        int startFrame = 0;
        int endFrame = 62;
        int totalFrames = endFrame - startFrame + 1;
        cutsceneImages = new GreenfootImage[totalFrames];

        for (int i = 0; i < totalFrames; i++) {
            String filename = "wakeup/JOHN_0" + (startFrame + i) + ".png";
            cutsceneImages[i] = new GreenfootImage(filename);
        }
    }

    private void showCurrentFrame() {
        setBackground(cutsceneImages[currentFrame]);
    }

    public void act() {
        delayCount++;

        // Auto-advance after delay
        if (delayCount >= frameDelay) {
            delayCount = 0;
            currentFrame++;

            if (currentFrame < cutsceneImages.length) {
                showCurrentFrame();
            } else {
                // Cutscene finished: stop music and transition to next world if desired
                stopCutsceneMusic();
                Greenfoot.setWorld(new LEVEL5_BEDROOM_START());
            }
        }
    }

    protected void prepare() {
        // Override to do nothing - no room setup during cutscene
    }

   
    @Override
    public void stopped() {
        stopCutsceneMusic();
    }
}

