import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_FINALE here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_FINALE extends Room
{
    grandpasemi grandpasemi = new grandpasemi();
    Player player = new Player();
    private boolean super_loaded = false;
    /**
     * Constructor for objects of class LEVEL4_FINALE.
     * 
     */
    public LEVEL4_FINALE()
    {
        setConnectionDown("LEVEL4");
        setConnectionRight("LEVEL4_HALL_RIGHT");
        prepare();
        setBackground("room/CHURCH/FINALE.png");
    }
    public void act() {
        if (!super_loaded) {
            super_loaded = true;
            MusicPlayer.PlayMus("knight_appears.wav");
            WorldController.save();
        }
        grandpasemi.setTarget(player.getX(), player.getY());
        if (player.getY() < 8) {
            grandpasemi.startChase();
        }
    }
    private void prepare()
    {
        addObject(new Solid("room/CHURCH/COLL_FINAL.png"),2,6);
        addObject(new Solid("room/CHURCH/COLL_FINAL.png"),14,6);
        addObject(grandpasemi,8,3);
        addObject(player,8,9);
        addObject(new CRT_OVERLAY(),8,7);
    }
}
