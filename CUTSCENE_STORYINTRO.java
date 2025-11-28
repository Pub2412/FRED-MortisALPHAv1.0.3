import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CUTSCENE_STORYINTRO here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CUTSCENE_STORYINTRO extends World
{
    int currentProgress = 0;
    int progressDelay = 0;
    int pressCooldown = 0;
    private GreenfootSound cutSnd = new GreenfootSound("cutscenes/int_1.wav");
    public CUTSCENE_STORYINTRO()
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
            case 0:
                setBackground("cutscene_STORYINTRO/hp.png");
                break;
            case 1:
                MusicPlayer.PlayMus("MOONLIGHT.wav");
                setBackground("cutscene_STORYINTRO/1.png");
                WorldController.showMessage("SEPTEMBER 4, 2006");
                cutSnd.play();
                break;
            case 2:
                cutSnd.stop();
                WorldController.showMessage("A MAN APPROACHED ME ON THIS HOLY DAY.");
                cutSnd = new GreenfootSound("cutscenes/int_2.wav");
                cutSnd.play();
                break;
            case 3:
                setBackground("BG_BLACK.png");
                cutSnd.stop();
                WorldController.showMessage("*KNOCK KNOCK*");
                cutSnd = new GreenfootSound("sfx/knock.wav");
                cutSnd.play();
                break;
            case 4:
                cutSnd.stop();
                WorldController.showMessage("COME IN.");
                cutSnd = new GreenfootSound("cutscenes/int_3.wav");
                cutSnd.play();
                cutSnd = new GreenfootSound("sfx/dooropenandclose.wav");
                cutSnd.play();
                break;
            case 5:
                setBackground("cutscene_STORYINTRO/2.png");
                cutSnd.stop();
                WorldController.showMessage("FATHER, THIS DEVICE I HAVE IS CURSED.");
                cutSnd = new GreenfootSound("cutscenes/int_4.wav");
                cutSnd.play();
                break;
            case 6:
                WorldController.showMessage("PRAY TELL? SHOW IT TO ME.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_5.wav");
                cutSnd.play();
                break;
            case 7:
                setBackground("cutscene_STORYINTRO/4.png");
                break;
            case 8:
                WorldController.showMessage("I SENSE A DEMON WITHIN.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_6.wav");
                cutSnd.play();
                break;
            case 9:
                WorldController.showMessage("IT NEEDS TO BE EXORCISED.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_7.wav");
                cutSnd.play();
                break;
            case 10:
                setBackground("cutscene_STORYINTRO/3.png");
                WorldController.showMessage("IN THE NAME OF THE FATHER...");
                cutSnd = new GreenfootSound("cutscenes/int_8.wav");
                cutSnd.play();
                break;
            case 11:
                WorldController.showMessage("...THE SON...");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_9.wav");
                cutSnd.play();
                break;
            case 12:
                setBackground("cutscene_STORYINTRO/4.png");
                cutSnd.stop();
                WorldController.showMessage("...AND THE HOLY SPIRIT...");
                cutSnd = new GreenfootSound("cutscenes/int_10.wav");
                cutSnd.play();
                break;
            case 13:
                setBackground("cutscene_STORYINTRO/5.png");
                cutSnd.stop();
                WorldController.showMessage("...AMEN...");
                cutSnd = new GreenfootSound("cutscenes/int_11.wav");
                cutSnd.play();
                break;
            case 14:
                MusicPlayer.StopMus();
                setBackground("cutscene_STORYINTRO/6.png");
                MusicPlayer.PlayMus("cutscenes/int_12.wav");
                break;
            case 15:
                WorldController.showMessage("...!");
                break;
            case 16:
                WorldController.showMessage("I RAISED MY CRUCIFIX AT IT.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_13.wav");
                cutSnd.play();
                break;
            case 17:
                WorldController.showMessage("BEGONE, DEMON!");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_14.wav");
                cutSnd.play();
                break;
            case 18:
            MusicPlayer.StopMus();
        setBackground("BG_BLACK.png");
        if (case18Timer == 0) {
            cutSnd = new GreenfootSound("sfx/laugh2.wav");
            cutSnd.play();
            case18Timer = 1; // start the timer
            return;
        }
        case18Timer++;
        if (case18Timer < 10 * 60) { // 10 seconds at 60 fps
            return;
        }
        case18Timer = 0; // reset for safety
        break;
            case 19:
                MusicPlayer.StopMus();
                MusicPlayer.PlayMus("church_lightning.wav");
                WorldController.showMessage("AFTER THAT, I WOKE UP IN THE DARK.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_15.wav");
                cutSnd.play();
                break;
            case 20:
                WorldController.showMessage("IT WAS COLD. VERY COLD.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_16.wav");
                cutSnd.play();
                break;
            case 21:
                WorldController.showMessage("BUT I COULD NOT MAKE OUT WHAT I WAS LOOKING AT.");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_17.wav");
                cutSnd.play();
                break;
            case 22:
                WorldController.showMessage("IN A VERY SMALL ROOM...");
                cutSnd.stop();
                cutSnd = new GreenfootSound("cutscenes/int_18.wav");
                cutSnd.play();
                break;
            case 23:
                cutSnd.stop();
                MusicPlayer.StopMus();
                WorldController.changeRoomNoTransition("LEVEL1");
                break;
        }
        currentProgress++;
        progressDelay = 120;
        pressCooldown = 30;
        
    }
}
