import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End_Faith here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End_Faith extends Room
{

    /**
     * Constructor for objects of class End_Faith.
     * 
     */
    public End_Faith()
    {
        setBackground("EndCards/Faith.png");
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
