package application.model.entities;

import javafx.scene.paint.Color;

/**
 * Bean class representing a player's checker.
 * <p>
 * It only retains the player's color
 */
public class Checker {
    private final Color color;

    //Constructeur
    public Checker() {
        this(Color.BLUE);
    }

    public Checker(Player player) {
        this(player.getColor());
    }

    public Checker(Color color) {
        this.color = color;
    }

    //Assesseurs

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
}
