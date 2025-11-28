import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LEVEL1_s3 - Shows a cutscene sequence with music (no player, no gameplay)
 */
public class LEVEL1_s3 extends LEVEL1
{
    private GreenfootImage[] cutsceneImages;
    private int currentFrame = 0;
    private int frameDelay = 3; // Number of acts before advancing to next frame (adjust for speed)
    private int delayCount = 0;
    private GreenfootSound cutsceneMusic;

    public LEVEL1_s3() {
        super();
        cutsceneMusic = new GreenfootSound("lostsoul.wav"); // or .wav, use correct file extension
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
        int startFrame = 123;
        int endFrame = 184;
        int totalFrames = endFrame - startFrame + 1;
        cutsceneImages = new GreenfootImage[totalFrames];

        for (int i = 0; i < totalFrames; i++) {
            String filename = "lostsoulintro/Screen Recording 2025-11-14 131805_" + (startFrame + i) + ".png";
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
                Greenfoot.setWorld(new LEVEL1_s4());
            }
        }
    }

    @Override
    protected void prepare() {
        // Override to do nothing - no room setup during cutscene
    }

   
    @Override
    public void stopped() {
        stopCutsceneMusic();
    }
}
