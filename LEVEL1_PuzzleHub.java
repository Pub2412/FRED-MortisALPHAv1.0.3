import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_PuzzleHub here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_PuzzleHub extends Room
{

  private GreenfootImage boxImage;
  
    public LEVEL1_PuzzleHub(){
        super();
        setSongFile("root_8bit");
        // Connections: left from LEVEL1, top" to LEVEL1_s2 (example next room), others null or LEVEL1 if cycling
        setConnections(null, null, "LEVEL1_l", "LEVEL1_r");
        prepare();

    }

    protected void prepare()   
    {
        int width = 16;
        int height = 10;
        

        // Bottom edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_d.png"), x, 11 - 1);
        }

        // Top edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/edge_u.png"), x, 1);
           // addObject(new Solid("room/edge_u.png"), x, 9);
        }
        
        // Right wall 
        for (int y = 2; y < height - 5; y++) {
            addObject(new Solid("room/edge_r.png"), width - 2, y);
        }

        // Left wall 
        for (int y = 2; y < height - 5; y++) {
            if (y != 0) {
                addObject(new Solid("room/edge_l.png"), 1, y);
            }
        }
        
        addObject(new Solid("room/edge_r.png"), 14, 9);
        addObject(new Solid("room/edge_l.png"), 1, 9);
        //addObject(new Solid("room/edge_u.png"), 8, 5);
        
        Sign sign = new Sign("FIND THE LETTERS TO KNOW HIS NAME");
        sign.setImage("interact/THE HOLY.png");
        
        if(TotalAm() < 6)addObject(sign,10,8);

        
        LEVEL1_MAZE_DOOR DDoor = new LEVEL1_MAZE_DOOR("LVL2_Tscreen", "LEVEL1_MAZE_DOOR", "1stlvlpuzzle/DoorSmileLocked.png", "1stlvlpuzzle/DoorSmileUnlocked.png");
        addObject(DDoor, 8, 5);
        
        Frames bf = new Frames("", "1stlvlpuzzle/None.png");
        addObject(bf,2,2);
        
        Frames bf2 = new Frames("", "1stlvlpuzzle/None.png");
        addObject(bf2,5,2);      
        
        Frames bf3 = new Frames("", "1stlvlpuzzle/None.png");
        addObject(bf3,10,2);
   
        Frames bf4 = new Frames("", "1stlvlpuzzle/None.png");
        addObject(bf4,13,2);
   
        Frames bf5 = new Frames("", "1stlvlpuzzle/None.png");
        addObject(bf5,4,5);
            
  
        Frames bf6 = new Frames("", "1stlvlpuzzle/None.png");
        addObject(bf6,12,5);
        
        changeframes();
        
        // Place player 
        Player player = new Player();
        addObject(player, 8, 7); 
        
}  
private void changeframes(){
    Frames solvedbf = new Frames("", "1stlvlpuzzle/BigD.png");
    Frames solvedbf2 = new Frames("", "1stlvlpuzzle/BigY.png");
    Frames solvedbf3 = new Frames("", "1stlvlpuzzle/BigB.png");
    Frames solvedbf4 = new Frames("", "1stlvlpuzzle/BigB.png");
    Frames solvedbf5 = new Frames("", "1stlvlpuzzle/BigU.png");
    Frames solvedbf6 = new Frames("", "1stlvlpuzzle/BigK.png");
    if (WorldController.isPuzzleSolved("D")) addObject(solvedbf,2,2);
    if (WorldController.isPuzzleSolved("Y")) addObject(solvedbf2,5,2);
    if (WorldController.isPuzzleSolved("B1")) addObject(solvedbf3,10,2);
    if (WorldController.isPuzzleSolved("B2")) addObject(solvedbf4,13,2);
    if (WorldController.isPuzzleSolved("U")) addObject(solvedbf5,4,5);
    if (WorldController.isPuzzleSolved("K")) addObject(solvedbf6,12,5);
    
}     

    public static int TotalAm() {
        int total = 0;
    if (WorldController.isPuzzleSolved("D")) total++;
    if (WorldController.isPuzzleSolved("Y")) total++;
    if (WorldController.isPuzzleSolved("B1")) total++;
    if (WorldController.isPuzzleSolved("B2")) total++;
    if (WorldController.isPuzzleSolved("U")) total++;
    if (WorldController.isPuzzleSolved("K")) total++;
        return total;
    }
}





