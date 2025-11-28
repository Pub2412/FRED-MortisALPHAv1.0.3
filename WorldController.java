import greenfoot.World;
import greenfoot.Greenfoot;
import java.util.HashMap;
import greenfoot.*;
import java.io.*;

/**
 * Write a description of class WorldController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WorldController  
{    
    // Controls the player's starting position
    public static double playerX = 0;
    public static double playerY = 0;
    public static String playerDirection = "d";
    public static boolean movePlayer = false;
    private static MessageBox currentBox;
    public static String currentLevel = "";
    
    // Tracks puzzles
    // Basically, puzzles are stored here so that if you change
    // rooms, it still knows that it was solved.
    // Use isPuzzleSolved to check in an object if it has been solved.
    public static HashMap<String, Boolean> puzzles = new HashMap<>();
    
    public static void solvePuzzle(String puzzleID) {
        puzzles.put(puzzleID, true);
    }
    public static boolean isPuzzleSolved(String puzzleID) {
        return puzzles.getOrDefault(puzzleID, false);
    }
    
    public static void reset() {
        currentLevel = "";
        playerX = 100;
        playerY = 100;
        playerDirection = "d";
        puzzles.clear();
        closeCurrentMessage();
        MusicPlayer.StopMus();
    }
    
    public static Room getRoomFromString(String className) {
        try {
            Class<?> world_class = Class.forName(className);
            return (Room) world_class.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static World getWorldFromString(String className) {
        try {
            Class<?> world_class = Class.forName(className);
            return (World) world_class.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void changeRoom(String roomName, double startX, double startY, String direction) {
        Room room = getRoomFromString(roomName);
        playerX = startX;
        playerY = startY;
        playerDirection = direction;
        movePlayer = true;
        currentLevel = roomName;
        Greenfoot.setWorld(room);
    }
    public static void changeRoomNoTransition(String worldName) {
        World world = getWorldFromString(worldName);
        movePlayer = false;
        boolean sherwinGay = true;
        if (sherwinGay && WorldController.isMessageShown()) {
            WorldController.closeCurrentMessage();
            currentBox = null;
        }
        Greenfoot.setWorld(world);
    }
    public static void startRoomTransition() {
        World world = (greenfoot.core.WorldHandler.getInstance()).getWorld();
        for (Object obj : world.getObjects(null)) {
            if (!(obj instanceof Player)) {
                world.removeObject((Actor)obj);
            }
        }
        world.setBackground("BG_BLACK.png");
    }
    
    // Message system
    public static boolean isMessageShown() { return currentBox != null; }
    public static void showMessage(String message) {
        currentBox = new MessageBox(message);
        World world = (greenfoot.core.WorldHandler.getInstance()).getWorld();
        world.addObject(currentBox,world.getWidth()/2,world.getHeight() - 1);
    }
    public static void closeCurrentMessage() {
        if (!isMessageShown() || !canCloseMessage()) { return; }
        World world = (greenfoot.core.WorldHandler.getInstance()).getWorld();
        world.removeObject((Actor)currentBox);
        currentBox = null;
    }
    public static boolean canCloseMessage() { return currentBox.canClose(); }
    
    public static void save() {
        try(PrintWriter writer = new PrintWriter(new FileWriter("save.dat"))) {
            writer.println("LEVEL=" + currentLevel);
            writer.println("PLAYER_X=" + playerX);
            writer.println("PLAYER_Y=" + playerY);
            writer.println("PLAYER_DIR=" + playerDirection);
            
            for (HashMap.Entry<String, Boolean> entry : puzzles.entrySet()) {
                writer.println("PUZZLE_" + entry.getKey() + "=" + entry.getValue());
            }
            
            //System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
    }
    
    public static void load() throws IOException {
        if (!doesSaveExist()) return;
        try (BufferedReader reader = new BufferedReader(new FileReader("save.dat"))) {
            puzzles.clear();
            
            String line;
            
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length != 2) continue;
                
                String key = parts[0];
                String value = parts[1];
                
                switch (key) {
                    case "LEVEL": currentLevel = value; break;
                    case "PLAYER_X": playerX = Double.parseDouble(value); break;
                    case "PLAYER_Y": playerY = Double.parseDouble(value); break;
                    case "PLAYER_DIR": playerDirection = value; break;
                    default:
                        if (key.startsWith("PUZZLE_")) {
                            String puzzleID = key.substring("PUZZLE_".length());
                            puzzles.put(puzzleID, Boolean.parseBoolean(value));
                        }
                        break;
                }
                
            }
            
            if (currentLevel != null && currentLevel != "") {
                changeRoom(currentLevel, playerX, playerY, playerDirection);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error loading save file: " + e.getMessage());
        }
    }
    
    public static boolean doesSaveExist() {
        File file = new File("save.dat");
        if (!file.exists()) {
            //System.out.println("No save file found");
            return false;
        }
        return true;
    }
}
