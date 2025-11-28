import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CUTSCENE_DOCTOR_ENDING here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CUTSCENE_DOCTOR_ENDING extends World
{
    int currentProgress = 0;
    int progressDelay = 0;
    int pressCooldown = 0;
    private GreenfootSound cutSnd = new GreenfootSound("cutscenes/int_1.wav");
    public CUTSCENE_DOCTOR_ENDING()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(16, 12, 80); 
        MusicPlayer.StopMus();
        prepare();
    }
    public void prepare() { addObject(new CRT_OVERLAY(),8,7); }
    public void act() {
        handleInput();
        if (pressCooldown > 0) pressCooldown--;
        if (progressDelay > 0) progressDelay--;
        handleCutscene();
        
        GreenfootImage screen = getBackground();
        screen.drawImage(
        new GreenfootImage("Press Space to Continue", 20, Color.WHITE, new Color(0,0,0,0)), 
            100, 20);
        
    }
    private void handleInput() {
        if (progressDelay > 0) return;
        if (WorldController.isMessageShown()) {
            if (Greenfoot.isKeyDown("space")) {
                WorldController.closeCurrentMessage();
            }
        }
    }
     private int case18Timer = 0;
    private void handleCutscene() {
        if (WorldController.isMessageShown()) return;
        if (progressDelay > 0) return;

        switch (currentProgress) {
            case 1:
                MusicPlayer.StopMus();
                setBackground("BG_BLACK.png");
                WorldController.showMessage("*HOLY WATER THROWN TO DAISY*");
                cutSnd = new GreenfootSound("sfx/shatter.wav");
                cutSnd.play();
                break;
            case 2:
                cutSnd.stop();
                setBackground("faith/demon1.png");
                WorldController.showMessage("Are you ready to give yourself?");
                cutSnd = new GreenfootSound("doc/int_1.wav");
                cutSnd.play();
                break;
            case 3:
                setBackground("doc/1.png");
                WorldController.showMessage("Yes, my lord");
                cutSnd = new GreenfootSound("doc/int_2.wav");
                cutSnd.play();
                break;
            case 4:
                cutSnd.stop();
                setBackground("faith/demon1.png");
                WorldController.showMessage("Good");
                cutSnd = new GreenfootSound("doc/int_3.wav");
                cutSnd.play();
                break;
            case 5:
                cutSnd.stop();
                setBackground("doc/2.png");
                cutSnd = new GreenfootSound("faith/int_3.wav");
                cutSnd.play();
                break;
            case 6:
                cutSnd.stop();
                MusicPlayer.StopMus();
                WorldController.changeRoomNoTransition("CREDITS_DOC");
                break;
        }
        currentProgress++;
        progressDelay = 120;
        pressCooldown = 30;
        
    }
}
