import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_SOUTHEAST_BRIDGE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_SOUTHEAST_BRIDGE extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_SOUTHEAST_BRIDGE.
     * 
     */
    public LEVEL4_SOUTHEAST_BRIDGE()
    {
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        setConnectionLeft("LEVEL4_SOUTH_BRIDGE");
        setConnectionRight("LEVEL4_SOUTHEAST_BRIDGE_CORNER");
    }
}
