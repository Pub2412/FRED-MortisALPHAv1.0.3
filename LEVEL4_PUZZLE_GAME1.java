import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE_GAME1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE_GAME1 extends LEVEL4_PUZZLE_GAME
{
    PlayerLevel4Puzzle player = new PlayerLevel4Puzzle(2);
    TargetLevel4Puzzle target = new TargetLevel4Puzzle("LEVEL4_PUZZLE1", "LEVEL4_PUZZLE1");
    public LEVEL4_PUZZLE_GAME1()
    {
        prepare();
    }
    private void prepare()
    {
        
        addObject(new Solid("box_dark.png"),14,12);
        addObject(new Solid("box_dark.png"),18,12);
        addObject(new Solid("box_dark.png"),14,8);
        addObject(new Solid("box_dark.png"),18,8);
        
        addObject(new Solid("room/edge_d.png"),14,14);
        addObject(new Solid("room/edge_d.png"),16,14);
        addObject(new Solid("room/edge_d.png"),18,14);
        
        addObject(new Solid("room/edge_u.png"),14,6);
        addObject(new Solid("room/edge_u.png"),16,6);
        addObject(new Solid("room/edge_u.png"),18,6);
        
        addObject(new Solid("room/edge_l.png"),12,8);
        addObject(new Solid("room/edge_l.png"),12,10);
        addObject(new Solid("room/edge_l.png"),12,12);
        
        addObject(new Solid("room/edge_r.png"),20,8);
        addObject(new Solid("room/edge_r.png"),20,10);
        addObject(new Solid("room/edge_r.png"),20,12);
        
        addObject(new BoxLevel4Puzzle(),16,12);
        addObject(new BoxLevel4Puzzle(),16,8);
        
        addObject(player, 16,15);
        addObject(target, 16,6);
        
        addObject(new CRT_OVERLAY(),16,14);
    }
}
