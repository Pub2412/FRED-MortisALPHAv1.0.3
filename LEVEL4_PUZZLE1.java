import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE1 extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_PUZZLE1.
     * 
     */
    public LEVEL4_PUZZLE1()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_ALT.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_ALT.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        setConnectionRight("LEVEL4_BRIDGE_TO_PUZZLE1");
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/EDGE_LEFT.png"),1,6);
        addObject(new LEVEL4_PUZZLE_STARTER("LEVEL4_PUZZLE_GAME1", "LEVEL4_PUZZLE1"),8,5);
    }
}
