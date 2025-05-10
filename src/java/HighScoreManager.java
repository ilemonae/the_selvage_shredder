import java.io.*;
import java.util.*;

public class HighScoreManager {
    private static final String FILE_PATH = "highscores.ser";
    
    // Save high score objects
    public void saveHighScores(ArrayList<HighScore> highScores) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(highScores);
        } catch (IOException e) {
            System.err.println("Error saving high scores: " + e.getMessage());
        }
    }
    
    // Load high score objects
    @SuppressWarnings("unchecked")
    public ArrayList<HighScore> loadHighScores() {
        ArrayList<HighScore> highScores = new ArrayList<>();
        
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            highScores = (ArrayList<HighScore>) ois.readObject();
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, return empty list
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading high scores: " + e.getMessage());
        }
        
        return highScores;
    }
}

// Make sure your HighScore class is Serializable
class HighScore implements Serializable {
    private static final long serialVersionUID = 1L; // Important for version control
    
    private String playerName;
    private int score;
    private Date date;
    
    // Constructor, getters, setters, etc.
}