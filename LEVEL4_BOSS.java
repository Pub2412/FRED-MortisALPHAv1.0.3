import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class LEVEL4_BOSS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL4_BOSS extends Room
{
    private boolean super_loaded = false;
    /**
     * Constructor for objects of class LEVEL4_BOSS.
     * 
     */
    Player player = new Player();
    LEVEL4_DEMON demon = new LEVEL4_DEMON();
    private List<LEVEL4_FALSE_DEMON> clones = new ArrayList<>();
    public LEVEL4_BOSS()
    {
        prepare();
 
    }
    
    public void prepare() {
        addObject(new Solid("room/edge_d.png"),4,10);
        addObject(new Solid("room/edge_d.png"),5,10);
        addObject(new Solid("room/edge_d.png"),6,10);
        addObject(new Solid("room/edge_d.png"),7,10);
        addObject(new Solid("room/edge_d.png"),8,10);
        addObject(new Solid("room/edge_d.png"),9,10);
        addObject(new Solid("room/edge_d.png"),10,10);
        addObject(new Solid("room/edge_d.png"),11,10);
        addObject(new Solid("room/edge_d.png"),12,10);

        addObject(new Solid("room/edge_u.png"),4,0);
        addObject(new Solid("room/edge_u.png"),5,0);
        addObject(new Solid("room/edge_u.png"),6,0);
        addObject(new Solid("room/edge_u.png"),7,0);
        addObject(new Solid("room/edge_u.png"),8,0);
        addObject(new Solid("room/edge_u.png"),9,0);
        addObject(new Solid("room/edge_u.png"),10,0);
        addObject(new Solid("room/edge_u.png"),11,0);
        addObject(new Solid("room/edge_u.png"),12,0);

        addObject(new Solid("room/edge_l.png"),3,1);
        addObject(new Solid("room/edge_l.png"),3,2);
        addObject(new Solid("room/edge_l.png"),3,3);
        addObject(new Solid("room/edge_l.png"),3,4);
        addObject(new Solid("room/edge_l.png"),3,5);
        addObject(new Solid("room/edge_l.png"),3,6);
        addObject(new Solid("room/edge_l.png"),3,7);
        addObject(new Solid("room/edge_l.png"),3,8);
        addObject(new Solid("room/edge_l.png"),3,9);

        addObject(new Solid("room/edge_r.png"),13,1);
        addObject(new Solid("room/edge_r.png"),13,2);
        addObject(new Solid("room/edge_r.png"),13,3);
        addObject(new Solid("room/edge_r.png"),13,4);
        addObject(new Solid("room/edge_r.png"),13,5);
        addObject(new Solid("room/edge_r.png"),13,6);
        addObject(new Solid("room/edge_r.png"),13,7);
        addObject(new Solid("room/edge_r.png"),13,8);
        addObject(new Solid("room/edge_r.png"),13,9);
        
        addObject(demon, 8,4);
        addObject(player,8,8);
        
    }
    
    public void act() {
        if (!super_loaded) {
            super_loaded = true;
            //MusicPlayer.StopMus();
            WorldController.save();
        }
        switch (demon.getPhase()) {
            case 1:
                MusicPlayer.PlayMus("sabbathofthewitch.wav");
                handlePhase1();
                break;
            case 2:
                handlePhase2();
                break;
            case 3:
                handlePhase3();
                break;
        }
    }
    
    private void handlePhase1() {
        if (demon.getBossTimer() == 0) {
            createClones();
        }
        if (demon.getBossTimer() > 90) {
            // do phase 2
            demon.setPhase(2);
            handlePhase2();
        }
        demon.setTarget(player.getX(), player.getY());
        for (LEVEL4_FALSE_DEMON fake : clones) {
            fake.setTarget(player.getX(), player.getY());
        }
    }
    
    private void handlePhase2() {
        if (demon.getBossTimer() == 0) {
            teleportDemonBehindPlayer();
            clearClones();
        }
        if (demon.getBossTimer() > 180 || demon.isOOB()) {
            demon.setPhase(1);
            handlePhase1();
        }
    }
    
    private void handlePhase3() {
        clearClones();
        if (demon.getBossTimer() > 30) {
            demon.setPhase(2);
            handlePhase2();
        }
    }
    
    private void teleportDemonBehindPlayer() {
        int px = player.getX(); int py = player.getY();
        int dist = 4;
        String dir = getOppositeDirection(demon.getDirection());
        
        switch (dir) {
            case "u": demon.setLocation(px, 1); break;
            case "d": demon.setLocation(px, 10); break;
            case "l": demon.setLocation(1, py); break;
            case "r": demon.setLocation(14, py); break;
        }
    }
    private String getOppositeDirection(String dir) {
        switch (dir) {
            case "u": return "d";
            case "d": return "u";
            case "l": return "r";
            case "r": return "l";
            default: return "d";
        }
    }
    
    private void createClones() {
        for (int i = 0; i < 4; i++) {
            // skip direction if would be real
            if (demon.getDirection() == getDirectionAsString(i)) continue;
            LEVEL4_FALSE_DEMON fake = new LEVEL4_FALSE_DEMON();
            fake.setDirection(getDirectionAsString(i));
            clones.add(fake);
            addObject(fake, demon.getX(), demon.getY());
        }
    }
    private void clearClones() {
        for (LEVEL4_FALSE_DEMON fake : clones) {
            removeObject(fake);
        }
        clones.clear();
    }
    private String getDirectionAsString(int dir) {
        switch (dir) {
            case 0: return "u";
            case 1: return "d";
            case 2: return "l";
            case 3: return "r";
            default: return "u";
        }
    }
}
