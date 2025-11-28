import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_HALLWAY here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_HALLWAY extends Room
{
    public Solid HALL1 = new Solid("room/CHURCH/HALL_LEFT.png");
    public Solid HALL2 = new Solid("room/CHURCH/HALL_RIGHT.png");
    public Solid FLOOR1 = new Solid("room/CHURCH/FLOOR_LEFT.png");
    public Solid FLOOR2 = new Solid("room/CHURCH/FLOOR_RIGHT.png");
    /**
     * Constructor for objects of class LEVEL4_HALLWAY.
     * 
     */
    public LEVEL4_HALLWAY()
    {
        setSongFile("darkchurch_intro");
        prepare();
    }
    private void prepare()
    {
        addObject(HALL1,3,3);
        addObject(HALL2,12,3);
        addObject(FLOOR1,3,11);
        addObject(FLOOR2,12,11);
        Player player = new Player();
        addObject(player,8,7);
    }
}
