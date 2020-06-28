package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

/**
 * @author enora
 */
public class BoardParameters {
    private final IntegerProperty nbColumns;
    private final IntegerProperty nbRow;
    private final ObservableList<Player> players;

    /**
     * Constructeur
     *
     * @param row
     * @param columns
     */
    public BoardParameters(int row, int columns) {
        this.nbColumns = new SimpleIntegerProperty(columns);
        this.nbRow = new SimpleIntegerProperty(row);

        players = FXCollections.observableArrayList();

        players.add(new Player("Joueur 1", Color.RED));
        players.add(new Player("Joueur 2", Color.YELLOW));
    }

    public BoardParameters() {
        this(4, 4);
    }

    public IntegerProperty getNbColProperty() {
        return nbColumns;
    }

    public IntegerProperty getNbRowProperty() {
        return nbRow;
    }

    public ObservableList<Player> getPlayers() {
        return players;
    }

    //Accesseur
    public int getNbCol() {
        return nbColumns.getValue();
    }

    public int getNbRow() {
        return nbRow.getValue();
    }
}
