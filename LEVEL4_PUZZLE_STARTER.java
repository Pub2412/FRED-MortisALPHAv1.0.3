import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE_STARTER here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE_STARTER extends Interactable
{
    private String puzzleRoom = "";
    private String puzzleName = "";
    LEVEL4_PUZZLE_STARTER(String puzzleRoom, String puzzleName) {
        this.puzzleRoom = puzzleRoom;
        this.puzzleName = puzzleName;
        
        if (WorldController.isPuzzleSolved(puzzleName)) {
            setImage("interact/LEVEL4_PUZZLE_DONE.png");
        } else {
            setImage("interact/LEVEL4_PUZZLE.png");
        }
    }
    public void interact() {
        if (WorldController.isPuzzleSolved(puzzleName)) {
            WorldController.showMessage("SOUL ALREADY FREED.");

        } else {
            WorldController.changeRoomNoTransition(this.puzzleRoom);
        }
    }
}
