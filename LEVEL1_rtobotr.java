import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_rtobotr extends LEVEL1_PuzzleHub
{

    /**
     * Constructor for objects of class LEVEL1_1.
     * 
     */
   public LEVEL1_rtobotr()
    {
        setSongFile("root_8bit");
        setConnections("LEVEL1_r", "LEVEL1_botr", null, null); // u,d l,r
        prepare();
        Player player = new Player();
        addObject(player, 1, 4);
    }


@Override
protected void prepare()
{
    // Add full border for top and sides
    for (int i = 0; i < 16; i++) {
         if (i != 7){
        addObject(new Solid("room/edge_u.png"), i, 0);
    }
    }
    for (int j = 0; j < 10; j++) {
        addObject(new Solid("room/edge_l.png"), 0, j);
        addObject(new Solid("room/edge_r.png"), 15, j);
    }

    // Bottom border with RIGHT opening (15,9)
    for (int i = 0; i < 16; i++) {
        if (i != 11) {
            addObject(new Solid("room/edge_d.png"), i, 9);
        }
    }

    // Corners
    addObject(new Solid("room/corner_lu.png"), 0, 0);
    addObject(new Solid("room/corner_ru.png"), 15, 0);
    addObject(new Solid("room/corner_ld.png"), 0, 9);
    addObject(new Solid("room/corner_rd.png"), 15, 9);

    // Player spawn


    // ======== MAZE PATTERN #5 — LADDER STYLE ========
    String wall = "room/corner_lu.png";

    // --- Top horizontal block ---
    addObject(new Solid(wall), 3, 1);
    addObject(new Solid(wall), 4, 1);
    addObject(new Solid(wall), 5, 1);
    addObject(new Solid(wall), 6, 1);

    // Left vertical drop
    addObject(new Solid(wall), 3, 2);
    addObject(new Solid(wall), 3, 3);

    // --- Middle horizontal block (shifted) ---
    addObject(new Solid(wall), 4, 3);
    addObject(new Solid(wall), 5, 3);
    addObject(new Solid(wall), 6, 3);
    //addObject(new Solid(wall), 7, 3);
    addObject(new Solid(wall), 8, 3);

    // Left vertical drop
    addObject(new Solid(wall), 5, 7);

    // --- Lower horizontal block (big obstacle) ---
    addObject(new Solid(wall), 6, 7);
    addObject(new Solid(wall), 7, 7);
    addObject(new Solid(wall), 8, 7);
    addObject(new Solid(wall), 9, 7);
    addObject(new Solid(wall), 10, 7);

    // Right vertical down toward exit
    addObject(new Solid(wall), 10, 8);

    // Final block near exit
    addObject(new Solid(wall), 12, 8);
    addObject(new Solid(wall), 13, 8);
    addObject(new Solid(wall), 14, 8);
    
    Letters letter = new Letters("LETTER B ACQUIRED", "B2", "1stlvlpuzzle/littleB.png");
    if (!WorldController.isPuzzleSolved("B2")) addObject(letter, 2, 2);
}
}

