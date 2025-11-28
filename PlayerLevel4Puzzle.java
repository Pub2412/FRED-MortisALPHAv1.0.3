import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerLevel4Puzzle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerLevel4Puzzle extends Actor
{
    int ammo = 0;
    private GreenfootImage ammoIcon = new GreenfootImage("ammo.png");
    private GreenfootImage shooterIcon = new GreenfootImage("shootguy.png");
    private int shootCooldown = 30;
    private GreenfootSound shootSnd = new GreenfootSound("sfx/shoot.wav");
    
    public PlayerLevel4Puzzle (int ammo) {
        this.ammo = ammo;
        updateImage();
    }
    public void act()
    {
        checkShoot();
        if (shootCooldown > 0) shootCooldown--;
    }
    private void checkShoot() {
        if (Greenfoot.isKeyDown("space") && shootCooldown <= 0 && ammo > 0) {
            shoot();
            shootCooldown = 15;
        }
    }
    private void shoot() {
        shootSnd.stop();
        shootSnd.play();
        ammo--;
        updateImage();
        
        World world = getWorld();
        if (world != null) {
            BulletLevel4Puzzle bullet = new BulletLevel4Puzzle();
            world.addObject(bullet, getX(), getY() - 3);
        }
    }
    private void updateImage() {
        int spacing = 4;
        int width = (ammoIcon.getWidth() + spacing) * ammo;
        int height = shooterIcon.getHeight();
        
        GreenfootImage img = new GreenfootImage(Math.max(width, shooterIcon.getWidth()), height * 2);
        img.drawImage(shooterIcon, Math.max(width, shooterIcon.getWidth()) / 2 - (shooterIcon.getWidth() / 2), 0);
        
        for (int i = 0; i < ammo; i++) {
            img.drawImage (ammoIcon, (i * (ammoIcon.getWidth() + spacing)), shooterIcon.getHeight());
        }
        
        setImage(img);
    }
}
