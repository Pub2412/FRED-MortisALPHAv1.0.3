import greenfoot.*;

public class LEVEL1_s4 extends LEVEL1
{
    private lostsoul lostSoul; 
    private Player player;
    private int dialogueProgress = 0;
    private int dialogueDelay = 0;
    private int pressCooldown = 0;
    private GreenfootSound currentSound;
    private GreenfootImage boxImage;
    public LEVEL1_s4() {
        super();
        setSongFile("silence");
        setConnections("LEVEL1_s1", null, null, "LEVEL1_s4");
        prepare();
    }
    
    @Override
    protected void prepare() {
        // Setup room walls, edges, player as before...
        int width = 16;
        int height = 9;

        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_d.png"), x, height - 1);
        }
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_u.png"), x, 1);
            addObject(new Solid("room/edge_u.png"), x, 9);
        }
        for (int y = 2; y < height - 1; y++) {
            addObject(new Solid("room/edge_r.png"), width - 2, y);
        }
        for (int y = 4; y < height - 1; y++) {
            if (y != 4) addObject(new Solid("room/edge_l.png"), 1, y);
        }

        player = new Player();
        addObject(player, 10, 4);

        lostSoul = new lostsoul();
        addObject(lostSoul, 8, 4);

        player.setCanMove(false);
        
        GreenfootImage screen = getBackground();
        screen.drawImage(new GreenfootImage("Press Space to Continue in Dialogue Statements", 20, Color.WHITE, new Color(0,0,0,0)), 100, 20);
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
                    WorldController.showMessage("Who are you?");
                    currentSound = new GreenfootSound("lvl1_d1/int_1.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 1:
                    WorldController.showMessage("I am the one that came before you");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl1_d1/int_2.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 2:
                    WorldController.showMessage("He is waiting beyond that door");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl1_d1/int_3.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 3:
                    WorldController.showMessage("You must say his name to escape");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl1_d1/int_4.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 4:
                    WorldController.showMessage("I have scattered crosses to guide you out from this labyrinth");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl1_d1/int_5.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 5:
                    WorldController.showMessage("FREE US, YOU ARE OUR ONLY HOPE");
                    if (currentSound != null) currentSound.stop();
                    currentSound = new GreenfootSound("lvl1_d1/int_6.wav");
                    currentSound.play();
                    dialogueDelay = 60;
                    break;
                case 6:
                    if (currentSound != null) currentSound.stop();
                    WorldController.showMessage("Huh?");
                    currentSound = new GreenfootSound("lvl1_d1/int_7.wav");
                    currentSound.play();
                    break;
                case 7:
                if (currentSound != null) currentSound.stop();
                player.setCanMove(true);
                Greenfoot.setWorld(new LEVEL1_s5());
                break;
                
                
            }
        }
    }
}
