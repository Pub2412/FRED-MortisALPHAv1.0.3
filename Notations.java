import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Notations here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notations extends Sign
{
   private String puzzleID;
    private GreenfootSound collectSound;

    // Constructor accepts message, puzzleID, and image filename
    public Notations(String message, String puzzleID, String imageName) {
        super(message);
        this.puzzleID = puzzleID;
        setImage(imageName);
        collectSound = new GreenfootSound("sfx/check.wav"); // Sound file in your project
    }

    public void interact() {
        if (WorldController.isPuzzleSolved(this.puzzleID)) {
        } else {
            WorldController.solvePuzzle(puzzleID);
            collectSound.play();
        }
        WorldController.showMessage(getMessage());
        getWorld().removeObject(this);

    }
    

    }
