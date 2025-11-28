import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MAIN_MENU here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MAIN_MENU extends World
{
    private int currentAnimationFrame = 0;
    private static int maxAnimationFrames = 60;
    private int currentSelection = 1;
    private int selectionCooldown = 0;
    private int choiceCooldown = 0;
    /**
     * Constructor for objects of class MAIN_MENU.
     * 
     */
    public MAIN_MENU()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(16, 12, 80);
        prepare();
    }

    public void act() {
        if (currentAnimationFrame > maxAnimationFrames) {
            if (WorldController.isMessageShown()) {
                if (Greenfoot.isKeyDown("space")) {
                    choiceCooldown = 30;
                    WorldController.closeCurrentMessage();
                }
                return;
            }
            handleInput();
            handleChoice();
            return;
        }
        if (currentAnimationFrame < maxAnimationFrames) {
            animateStartup();
            currentAnimationFrame++;
            return;
        }
        if (currentAnimationFrame == maxAnimationFrames) {
            MusicPlayer.PlayMus("TITLE.wav");
            setBackground("menu/1.png");
            currentAnimationFrame++;
        }
    }
    
    public void handleInput() {
        if (selectionCooldown > 0) {
            selectionCooldown--; return;
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            currentSelection++;
            selectionCooldown = 30;
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            currentSelection--;
            selectionCooldown = 30;
        }
        if (currentSelection < 1) currentSelection = 3;
        if (currentSelection > 3) currentSelection = 1;
        
        switch (currentSelection) {
            case 1: setBackground("menu/2.png"); break;
            case 2: setBackground("menu/3.png"); break;
            case 3: setBackground("menu/4.png"); break;
        }
    }
    
    public void handleChoice() {
        if (choiceCooldown > 0) {
            choiceCooldown--;
            return;
        }
        if (!Greenfoot.isKeyDown("space") && !Greenfoot.isKeyDown("enter")) { return; }
        switch (currentSelection) {
            case 1:
                WorldController.reset();
                WorldController.changeRoomNoTransition("CUTSCENE_STORYINTRO");
                break;
            case 2:
                if (WorldController.doesSaveExist()) {
                    try
                    {
                        WorldController.load();
                    }
                    catch (java.io.IOException ioe)
                    {
                        WorldController.showMessage("FAILED TO LOAD.");
                    }
                } else {
                    WorldController.showMessage("NO SAVE FILE DETECTED.");
                }
                break;
            case 3:
                WorldController.showMessage("NO OPTIONS FOR FREEDOM.");
                break;
        }
    }
    
    public void prepare() {
        setBackground("BG_BLACK.png");
        MusicPlayer.StopMus();
        addObject(new CRT_OVERLAY(),8,7);
    }
    
    private void animateStartup() {
        if (currentAnimationFrame >= maxAnimationFrames) {
            setBackground("menu/1.png");
            return;
        }
        if (currentAnimationFrame > 10) {
            if (currentAnimationFrame % 4 == 0) {
                setBackground("menu/1.png");
                
            }
            if (currentAnimationFrame % 8 == 0) {
                setBackground("BG_BLACK.png");
            }
        }
    }
}
