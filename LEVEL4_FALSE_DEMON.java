import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_FALSE_DEMON here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_FALSE_DEMON extends Interactable
{
    private int blinkFrames = 0;
    private boolean blinkState = false;
    private int targetX, targetY;
    private String direction = "d";
    
    private int moveCooldown = 0;
    
    public LEVEL4_FALSE_DEMON () {
        setImage("grandpasemi.png");
    }
    public void act()
    {
        this.moveCooldown++;
        followTarget();
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
        if (blinkFrames % 16 == 0) {
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
        if (this.moveCooldown % 4 == 0 && this.moveCooldown > 15) {
            setLocation(getX() + dx, getY() + dy);
        }
        if (isTouching(Player.class)) {
            WorldController.changeRoomNoTransition("DEMON_JUMPSCARE");
        }
    }
    
    public void interact() {
        return;
    }
    public void setTarget(int x, int y) {
        this.targetX = x;
        this.targetY = y;
    }
    public int getBossTimer() { return this.moveCooldown; }
    public void setDirection(String dir) {
        this.direction = dir;
    }
    public String getDirection() { return this.direction; }
    public boolean isOOB() {
        return getY() <= 0 || getY() >= 11 || getX() <= 0 || getX() >= 15;
    }
}
