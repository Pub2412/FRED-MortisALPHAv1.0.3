import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CREDITS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CREDITS_SHOTGUN extends World
{

   private GreenfootImage[] cutsceneImages;
    private int currentFrame = 0;
    private int frameDelay = 500; // Number of acts before advancing to next frame (adjust for speed)
    private int delayCount = 0;
    private GreenfootSound cutsceneMusic;

    public CREDITS_SHOTGUN() {
        super(16, 12, 80);
        cutsceneMusic = new GreenfootSound("american/america_credits.wav"); // or .wav, use correct file extension
        cutsceneMusic.setVolume(100); // (optional) Adjust volume 0-100
        // Don't call prepare() - we skip all room setup for cutscene
        prepare();
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
        int startFrame = 8;
        int endFrame = 15;
        int totalFrames = endFrame - startFrame + 1;
        cutsceneImages = new GreenfootImage[totalFrames];

        for (int i = 0; i < totalFrames; i++) {
            String filename = "creds/" + (startFrame + i) + ".png";
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
                Greenfoot.setWorld(new End_American());
            }
        }
    }

    protected void prepare() {
        addObject(new CRT_OVERLAY(),8,7);
    }

   
    @Override
    public void stopped() {
        stopCutsceneMusic();
    }
}
