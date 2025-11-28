import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_botr extends LEVEL1_PuzzleHub
{

    /**
     * Constructor for objects of class LEVEL1_1.
     * 
     */
   public LEVEL1_botr()
    {
        setSongFile("root_8bit");
        setConnections("LEVEL1_rtobotr", null, "LEVEL1_bot", null);// u,d l,r
        prepare();
        Player player = new Player();
        addObject(player, 1, 4);
    }


@Override
protected void prepare()
{
    // Add full border for top and sides
    for (int i = 0; i < 16; i++) {
        if ( i != 11){
        addObject(new Solid("room/edge_u.png"), i, 0);
    }
    }
    for (int j = 5; j < 10; j++) {
        if (j != 4 && j != 3) {
        addObject(new Solid("room/edge_l.png"), 0, j);
    }
    }
        for (int j = 0; j < 10; j++) {  
        addObject(new Solid("room/edge_r.png"), 15, j);
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

    // ======== MAZE PATTERN #6 — Z STYLE ========
    String wall = "room/corner_ld.png";

    // --- Top horizontal bar (Z top) ---
    addObject(new Solid(wall), 2, 1);
    addObject(new Solid(wall), 3, 1);
    addObject(new Solid(wall), 4, 1);
    addObject(new Solid(wall), 5, 1);
    addObject(new Solid(wall), 6, 1);
    addObject(new Solid(wall), 7, 1);
    addObject(new Solid(wall), 8, 1);
    addObject(new Solid(wall), 9, 1);

    // Diagonal connector downward-left
    addObject(new Solid(wall), 8, 2);
    addObject(new Solid(wall), 7, 3);
    addObject(new Solid(wall), 6, 4);
    addObject(new Solid(wall), 5, 5);

    // --- Middle horizontal bar (Z middle) ---
    addObject(new Solid(wall), 6, 5);
    addObject(new Solid(wall), 7, 5);
    addObject(new Solid(wall), 8, 5);
    addObject(new Solid(wall), 9, 5);
    addObject(new Solid(wall), 10, 5);
    addObject(new Solid(wall), 11, 5);

    // Diagonal connector downward-right
    //addObject(new Solid(wall), 10, 6);
    //addObject(new Solid(wall), 11, 7);
    //addObject(new Solid(wall), 12, 8);

    // --- Bottom horizontal bar (Z bottom) ---
    //addObject(new Solid(wall), 12, 8);
    addObject(new Solid(wall), 13, 8);
    addObject(new Solid(wall), 14, 8);
    

}
}

