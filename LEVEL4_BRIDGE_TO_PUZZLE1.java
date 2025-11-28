import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_BRIDGE_TO_PUZZLE1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_BRIDGE_TO_PUZZLE1 extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_BRIDGE_TO_PUZZLE1.
     * 
     */
    public LEVEL4_BRIDGE_TO_PUZZLE1()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_BRIDGE.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_BRIDGE.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_BRIDGE.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_BRIDGE.png");
        setConnectionUp("LEVEL4_HALLWAY_TO_PUZZLE1");
        setConnectionLeft("LEVEL4_PUZZLE1");
        setConnectionDown("LEVEL4_SOUTHWEST_BRIDGE_CORNER");
        prepare();
    }
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/EDGE_RIGHT.png"),14,6);
    }
}
