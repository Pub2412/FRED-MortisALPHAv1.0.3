import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CUTSCENE_FAITH_ENDING here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CUTSCENE_FAITH_ENDING extends World
{
    int currentProgress = 0;
    int progressDelay = 0;
    int pressCooldown = 0;
    private GreenfootSound cutSnd = new GreenfootSound("cutscenes/int_1.wav");
    public CUTSCENE_FAITH_ENDING()
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
                WorldController.showMessage("*HOLY WATER BREAKS*");
                cutSnd = new GreenfootSound("sfx/shatter.wav");
                cutSnd.play();
                break;
            case 2:
                cutSnd.stop();
                WorldController.showMessage("This Ends now!");
                cutSnd = new GreenfootSound("faith/int_1.wav");
                cutSnd.play();
                break;
            case 3:
                cutSnd.stop();
                cutSnd = new GreenfootSound("crepintro.wav");
                cutSnd.play();
                break;
            case 4:
                cutSnd.stop();
                WorldController.showMessage("HAHA You Fool, I shall take you, Father");
                setBackground("faith/demon1.png");
                cutSnd = new GreenfootSound("faith/int_2.wav");
                cutSnd.play();
                break;
            case 5:
                cutSnd.stop();
                setBackground("faith/possesion.png");
                cutSnd = new GreenfootSound("faith/int_3.wav");
                cutSnd.play();
                break;
            case 6:
                cutSnd.stop();
                setBackground("faith/fight.png");
                WorldController.showMessage("I will say of the Lord: He is my refuge and my fortress");
                cutSnd = new GreenfootSound("faith/int_4.wav");
                cutSnd.play();
                break;
            case 7:
                cutSnd.stop();
                WorldController.showMessage("My God, in Him i will trust");
                cutSnd = new GreenfootSound("faith/int_5.wav");
                cutSnd.play();
                break;
            case 8:
                cutSnd.stop();
                setBackground("faith/demon1.png");
                WorldController.showMessage("NO? THATS IMPOSSIBLE!");
                cutSnd = new GreenfootSound("faith/int_6.wav");
                cutSnd.play();
                break;
            case 9:
                cutSnd.stop();
                setBackground("faith/lacpray.png");
                WorldController.showMessage("I shall not be afraid of the terror in the night");
                cutSnd = new GreenfootSound("faith/int_7.wav");
                cutSnd.play();
                break;
            case 10:
                cutSnd.stop();
                WorldController.showMessage("Nor the evil that walketh in darkness because I have made!");
                cutSnd = new GreenfootSound("faith/int_8.wav");
                cutSnd.play();
                break;
            case 11:
                cutSnd.stop();
                WorldController.showMessage("the Lord my refuge, always!");
                cutSnd = new GreenfootSound("faith/int_9.wav");
                cutSnd.play();
                break;
            case 12:
                cutSnd.stop();
                setBackground("faith/demon1.png");
                WorldController.showMessage("NO!!!");
                cutSnd = new GreenfootSound("faith/int_10.wav");
                cutSnd.play();
                break;
            case 13:
                cutSnd.stop();
                setBackground("BG_BLACK.png");
                WorldController.showMessage("*FR. LACUESTA JUMPS TO THE WINDOW*");
                cutSnd = new GreenfootSound("faith/int_11.wav");
                cutSnd.play();
                break;
            case 14:
                cutSnd.stop();
                setBackground("faith/savior.png");
                break;
            case 15:
                cutSnd.stop();
                WorldController.showMessage("Reports found the man died while jumping through a window");
                cutSnd = new GreenfootSound("faith/int_12.wav");
                cutSnd.play();
                break;
            case 16:
                cutSnd.stop();
                WorldController.showMessage("The name of the man is Rev. Fr. Lacuesta, causes unknown. ");
                cutSnd = new GreenfootSound("faith/int_13.wav");
                cutSnd.play();
                break;
            case 17:
                break;
            case 18:
                cutSnd.stop();
                setBackground("faith/daisywindow.png");
                break;
            case 19:
                cutSnd.stop();
                MusicPlayer.StopMus();
                WorldController.changeRoomNoTransition("CREDITS_FAITH");
                break;
        }
        currentProgress++;
        progressDelay = 120;
        pressCooldown = 30;
        
    }
}
