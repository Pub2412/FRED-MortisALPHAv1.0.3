import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChoiceButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChoiceButton extends Actor {
    private String optionText;
    private Runnable action; // Code to run on click

    public ChoiceButton(String text, Runnable action) {
        this.optionText = text;
        this.action = action;
        GreenfootImage img = new GreenfootImage(150, 30);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawString(optionText, 10, 20);
        setImage(img);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            action.run();
        }
    }
}

