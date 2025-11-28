import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * LEVEL1_s1 - Room with no WASD message, player enters from left, exit on top
 */
public class LEVEL1_s1 extends LEVEL1
{
    private GreenfootImage boxImage;
    public LEVEL1_s1(){

        // Connections: left from LEVEL1, top" to LEVEL1_s2 (example next room), others null or LEVEL1 if cycling
        setConnections("LEVEL1", null, null, "LEVEL1_s3");
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

        // Top edge with opening in the middle (x=7 and x=8)
        for (int x = 0; x < width; x++) {
            if (x < 7 || x > 6) {
                addObject(new Solid("room/edge_u.png"), x, 1);
            }
        }
        addObject(new Solid("room/corner_lu.png"), 1, 2);
        //addObject(new Solid("room/corner_ru.png"), width - 2, 2);
        
            for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_u.png"), x, 9);
        }

        // Right wall solid
        for (int y = 2; y < height - 4; y++) {
            addObject(new Solid("room/edge_r.png"), width - 2, y);
        }

        // Left wall with opening at y=4 for player entry
        for (int y = 3; y < height - 1; y++) {
            if (y != 4) {
                addObject(new Solid("room/edge_l.png"), 1, y);
            }
        }
        
        GreenfootImage screen = getBackground();
        screen.drawImage(new GreenfootImage("Press Space to Interact (Interact to the cross now)", 20, Color.WHITE, new Color(0,0,0,0)), 100, 20);
     
        LEVEL1_FredDoor keyDoor = new LEVEL1_FredDoor("LEVEL1_s2", "LEVEL1_FredDoor", "interact/asy_doornoeye.png", "interact/asy_dooreye.png");
        addObject(keyDoor, 7, 1); 
        
         // Place player near left opening
        Player player = new Player();
        addObject(player, 2, 4);  // Slightly inside room to avoid placing too close to left edge
        
        Sign sign = new Sign("THE KEY RESIDES ON THE OTHER ROOM.");
        sign.setImage("interact/THE HOLY.png");
        addObject(sign,10,4);
        addObject(new Solid("interact/THE HOLY.png"), 10, 4);
        
    }
}
