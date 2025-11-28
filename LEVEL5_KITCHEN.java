import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_KITCHEN extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    public LEVEL5_KITCHEN()
    {
        WorldController.currentLevel = "LEVEL5_KITCHEN";
        setSongFile("church_lightning");
        setConnectionLeft("LEVEL5_BEDROOM");
        setConnectionDown("LEVEL5_BASEMENT");
        setConnectionUp("LEVEL5_HALLWAY");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Solid("room/HOME/KITCHEN_UP1.png"),1,3);
        addObject(new Solid("room/HOME/KITCHEN_UP2.png"),9,3);
        addObject(new NonSolid("room/HOME/KITCHEN_UP3.png"),8,5);

        addObject(new Solid("room/HOME/KITCHEN_RIGHT1.png"),14,6);

        addObject(new Solid("room/HOME/KITCHEN_DOWN1.png"),0,9);
        addObject(new Solid("room/HOME/KITCHEN_DOWN2.png"),5,11);
        addObject(new Solid("room/HOME/KITCHEN_DOWN3.png"),11,11);
        addObject(new NonSolid("room/HOME/KITCHEN_DOWN4.png"),12,11);
        addObject(new NonSolid("room/HOME/KITCHEN_DOWN4.png"),13,11);

        Player player = new Player();
        addObject(player,4,6);
        
        addObject(new Solid("room/HOME/KITCHEN_FURNITURE1.png"),3,10);
        addObject(new NonSolid("room/HOME/KITCHEN_FURNITURE2.png"),3,9);
        addObject(new NonSolid("room/HOME/KITCHEN_FURNITURE3.png"),3,8);
        
        addObject(new NonSolid("room/HOME/KITCHEN_FURNITURE4.png"),6,10);
        addObject(new NonSolid("room/HOME/KITCHEN_FURNITURE5.png"),6,9);
        
        if (WorldController.isPuzzleSolved("HW") || WorldController.isPuzzleSolved("CH") || WorldController.isPuzzleSolved("SH") ) {
            addObject(new NonSolid("room/HOME/KITCHEN_UP4_ALT.png"),3,3);
            addObject(new NonSolid("room/HOME/KITCHEN_UP5_ALT.png"),4,3);
            addObject(new NonSolid("room/HOME/KITCHEN_UP6.png"),3,0);
            addObject(new NonSolid("room/HOME/KITCHEN_UP6.png"),4,0);
            addObject(new NonSolid("room/HOME/KITCHEN_UP6.png"),3,1);
            addObject(new NonSolid("room/HOME/KITCHEN_UP6.png"),4,1);
            addObject(new Solid("room/HOME/KITCHEN_UP6.png"),2,0);
            addObject(new Solid("room/HOME/KITCHEN_UP6.png"),2,1);
            addObject(new Solid("room/HOME/KITCHEN_UP6.png"),5,0);
            addObject(new Solid("room/HOME/KITCHEN_UP6.png"),5,1);
        } else {
            addObject(new Solid("room/HOME/KITCHEN_UP4.png"),3,3);
            addObject(new Solid("room/HOME/KITCHEN_UP5.png"),4,3);
        }
        
    Notations note = new Notations("YOU NEED TO COME TO THE BASEMENT", "NN", "notes.png");
    Notations note2 = new Notations("FIND THE HOLY WATER, FINISH HIM", "NN2", "notes.png"); 
    Notations note3 = new Notations("GO UP THE OPEN DOOR", "NN3", "notes.png");
    
    if (!WorldController.isPuzzleSolved("NN")) addObject(note, 8, 7);
    if (!WorldController.isPuzzleSolved("NN2")) addObject(note2, 12, 9);
    if (!WorldController.isPuzzleSolved("NN3") && WorldController.isPuzzleSolved("HW")) addObject(note3,12,6);
    }
}
