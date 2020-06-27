package application;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author Dorian
 *
 */
public class GameBoard {
    @FXML
    private HBox gameRoot;
    private List<VBox> vBoxes;

    public GameBoard() {
        vBoxes = new ArrayList<VBox>();
    }

    // Création du plateau de jeu avec possibilité de modifier le nombee de
    // ligne/colonne
    public void createPlateau(int row, int columns) {
        int largeur = 50;
        for (int i = 0; i < columns; i++) {
            VBox vbox = new VBox();
            gameRoot.getChildren().add(vbox);
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5));
            vbox.setStyle("-fx-background-color: #0000FF"); //fond bleu
            vBoxes.add(vbox);
            Double h = gameRoot.heightProperty().doubleValue();
            Double l = gameRoot.widthProperty().doubleValue();
            Double hCircle = (h / row);
            Double lCircle = (l / columns);
            Double radius = Math.min(lCircle, hCircle) / 2 - 5 ;// 5 -> result of the padding
            for (int j = 0; j < row; j++) {
                Circle cercle = new Circle();
                cercle.setRadius(radius);
                cercle.setFill(Color.WHITE);
                vbox.getChildren().add(cercle);
            }
        }
        gameRoot.setFillHeight(false);
    }

    public void initialize() {
    }
}
