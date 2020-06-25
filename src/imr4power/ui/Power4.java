package imr4power.ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class Power4 extends Scene{

    public Power4(MainFrame main) {
        super(new VBox());
        //main.hide();
        Group root = new Group();
        //Scene scene = main.getScene();
        this.setRoot(root);

        createPlateau(root, 5, 3);

        main.setScene(this);
        main.sizeToScene();
        //primaryStage.show();
    }

    //Création du plateau de jeu avec possibilité de modifier le nombe de ligne/colonne
    private void createPlateau(Group root, int ligne, int colonne) {
        //Rectangle[] rectangles = new Rectangle[42];
        //Circle[] cercles = new Circle[42];
        int largeur = 50;
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
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