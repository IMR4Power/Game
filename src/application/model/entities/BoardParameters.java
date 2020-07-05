package application.model.entities;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 * Bean class for game parameters
 * <p>
 * Contains :
 * - The number of rows
 * - The number of Columns
 * - The player's list
 */
public class BoardParameters {
    private final IntegerProperty nbColumns;
    private final IntegerProperty nbRows;
    private final ObservableList<Player> players;

    /**
     * Creates a new BoardParameters
     * <p>
     * By default, this will add 2 players with colors Red and Yellow
     *
     * @param rows    Number of rows for the game
     * @param columns Number of columns for the game
     */
    public BoardParameters(int rows, int columns) {
        this.nbColumns = new SimpleIntegerProperty(columns);
        this.nbRows = new SimpleIntegerProperty(rows);

        players = FXCollections.observableArrayList();

        players.add(new Player("Joueur 1", Color.RED));
        players.add(new Player("Joueur 2", Color.YELLOW));
    }

    /**
     * Default constructor
     * <p>
     * Calls the previous constructor with default values 6 and 7 for rows and columns
     */
    public BoardParameters() {
        this(6, 7);
    }

    public IntegerProperty getNbColProperty() {
        return nbColumns;
    }

    public IntegerProperty getNbRowProperty() {
        return nbRows;
    }

    public ObservableList<Player> getPlayers() {
        return players;
    }

    //Accesseur
    public int getNbCol() {
        return nbColumns.getValue();
    }

    public int getNbRows() {
        return nbRows.getValue();
    }
}
