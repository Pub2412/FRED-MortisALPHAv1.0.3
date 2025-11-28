import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL2 extends Room
{
    public Solid CORNER1 = new Solid("room/FOREST/FOREST_CORNER1.png");
    public Solid CORNER2 = new Solid("room/FOREST/FOREST_CORNER2.png");
    public Solid CORNER3 = new Solid("room/FOREST/FOREST_CORNER3.png");
    public Solid CORNER4 = new Solid("room/FOREST/FOREST_CORNER4.png");
    
    public LEVEL2()
    {
        super();
        setSongFile("glacier");
        setConnections("LEVEL2_start", "LEVEL2_start", "LEVEL2_start", "LEVEL2_start");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(CORNER1,2,1);
        addObject(CORNER2,13,1);
        addObject(CORNER3,2,10);
        addObject(CORNER4,13,10);
        
        Player player = new Player();
        addObject(player,8,5);
    }
}
