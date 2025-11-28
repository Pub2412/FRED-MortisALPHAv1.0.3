import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_HALLWAY extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    public LEVEL5_HALLWAY()
    {
        WorldController.currentLevel = "LEVEL5_HALLWAY";
        setSongFile("church_lightning");
        setConnectionDown("LEVEL5_KITCHEN");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Solid("room/HOME/HALLWAY_UP1.png"),8,6);

        addObject(new Solid("room/HOME/HALLWAY_LEFT1.png"),0,7);

        addObject(new Solid("room/HOME/HALLWAY_DOWN1.png"),1,11);
        addObject(new Solid("room/HOME/HALLWAY_DOWN2.png"),10,11);

        Player player = new Player();
        addObject(player,4,10);
        
    TeleportArea teleportToBasement = new TeleportArea("LEVEL5_HALLWAY_CUTSCENE", 4, 7);
    addObject(teleportToBasement, 8, 9); // Example coordinates for the area in 
    }
}
