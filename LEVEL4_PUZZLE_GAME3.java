import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL4_PUZZLE_GAME2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_PUZZLE_GAME3 extends LEVEL4_PUZZLE_GAME
{
    PlayerLevel4Puzzle player = new PlayerLevel4Puzzle(1);
    TargetLevel4Puzzle target = new TargetLevel4Puzzle("LEVEL4_PUZZLE3", "LEVEL4_PUZZLE3");
    public LEVEL4_PUZZLE_GAME3()
    {
        prepare();
    }
    private void prepare()
    {
        addObject(new Solid("box_dark.png"),12,6);
        addObject(new Solid("box_dark.png"),14,6);
        addObject(new Solid("box_dark.png"),20,6);
        addObject(new Solid("box_dark.png"),18,8);
        addObject(new Solid("box_dark.png"),14,10);
        addObject(new Solid("box_dark.png"),20,12);
        addObject(new Solid("box_dark.png"),12,14);
        addObject(new Solid("box_dark.png"),14,14);
        addObject(new Solid("box_dark.png"),18,14);
        addObject(new Solid("box_dark.png"),20,14);
        
        addObject(new Solid("room/edge_d.png"),12,16);
        addObject(new Solid("room/edge_d.png"),14,16);
        addObject(new Solid("room/edge_d.png"),16,16);
        addObject(new Solid("room/edge_d.png"),18,16);
        addObject(new Solid("room/edge_d.png"),20,16);
        
        addObject(new Solid("room/edge_u.png"),12,4);
        addObject(new Solid("room/edge_u.png"),14,4);
        addObject(new Solid("room/edge_u.png"),16,4);
        addObject(new Solid("room/edge_u.png"),18,4);
        addObject(new Solid("room/edge_u.png"),20,4);
        
        addObject(new Solid("room/edge_l.png"),10,6);
        addObject(new Solid("room/edge_l.png"),10,8);
        addObject(new Solid("room/edge_l.png"),10,10);
        addObject(new Solid("room/edge_l.png"),10,12);
        addObject(new Solid("room/edge_l.png"),10,14);
        
        addObject(new Solid("room/edge_r.png"),22,6);
        addObject(new Solid("room/edge_r.png"),22,8);
        addObject(new Solid("room/edge_r.png"),22,10);
        addObject(new Solid("room/edge_r.png"),22,12);
        addObject(new Solid("room/edge_r.png"),22,14);
        
        addObject(new BoxLevel4Puzzle(),18,6);
        addObject(new BoxLevel4Puzzle(),14,8);
        addObject(new BoxLevel4Puzzle(),16,10);
        addObject(new BoxLevel4Puzzle(),20,10);
        addObject(new BoxLevel4Puzzle(),14,12);
        addObject(new BoxLevel4Puzzle(),18,12);
        
        addObject(player, 16,17);
        addObject(target, 16,4);
        
        addObject(new CRT_OVERLAY(),16,14);
    }
}
