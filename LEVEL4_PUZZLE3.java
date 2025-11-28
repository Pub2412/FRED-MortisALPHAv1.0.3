import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE3 extends LEVEL4_HALLWAY
{

    /**
     * Constructor for objects of class LEVEL4_PUZZLE3.
     * 
     */
    public LEVEL4_PUZZLE3()
    {
        FLOOR1.setImage("room/CHURCH/FLOOR_LEFT_BRIDGE.png");
        FLOOR2.setImage("room/CHURCH/FLOOR_RIGHT_BRIDGE.png");
        HALL1.setImage("room/CHURCH/HALL_LEFT_ALT.png");
        HALL2.setImage("room/CHURCH/HALL_RIGHT_ALT.png");
        setConnectionDown("LEVEL4_HALLWAY_TO_PUZZLE3");
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/EDGE_LEFT.png"),1,6);
        addObject(new Solid("room/CHURCH/EDGE_RIGHT.png"),14,6);
        addObject(new LEVEL4_PUZZLE_STARTER("LEVEL4_PUZZLE_GAME3", "LEVEL4_PUZZLE3"),8,5);
    }
}
