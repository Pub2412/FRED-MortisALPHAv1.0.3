import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL3_MirrorRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL3_MirrorRoom extends LEVEL3
{

    /**
     * Constructor for objects of class LEVEL3_MirrorRoom.
     * 
     */
    private Player player;
    private VisionMask mask;
    private Beholder beholder;

    public LEVEL3_MirrorRoom()
    {
        setConnections(null, null, "LEVEL3", null);
              
        player = new Player();
        addObject(player, 1, 4);

        mask = new VisionMask(player, 200);  // 200px radius suggestion for 80px tiles
        addObject(mask, 8, 6);
        

        setPaintOrder(VisionMask.class);
        if (TotalPort() == 1) Beholder.moveDelay = 90;
        if (TotalPort() == 2) Beholder.moveDelay = 70;
        if (TotalPort() == 3) Beholder.moveDelay = 50;
        if (TotalPort() == 4) Beholder.moveDelay = 40;
    }


@Override
protected void prepare()
{
    
    // Add full border for top and sides
    for (int i = 0; i < 15; i++) {
        addObject(new Solid("room/blue_edge_u.png"), i, 0);
    }
    for (int j = 1; j < 13; j++) {
        if (j != 7 && j != 6 && j != 5) {
        addObject(new Solid("room/blue_edge_l.png"), 0, j);
    }
    }
        for (int j = 1; j < 11; j++) {
        addObject(new Solid("room/blue_edge_r.png"), 15, j);
    }

    // Bottom border with opening at RIGHT (15,9)
    for (int i = 0; i < 15; i++) {
            addObject(new Solid("room/blue_edge_d.png"), i, 15);
    }
    
    TrueMirrors M1 = new TrueMirrors("", "M1", "lvl3_glasses/birds.png");
    TrueMirrors M2 = new TrueMirrors("", "M2", "lvl3_glasses/man.png");
    TrueMirrors M3 = new TrueMirrors("", "M3", "lvl3_glasses/smile.png");
    FalseMirrors M4 = new FalseMirrors("", "M4", "lvl3_glasses/tech.png");
    FalseMirrors M5 = new FalseMirrors("", "M5", "lvl3_glasses/sun.png");
    TrueMirrors M7 = new TrueMirrors("", "M7", "lvl3_glasses/heart.png");
    FalseMirrors M8 = new FalseMirrors("", "M8", "lvl3_glasses/blood.png");

    addObject(M1, 8, 2);
    addObject(M2, 8, 9);
    addObject(M3, 3, 9);
    addObject(M5, 3, 2);
    addObject(M7, 13, 2);
    addObject(M8, 13, 9);
    
        String[] allowedRooms = {"LEVEL3_MirrorRoom"};
        beholder = new Beholder(allowedRooms);
        addObject(beholder, 10, 7);
}
}
