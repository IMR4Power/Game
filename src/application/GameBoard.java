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
import model.BoardParameters;
import model.Checker;
import model.Columns;
import model.Game;
import model.Joueur;

/**
 * @author Dorian
 *
 */
public class GameBoard {
    @FXML
    private HBox gameRoot;
    private List<VBox> vBoxes;
    private double radiusChecker;
    private Game game;

    public GameBoard() {
        vBoxes = new ArrayList<VBox>();
        radiusChecker = 0;
    }

    public void startGame(List<Joueur> playerList, BoardParameters params){
        game = new Game(playerList, params);
        createPlateau(params);
    }

    public void createPlateau(BoardParameters params){
        createPlateau(params.getHauteurColonne(), params.getNbColonne());
    }

    // Création du plateau de jeu avec possibilité de modifier le nombee de
    // ligne/colonne
    public void createPlateau(int row, int columns) {
        for (int i = 0; i < columns; i++) {
            VBox vbox = new VBox();
            gameRoot.getChildren().add(vbox);
            vbox.setOnMouseClicked(e -> clicOnColums(vbox));
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5));
            vbox.setStyle("-fx-background-color: #0000FF"); // fond bleu
            vBoxes.add(vbox);
            Double h = gameRoot.heightProperty().doubleValue();
            Double l = gameRoot.widthProperty().doubleValue();
            Double hCircle = (h / row);
            Double lCircle = (l / columns);
            radiusChecker = Math.min(lCircle, hCircle) / 2 - 5;// 5 -> result of the padding
            for (int j = 0; j < row; j++) {
                Circle cercle = new Circle();
                cercle.setRadius(radiusChecker);
                cercle.setFill(Color.WHITE);
                vbox.getChildren().add(cercle);
            }
        }
        gameRoot.setFillHeight(false);
    }

    public void updateColumns(int index, Columns columns) {
        VBox vbox = vBoxes.get(index);
        vbox.getChildren().clear();
        for (int i = columns.getHauteur(); i > 0; --i) {
            Checker checker = columns.getChecker(i);
            Circle cercle = new Circle();
            cercle.setRadius(radiusChecker);
            if (checker != null) {
                cercle.setFill(checker.getColor());
            } else {
                cercle.setFill(Color.WHITE);
            }
            vbox.getChildren().add(cercle);
        }
    }


    private void clicOnColums(VBox vBox) {
        int index = vBoxes.indexOf(vBox);
        game.JouerPion(index);
        updateColumns(index, game.getGameBoard().getColumns().get(index));
    }

}
