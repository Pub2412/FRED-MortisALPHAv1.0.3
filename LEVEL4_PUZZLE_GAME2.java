import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE_GAME2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE_GAME2 extends LEVEL4_PUZZLE_GAME
{
    PlayerLevel4Puzzle player = new PlayerLevel4Puzzle(2);
    TargetLevel4Puzzle target = new TargetLevel4Puzzle("LEVEL4_PUZZLE2", "LEVEL4_PUZZLE2");
    public LEVEL4_PUZZLE_GAME2()
    {
        prepare();
    }
    private void prepare()
    {
        addObject(new Solid("box_dark.png"),12,8);
        addObject(new Solid("box_dark.png"),12,14);
        addObject(new Solid("box_dark.png"),14,12);
        addObject(new Solid("box_dark.png"),18,8);
        addObject(new Solid("box_dark.png"),18,12);
        
        addObject(new Solid("room/edge_d.png"),12,16);
        addObject(new Solid("room/edge_d.png"),14,16);
        addObject(new Solid("room/edge_d.png"),16,16);
        addObject(new Solid("room/edge_d.png"),18,16);
        
        addObject(new Solid("room/edge_u.png"),12,6);
        addObject(new Solid("room/edge_u.png"),14,6);
        addObject(new Solid("room/edge_u.png"),16,6);
        addObject(new Solid("room/edge_u.png"),18,6);
        
        addObject(new Solid("room/edge_l.png"),10,8);
        addObject(new Solid("room/edge_l.png"),10,10);
        addObject(new Solid("room/edge_l.png"),10,12);
        addObject(new Solid("room/edge_l.png"),10,14);
        
        addObject(new Solid("room/edge_r.png"),20,8);
        addObject(new Solid("room/edge_r.png"),20,10);
        addObject(new Solid("room/edge_r.png"),20,12);
        addObject(new Solid("room/edge_r.png"),20,14);
        
        addObject(new BoxLevel4Puzzle(),12,10);
        addObject(new BoxLevel4Puzzle(),14,10);
        addObject(new BoxLevel4Puzzle(),16,10);
        addObject(new BoxLevel4Puzzle(),16,12);
        addObject(new BoxLevel4Puzzle(),14,14);
        addObject(new BoxLevel4Puzzle(),16,14);
        
        addObject(player, 16,17);
        addObject(target, 16,6);
        
        addObject(new CRT_OVERLAY(),16,14);
    }
}
