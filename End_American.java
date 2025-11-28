import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End_American here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End_American extends Room
{

    /**
     * Constructor for objects of class End_American.
     * 
     */
    public End_American()
    {
        setBackground("EndCards/American.png");
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
