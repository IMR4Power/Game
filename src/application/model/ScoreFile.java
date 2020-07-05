package application.model;

import application.model.entities.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class handling the score file
 */
public class ScoreFile {
    private List<Player> players;

    private static ScoreFile instance = null;
    private static final String path = "./scores.bin";

    /**
     * Getter returning the singleton instance of ScoreFile
     *
     * @return Instance of the ScoreFile
     */
    public static ScoreFile getScoreFile() {
        if (instance == null)
            instance = new ScoreFile();
        return instance;
    }

    /**
     * Private constructor for the singleton instance
     */
    private ScoreFile() {
        players = null;
    }

    /**
     * Adds the score of given players to the score file
     *
     * @param players The list of players to add to the file
     */
    public void addScores(List<Player> players) {
        getScores(); // Get the current scores in file. It sets internal "players" list

        /*
            In case the user saved more than once the scores of the current game, we remove the old player's scores
            from the list and then add them back with the new scores
         */
        for (Player p : players)
            this.players.remove(p);

        this.players.addAll(players); // append the players scores to the list

        try {
            // Save the player's list into the file using object serialization
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this.players);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the list of the players with theirs scores
     * <p>
     * Internally, the first time this method is called, it reads from the file and set the internal attributes "players"
     * with the retrieved list. The next calls directly returns the internal attributes to avoid multiple reads.
     *
     * @return The list of all the players with theirs scores from the file.
     */
    public List<Player> getScores() {
        if (players == null) { // If first call
            try {
                // Read the player's list from file
                FileInputStream file = new FileInputStream(path);
                ObjectInputStream in = new ObjectInputStream(file);

                players = (ArrayList<Player>) in.readObject();

                in.close();
            } catch (FileNotFoundException e) {
                players = new ArrayList<>();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            players.sort((p1, p2) -> Integer.compare(p2.getCurrentScore(), p1.getCurrentScore()));
        }

        return players; // Returns the player's list
    }
}
