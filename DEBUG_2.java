import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DEBUG_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DEBUG_2 extends Room
{
    private GreenfootImage boxImage;
    public DEBUG_2()
    {
        super();
        setSongFile("root_8bit");
        setConnections("DEBUG_2", "DEBUG_2", "DEBUG_2", "DEBUG_2");
        prepare();
    }
    
    private void prepare()
    {
        addObject(new Solid("room/edge_d.png"),0,8);
        addObject(new Solid("room/edge_d.png"),1,8);
        addObject(new Solid("room/edge_d.png"),2,8);
        addObject(new Solid("room/edge_d.png"),3,8);
        addObject(new Solid("room/corner_ru.png"),12,2);
        addObject(new Solid("room/corner_lu.png"),9,2);
        addObject(new Solid("room/edge_u.png"),13,2);
        addObject(new Solid("room/edge_u.png"),14,2);
        addObject(new Solid("room/edge_u.png"),15,2);
        addObject(new Solid("room/edge_u.png"),8,2);
        addObject(new Solid("room/edge_u.png"),7,2);
        addObject(new Solid("room/edge_u.png"),6,2);
        addObject(new Solid("room/edge_u.png"),5,2);
        addObject(new Solid("room/edge_u.png"),4,2);
        addObject(new Solid("room/edge_u.png"),3,2);
        addObject(new Solid("room/edge_u.png"),2,2);
        addObject(new Solid("room/edge_u.png"),1,2);
        addObject(new Solid("room/edge_u.png"),0,2);

        Player player = new Player();

        addObject(player,317,235);
        player.setLocation(7,4);
        COMPUTEr cOMPUTEr = new COMPUTEr("COMPUTER EXAMPLE", "TERMINAL_exampleDEBUGROOM");
        addObject(cOMPUTEr,4,4);
    }
}
