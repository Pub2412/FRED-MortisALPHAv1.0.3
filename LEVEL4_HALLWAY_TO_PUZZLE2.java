import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_HALLWAY_TO_PUZZLE2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_HALLWAY_TO_PUZZLE2 extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_HALLWAY_TO_PUZZLE2.
     * 
     */
    public LEVEL4_HALLWAY_TO_PUZZLE2()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_BRIDGE.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_BRIDGE.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        setConnectionLeft("LEVEL4_HALL_RIGHT");
        setConnectionDown("LEVEL4_BRIDGE_TO_PUZZLE2");
        setConnectionRight("LEVEL4_PUZZLE2");
    }
}
