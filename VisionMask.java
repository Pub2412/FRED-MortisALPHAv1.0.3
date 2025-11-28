import greenfoot.*;
import java.awt.Graphics2D;
import java.awt.AlphaComposite;
import java.awt.image.BufferedImage;

public class VisionMask extends Actor {

    private Player player;
    private int radius;
    private GreenfootImage mask;

    private final int CELL_SIZE = 80;   // Your world uses 80px tiles

    public VisionMask(Player player, int radius) {
        this.player = player;
        this.radius = radius;

        // Placeholder image – real size set in addedToWorld()
        mask = new GreenfootImage(1, 1);
        setImage(mask);
    }

    @Override
    protected void addedToWorld(World world) {
        // Resize mask to full window size in pixels
        int w = world.getWidth() * CELL_SIZE;
        int h = world.getHeight() * CELL_SIZE;

        mask = new GreenfootImage(w, h);
        setImage(mask);
    }

    @Override
    public void act() {
        updateMask();
    }

    private void updateMask() {

        // Fill screen with darkness
        mask.clear();
        mask.setColor(new Color(0, 0, 0, 255)); // Greenfoot.Color RGBA
        mask.fill();

        // Use AWT to cut a transparent circle in the dark overlay
        BufferedImage awtImage = (BufferedImage) mask.getAwtImage();
        Graphics2D g2 = awtImage.createGraphics();

        try {
            g2.setComposite(AlphaComposite.Clear);

            int px = player.getX() * CELL_SIZE;
            int py = player.getY() * CELL_SIZE;

            g2.fillOval(px - radius, py - radius, radius * 2, radius * 2);

        } finally {
            g2.dispose();
        }

        setImage(mask);
    }
}
