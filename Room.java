import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Room here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Room extends World
{
    public String room_u = null;
    public String room_d = null;
    public String room_l = null;
    public String room_r = null;

    private boolean loaded = false;
    private String song_file = "AUDIO_DRONE";
    public Room()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(16, 12, 80); 
        prepare();
    }

    public void setSongFile(String filename) {
        song_file = filename;
    }

    public void setConnections(String up, String down, String left, String right) {
        this.room_u = up;
        this.room_d = down;
        this.room_l = left;
        this.room_r = right;
    }
    public void setConnectionUp(String conn) { this.room_u = conn; }
    public void setConnectionDown(String conn) { this.room_d = conn; }
    public void setConnectionLeft(String conn) { this.room_l = conn; }
    public void setConnectionRight(String conn) { this.room_r = conn; }

    public void act() {
        if (!loaded) {
            loaded = true;
            MusicPlayer.PlayMus(song_file + ".wav");
            WorldController.save();
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
    }
}
