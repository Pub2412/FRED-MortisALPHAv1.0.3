import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE4 extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_PUZZLE4.
     * 
     */
    public LEVEL4_PUZZLE4()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_ALT.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_ALT.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_BRIDGE.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_BRIDGE.png");
        setConnectionUp("LEVEL4_SOUTH_BRIDGE");
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/EDGE_LEFT.png"),1,6);
        addObject(new Solid("room/CHURCH/EDGE_RIGHT.png"),14,6);
        addObject(new LEVEL4_PUZZLE_STARTER("LEVEL4_PUZZLE_GAME4", "LEVEL4_PUZZLE4"),8,10);
    }
}
