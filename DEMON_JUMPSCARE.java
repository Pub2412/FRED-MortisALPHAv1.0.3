import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JUMPSCARE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DEMON_JUMPSCARE extends World
{
    private int frames = 0;
    private GreenfootSound curSnd = new GreenfootSound("sfx/audio_glitch.wav");
    public DEMON_JUMPSCARE()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 2); 
        prepare();
    }
    public void prepare() { addObject(new CRT_OVERLAY(),320,240); }
    public void act() {
        if (frames == 30) {
            curSnd.play();
        }
        if (frames > 30 && frames < 90) {
            if (frames % 8 == 0) {
                setBackground("BG_RED.png");
            } else if (frames % 8 == 2) {
                setBackground("BG_BLACK.png");
            } else if (frames % 8 == 4) {
                setBackground("demon_jumpscare.png");
            }
        }
        if (frames == 90) {
            curSnd.stop();
            curSnd = new GreenfootSound("sfx/laugh.wav");
            setBackground("BG_BLACK.png");
        }
        if (frames == 120) {
            curSnd.play();
        }
        if (frames == 120 + 90) {
            WorldController.changeRoomNoTransition("GAME_OVER");
        }
        frames++;
    }
}
