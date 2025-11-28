import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BulletLevel4Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BulletLevel4Puzzle extends Actor
{
    int moveCooldown = 0;
    public void act()
    {
        if (moveCooldown <= 0) {
            setLocation(getX(), getY() - 1);
            moveCooldown = 3;
        } else {
            moveCooldown--;
        }
        boolean touchingSolid = isTouching(Solid.class);
        if (touchingSolid) {
            BoxLevel4Puzzle box = (BoxLevel4Puzzle) getOneIntersectingObject(BoxLevel4Puzzle.class);
            if (box != null) {
                box.kill();
            }
        }
        boolean touchingTarget = isTouching(TargetLevel4Puzzle.class);
        if (touchingTarget) {
            TargetLevel4Puzzle target = (TargetLevel4Puzzle) getOneIntersectingObject(TargetLevel4Puzzle.class);
            if (target != null) {
                target.kill();
            }
        }
        if (getY() <= 0 || touchingTarget || touchingSolid) {
            World world = getWorld();
            world.removeObject(this);
        }
    }
}
