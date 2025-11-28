import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class End_Doc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class End_Doc extends Room
{

    /**
     * Constructor for objects of class End_Doc.
     * 
     */
    public End_Doc()
    {
        setBackground("EndCards/The Doctor.png");
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
