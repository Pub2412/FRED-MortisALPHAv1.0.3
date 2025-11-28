import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MessageBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MessageBox extends Actor
{
    private GreenfootImage boxImage;
    private String text;
    private int delay = 0;
    public MessageBox(String text) {
        this.text = text;
        this.delay = 60;
        drawBox();
    }
    
    private void drawBox() {
        boxImage = new GreenfootImage(1920, 120);
        boxImage.setColor(new Color(0, 0, 0, 255)); // transparent black
        boxImage.fillRect(0, 0, 1920, 120);

        boxImage.setColor(Color.WHITE);
        boxImage.setFont(new Font("Serif", 32));
        boxImage.drawString(text, 640, 30);

        setImage(boxImage);
    }
    
    public void act() {
        this.delay -= 1;
    }
    
    public boolean canClose() {
        return this.delay <= 0;
    }
}
