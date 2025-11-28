import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Frames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Frames extends Actor
{
    /**
     * Act - do whatever the Frames wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
      private String imageName;

    // Constructor: accepts two parameters (first unused, second for image name)
    public Frames(String unused, String imageName) {
        this.imageName = imageName;
        setImage(imageName); // Set the image when the actor is created
    }

    // Method to change the image later
    public void changeImage(String newImageName) {
        setImage(newImageName);
    }

    // Example: change image on every act (uncomment if needed)
    public void act() {
        // changeImage("newImage.png");
    }
}
