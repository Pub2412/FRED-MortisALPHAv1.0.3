import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL2_start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL2_start extends LEVEL2
{

    /**
     * Constructor for objects of class LEVEL2_start.
     * 
     */
    public LEVEL2_start()
    {
        setConnections("LEVEL2_correct1", "LEVEL2_correct1", "LEVEL2_correct1", "LEVEL2_correct1");
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Sign sign = new Sign("THE RIGHT PATH SHOWS ITS WAY.");
        sign.setImage("interact/THE HOLY.png");
        addObject(sign,13,3);
    }
}
