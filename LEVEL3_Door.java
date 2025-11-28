import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LEVEL3_Door extends Interactable
{
    private String nextRoom;
    private String doorName;
    private String sprite1;
    private String sprite2;
    private int spriteIndex = 0;
    private GreenfootSound currentSound;
    
    public LEVEL3_Door(String nextRoom, String doorName, String sprite1, String sprite2) {
        this.nextRoom = nextRoom;
        this.doorName = doorName;
        this.sprite1 = sprite1;
        this.sprite2 = sprite2;
        setImage(sprite1);
    }
    
    
    public void interact() {
        Player player = getWorld().getObjects(Player.class).stream().findFirst().orElse(null);
        World currentWorld = getWorld();
        
        if (player != null) {
            if (LEVEL3.TotalPort() == 4) {
                MusicPlayer.StopMus();
                WorldController.showMessage("FREE US, YOU ARE OUR ONLY HOPE");
                GreenfootSound sound2 = new GreenfootSound("lvl3_d1/int_12.wav");
                sound2.play();            
                Greenfoot.delay(200);  
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
