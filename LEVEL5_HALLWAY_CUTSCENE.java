import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL5_HALLWAY_CUTSCENE extends Room
{

    /**
     * Constructor for objects of class LEVEL5.
     * 
     */
    Player player = new Player();
    BluePlayer playerb = new BluePlayer();
    private int dialogueProgress = 0;
    private int dialogueDelay = 0;
    private int pressCooldown = 0;
    private GreenfootSound currentSound;
    public LEVEL5_HALLWAY_CUTSCENE()
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
                    WorldController.showMessage("Hello, Fr. Lacuesta, I have been expecting you");
                    currentSound = new GreenfootSound("lvl5_d2/int_1.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 1:
                    WorldController.showMessage("STAY BACK! DEMON!");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_2.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 2:
                    WorldController.showMessage("Lets don't be too harsh, I'm Dr. Sherwin Fuhrer");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_3.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 3:
                    WorldController.showMessage("and I would like to thank you for setting me free from that machine.");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_4.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 4:
                    WorldController.showMessage("You see my dear daisy here is the one who summoned the demon");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_5.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 5:
                    WorldController.showMessage("And burned down my business");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_6.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 6:
                    WorldController.showMessage("I would like you to cleanse her Father");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_7.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 7:
                    WorldController.showMessage("LIES, DECEPTION");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_8.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 8:
                    WorldController.showMessage("Oh check her face father, that is from the devil");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_9.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 9:
                    WorldController.showMessage("Oh check her face father, that is from the devil");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_9.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 10:
                    WorldController.showMessage("You know what must be done");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl5_d2/int_10.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 11:
                if (currentSound != null) currentSound.stop();
                
                if (WorldController.isPuzzleSolved("SH")) {
                Greenfoot.setWorld(new LEVEL5_HALLWAY_CH1());} else{Greenfoot.setWorld(new LEVEL5_HALLWAY_CH2());
                }
                
                break;
            }
        }
    }
}

