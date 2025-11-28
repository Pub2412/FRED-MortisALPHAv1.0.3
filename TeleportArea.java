import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeleportArea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TeleportArea extends Actor {
    private String targetWorld;
    private int targetX, targetY;

    public TeleportArea(String targetWorld, int targetX, int targetY) {
        this.targetWorld = targetWorld;
        this.targetX = targetX;
        this.targetY = targetY;
                 setImage(new GreenfootImage(200, 200));
    }

    public void act() {
        Player player = (Player) getOneIntersectingObject(Player.class);
        if (player != null) {
            teleportPlayer(player);
        }
    }

    private void teleportPlayer(Player player) {
    World nextWorld;
    try {
        nextWorld = (World)Class.forName(targetWorld).newInstance();
    } catch (Exception e) {
        e.printStackTrace();
        return;
    }
    
    // Remove the old player from the current world
    World currentWorld = getWorld();
    if (currentWorld != null) {
        currentWorld.removeObject(player);
    }
    
    // Switch to the new world
    Greenfoot.setWorld(nextWorld);
    
}

}

