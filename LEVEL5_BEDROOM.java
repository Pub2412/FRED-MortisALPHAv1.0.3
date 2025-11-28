import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_BEDROOM extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    public LEVEL5_BEDROOM()
    {
        WorldController.currentLevel = "LEVEL5_BEDROOM";
        setSongFile("church_lightning");
        setConnectionRight("LEVEL5_KITCHEN");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Solid("room/HOME/BEDROOM_UP1.png"),4,3);
        addObject(new Solid("room/HOME/BEDROOM_UP2.png"),8,3);
        addObject(new NonSolid("room/HOME/BEDROOM_UP3.png"),9,5);
        addObject(new Solid("room/HOME/BEDROOM_UP4.png"),11,4);
        addObject(new Solid("room/HOME/BEDROOM_UP5.png"),14,3);
        addObject(new NonSolid("room/HOME/BEDROOM_UP6.png"),4,5);

        addObject(new Solid("room/HOME/BEDROOM_LEFT1.png"),1,6);
        addObject(new Solid("room/HOME/BEDROOM_LEFT2.png"),1,11);
        addObject(new Solid("room/HOME/BEDROOM_LEFT3.png"),4,9);

        addObject(new Solid("room/HOME/BEDROOM_DOWN1.png"),4,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN2.png"),9,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN3.png"),13,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN4.png"),15,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN5.png"),15,9);
        
        Player player = new Player();
        addObject(player,9,7);
    }
}
