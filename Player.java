import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends SmoothMover
{
    // Sets up the animations
    private ArrayList<GreenfootImage> frames_u = new ArrayList<>();
    private ArrayList<GreenfootImage> frames_d = new ArrayList<>();
    private ArrayList<GreenfootImage> frames_l = new ArrayList<>();
    private ArrayList<GreenfootImage> frames_r = new ArrayList<>();
    
    // For animating
    private int frameIndex = 0;
    private int animationDelay = 16; // frames to wait before changing image
    private int animationCounter = 0; // How many frames it has waited before changing image
    
    private String currentDirection = "d"; // Current direction (u, d, l, r)
    private boolean moving = false;
    private boolean can_move = true;
    private boolean is_transitioning = false; // between rooms

    // For interactions
    private int interactCooldown = 0;
    
    private boolean loaded = false;
    
    // For transitioning between rooms
    private double targetX = 0; private double dx = 0;
    private double targetY = 0; private double dy = 0;
    private int transitionSteps = 0;
    private String targetRoom = null;
    
    private int lastX = -1;
    private int lastY = -1;
    private boolean moved = false;

    
    public Player() {
        super();
        
        // Add the frames and stuff
    String currentLevel = WorldController.currentLevel;

    if (currentLevel.equals("LEVEL5_BEDROOM") || currentLevel.equals("LEVEL5_KITCHEN") || currentLevel.equals("LEVEL5_BASEMENT") || currentLevel.equals("LEVEL5_HALLWAY") || currentLevel.equals("LEVEL5_BASEMENT_CUTSCENE")) { 
    for (int i = 1; i <= 3; i++) {
        frames_u.add(new GreenfootImage("blue_lac/player_u" + i + ".png"));
        frames_d.add(new GreenfootImage("blue_lac/player_d" + i + ".png"));
        frames_l.add(new GreenfootImage("blue_lac/player_l" + i + ".png"));
        frames_r.add(new GreenfootImage("blue_lac/player_r" + i + ".png"));
    }
    } else {
    for (int i = 1; i <= 3; i++) {
        frames_u.add(new GreenfootImage("player_u" + i + ".png"));
        frames_d.add(new GreenfootImage("player_d" + i + ".png"));
        frames_l.add(new GreenfootImage("player_l" + i + ".png"));
        frames_r.add(new GreenfootImage("player_r" + i + ".png"));
    }
    }
        
        // Just in case
        if (WorldController.movePlayer) {
            setLocation(WorldController.playerX, WorldController.playerY);
            currentDirection = WorldController.playerDirection;
            WorldController.movePlayer = false;
            handleAnimation();
        }
    }
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Loads player and stuff
        if (!loaded) {
            loaded = true;
            if (WorldController.movePlayer) {
                setLocation(WorldController.playerX, WorldController.playerY);
                currentDirection = WorldController.playerDirection;
                WorldController.movePlayer = false;
                handleAnimation();
            }
            return;
        }
        
        if (!WorldController.isMessageShown()) {
            moving = handleMovement();
            checkEdges();
            handleAnimation();
            if (Greenfoot.isKeyDown("space")) {
                checkInteraction();
            }
            interactCooldown -= 1;
        } else {
            if (Greenfoot.isKeyDown("space")) {
                WorldController.closeCurrentMessage();
                interactCooldown = 60;
            }
        }
        
        // Does transition stuff
        if (is_transitioning)
            doTransition();
            
        int curX = getX();
        int curY = getY();
        moved = (curX != lastX || curY != lastY);
        lastX = curX;
        lastY = curY;
    }
    
    private boolean canMoveTo(double newX, double newY) {
        double oldX = getExactX();
        double oldY = getExactY();
        setLocation(newX, newY);
    
        boolean collision = isTouching(Solid.class);
    
        // Move player back
        setLocation(oldX, oldY);
    
        return !collision;
    }
    
    private boolean handleMovement() {
        if (Greenfoot.isKeyDown("space") || !can_move || is_transitioning) {
            return false;
        }
        
        int normalized_x = 0;
        int normalized_y = 0;
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            normalized_x -= 1; currentDirection = "l";
        }
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            normalized_x += 1; currentDirection = "r";
        }
        if (Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("w")) {
            normalized_y -= 1; currentDirection = "u";
        }
        if (Greenfoot.isKeyDown("down") || Greenfoot.isKeyDown("s")) {
            normalized_y += 1; currentDirection = "w";
        }
        
        double move_distance = 0;
        if (normalized_x != 0 || normalized_y != 0) {
            move_distance = 0.1;
            if (normalized_x != 0 && normalized_y != 0)
                move_distance *= 0.707;
            
            double newX = getExactX() + (normalized_x * move_distance);
            double newY = getExactY() + (normalized_y * move_distance);
            
            if (canMoveTo(newX, getExactY())) setLocation(newX, getExactY());
            if (canMoveTo(getExactX(), newY)) setLocation(getExactX(), newY);
        }
        
        return move_distance > 0;
    }
    
    public void setCanMove(boolean canMove) {
    this.can_move = canMove;
}
    
    private void handleAnimation() {
        ArrayList<GreenfootImage> frames = getCurrentFrames();
        if (moving) {
            animationCounter++;
            if (animationCounter >= animationDelay) {
                animationCounter = 0;
                if (frameIndex == 1) {
                    frameIndex = 0;
                } else {
                    frameIndex = 1;
                }
                setImage(frames.get(frameIndex));
            }
        } else {
            animationCounter = animationDelay;
            if (Greenfoot.isKeyDown("space") && can_move) {
                setImage(frames.get(2));
            } else {
                setImage(frames.get(frameIndex));
            }
        }
    }
    private ArrayList<GreenfootImage> getCurrentFrames() {
        switch(currentDirection) {
            case "u": return frames_u;
            case "d": return frames_d;
            case "l": return frames_l;
            case "r": return frames_r;
            default: return frames_d;
        }
    }
    
    private void checkInteraction() {
        if (interactCooldown > 0) {return;}
        int checkX = 0;
        int checkY = 0;
        
        switch(currentDirection) {
            case "u": checkY += -1; break;
            case "d": checkY += 1; break;
            case "l": checkX += -1; break;
            case "r": checkX += 1; break;
            default: break;
        }
        
        Actor target = getOneObjectAtOffset(checkX, checkY, Interactable.class);
        if (target != null) {
            ((Interactable) target).interact();
        }
    }
    
    private void checkEdges() {
        if (is_transitioning) { return; }
        World current = getWorld();
        
        double x = getExactX();
        double y = getExactY();
        int w = current.getWidth();
        int h = current.getHeight();
    
        String nextRoom = null;
        double newX = x;
        double newY = y;
    
        if (x <= 0 && ((Room)current).room_l != null) {
            nextRoom = ((Room)current).room_l;
            newX = w - 2;
            newY = y;
        } else if (x >= w - 1 && ((Room)current).room_r != null) {
            nextRoom = ((Room)current).room_r;
            newX = 1;
            newY = y;
        } else if (y <= 0 && ((Room)current).room_u != null) {
            nextRoom = ((Room)current).room_u;
            newY = h - 2;
            newX = x;
        } else if (y >= h - 1 && ((Room)current).room_d != null) {
            nextRoom = ((Room)current).room_d;
            newY = 1;
            newX = x;
        }
    
        if (nextRoom != null) {
            startRoomTransition(nextRoom, newX, newY);
        }
    }
    
    private void startRoomTransition(String nextRoom, double newX, double newY) {
        can_move = false;
        is_transitioning = true;
        targetX = newX;
        targetY = newY;
        dx = (targetX - getExactX()) / 60.0;
        dy = (targetY - getExactY()) / 60.0;
        transitionSteps = 0;
        targetRoom = nextRoom;
        WorldController.startRoomTransition();
    }
    
    private void doTransition() {
        if (!is_transitioning) { return; }

        if (transitionSteps < 60) {
            setLocation(getExactX() + dx, getExactY() + dy);
            transitionSteps++;
        } else {
            // Transition finished: switch worlds
            is_transitioning = false;
            WorldController.changeRoom(targetRoom, getExactX(), getExactY(), currentDirection);
        }
    }
    
        public boolean hasMoved() {
        return moved;
    }
    

}
