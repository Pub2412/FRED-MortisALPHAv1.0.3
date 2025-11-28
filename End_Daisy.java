import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End_Daisy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End_Daisy extends Room
{

    /**
     * Constructor for objects of class End_Daisy.
     * 
     */
    public End_Daisy()
    {
        setBackground("EndCards/Daisy.png");
        prepare();
        }
        public void prepare() {addObject(new CRT_OVERLAY(),8,7);}
         public void act(){
               //MusicPlayer.PlayMus("church_lightning.wav");
        if (Greenfoot.isKeyDown("enter")) {
               //MusicPlayer.StopMus();
            WorldController.changeRoomNoTransition("MAIN_MENU");
        }
        
    }
    
}
