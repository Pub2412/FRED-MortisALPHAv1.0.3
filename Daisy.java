import greenfoot.*;
import java.util.List;
import java.util.Arrays;


/**
 * Write a description of class Daisy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Daisy extends Actor {
    private int cooldownFrames;
    private static final int COOLDOWN_TIME = 60 * 25; // 25 seconds * 60 fps
    private List<String> allowedLevels;
    private GreenfootSound proximityMusic;
    private boolean musicPlaying = false;
    public static int moveDelay = 500; // Number of frames to wait between moves
    private int moveDelayCounter = 0;
    private String[] tauntSounds = { "taunts/t1.wav", "taunts/t2.wav", "taunts/t3.wav" };
    private GreenfootSound currentTaunt; 

    public Daisy(String[] roomsCanTeleport) {
        allowedLevels = Arrays.asList(roomsCanTeleport);
        cooldownFrames = COOLDOWN_TIME;
        setImage("lostsoul.png");
        //proximityMusic = new GreenfootSound("sfx/sare.wav");
    }

    public void act() {
    World world = getWorld();
    if (world == null) {
        stopAllSounds();
        return;
    }

    String currentLevel = world.getClass().getSimpleName();
    if (!allowedLevels.contains(currentLevel)) {
        stopAllSounds();
        removeSelfAndRestartCooldown();
        return;
    }

    Player player = getPlayerInWorld();

    // If player leaves the room, stop music
    if (player == null) {
        stopAllSounds();
        return;
    }

    // Jumpscare if touching player
    if (isTouching(Player.class)) {
        stopAllSounds();
        Greenfoot.setWorld(new DAISY_JUMPSCARE());
        return;
    }

    // Only move every 'moveDelay' frames
    if (moveDelayCounter <= 0) {
        chasePlayer(player);
        moveDelayCounter = moveDelay;
    } else {
        moveDelayCounter--;
    }

    // Teleport to player after cooldown
    if (cooldownFrames > 0) {
        cooldownFrames--;
    } else {
        playRandomTaunt(); // Play the taunt FIRST
        teleportToPlayer(player);
        cooldownFrames = COOLDOWN_TIME;
    }

    // Small proximity hitbox threshold (e.g., 50 pixels)
    int proximityThreshold = 1;
    if (distanceTo(player) <= proximityThreshold) {
        //startProximityMusic();
    } else {
        //stopProximityMusic();
    }
}

/** Returns the distance in pixels to the player */
private int distanceTo(Player player) {
    int dx = getX() - player.getX();
    int dy = getY() - player.getY();
    return (int)Math.sqrt(dx*dx + dy*dy);
}


    private void chasePlayer(Player player) {
        if (WorldController.isMessageShown()) { return; }
        int fredX = getX();
        int fredY = getY();
        int playerX = player.getX();
        int playerY = player.getY();
        int dx = Integer.compare(playerX, fredX);
        int dy = Integer.compare(playerY, fredY);
        setLocation(fredX + dx, fredY + dy);
    }

    private Player getPlayerInWorld() {
        List<Player> players = getWorld().getObjects(Player.class);
        if (!players.isEmpty()) return players.get(0);
        return null;
    }

    private void teleportToPlayer(Player player) {
        if (player != null) {
            setLocation(player.getX(), player.getY());
        }
    }

    private void playRandomTaunt() {
        stopCurrentTaunt(); // Stop any running taunt first
        int idx = Greenfoot.getRandomNumber(tauntSounds.length);
        currentTaunt = new GreenfootSound(tauntSounds[idx]);
        currentTaunt.play();
    }

    private void startProximityMusic() {
        // Only start if not already playing
        if (!musicPlaying) {
            proximityMusic.playLoop();
            musicPlaying = true;
        }
    }

    private void stopProximityMusic() {
        if (musicPlaying) {
            proximityMusic.stop();
            musicPlaying = false;
        }
    }

    private void stopCurrentTaunt() {
        if (currentTaunt != null) {
            currentTaunt.stop();
        }
    }

    // Stop music + taunt
    private void stopAllSounds() {
        stopProximityMusic();
        stopCurrentTaunt();
    }

    /** Removes demon, stops music, restarts cooldown on reappear */
    private void removeSelfAndRestartCooldown() {
        stopAllSounds();
        World w = getWorld();
        if (w != null) {
            w.removeObject(this);
        }
        cooldownFrames = COOLDOWN_TIME;
    }
}

