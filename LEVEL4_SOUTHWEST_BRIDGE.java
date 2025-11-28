import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_SOUTHWEST_BRIDGE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_SOUTHWEST_BRIDGE extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_SOUTHWEST_BRIDGE.
     * 
     */
    public LEVEL4_SOUTHWEST_BRIDGE()
    {
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        setConnectionRight("LEVEL4_SOUTH_BRIDGE");
        setConnectionLeft("LEVEL4_SOUTHWEST_BRIDGE_CORNER");
    }
}
