import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Portraits actor that can display a large popup image and message on interaction.
 */
public class Portraits extends Actor
{
    private String imageName;   // the normal image for the portrait
    private String popupImageName; // image to show when interacted
    private String message;        // message for popup

    // Constructor: accepts optional unused param, small image name, popup image name, and message
    public Portraits(String unused, String imageName, String popupImageName, String message) {
        this.imageName = imageName;
        this.popupImageName = popupImageName;
        this.message = message;
        setImage(imageName);
    }

    // Method to change the image later
    public void changeImage(String newImageName) {
        setImage(newImageName);
    }

    // Called when player interacts with this portrait
    public void interact() {
        World w = getWorld();
        if (w != null) {
            
            PortraitImagePopup imgPopup = new PortraitImagePopup(popupImageName, message);
            int popupX = w.getWidth() / 2;
            int popupY = w.getHeight() / 2;
            w.addObject(imgPopup, popupX, popupY);
        }
    }

    public void act() {

        if (isTouching(Player.class) && Greenfoot.isKeyDown("space")) {
            interact();
        }

    }
}
