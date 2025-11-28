import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LEVEL 1
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class LEVEL1 extends Room
{
    private GreenfootImage boxImage;
    public LEVEL1()
    {
        super();
        setSongFile("silence");
        setConnections("LEVEL1_s1", "LEVEL1_s1", "LEVEL1_s1", "LEVEL1_s1");
        prepare();
    }
    
    protected void prepare()   
    {
        int width = 16;  
        int height = 9;  

        // Bottom edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_d.png"), x, height - 1);
        }

        // Top edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_u.png"), x, 1);
            addObject(new Solid("room/edge_u.png"), x, 9);
        }
        addObject(new Solid("room/corner_lu.png"), 1, 2);
        addObject(new Solid("room/corner_ru.png"), width - 2, 2);

        // right walls
        for (int y = 3; y < height - 4; y++) {
            addObject(new Solid("room/edge_r.png"), width - 2, y);
        }
        // left wall
        for (int y = 3; y < height - 1; y++) {
            addObject(new Solid("room/edge_l.png"), -1,y);
        }

        GreenfootImage screen = getBackground();
        screen.drawImage(new GreenfootImage("Press W A S D keys to Move", 20, Color.WHITE, new Color(0,0,0,0)), 100, 20);
        
        // Player Location
        Player player = new Player();
        addObject(player,7,4);
    }
}
