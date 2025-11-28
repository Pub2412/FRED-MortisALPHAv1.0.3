import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE_GAME here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE_GAME extends World
{
    PlayerLevel4Puzzle player;
    TargetLevel4Puzzle target;
    /**
     * Constructor for objects of class LEVEL4_PUZZLE_GAME.
     * 
     */
    public LEVEL4_PUZZLE_GAME()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(32, 24, 40); 
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(new Solid("Interact/LEVEL4_PUZZLE_GUIDE.png"),8,22);
    }
}
