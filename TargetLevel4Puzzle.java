import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TargetLevel4Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TargetLevel4Puzzle extends Actor
{
    private String targetRoom = "";
    private String puzzleName = "";
    private boolean killed = false;
    private int killWaitTime = 30;
    private GreenfootSound killSnd = new GreenfootSound("sfx/ominous.wav");
    private GreenfootSound killSnd2 = new GreenfootSound("sfx/spawn_hurt.wav");
    public TargetLevel4Puzzle(String target, String puzzleName) {
        this.targetRoom = target;
        this.puzzleName = puzzleName;
    }
    public void act()
    {
        if (this.killed) {
            if (this.killWaitTime <= 0) {
                WorldController.changeRoomNoTransition(targetRoom);
            } else {
                this.killWaitTime--;
            }
        }
        if (Greenfoot.isKeyDown("Q")) {
            WorldController.changeRoomNoTransition(targetRoom);
        }
    }
    public void kill() {
        this.killed = true;
        killSnd.play();
        killSnd2.play();
        setImage(new GreenfootImage("targetguy_1.png"));
        if (puzzleName != "" && puzzleName != null) {
            WorldController.solvePuzzle(puzzleName);
        }
    }
}
