import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LEVEL1_s2 - Room with no WASD message, player enters from left, exit on top
 */
public class LEVEL1_s2 extends LEVEL1
{
    private GreenfootImage boxImage;
    public LEVEL1_s2(){
        super();
        setSongFile("silence");
        // Connections: left from LEVEL1, top" to LEVEL1_s2 (example next room), others null or LEVEL1 if cycling
        setConnections("LEVEL1_s1", null, null, "LEVEL1_s2");
        prepare();
    }

    @Override
    protected void prepare()   // override to customize walls and openings
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
        
            for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_u.png"), x, 9);
        }

       // Right wall solid
        for (int y = 2; y < height - 1; y++) {
            addObject(new Solid("room/edge_r.png"), width - 2, y);
        }

        // Left wall with opening at y=4 for player entry
        for (int y = 4; y < height - 1; y++) {
            if (y != 4) {
                addObject(new Solid("room/edge_l.png"), 1, y);
            }
        }

        // Place player near left opening
        Player player = new Player();
        addObject(player, 2, 4); 
        
        Key key = new Key();
        addObject(key, 11, 3);
    }
}
