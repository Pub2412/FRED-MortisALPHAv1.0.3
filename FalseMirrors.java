import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mirrors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FalseMirrors extends Sign
{
    private String puzzleID;
    private GreenfootSound collectSound;

    // Constructor accepts message, puzzleID, and image filename
    public FalseMirrors(String message, String puzzleID, String imageName) {
        super(message);
        this.puzzleID = puzzleID;
        setImage(imageName);
        collectSound = new GreenfootSound("sfx/check.wav"); // Sound file in your project
    }

    public void interact() {
        if (WorldController.isPuzzleSolved(this.puzzleID)) {
        } else {
            WorldController.solvePuzzle(puzzleID);
        }
        WorldController.showMessage(getMessage());

    }
    

    }
    
