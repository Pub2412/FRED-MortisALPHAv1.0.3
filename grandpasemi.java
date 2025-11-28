import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class grandpasemi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class grandpasemi extends SmoothMover
{
    private boolean isChasing = false;
    private int targetX, targetY;
    public void act()
    {
        if (targetY == getY()) {
            WorldController.changeRoomNoTransition("LEVEL4_BOSS");
        }
        if (!isChasing) return;
        setLocation(targetX, getY());
    }
    public void setTarget(int x, int y) {
        this.targetX = x;
        this.targetY = y;
    }
    public void startChase() { this.isChasing = true; }
}
