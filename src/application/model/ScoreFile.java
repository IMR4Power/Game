package application.model;

import application.model.entities.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreFile {
    private List<Player> players;

    private static ScoreFile instance = null;
    private static final String path = "./scores.bin";

    public static ScoreFile getScoreFile() {
        if (instance == null)
            instance = new ScoreFile();
        return instance;
    }

    private ScoreFile() {
        players = null;
    }

    public void addScores(List<Player> players) {
        getScores();

        for (Player p : players)
            this.players.remove(p);

        this.players.addAll(players);

        try {
            FileOutputStream file = new FileOutputStream(path);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this.players);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Player> getScores() {
        if (players == null) {
            try {
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

        return players;
    }
}
