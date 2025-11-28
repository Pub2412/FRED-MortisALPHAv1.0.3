import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LEVEL1_FredDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LEVEL1_FredDoor extends Interactable
{
    private String nextRoom;
    private String doorName;
    private String sprite1;
    private String sprite2;
    private int spriteIndex = 0;
    private long lastSwitchTime = System.currentTimeMillis();
    private boolean hasKey = false;
    private GreenfootSound currentSound;
    
    public LEVEL1_FredDoor(String nextRoom, String doorName, String sprite1, String sprite2) {
        this.nextRoom = nextRoom;
        this.doorName = doorName;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        setImage(sprite1);
    }
    public void act() {
        // Switch sprites every 10 seconds
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastSwitchTime > 5000) { // 10,000 ms = 10 seconds
            spriteIndex = 1 - spriteIndex;  // Toggles between 0 and 1
            setImage(spriteIndex == 0 ? sprite1 : sprite2);
            lastSwitchTime = currentTime;
        }
    }
public void setHasKey(boolean value) { hasKey = value; }    
public void interact() {
    Player player = getWorld().getObjects(Player.class).stream().findFirst().orElse(null);
    World currentWorld = getWorld();
    
     if (currentWorld instanceof LEVEL1_s6) {
                GreenfootSound sound = new GreenfootSound("sfx/entrydoorswing.wav");
                sound.play();
                WorldController.changeRoomNoTransition("LVL1_Tscreen");
                return;
            }
    
    if (player != null) {
        if (hasKey == true) {
           WorldController.changeRoomNoTransition(nextRoom);
        } else {
            WorldController.showMessage("THE DOOR IS LOCKED");
            GreenfootSound sound = new GreenfootSound("doorlocked.wav");
            sound.play();
        }
    } 
}
}

