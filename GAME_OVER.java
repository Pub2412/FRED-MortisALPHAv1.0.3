import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JUMPSCARE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GAME_OVER extends World
{
    private int frames = 0;
    private GreenfootSound curSnd = new GreenfootSound("sfx/MORTIS.wav");
    public GAME_OVER()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(640, 480, 2); 
        prepare();
    }
    public void prepare() {addObject(new CRT_OVERLAY(),8,7);}
    public void act() {
        if (frames == 30) {
            curSnd.play();
            setBackground("MORTIS.png");
        }
        if (frames == 300) {
            setBackground("BG_BLACK.png");
        }
        if (frames == 500) {
            WorldController.changeRoomNoTransition("MAIN_MENU");
        }
        frames++;
    }
}
