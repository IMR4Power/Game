package application.model.entities;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Bean class representing a Player
 */
public class Player implements Serializable {
    private StringProperty name;
    private ObjectProperty<Color> color;
    private IntegerProperty currentScore;

    private static final long serialVersionUID = 1L;

    /**
     * Create a Player from a name and a color
     *
     * @param name  Player's name
     * @param color Player's color
     */
    public Player(String name, Color color) {
        this.name = new SimpleStringProperty(name);
        this.color = new SimpleObjectProperty<>(color);
        this.currentScore = new SimpleIntegerProperty(0);
    }

    //Accesseur
    public String getName() {
        return name.getValue();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public ObjectProperty<Color> getColorProperty() {
        return color;
    }

    public Color getColor() {
        return color.getValue();
    }

    //Modificateur
    public void setName(String newName) {
        name.setValue(newName);
    }

    public void setColor(Color newColor) {
        color.setValue(newColor);
    }

    public IntegerProperty getScoreProperty() {
        return this.currentScore;
    }

    public int getCurrentScore() {
        return currentScore.get();
    }

    /**
     * Updates the player's score by adding 1 point
     */
    public void wonAGame() {
        this.currentScore.set(this.currentScore.get() + 1);
    }

    /**
     * Method used to deserialize a player's object
     *
     * @param in The input stream from where reading objects
     * @throws IOException Thrown when error occurs in reading from input stream
     */
    private void readObject(ObjectInputStream in) throws IOException {
        name = new SimpleStringProperty(in.readUTF());
        color = new SimpleObjectProperty<>(Color.valueOf(in.readUTF()));
        currentScore = new SimpleIntegerProperty(in.readInt());
    }

    /**
     * Method used to serialize a player's object into an object output stream
     *
     * @param out The output stream in where put the player's data
     * @throws IOException Thrown when error occurs while writing data into the stream
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(name.getValue());
        out.writeUTF(color.getValue().toString());
        out.writeInt(currentScore.get());
    }

}