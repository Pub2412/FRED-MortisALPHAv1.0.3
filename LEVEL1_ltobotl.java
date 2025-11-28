import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_ltobotl extends LEVEL1_PuzzleHub
{

    /**
     * Constructor for objects of class LEVEL1_1.
     * 
     */
   public LEVEL1_ltobotl()
    {
        setSongFile("root_8bit");
        setConnections("LEVEL1_l", "LEVEL1_botl", null, null); // u,d l,r
        prepare();
        Player player = new Player();
        addObject(player, 13, 2);
    }


    @Override
    protected void prepare()
    {
        // Add full border for top and sides
        for (int i = 0; i < 16; i++) {
            if (i != 5){
                addObject(new Solid("room/edge_u.png"), i, 0); 
            }
        }
        for (int j = 0; j < 10; j++) {
            addObject(new Solid("room/edge_l.png"), 0, j);  
            addObject(new Solid("room/edge_r.png"), 15, j); 
        }

        // Bottom border with opening at RIGHT (15,9)
        for (int i = 0; i < 16; i++) {
            if (i != 10){
                addObject(new Solid("room/edge_d.png"), i, 9);
            }
        }

        // Corners
        addObject(new Solid("room/corner_lu.png"), 0, 0);
        addObject(new Solid("room/corner_ru.png"), 15, 0);
        addObject(new Solid("room/corner_ld.png"), 0, 9);
        addObject(new Solid("room/corner_rd.png"), 15, 9);

        // Player spawn

        // ======== NEW MAZE DESIGN ========
        String wall = "room/corner_ru.png";

        // Row 1 walls
        addObject(new Solid(wall), 2, 1);
        addObject(new Solid(wall), 3, 1);
        addObject(new Solid(wall), 4, 1);
        addObject(new Solid(wall), 6, 1);
        addObject(new Solid(wall), 7, 1);
        addObject(new Solid(wall), 9, 1);
        addObject(new Solid(wall), 10, 1);
        addObject(new Solid(wall), 11, 1);

        // Vertical barriers
        addObject(new Solid(wall), 4, 2);
        addObject(new Solid(wall), 4, 3);

        addObject(new Solid(wall), 7, 2);
        addObject(new Solid(wall), 7, 3);
        addObject(new Solid(wall), 7, 4);

        addObject(new Solid(wall), 10, 2);
        addObject(new Solid(wall), 10, 3);

        // Lower maze section
        addObject(new Solid(wall), 3, 7);
        addObject(new Solid(wall), 4, 7);

        addObject(new Solid(wall), 6, 8);
        addObject(new Solid(wall), 7, 8);
        addObject(new Solid(wall), 8, 8);

        addObject(new Solid(wall), 12, 7);
        addObject(new Solid(wall), 13, 7);
        addObject(new Solid(wall), 14, 7);

        // Final barrier before exit
        addObject(new Solid(wall), 13, 8);
        addObject(new Solid(wall), 14, 8);

        Letters letter = new Letters("LETTER K ACQUIRED", "K", "1stlvlpuzzle/littleK.png");

        if (!WorldController.isPuzzleSolved("K")) addObject(letter, 9, 3);

        // in LEVEL1_r
        String[] allowedRooms = {"LEVEL1_ltobotl"};
        FRED demon = new FRED(allowedRooms);
        addObject(demon, 2, 7);
    }
}

