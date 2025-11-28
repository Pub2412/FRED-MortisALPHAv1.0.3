import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EpilepsyWarning here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EpilepsyWarning extends World
{

 private GreenfootImage warningImage;
    private int timer; // counts act cycles
    
    public EpilepsyWarning()
    {    
        super(16, 12, 80); // your world size
        warningImage = new GreenfootImage("epilepsy.png");
        setBackground(warningImage);
        timer = 0;
    }
    
    public void act()
    {
        timer++;
        // Assuming Greenfoot runs at 60 acts per second, 10 seconds = 600 act cycles
        if(timer >= 300) {
            Greenfoot.setWorld(new MAIN_MENU());
        }
    }
}

// Epilepsy warning
