import greenfoot.*;

public class MirrorPopupImage extends Actor {
    private boolean readyToClose = false;

    // Add this constructor!
    public MirrorPopupImage(String filename) {
        GreenfootImage img = new GreenfootImage(filename);
        int maxW = 320, maxH = 250;
        if (img.getWidth() > maxW || img.getHeight() > maxH) {
            img.scale(maxW, maxH);
        }
        setImage(img);
    }

    @Override
    public void act() {
        // When player presses space, remove this popup image
        if (Greenfoot.isKeyDown("space")) {
            if (readyToClose) {
                getWorld().removeObject(this);
            }
        } else {
            readyToClose = true;
        }
    }
}

