package application;

import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author Dorian
 *
 */
public class GameBoard {
    @FXML
    private Group gameRoot;


	public GameBoard() {
    }



    //Création du plateau de jeu avec possibilité de modifier le nombee de ligne/colonne
    public void createPlateau(int row, int columns) {
        int largeur = 50;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                Rectangle rect = new Rectangle(((largeur ) * j) + 10, ((largeur ) * i) + 10, largeur, largeur);
                rect.setFill(Color.BLUE);
                gameRoot.getChildren().add(rect);
                Circle cercle = new Circle();
                cercle.setCenterX((rect.getX() + (rect.getWidth() / 2)));
                cercle.setCenterY((rect.getY() + (rect.getHeight() / 2)));
                cercle.setRadius(rect.getWidth() /2 - 1);
                cercle.setFill(Color.WHITE);
                gameRoot.getChildren().add(cercle);
            }
        }
    }
}
