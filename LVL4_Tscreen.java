import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LVL4_Tscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVL4_Tscreen extends Room
{

    /**
     * Constructor for objects of class LVL4_Tscreen.
     * 
     */
    public LVL4_Tscreen()
    {
        setBackground("t_cards/lvl4.png");
        prepare();
        }
        public void prepare() {addObject(new CRT_OVERLAY(),8,7);}
         public void act(){
               //MusicPlayer.PlayMus("church_lightning.wav");
        if (Greenfoot.isKeyDown("enter")) {
               //MusicPlayer.StopMus();
            WorldController.changeRoomNoTransition("LEVEL4");
        }
        
    }
    
}
