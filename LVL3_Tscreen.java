import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LVL3_Tscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVL3_Tscreen extends Room
{

    /**
     * Constructor for objects of class LVL3_Tscreen.
     * 
     */
    public LVL3_Tscreen()
    {
        setBackground("t_cards/lvl3.png");
        prepare();
        MusicPlayer.StopMus();
        }
        public void prepare() {addObject(new CRT_OVERLAY(),8,7);}
         public void act(){
            //MusicPlayer.PlayMus("church_lightning.wav");
        if (Greenfoot.isKeyDown("enter")) {
            WorldController.changeRoomNoTransition("LEVEL3_Start");
        }
        
    }
    
}
