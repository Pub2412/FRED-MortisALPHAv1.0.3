import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CUTSCENE_DEMON_BANISHED here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CUTSCENE_DEMON_BANISHED extends World
{
    int currentProgress = 0;
    int progressDelay = 0;
    int pressCooldown = 0;
    private GreenfootSound cutSnd = new GreenfootSound("demon_banished/int_1.wav");
    public CUTSCENE_DEMON_BANISHED()
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
        
        GreenfootImage screen = getBackground();
        screen.drawImage(
        new GreenfootImage("Press Space to Continue", 20, Color.WHITE, new Color(0,0,0,0)), 
            100, 20);
            
        handleCutscene();
        
    }
    private void handleInput() {
        if (progressDelay > 0) return;
        if (WorldController.isMessageShown()) {
            if (Greenfoot.isKeyDown("space")) {
                WorldController.closeCurrentMessage();
            }
        }
    }
    private void handleCutscene() {
        if (WorldController.isMessageShown()) return;
        if (progressDelay > 0) return;

        switch (currentProgress) {
            case 0:
                MusicPlayer.PlayMus("MOONLIGHT.wav");
                setBackground("BG_BLACK.png");
                break;
            case 1:
                WorldController.showMessage("THE DEMON WAS BANISHED.");
                cutSnd.play();
                break;
            case 2:
                cutSnd.stop();
                WorldController.showMessage("ITS SCREAMS RATTLED THE ROOM.");
                cutSnd = new GreenfootSound("demon_banished/int_2.wav");
                cutSnd.play();
                break;
            case 3:
                cutSnd.stop();
                setBackground("BG_WHITE.png");
                WorldController.showMessage("A HOLY BEAM BURST THROUGH THE DEMON'S BODY.");
                cutSnd = new GreenfootSound("demon_banished/int_3.wav");
                cutSnd.play();
                break;
            case 4:
                cutSnd.stop();
                setBackground("cutscene_STORYINTRO/4.png");
                WorldController.showMessage("THE MAN TOLD ME THAT...");
                cutSnd = new GreenfootSound("demon_banished/int_4.wav");
                cutSnd.play();
                break;
            case 5:
                cutSnd.stop();
                setBackground("cutscene_STORYINTRO/6.png");
                WorldController.showMessage("A BLINDING LIGHT BURST FROM THE ELECTRONIC.");
                cutSnd = new GreenfootSound("demon_banished/int_5.wav");
                cutSnd.play();
                break;
            case 6:
                cutSnd.stop();
                setBackground("BG_BLACK.png");
                WorldController.showMessage("HE SAW IT ALL HAPPEN.");
                cutSnd = new GreenfootSound("demon_banished/int_6.wav");
                cutSnd.play();
                break;
            case 7:
                cutSnd.stop();
                setBackground("cutscene_STORYINTRO/4.png");
                break;
            case 8:
                WorldController.showMessage("TO HIM, I WAS JUST AN IMAGE PRINTED ON HIS COMPUTER.");
                cutSnd = new GreenfootSound("demon_banished/int_7.wav");
                cutSnd.play();
                break;
            case 9:
                cutSnd.stop();
                WorldController.showMessage("BUT NOW THAT THE DEMON WAS EXORCISED...");
                cutSnd = new GreenfootSound("demon_banished/int_8.wav");
                cutSnd.play();
                break;
            case 10:
                cutSnd.stop();
                WorldController.showMessage("...HE GAVE HIS THANKS AND AN OFFERING.");
                cutSnd = new GreenfootSound("demon_banished/int_9.wav");
                cutSnd.play();
                break;
            case 11:
                cutSnd.stop();
                setBackground("BG_BLACK.png");
                WorldController.showMessage("BY THE TIME I HAD FINISHED, IT WAS ALREADY DUSK.");
                cutSnd = new GreenfootSound("demon_banished/int_10.wav");
                cutSnd.play();
                break;
            case 12:
                cutSnd.stop();
                WorldController.showMessage("AND SO I RETIRED ON MY HOME.");
                cutSnd = new GreenfootSound("demon_banished/int_11.wav");
                cutSnd.play();
                break;
            case 13:
                cutSnd.stop();
                setBackground("cutscene_STORYINTRO/4.png");
                WorldController.showMessage("WHAT EVER MAY THAT DEMON BE...");
                cutSnd = new GreenfootSound("demon_banished/int_12.wav");
                cutSnd.play();
                break;
            case 14:
                cutSnd.stop();
                break;
            case 15:
                cutSnd.stop();
                setBackground("cutscene_STORYINTRO/5.png");
                WorldController.showMessage("I HOPE I DO NOT EVER HAVE TO ENCOUNTER IT AGAIN.");
                cutSnd = new GreenfootSound("demon_banished/int_13.wav");
                cutSnd.play();
                break;
            case 16:
                cutSnd.stop();
                break;
            case 17:
                WorldController.showMessage("THIS CONCLUDES MY JOURNAL ENTRY.");
                cutSnd = new GreenfootSound("demon_banished/int_14.wav");
                cutSnd.play();
                break;
            case 18:
                cutSnd.stop();
                break;
            case 19:
                MusicPlayer.StopMus();
                setBackground("scarefred.png");
                cutSnd = new GreenfootSound("sfx/sare.wav");
                cutSnd.play();
                break;
            case 20:
                cutSnd.stop();
                WorldController.changeRoomNoTransition("LEVEL5_START");
                break;
        }
        currentProgress++;
        progressDelay = 120;
        pressCooldown = 30;
    }
}
