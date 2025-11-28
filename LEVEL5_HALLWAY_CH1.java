import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_HALLWAY_CH1 extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    Player player = new Player();
    BluePlayer playerb = new BluePlayer();
    public LEVEL5_HALLWAY_CH1()
    {
        setSongFile("church_lightning");
        setConnectionDown("LEVEL5_KITCHEN");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
private void prepare()
{
    addObject(new Solid("room/HOME/HALLWAY_UP1.png"),8,6);
    addObject(new Solid("room/HOME/HALLWAY_LEFT1.png"),0,7);
    addObject(new Solid("room/HOME/HALLWAY_DOWN1.png"),1,11);
    addObject(new Solid("room/HOME/HALLWAY_DOWN2.png"),10,11);

    addObject(playerb,8,9);

    grandpasemi doc = new grandpasemi();
    addObject(doc, 11,9);

    lostsoul daisy = new lostsoul();
    addObject(daisy, 5, 9);

    playerb.setCanMove(false);
    
    QuestionText question = new QuestionText("What are you going to use?");
    addObject(question, 8, 3); // x, y position (centered near top)

    // Add choice buttons for player decision
    ChoiceButton option1 = new ChoiceButton("Holy Water", () -> {
        Greenfoot.setWorld(new LEVEL5_HALLWAY_CH2());
    });
    ChoiceButton option2 = new ChoiceButton("Shotgun", () -> {
        Greenfoot.setWorld(new CUTSCENE_SHOTGUN_ENDING());
    });

    addObject(option1, 5, 4);
    addObject(option2, 11, 4);


}

}

