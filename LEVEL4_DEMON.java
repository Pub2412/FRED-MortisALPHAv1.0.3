import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_DEMON here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_DEMON extends Interactable
{
    private int HITS = 5;
    private boolean canHit = false;
    private int startupAnimationFrames = 120;
    private int blinkFrames = 0;
    private boolean blinkState = false;
    
    private int phase = 0;
    private int targetX, targetY;
    private String direction = "d";
    
    private int moveCooldown = 0;
    private boolean attackShown = false;
    
    private GreenfootSound curSnd = new GreenfootSound("sfx/audio_glitch.wav");
    
    public LEVEL4_DEMON () {
        setImage("grandpasemi.png");
    }
    
    public void kill() {
        curSnd.stop();
        curSnd = new GreenfootSound("sfx/roar.wav");
        curSnd.play();
        WorldController.changeRoomNoTransition("CUTSCENE_DEMON_BANISHED");
    }
    
    public void act()
    {
        if (startupAnimationFrames > 0) {
            animateStartup();
            return;
        }
        
        this.moveCooldown++;
        
        switch (phase) {
            case 1: followTarget(); break;
            case 2: attack(); break;
        }
    }

    private void followTarget() {
        int dx = targetX, dy = targetY;
        switch (direction) {
            case "u": dy--; break;
            case "d": dy++; break;
            case "l": dx--; break;
            case "r": dx++; break;
        }
        setLocation(dx, dy);
        if (blinkFrames % 8 == 0) {
            if (blinkState) { setImage("grandpasemi.png");  } else { setImage("demon.png");}
            blinkState = !blinkState;
        }
        blinkFrames++;
    }
    private void attack() {
        setImage("demon.png");
        int dx = 0, dy = 0;
        switch (direction) {
            case "u": dy = -1; break;
            case "d": dy = 1; break;
            case "l": dx = -1; break;
            case "r": dx = 1; break;
        }
        // moves every 4 frames after 15 frames have passed
        if (this.moveCooldown % 4 == 0 && ((attackShown && this.moveCooldown > 15) || (!attackShown && this.moveCooldown > 60))) {
            setLocation(getX() + dx, getY() + dy);
            attackShown = true;
        }
        if (isTouching(Player.class)) {
            MusicPlayer.StopMus();
            WorldController.changeRoomNoTransition("DEMON_JUMPSCARE");
        }
    }
    
    public void interact() {
        if (!canHit || phase != 1) return;
        hurt();
    }
    
    public void hurt() {
        this.canHit = false;
        HITS--;
        if (HITS <= 0) {
            kill();
            return;
        }
        curSnd.stop();
        curSnd = new GreenfootSound("sfx/demon_hurt.wav");
        curSnd.play();
        setPhase(3);
        setImage("demon_hurt.png");
    }
    
    public void setPhase(int phase) {
        this.phase = phase;
        blinkFrames = 0;
        this.moveCooldown = 0;
        if (phase == 1) {
            this.canHit = true;
            int dir = Greenfoot.getRandomNumber(4);
            switch (dir) {
                case 0: this.direction = "u"; break;
                case 1: this.direction = "d"; break; // TODO: fix bug with downwards interaction so this can be replaced with "d" again
                case 2: this.direction = "l"; break;
                case 3: this.direction = "r"; break;
            }
        } else if (phase == 2) {
            curSnd.stop();
            curSnd = new GreenfootSound("sfx/laugh_fast.wav");
            curSnd.play();
        }
    }
    public int getPhase() {return this.phase;}
    public void setTarget(int x, int y) {
        if (phase == 1) {
            this.targetX = x;
            this.targetY = y;
        }
    }
    public int getBossTimer() { return this.moveCooldown; }
    public void setDirection(String dir) {
        this.direction = dir;
    }
    public String getDirection() { return this.direction; }
    public boolean isOOB() {
        return getY() <= 0 || getY() >= 11 || getX() <= 0 || getX() >= 15;
    }
    
    public void animateStartup() {
        if (startupAnimationFrames == 60) {
            curSnd.play();
        }
        
        if (startupAnimationFrames < 60) {
            if (startupAnimationFrames % 4 == 0) setImage("false_demon.png");
            if ((startupAnimationFrames % 8 == 0)) setImage("grandpasemi.png");
            if (startupAnimationFrames <= 1) setImage("demon.png");
        }
        
        if (startupAnimationFrames > 0) startupAnimationFrames--;
        
        if (startupAnimationFrames <= 0) {
            // do things to make the fight start
            this.canHit = true;
            setPhase(1);
            curSnd.stop();
        }
    }
}
