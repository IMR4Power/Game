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
    private final ObservableList<Joueur> players;

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

        players.add(new Joueur("Joueur 1", Color.RED));
        players.add(new Joueur("Joueur 2", Color.YELLOW));
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

    public ObservableList<Joueur> getPlayers() {
        return players;
    }

    //Accesseur
    public int getNbColonne() {
        return nbColumns.getValue();
    }

    public int getHauteurColonne() {
        return nbRow.getValue();
    }
}
