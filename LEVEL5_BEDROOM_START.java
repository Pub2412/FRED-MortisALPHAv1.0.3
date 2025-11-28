import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_BEDROOM_START extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    BluePlayer player = new BluePlayer();
    private int dialogueProgress = 0;
    private int dialogueDelay = 0;
    private int pressCooldown = 0;
    private GreenfootSound currentSound;
    public LEVEL5_BEDROOM_START()
    {
        setSongFile("church_lightning");
        setConnectionRight("LEVEL5_KITCHEN");
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Solid("room/HOME/BEDROOM_UP1.png"),4,3);
        addObject(new Solid("room/HOME/BEDROOM_UP2.png"),8,3);
        addObject(new NonSolid("room/HOME/BEDROOM_UP3.png"),9,5);
        addObject(new Solid("room/HOME/BEDROOM_UP4.png"),11,4);
        addObject(new Solid("room/HOME/BEDROOM_UP5.png"),14,3);
        addObject(new NonSolid("room/HOME/BEDROOM_UP6.png"),4,5);

        addObject(new Solid("room/HOME/BEDROOM_LEFT1.png"),1,6);
        addObject(new Solid("room/HOME/BEDROOM_LEFT2.png"),1,11);
        addObject(new Solid("room/HOME/BEDROOM_LEFT3.png"),4,9);

        addObject(new Solid("room/HOME/BEDROOM_DOWN1.png"),4,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN2.png"),9,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN3.png"),13,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN4.png"),15,11);
        addObject(new Solid("room/HOME/BEDROOM_DOWN5.png"),15,9);
        
        
        addObject(player,9,7);
        player.setCanMove(false);
    }
    
    public void act() {
        handleDialogue();
        // Other act logic if needed
    }

    private void handleDialogue() {
        if (pressCooldown > 0) pressCooldown--;
        if (dialogueDelay > 0) {
            dialogueDelay--;
            return;
        }
        if (Greenfoot.isKeyDown("space") && pressCooldown <= 0 && WorldController.isMessageShown()) {
            WorldController.closeCurrentMessage();
            pressCooldown = 20;  // Debounce space press
            dialogueProgress++;
        }
        if (!WorldController.isMessageShown()) {
            switch(dialogueProgress) {
                case 0:
                    WorldController.showMessage("That was an unpleasant dream");
                    currentSound = new GreenfootSound("lvl5_d1/int_1.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 1:
                    WorldController.showMessage("I should do some chores in the kitchen");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d1/int_2.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 2:
                if (currentSound != null) currentSound.stop();
                player.setCanMove(true);
                Greenfoot.setWorld(new LEVEL5_BEDROOM());
                break;
            }
        }
    }
}

