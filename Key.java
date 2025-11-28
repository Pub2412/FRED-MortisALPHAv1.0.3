import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Key here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Key extends Interactable {
     private GreenfootSound keySound;

    public Key() {
        setImage("interact/key.png"); // Use your key sprite
        keySound = new GreenfootSound("sfx/check.wav"); // Your sound file here
    }

    @Override
    public void interact() {
    LEVEL1_FredDoor player = (LEVEL1_FredDoor) getOneObjectAtOffset(0, 0, Player.class);
    if (player == null) {
        WorldController.changeRoomNoTransition("LEVEL1_s3");
        return;
    }
    player.setHasKey(true);
    
 
}
}
