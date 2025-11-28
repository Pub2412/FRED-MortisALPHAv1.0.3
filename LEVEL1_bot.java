import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_bot extends LEVEL1_PuzzleHub
{

    /**
     * Constructor for objects of class LEVEL1_1.
     * 
     */
   public LEVEL1_bot()
    {
        setSongFile("root_8bit");
        setConnections(null, null, "LEVEL1_botl", "LEVEL1_botr"); // u,d l,r
        prepare();
        Player player = new Player();
        addObject(player, 1, 4);

    }


@Override
protected void prepare()
{
    // Add full border for top and sides
    for (int i = 0; i < 16; i++) {
        addObject(new Solid("room/edge_u.png"), i, 0);
    }
    for (int j = 5; j < 10; j++) {
        if (j != 4 && j != 3) {
        addObject(new Solid("room/edge_l.png"), 0, j);
    }
    }
        for (int j = 5; j < 10; j++) {
            if (j != 4 && j != 3) {
        addObject(new Solid("room/edge_r.png"), 15, j);
    }
    }

    // Bottom border with opening at RIGHT (15,9)
    for (int i = 0; i < 16; i++) {
            addObject(new Solid("room/edge_d.png"), i, 9);
    }

        // Corners
    addObject(new Solid("room/corner_lu.png"), 0, 0);
    addObject(new Solid("room/corner_ru.png"), 15, 0);
    addObject(new Solid("room/corner_ld.png"), 0, 9);
    addObject(new Solid("room/corner_rd.png"), 15, 9);

    // Player spawn

    // ======== NEW MAZE PATTERN #4 (SPIRAL STYLE) ========
    String wall = "room/corner_ru.png";

    // Outer spiral walls
    addObject(new Solid(wall), 2, 1);
    addObject(new Solid(wall), 3, 1);
    addObject(new Solid(wall), 4, 1);
    addObject(new Solid(wall), 5, 1);
    addObject(new Solid(wall), 6, 1);
    addObject(new Solid(wall), 7, 1);
    addObject(new Solid(wall), 8, 1);
    addObject(new Solid(wall), 9, 1);

    // Right vertical outer line
    addObject(new Solid(wall), 9, 2);
    addObject(new Solid(wall), 9, 3);
    addObject(new Solid(wall), 9, 4);
    addObject(new Solid(wall), 9, 5);

    // Bottom horizontal outward
    addObject(new Solid(wall), 8, 5);
    addObject(new Solid(wall), 7, 5);
    addObject(new Solid(wall), 6, 5);
    addObject(new Solid(wall), 5, 5);

    // Left vertical inward
    addObject(new Solid(wall), 5, 4);
    addObject(new Solid(wall), 5, 3);

    // Inner loop
    addObject(new Solid(wall), 6, 3);
    addObject(new Solid(wall), 7, 3);
    addObject(new Solid(wall), 7, 2);
    addObject(new Solid(wall), 6, 2);

    // Path leading toward exit
    addObject(new Solid(wall), 11, 6);
    addObject(new Solid(wall), 12, 6);
    addObject(new Solid(wall), 13, 6);
    addObject(new Solid(wall), 14, 6);

    // Bottom-right mini cluster
    addObject(new Solid(wall), 12, 8);
    addObject(new Solid(wall), 13, 8);
    addObject(new Solid(wall), 14, 8);
    
    Letters letter = new Letters("LETTER B ACQUIRED", "B1", "1stlvlpuzzle/littleB.png");
    
    if (!WorldController.isPuzzleSolved("B1")) addObject(letter, 8, 7);
    
            // in LEVEL1_r
    String[] allowedRooms = {"LEVEL1_bot"};
    FRED demon = new FRED(allowedRooms);
    addObject(demon, 2, 7);

}
}

