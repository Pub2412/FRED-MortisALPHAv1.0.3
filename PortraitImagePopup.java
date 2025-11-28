import greenfoot.*;

public class PortraitImagePopup extends Actor {
    private boolean readyToClose = false;

    public PortraitImagePopup(String imageName, String message) {
        GreenfootImage img = new GreenfootImage(imageName);

        int width = 400;
        int height = 350;
        GreenfootImage popup = new GreenfootImage(width, height);

        // Background
        popup.setColor(new greenfoot.Color(0, 0, 0, 200));
        popup.fill();

        // Portrait image
        GreenfootImage imgCopy = new GreenfootImage(img);
        imgCopy.scale(320, 270);
        popup.drawImage(imgCopy, 40, 20);

        // Message at bottom
        popup.setColor(greenfoot.Color.WHITE);
        popup.setFont(new Font("Arial", true, false, 24));
        popup.drawString(message, 40, height - 40);

        setImage(popup);
    }

    @Override
    public void act() {
        // Close on space (after key release)
        if (Greenfoot.isKeyDown("space")) {
            if (readyToClose) {
                getWorld().removeObject(this);
            }
        } else {
            readyToClose = true;
        }
    }
}
