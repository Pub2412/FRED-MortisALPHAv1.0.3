import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_BASEMENT extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    Player player = new Player();
    public LEVEL5_BASEMENT()
    {
        WorldController.currentLevel = "LEVEL5_BASEMENT";
        setSongFile("cutscenes/int_12");
        setConnectionUp("LEVEL5_KITCHEN");
        prepare();
            
        
        addObject(player,13,1);
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private VisionMask mask;
    protected void prepare()
    {
        addObject(new Solid("room/HOME/BASEMENT_UP1.png"),6,3);
        addObject(new Solid("room/HOME/BASEMENT_UP2.png"),11,0);
        addObject(new Solid("room/HOME/BASEMENT_UP2.png"),11,1);
        addObject(new NonSolid("room/HOME/BASEMENT_STAIRCASE.png"),12,2);
        addObject(new NonSolid("room/HOME/BASEMENT_STAIRCASE.png"),13,2);

        addObject(new Solid("room/HOME/BASEMENT_LEFT1.png"),0,6);
        addObject(new Solid("room/HOME/BASEMENT_RIGHT1.png"),14,5);

        addObject(new Solid("room/HOME/BASEMENT_DOWN1.png"),7,12);
    
        
        String[] allowedRooms = {"LEVEL5_BASEMENT"};
        Daisy daisy = new Daisy(allowedRooms);
        addObject(daisy, 10, 9);
        
        mask = new VisionMask(player, 200);  // 200px radius suggestion for 80px tiles
        addObject(mask, 8, 6);
        
        Holies holywater = new Holies("", "HW", "interact/hw.png");
        Holies cross = new Holies("Help me father, that is not me - Daisy", "CH", "interact/THE HOLY.png");
        Holies shot = new Holies("", "SH", "interact/shot.png");
        
        if (!WorldController.isPuzzleSolved("HW")) addObject(holywater, 3, 5);
        if (!WorldController.isPuzzleSolved("CH")) addObject(cross, 12, 9);
        if (!WorldController.isPuzzleSolved("SH")) addObject(shot, 2, 9);

        setPaintOrder(VisionMask.class);

    }
}
