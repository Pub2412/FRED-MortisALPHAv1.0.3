import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EVEL4_SOUTWEST_BRIDGE_CORNER here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_SOUTHWEST_BRIDGE_CORNER extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_SOUTHWEST_BRIDGE_CORNER.
     * 
     */
    public LEVEL4_SOUTHWEST_BRIDGE_CORNER()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_BRIDGE.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_BRIDGE.png");
        setConnectionRight("LEVEL4_SOUTHWEST_BRIDGE");
        setConnectionUp("LEVEL4_BRIDGE_TO_PUZZLE1");
        prepare();
    }
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/EDGE_LEFT.png"),1,6);
    }
}
