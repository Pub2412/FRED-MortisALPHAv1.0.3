import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_SOUTH_BRIDGE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_SOUTH_BRIDGE extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_SOUTH_BRIDGE.
     * 
     */
    public LEVEL4_SOUTH_BRIDGE()
    {
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_ALT.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_ALT.png");
        setConnectionLeft("LEVEL4_SOUTHWEST_BRIDGE");
        setConnectionRight("LEVEL4_SOUTHEAST_BRIDGE");
        setConnectionDown("LEVEL4_PUZZLE4");
        if (WorldController.isPuzzleSolved("LEVEL4_PUZZLE1") && WorldController.isPuzzleSolved("LEVEL4_PUZZLE2")) {
            FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_BRIDGE.png");
            FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_BRIDGE.png");
        }
    }
}
