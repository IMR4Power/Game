package application;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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
    @FXML
    private Label labelJ1;
    @FXML
    private Label labelJ2;
    @FXML
    private Label labelJ3;
    @FXML
    private Label labelJ4;
    @FXML
    private Label labelColor1;
    @FXML
    private Label labelColor2;
    @FXML
    private Label labelColor3;
    @FXML
    private Label labelColor4;
    private List<Label> joueursLabel;
    private List<Label> colorsLabel;

    public GameBoard() {
        vBoxes = new ArrayList<VBox>();
        joueursLabel = new ArrayList<Label>();
        colorsLabel = new ArrayList<Label>();

        radiusChecker = 0;
    }

    public void initialize() {

        joueursLabel.add(labelJ1);
        joueursLabel.add(labelJ2);
        joueursLabel.add(labelJ3);
        joueursLabel.add(labelJ4);

        colorsLabel.add(labelColor1);
        colorsLabel.add(labelColor2);
        colorsLabel.add(labelColor3);
        colorsLabel.add(labelColor4);
    }

    public void StartGame(List<Joueur> playerList, BoardParameters params) {
        game = new Game(playerList, params);
        configPlayers(playerList);
        createPlateau(params);
    }

    private void configPlayers(List<Joueur> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            joueursLabel.get(i).setText(playerList.get(i).getName());
            colorsLabel.get(i).setText(playerList.get(i).getColor().toString());
            // TODO: Make it color the cell @Kevin?
        }
    }

    private void createPlateau(BoardParameters params) {
        createPlateau(params.getHauteurColonne(), params.getNbColonne());
    }

    // Création du plateau de jeu avec possibilité de modifier le nombee de
    // ligne/colonne
    private void createPlateau(int row, int columns) {
        for (int i = 0; i < columns; i++) {
            VBox vbox = new VBox();
            gameRoot.getChildren().add(vbox);
            vbox.setOnMouseClicked(e -> clicOnColums(vbox));
            vbox.setOnMouseEntered(e -> {
                vbox.setStyle("-fx-background-color: #00AAFF");
            });
            vbox.setOnMouseExited(e -> {
                vbox.setStyle("-fx-background-color: #0000FF");
            });
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

    private void updateColumns(int index, Columns columns) {
        VBox vbox = vBoxes.get(index);
        vbox.getChildren().clear();
        for (int i = columns.getHauteur()-1; i >= 0; i--) {
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
