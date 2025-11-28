import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CUTSCENE_SHOTGUN_ENDING here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CUTSCENE_SHOTGUN_ENDING extends World
{
    int currentProgress = 0;
    int progressDelay = 0;
    int pressCooldown = 0;
    private GreenfootSound cutSnd = new GreenfootSound("cutscenes/int_1.wav");
    public CUTSCENE_SHOTGUN_ENDING()
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
                setBackground("shotgun/s1.png");
                WorldController.showMessage("Adios Demonios");
                cutSnd = new GreenfootSound("american/int_1.wav");
                cutSnd.play();
                break;
            case 2:
                cutSnd.stop();
                setBackground("BG_BLACK.png");
                cutSnd = new GreenfootSound("sfx/shoot.wav");
                cutSnd.play();
                break;
            case 3:
                cutSnd.stop();
                cutSnd = new GreenfootSound("sfx/shoot.wav");
                cutSnd.play();
                break;
            case 4:
                cutSnd.stop();
                MusicPlayer.PlayMus("american/america_intro.wav");
                setBackground("shotgun/s2.png");
                break;
            case 5:
                WorldController.showMessage("God may forgive you, but I wont");
                cutSnd = new GreenfootSound("american/int_2.wav");
                cutSnd.play();
                break;
            case 6:
                cutSnd.stop();
                WorldController.showMessage("Don't Be Afraid to face Him");
                cutSnd = new GreenfootSound("american/int_3.wav");
                cutSnd.play();
                break;
            case 7:
                cutSnd.stop();
                MusicPlayer.StopMus();
                WorldController.changeRoomNoTransition("CREDITS_SHOTGUN");
                break;
        }
        currentProgress++;
        progressDelay = 120;
        pressCooldown = 30;
        
    }
}
