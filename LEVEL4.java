import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4 extends Room
{
    /**
     * Constructor for objects of class LEVEL4.
     * 
     */
    public LEVEL4()
    {
        setSongFile("darkchurch_intro");
        setConnectionLeft("LEVEL4_HALL_LEFT");
        setConnectionRight("LEVEL4_HALL_RIGHT");
        setConnectionUp("LEVEL4_FINALE");
        prepare();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/ENTRANCE_LEFT.png"),2,3);
        addObject(new Solid("room/CHURCH/ENTRANCE_RIGHT.png"),14,3);
        if (WorldController.isPuzzleSolved("LEVEL4_PUZZLE1") && WorldController.isPuzzleSolved("LEVEL4_PUZZLE2") && WorldController.isPuzzleSolved("LEVEL4_PUZZLE3") && WorldController.isPuzzleSolved("LEVEL4_PUZZLE4")) {
            
        } else {
            addObject(new Solid("room/CHURCH/DOOR_LEFT.png"),7,3);
            addObject(new Solid("room/CHURCH/DOOR_RIGHT.png"),9,3);
            if (getAmountLeft() > 0) {
                Sign sign = new Sign((4 - getAmountLeft()) + " SOULS REMAIN.");
                sign.setImage("interact/THE HOLY.png");
                addObject(sign,8,6);
            } else {
                Sign sign = new Sign("THE DOOR OPENS ONLY WHEN YOU FREE THE SOULS");
                sign.setImage("interact/THE HOLY.png");
                addObject(sign,8,6);
            }
            
        }
        
        addObject(new Solid("room/CHURCH/FLOOR_LEFT_ALT.png"),3,11);
        addObject(new Solid("room/CHURCH/FLOOR_RIGHT_ALT.png"),12,11);
        
        Player player = new Player();
        addObject(player,8,9);

    }
    private int getAmountLeft() {
        int total = 0;
        if (WorldController.isPuzzleSolved("LEVEL4_PUZZLE1")) total++;
        if (WorldController.isPuzzleSolved("LEVEL4_PUZZLE2")) total++;
        if (WorldController.isPuzzleSolved("LEVEL4_PUZZLE3")) total++;
        if (WorldController.isPuzzleSolved("LEVEL4_PUZZLE4")) total++;
        return total;
    }
}
