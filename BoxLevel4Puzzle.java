import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BoxLevel4Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoxLevel4Puzzle extends Solid
{
    private int moveCooldown = 0;
    private int stepCooldown = 0;
    private int stepsTaken = 0;
    private int dx = 0;
    private int dy = 0;
    private int attempts = 0;
    BoxLevel4Puzzle() {
        super("box.png");
    }
    public void act()
    {
        if (moveCooldown > 0) moveCooldown--;
        if (stepCooldown > 0) stepCooldown--;
        if (moveCooldown <= 0) {
            dx = 0;
            dy = 0;
            stepsTaken = 0;
            attempts = 0;
        }
        handleInput();
    }
    private void handleInput() {
        if (stepCooldown <= 0 && moveCooldown <= 0) {
            if (Greenfoot.isKeyDown("w")) {dy = -1; dx = 0;}
            else if (Greenfoot.isKeyDown("s")) {dy = 1; dx = 0;}
            else if (Greenfoot.isKeyDown("a")) {dx = -1; dy = 0;}
            else if (Greenfoot.isKeyDown("d")) {dx = 1; dy = 0;}
            if (dx != 0 || dy != 0) {
                moveCooldown = 30;
            }
        }
        if ((dx != 0 || dy != 0) && stepCooldown <= 0 && stepsTaken < 2) {
            tryMove();
            stepCooldown = 10;
        }
    }
    private void tryMove() {
        int newX = getX() + dx;
        int newY = getY() + dy;
        
        attempts++;
        if (canMoveTo(newX, newY)) {
            setLocation(newX, newY);
            stepsTaken++;
        }
    }
    private boolean willCollide() {
        Actor temp = getOneObjectAtOffset(dx, dy, Solid.class);
        if (temp != null && temp != this) return true;
        return false;
    }
    private boolean canMoveTo(int newX, int newY) {
        int oldX = getX();
        int oldY = getY();
        setLocation(newX, newY);
    
        boolean collision = isTouching(Solid.class);
    
        // Move player back
        setLocation(oldX, oldY);
    
        return !collision;
    }
    public void kill() {
        World world = getWorld();
        world.removeObject(this);
    }
}
