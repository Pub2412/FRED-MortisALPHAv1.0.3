import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_HALLWAY_TO_PUZZLE1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_HALLWAY_TO_PUZZLE1 extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_HALLWAY_TO_PUZZLE1.
     * 
     */
    public LEVEL4_HALLWAY_TO_PUZZLE1()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_BRIDGE.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_BRIDGE.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        setConnectionRight("LEVEL4_HALL_LEFT");
        setConnectionLeft("LEVEL4_HALLWAY_TO_PUZZLE3");
        setConnectionDown("LEVEL4_BRIDGE_TO_PUZZLE1");
        prepare();
    }
    private void prepare()
    {
        if (!WorldController.isPuzzleSolved("LEVEL4_PUZZLE1") || !WorldController.isPuzzleSolved("LEVEL4_PUZZLE2")) {
            addObject(new Solid("room/CHURCH/EDGE_LEFT.png"),1,6);
        }
    }
}
