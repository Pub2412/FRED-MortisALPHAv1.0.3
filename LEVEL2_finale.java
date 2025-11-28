import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL2_finale here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL2_finale extends LEVEL2
{

    /**
     * Constructor for objects of class LEVEL2_finale.
     * 
     */
    public LEVEL2_finale()
    {
        setConnectionRight("LEVEL2_correct7");
        setConnectionUp("LVL3_Tscreen"); // CHANGE THIS!!!!!
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Sign sign = new Sign("THE EDGE OF THE WOODS, YOU ARE NEAR");
        sign.setImage("interact/THE HOLY.png");
        addObject(sign,13,3);
        
        CORNER1.setImage("room/FOREST/FOREST_CORNER1_FINALE.png");
        CORNER1.setLocation(2, 3);
        
        CORNER3.setImage("room/FOREST/FOREST_CORNER3_FINALE.png");
        CORNER4.setImage("room/FOREST/FOREST_CORNER4_FINALE.png");
        CORNER4.setLocation(11, 10);
    }
}
