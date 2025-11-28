import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LEVEL1_MAZE_DOOR extends Interactable
{
    private String nextRoom;
    private String doorName;
    private String sprite1;
    private String sprite2;
    private int spriteIndex = 0;
    private GreenfootSound currentSound;
    
    public LEVEL1_MAZE_DOOR(String nextRoom, String doorName, String sprite1, String sprite2) {
        this.nextRoom = nextRoom;
        this.doorName = doorName;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        setImage(sprite1);
    }
    
    
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
            if (LEVEL1_PuzzleHub.TotalAm() == 6) {
                WorldController.showMessage("DYBBUK");
                GreenfootSound sound2 = new GreenfootSound("lvl1_d1/int_8.wav");
                sound2.play();
                setImage(sprite2);              
                Greenfoot.delay(120);  
                GreenfootSound sound = new GreenfootSound("sfx/entrydoorswing.wav");
                sound.play();
                WorldController.changeRoomNoTransition(nextRoom);
                return;
            } else {
                WorldController.showMessage("THE DOOR IS LOCKED");
                GreenfootSound sound = new GreenfootSound("doorlocked.wav");
                sound.play();
            }
        } 
    }
}
