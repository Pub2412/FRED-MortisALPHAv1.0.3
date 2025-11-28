import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LVL2_Tscreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LVL2_Tscreen extends Room
{

    /**
     * Constructor for objects of class LVL2_Tscreen.
     * 
     */
    public LVL2_Tscreen()
    {
        setBackground("t_cards/lvl2.png");
        MusicPlayer.StopMus();
        prepare();
        }
        public void prepare() {addObject(new CRT_OVERLAY(),8,7);}
        
         public void act(){

        if (Greenfoot.isKeyDown("enter")) {
            WorldController.changeRoomNoTransition("LEVEL2_start");
        }
        
    }
    
}
