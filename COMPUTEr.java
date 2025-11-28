import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class COMPUTEr here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class COMPUTEr extends Sign
{
    private String puzzleID;
    public COMPUTEr(String message, String puzzleID) {
        super(message);
        this.puzzleID = puzzleID;
        setImage("interact/COMPUTEr.png");
    }
    public void interact() {
        if (WorldController.isPuzzleSolved(this.puzzleID)) {
            setMessage("TERMINAL ALREADY OPENED.");
        } else {
            WorldController.solvePuzzle(puzzleID);
        }
        WorldController.showMessage(getMessage());
    }
}
