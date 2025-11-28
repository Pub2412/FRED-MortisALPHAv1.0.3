import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LVL1_Tscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVL1_Tscreen extends Room
{

    /**
     * Constructor for objects of class LVL1_Tscreen.
     * 
     */
    public LVL1_Tscreen()
    {
        setBackground("t_cards/lvl1.png");
        prepare();
        }
        public void prepare() {addObject(new CRT_OVERLAY(),8,7);}
        
         public void act(){
            //MusicPlayer.PlayMus("church_lightning.wav");
        if (Greenfoot.isKeyDown("enter")) {
            //MusicPlayer.StopMus();
            WorldController.changeRoomNoTransition("LEVEL1_PuzzleHub");
        }
        
    }
    
}
