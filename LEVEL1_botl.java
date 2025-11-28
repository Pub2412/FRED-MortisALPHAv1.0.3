import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_botl extends LEVEL1_PuzzleHub
{

    /**
     * Constructor for objects of class LEVEL1_1.
     * 
     */
   public LEVEL1_botl()
    {
        setSongFile("root_8bit");
        setConnections("LEVEL1_ltobotl", null, null, "LEVEL1_bot");// u,d l,r
        prepare();
        Player player = new Player();
        addObject(player, 10, 2);
    }


@Override
protected void prepare()
{
    // Add full border for top and sides
    for (int i = 0; i < 16; i++) {
        if ( i != 10){
        addObject(new Solid("room/edge_u.png"), i, 0);
    }
    }
    for (int j = 0; j < 10; j++) {
        addObject(new Solid("room/edge_l.png"), 0, j);
    }
        for (int j = 4; j < 10; j++) {
            if (j != 4 && j != 5) {
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


    String wall = "room/corner_lu.png";

    // --- First horizontal block ---
    addObject(new Solid(wall), 2, 1);
    addObject(new Solid(wall), 3, 1);
    addObject(new Solid(wall), 4, 1);
    addObject(new Solid(wall), 5, 1);

    // Down from left side
    addObject(new Solid(wall), 2, 2);

    // Vertical barrier dropping down
    addObject(new Solid(wall), 7, 4);
    addObject(new Solid(wall), 7, 5);

    // --- Third horizontal block near center ---
    addObject(new Solid(wall), 6, 5);
    addObject(new Solid(wall), 5, 5);
    addObject(new Solid(wall), 4, 5);
    

    // Bend upward on right side
    //addObject(new Solid(wall), 8, 6);
    addObject(new Solid(wall), 8, 5);

    // --- Upper-right block ---
    addObject(new Solid(wall), 9, 5);
    addObject(new Solid(wall), 10, 5);
    addObject(new Solid(wall), 11, 5);

    // Drop straight down near exit
    addObject(new Solid(wall), 11, 6);
    addObject(new Solid(wall), 11, 7);
    addObject(new Solid(wall), 11, 8);

    // Final wall before exit (forces you left first)
    addObject(new Solid(wall), 13, 8);
    addObject(new Solid(wall), 14, 8);
    
    Letters letter = new Letters("LETTER U ACQUIRED", "U", "1stlvlpuzzle/littleU.png");
    
    if (!WorldController.isPuzzleSolved("U")) addObject(letter, 10, 7);
}
}

