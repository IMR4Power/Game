package application;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dorian
 */
public class GameBoard {
    private final List<VBox> vBoxes;
    private double radiusChecker;
    private Game game;
    private final List<Label> playersLabel;
    private final List<Label> colorsLabel;

    @FXML
    private HBox gameRoot;
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
    @FXML
    private Button quit;

    public GameBoard() {
        vBoxes = new ArrayList<>();
        playersLabel = new ArrayList<>();
        colorsLabel = new ArrayList<>();

        radiusChecker = 0;
    }

    public void initialize() {
        playersLabel.add(labelJ1);
        playersLabel.add(labelJ2);
        playersLabel.add(labelJ3);
        playersLabel.add(labelJ4);

        colorsLabel.add(labelColor1);
        colorsLabel.add(labelColor2);
        colorsLabel.add(labelColor3);
        colorsLabel.add(labelColor4);

        quit.setOnMouseClicked(e -> System.exit(0));
    }

    public void startGame(List<Player> playerList, BoardParameters params) {
        game = new Game(playerList, params);
        configPlayers(playerList);
        createBoard(params);
    }

    public void startGame(BoardParameters params) {
        startGame(params.getPlayers(), params);
    }

    private void configPlayers(List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            playersLabel.get(i).setText(playerList.get(i).getName());
            colorsLabel.get(i).setBackground(new Background(new BackgroundFill(playerList.get(i).getColor(), null, null)));
        }
    }

    private void createBoard(BoardParameters params) {
        createBoard(params.getNbRows(), params.getNbCol());
    }

    // Création du plateau de jeu avec possibilité de modifier le nombee de
    // ligne/colonne
    private void createBoard(int rows, int columns) {
        for (int i = 0; i < columns; i++) {
            VBox vbox = new VBox();
            gameRoot.getChildren().add(vbox);

            vbox.setOnMouseClicked(e -> clickOnColumn(vbox));
            vbox.setOnMouseEntered(e -> vbox.setStyle("-fx-background-color: #00AAFF"));
            vbox.setOnMouseExited(e -> vbox.setStyle("-fx-background-color: #0000FF"));
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5));
            vbox.setStyle("-fx-background-color: #0000FF"); // fond bleu
            vBoxes.add(vbox);

            double h = gameRoot.heightProperty().doubleValue();
            double l = gameRoot.widthProperty().doubleValue();

            double hCircle = (h / rows);
            double lCircle = (l / columns);

            radiusChecker = Math.min(lCircle, hCircle) / 2 - 5;// 5 -> result of the padding

            for (int j = 0; j < rows; j++) {
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
        for (int i = columns.getHeight() - 1; i >= 0; i--) {
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

    private void clickOnColumn(VBox vBox) {
        int index = vBoxes.indexOf(vBox);
        boolean hasEnded = game.playChecker(index);
        updateColumns(index, game.getGameBoard().getColumns().get(index));

        if (hasEnded)
            endGame();
    }

    private void endGame() {
        for (VBox layout : vBoxes)
            layout.setOnMouseClicked(null);

        Alert.AlertType type = (game.isADraw()) ? Alert.AlertType.WARNING : Alert.AlertType.INFORMATION;

        Alert endGame = new Alert(type);
        endGame.setTitle("Résultat de la partie");
        endGame.setHeaderText(null);

        if (game.isADraw()) {
            endGame.setContentText("Fin de la partie : Égalité !");
        } else {
            endGame.setContentText("Fin de la partie : " + game.getWinner().getName() + " a gagné(e) !");
        }

        endGame.showAndWait();
    }
}
