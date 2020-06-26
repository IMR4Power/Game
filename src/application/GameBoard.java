/**
 * 
 */
package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * @author enora
 *
 */
public class GameBoard extends Scene {
	public GameBoard(MainFrame main, int row, int columns) {
        super(new VBox());
        //main.hide();
        Group root = new Group();
        //Scene scene = main.getScene();
        this.setRoot(root);

        createPlateau(root, row, columns);

        main.setScene(this);
        main.sizeToScene();
        //primaryStage.show();
    }

    //Création du plateau de jeu avec possibilité de modifier le nombee de ligne/colonne
    private void createPlateau(Group root, int row, int columns) {
        //Rectangle[] rectangles = new Rectangle[42];
        //Circle[] cercles = new Circle[42];
        int largeur = 50;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < columns; j++) {
                Rectangle rect = new Rectangle(((largeur ) * j) + 10, ((largeur ) * i) + 10, largeur, largeur);
                rect.setFill(Color.BLUE);
                root.getChildren().add(rect);
                Circle cercle = new Circle();
                cercle.setCenterX((rect.getX() + (rect.getWidth() / 2)));
                cercle.setCenterY((rect.getY() + (rect.getHeight() / 2)));
                cercle.setRadius(rect.getWidth() /2 - 1);
                cercle.setFill(Color.WHITE);
                root.getChildren().add(cercle);
            }
        }

    }
}
