import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  
public class Sign extends Interactable
{
private String message;
    private GreenfootSound interactionSound;

    public Sign(String message) {
        this.message = message;
        interactionSound = new GreenfootSound("sfx/check.wav");  // place your sound file here
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void interact() {
        if (interactionSound != null) {
            interactionSound.play();
        }
        WorldController.showMessage(this.message);
    }
}
