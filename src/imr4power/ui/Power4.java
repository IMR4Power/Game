package imr4power.ui;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Power4 {

    public Power4(Stage primaryStage) {
        primaryStage.hide();
        Group root = new Group();
        Scene scene = primaryStage.getScene();
        scene.setRoot(root);

        createPlateau(root);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void createPlateau(Group root) {
        Rectangle[] rectangles = new Rectangle[42];
        Circle[] cercles = new Circle[42];
        int largeur = 20;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                Rectangle rect = new Rectangle(((largeur+1) * j) + 10, ((largeur+1) * i) + 10, largeur, largeur);
                rect.setFill(Color.BLUE);
                root.getChildren().add(rect);
                Circle cercle = new Circle((rect.getX() + (rect.getX()/2)), (rect.getY() + (rect.getY()/2)), (rect.getHeight()/2)-1);
                cercle.setFill(Color.WHITE);
                root.getChildren().add(cercle);
            }
        }

    }
}