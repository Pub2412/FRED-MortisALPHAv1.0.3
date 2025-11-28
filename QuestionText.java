import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class QuestionText here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuestionText extends Actor {
    public QuestionText(String text) {
        GreenfootImage img = new GreenfootImage(300, 40);
        img.setColor(Color.WHITE);
        img.fill();
        img.setColor(Color.BLACK);
        img.drawString(text, 10, 25);
        setImage(img);
    }
}
