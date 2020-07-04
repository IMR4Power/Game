package application.model.entities;

import javafx.beans.property.*;
import javafx.scene.paint.Color;

public class Player {
    private final StringProperty name;
    private final ObjectProperty<Color> color;
    private final IntegerProperty currentScore;

    //Constructeur
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

    public void wonAGame() {
        this.currentScore.set(this.currentScore.get() + 1);
    }

}