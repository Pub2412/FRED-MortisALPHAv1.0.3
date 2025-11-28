import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL3_Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL3_Start extends LEVEL3
{

    /**
     * Constructor for objects of class LEVEL3_Start.
     * 
     */
    private lostsoul lostSoul; 
    private Player player;
    private int dialogueProgress = 0;
    private int dialogueDelay = 0;
    private int pressCooldown = 0;
    private GreenfootSound currentSound;
    public LEVEL3_Start()
    {
        
        // Connections: left from LEVEL1, top" to LEVEL1_s2 (example next room), others null or LEVEL1 if cycling
        setConnections(null, null, null, "LEVEL3_MirrorRoom"); // u,d l,r
        prepare();
    }
    
      protected void prepare()   
    {
        int width = 16;
        int height = 10;
        
        // Bottom edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/black_u.png"), x, 11 - 1);
        }
        
        // Top edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/blue_edge_u.png"), x, 1);
           // addObject(new Solid("room/edge_u.png"), x, 9);
        }
        
        // Right wall 
        for (int y = 2; y < height - 0; y++) {
            if (y != 7 && y != 6 && y != 5){
            addObject(new Solid("room/blue_edge_r.png"), width - 2, y);
        }
        }

        // Left wall 
        for (int y = 2; y < height - 0; y++) {
                addObject(new Solid("room/blue_edge_l.png"), 1, y);
        }
        
        
        

        //addObject(new Solid("room/edge_u.png"), 8, 5);
        


        
        Frames bf = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf,3,2);
        
        Frames bf2 = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf2,6,2);      
        
        Frames bf3 = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf3,9,2);
   
        Frames bf4 = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf4,12,2);
        
        LEVEL3_Door DDoor = new LEVEL3_Door("LVL2_Tscreen", "LEVEL1_MAZE_DOOR", "1stlvlpuzzle/DoorSmileUnlocked.png", "1stlvlpuzzle/DoorSmileUnlocked.png");
     
        lostSoul = new lostsoul();
        addObject(lostSoul, 8, 5);
        
        // Place player 
        player = new Player();
        addObject(player, 8, 7); 

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
                    WorldController.showMessage("YOU!");
                    currentSound = new GreenfootSound("lvl3_d1/int_1.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 1:
                    WorldController.showMessage("I am impressed, you came this far");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl3_d1/int_2.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 2:
                    WorldController.showMessage("His throne is near");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl3_d1/int_3.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 3:
                    WorldController.showMessage("What do you mean?");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl3_d1/int_4.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 4:
                    WorldController.showMessage("You will find your answers, after finding the right glasses");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl3_d1/int_5.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 5:
                    WorldController.showMessage("Only then, you can free us");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl3_d1/int_6.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 6:
                    if (currentSound != null) currentSound.stop();
                    WorldController.showMessage("The glasses is on the other room in the left");
                    currentSound = new GreenfootSound("lvl3_d1/int_7.wav");
                    currentSound.play();
                    break;
                case 7:
                    if (currentSound != null) currentSound.stop();
                    WorldController.showMessage("Though beware of the beholder");
                    currentSound = new GreenfootSound("lvl3_d1/int_8.wav");
                    currentSound.play();
                    break;
                case 8:
                    if (currentSound != null) currentSound.stop();
                    WorldController.showMessage("WAIT! what is your name?");
                    currentSound = new GreenfootSound("lvl3_d1/int_10.wav");
                    currentSound.play();
                    break;
                case 9:
                    if (currentSound != null) currentSound.stop();
                    WorldController.showMessage("Daisy");
                    currentSound = new GreenfootSound("lvl3_d1/int_11.wav");
                    currentSound.play();
                    break;
                case 10:
                if (currentSound != null) currentSound.stop();
                player.setCanMove(true);
                Greenfoot.setWorld(new LEVEL3());
                break;
            }
        }
}
}
