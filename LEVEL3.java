import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL3 extends Room
{
 private GreenfootImage boxImage;
  
    public LEVEL3(){
        super();
        setSongFile("daisy");
        // Connections: left from LEVEL1, top" to LEVEL1_s2 (example next room), others null or LEVEL1 if cycling
        setConnections(null, null, null, "LEVEL3_MirrorRoom"); // u,d l,r
        prepare();

    }

    protected void prepare()   
    {
        int width = 16;
        int height = 10;
        
        // Bottom edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/black_u.png"), x, 11 - 1);
        }
        
        // Top edge
        for (int x = 0; x < width; x++) {
            addObject(new Solid("room/blue_edge_u.png"), x, 1);
           // addObject(new Solid("room/edge_u.png"), x, 9);
        }
        
        // Right wall 
        for (int y = 2; y < height - 0; y++) {
            if (y != 7 && y != 6 && y != 5){
            addObject(new Solid("room/blue_edge_r.png"), width - 2, y);
        }
        }

        // Left wall 
        for (int y = 2; y < height - 0; y++) {
                addObject(new Solid("room/blue_edge_l.png"), 1, y);
        }
        
        
        

        //addObject(new Solid("room/edge_u.png"), 8, 5);
        
        Sign sign = new Sign("COLLECT THE CORRECT MIRRORS");
        sign.setImage("interact/THE HOLY.png");
        
        if(TotalPort() < 4)addObject(sign,11,5);

        
        Frames bf = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf,3,2);
        
        Frames bf2 = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf2,6,2);      
        
        Frames bf3 = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf3,9,2);
   
        Frames bf4 = new Frames("", "lvl3_portraits/blank.png");
        addObject(bf4,12,2);
        
        LEVEL3_Door DDoor = new LEVEL3_Door("LVL4_Tscreen", "LEVEL3_Door", "1stlvlpuzzle/DoorSmileUnlocked.png", "1stlvlpuzzle/DoorSmileUnlocked.png");
     
        if(TotalPort() == 4) addObject(DDoor, 8, 6);
   
        
        changeportraits();
        
        // Place player 
        Player player = new Player();
        addObject(player, 8, 7); 
        
}  
private void changeportraits(){
    Portraits solvedbf = new Portraits("", "lvl3_portraits/smallIntheBeginning.png","lvl3_portraits/IntheBeginning.png","In the Beginning.");
    Portraits solvedbf2 = new Portraits("", "lvl3_portraits/smallstatanbanished.png","lvl3_portraits/satanbanished.png","Saint Michael Defeating Lucifer.");
    Portraits solvedbf3 = new Portraits("", "lvl3_portraits/smallFco.png","lvl3_portraits/Fco.png","Fuherer Co. Building.");
    Portraits solvedbf4 = new Portraits("", "lvl3_portraits/smallostcomp.png","lvl3_portraits/lostcomp.png","The Surviving Laptop.");
    if (TotalPort() == 1 || TotalPort() == 2 || TotalPort() == 3 || TotalPort() == 4 ) addObject(solvedbf,3,2);
    if (TotalPort() == 2 || TotalPort() == 3 || TotalPort() == 4) addObject(solvedbf2,6,2);
    if (TotalPort() == 3 || TotalPort() == 4) addObject(solvedbf3,9,2);
    if (TotalPort() == 4) addObject(solvedbf4,12,2);

    
}     

    public static int TotalPort() {
    int total = 0;
    if (WorldController.isPuzzleSolved("M1")) total++;
    if (WorldController.isPuzzleSolved("M2")) total++;
    if (WorldController.isPuzzleSolved("M3")) total++;
    if (WorldController.isPuzzleSolved("M7")) total++;
        return total;
    }
    
}

