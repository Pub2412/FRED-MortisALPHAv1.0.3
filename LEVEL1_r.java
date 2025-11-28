import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_r extends LEVEL1_PuzzleHub
{

    /**
     * Constructor for objects of class LEVEL1_1.
     * 
     */
   public LEVEL1_r()
    {
        setSongFile("root_8bit");
        setConnections(null, "LEVEL1_rtobotr", "LEVEL1_PuzzleHub", null); // u,d l,r
        prepare();
        Player player = new Player();
        addObject(player, 1, 7);
    }


@Override
protected void prepare()
{
    // Add full border for top and sides
    for (int i = 0; i < 16; i++) {
        addObject(new Solid("room/edge_u.png"), i, 0); // top edge
    }
    for (int j = 0; j < 6; j++) {
        addObject(new Solid("room/edge_l.png"), 0, j); // left edge
    }
        for (int j = 0; j < 10; j++) {
        addObject(new Solid("room/edge_r.png"), 15, j); // right edge
    }

    // Bottom edge with opening at (7,9)
    for (int i = 0; i < 16; i++) {
        if (i != 7) {
            addObject(new Solid("room/edge_d.png"), i, 9);
        }
    }

    // Corners
    addObject(new Solid("room/corner_lu.png"), 0, 0);
    addObject(new Solid("room/corner_ru.png"), 15, 0);
    addObject(new Solid("room/corner_ld.png"), 0, 9);
    addObject(new Solid("room/corner_rd.png"), 15, 9);

    // Place player near left entrance


    // =============== FIXED MAZE WALLS ===============
    // Use only a generic wall tile inside the maze!
    String wall = "room/corner_ru.png";

    addObject(new Solid(wall), 3, 1);
    addObject(new Solid(wall), 4, 1);
    addObject(new Solid(wall), 5, 1);

    addObject(new Solid(wall), 5, 2);
    addObject(new Solid(wall), 5, 3);

    addObject(new Solid(wall), 7, 2);
    addObject(new Solid(wall), 8, 2);

    addObject(new Solid(wall), 8, 3);
    addObject(new Solid(wall), 8, 4);

    addObject(new Solid(wall), 10, 5);
    addObject(new Solid(wall), 11, 5);

    addObject(new Solid(wall), 11, 6);
    addObject(new Solid(wall), 11, 7);

    addObject(new Solid(wall), 13, 8);
    addObject(new Solid(wall), 14, 8);
    
    
    Letters letter = new Letters("LETTER D ACQUIRED", "D", "1stlvlpuzzle/littleD.png");
    
    if (!WorldController.isPuzzleSolved("D")) addObject(letter, 14, 2);
    
    // in LEVEL1_r
    String[] allowedRooms = {"LEVEL1_r"};
    FRED demon = new FRED(allowedRooms);
    addObject(demon, 2, 2);



}

} 
