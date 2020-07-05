package application.ui.controller;

import application.model.Game;
import application.model.ScoreFile;
import application.model.entities.BoardParameters;
import application.model.entities.Checker;
import application.model.entities.Column;
import application.model.entities.Player;
import application.ui.MainFrame;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for the GameBoard view
 */
public class GameBoard {
    private final List<VBox> vBoxes; // List of VBox representing the board's columns
    private double radiusChecker; // Contains the radius to draw the checkers

    private Game game; // Game from model used to play the game.

    // Lists for the player's labels
    private final List<Label> playersLabel;
    private final List<Label> colorsLabel;
    private final List<Label> scoreLabel;

    // List of the players
    private final List<Player> players;

    @FXML
    private HBox gameRoot; // Layout containing the board
    @FXML
    private Button quit;
    @FXML
    private Button save;
    @FXML
    private Label labelCurrent; // Label indicating the current player
    @FXML
    private Button back;

    // The 4 labels to display the player's names
    @FXML
    private Label labelJ1;
    @FXML
    private Label labelJ2;
    @FXML
    private Label labelJ3;
    @FXML
    private Label labelJ4;

    // The 4 labels to display the player's colors
    @FXML
    private Label labelColor1;
    @FXML
    private Label labelColor2;
    @FXML
    private Label labelColor3;
    @FXML
    private Label labelColor4;

    // The 4 labels to display the player's scores
    @FXML
    private Label labelScore1;
    @FXML
    private Label labelScore2;
    @FXML
    private Label labelScore3;
    @FXML
    private Label labelScore4;

    public GameBoard() {
        vBoxes = new ArrayList<>();
        playersLabel = new ArrayList<>();
        colorsLabel = new ArrayList<>();
        scoreLabel = new ArrayList<>();
        players = new ArrayList<>();

        radiusChecker = 0;
    }

    /**
     * Called after ui has been initialized.
     * <p>
     * Adds the labels in their corresponding lists. Binds button's onMouseClicked event to their callbacks
     */
    public void initialize() {
        playersLabel.add(labelJ1);
        playersLabel.add(labelJ2);
        playersLabel.add(labelJ3);
        playersLabel.add(labelJ4);

        colorsLabel.add(labelColor1);
        colorsLabel.add(labelColor2);
        colorsLabel.add(labelColor3);
        colorsLabel.add(labelColor4);

        scoreLabel.add(labelScore1);
        scoreLabel.add(labelScore2);
        scoreLabel.add(labelScore3);
        scoreLabel.add(labelScore4);

        quit.setOnMouseClicked(e -> System.exit(0)); // Exit the app
        back.setOnMouseClicked(e -> MainFrame.getMainFrame().home()); // Returns to the Welcome menu
        save.setOnMouseClicked(e -> { //Save player's scores to the file and display a modal to notify the user
            ScoreFile.getScoreFile().addScores(players);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Succès");
            alert.setContentText("Scores sauvegardés avec succès !");

            alert.showAndWait();

            save.setDisable(true); // Disable the button until the next ended game
        });
    }

    /**
     * Starts a game according to board parameters
     *
     * @param params The parameters to use to create the game. It contains columns number, rows number and player list
     */
    public void startGame(BoardParameters params) {
        game = new Game(params); // Create a new Game which will handle the game
        labelCurrent.setText(game.getCurrentPlayer().getName()); // Update current user label
        configPlayers(params.getPlayers()); // Configure players labels
        createBoard(params); // Create the game board view
        players.addAll(params.getPlayers()); // Add all the players inside the attribute.
    }

    /**
     * Configure all the player's labels according to the players list
     *
     * @param playerList The list of the player for this game
     */
    private void configPlayers(List<Player> playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            playersLabel.get(i).setText(playerList.get(i).getName());
            colorsLabel.get(i)
                    .setBackground(new Background(new BackgroundFill(playerList.get(i).getColor(), null, null)));
            scoreLabel.get(i).textProperty().bind(playerList.get(i).getScoreProperty().asString()); // Binds the score label to the player's score
        }
    }

    /**
     * Creating a board view according to a board parameter
     *
     * @param params Board parameter on which base the view creation
     */
    private void createBoard(BoardParameters params) {
        createBoard(params.getNbRows(), params.getNbCol());
    }

    /**
     * Creates a board view according to a number of rows and columns
     * <p>
     * It creates it dynamically in order to be flexible for each number of rows / columns
     *
     * @param rows    Number of rows to generate
     * @param columns Number of columns to generate
     */
    private void createBoard(int rows, int columns) {
        // computes coordinates to draw the circles
        double h = gameRoot.heightProperty().doubleValue();
        double l = gameRoot.widthProperty().doubleValue();

        double hCircle = (h / rows);
        double lCircle = (l / columns);

        radiusChecker = Math.min(lCircle, hCircle) / 2 - 5;// 5 -> result of the padding

        for (int i = 0; i < columns; i++) {
            VBox vbox = new VBox(); // Create a VBox for each column
            gameRoot.getChildren().add(vbox);

            // Bind some events to callbacks
            vbox.setOnMouseClicked(e -> clickOnColumn(vbox)); // Handles a click to put a checker in the column
            vbox.setOnMouseEntered(e -> vbox.setStyle("-fx-background-color: #00AAFF")); // Modify style when mouse is over the column
            vbox.setOnMouseExited(e -> vbox.setStyle("-fx-background-color: #0000FF")); // Put the current style back when mouse exits the column
            vbox.setSpacing(5);
            vbox.setPadding(new Insets(5));
            vbox.setStyle("-fx-background-color: #0000FF"); // blue background
            vBoxes.add(vbox);

            // Creates the white circles and add them to the column
            for (int j = 0; j < rows; j++) {
                Circle cercle = new Circle();
                cercle.setRadius(radiusChecker);
                cercle.setFill(Color.WHITE);
                vbox.getChildren().add(cercle);
            }
        }
        gameRoot.setFillHeight(false);
    }

    /**
     * Called to update a column view with a new checker
     *
     * @param index  The column index
     * @param column The concerned column
     */
    private void updateColumns(int index, Column column) {
        VBox vbox = vBoxes.get(index);
        vbox.getChildren().clear();
        for (int i = column.getHeight() - 1; i >= 0; i--) {
            Checker checker = column.getChecker(i);
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

    /**
     * Handles a player's click on a column
     * <p>
     * It informs the model of where the new checker has been played. Then it checks if the game ended or not and updates
     * the column's view.
     *
     * @param vBox The VBox corresponding to the column where the player clicked
     */
    private void clickOnColumn(VBox vBox) {
        int index = vBoxes.indexOf(vBox);
        boolean hasEnded = false;
        if (!game.getGameBoard().getColumns().get(index).isFull()) { // If the column isn't full
            hasEnded = game.playChecker(index);
            updateColumns(index, game.getGameBoard().getColumns().get(index)); // Update column's view
            labelCurrent.setText(game.getCurrentPlayer().getName()); // Update current player label
        }

        if (hasEnded) // If the game has ended
            endGame(); // handle it
    }

    /**
     * Handles the end of the game.
     * <p>
     * It deactivates the callbacks on the columns, then displays a modal telling who has win or if there is a draw.
     * It asks too if players want to play another game.
     * <p>
     * If yes, it resets teh game and enables the save button
     * Else the app returns back to the welcome menu
     */
    private void endGame() {
        // Deactivate events on columns
        for (VBox col : vBoxes) {
            col.setOnMouseEntered(null);
            col.setOnMouseExited(null);
            col.setOnMouseClicked(null);
        }

        // Displays the modal window giving the game result and asking for a new game
        Alert.AlertType type = (game.isADraw()) ? Alert.AlertType.WARNING : Alert.AlertType.INFORMATION;

        Alert endGame = new Alert(type, "Voulez-vous rejouer ?", ButtonType.YES, ButtonType.NO);
        endGame.setTitle("Résultat de la partie");

        if (game.isADraw()) {
            endGame.setHeaderText("Fin de la partie : Égalité !");
        } else {
            endGame.setHeaderText("Fin de la partie : " + game.getWinner().getName() + " a gagné(e) !");
        }

        endGame.showAndWait().filter(response -> (response == ButtonType.YES || response == ButtonType.NO))
                .ifPresent(response -> {
                    if (response == ButtonType.YES) { // If a new game, enable save button and resets game
                        save.setDisable(false);
                        resetGame();
                    } else
                        MainFrame.getMainFrame().home(); // Else return to Welcome menu
                });
    }

    /**
     * Resets the game.
     * <p>
     * Set back the callbacks on columns, resets the Game instance and turns all the circles in columns to white
     */
    private void resetGame() {
        game.resetGame();

        for (VBox col : vBoxes) {
            col.setOnMouseClicked(e -> clickOnColumn(col));
            col.setOnMouseEntered(e -> col.setStyle("-fx-background-color: #00AAFF"));
            col.setOnMouseExited(e -> col.setStyle("-fx-background-color: #0000FF"));

            col.setStyle("-fx-background-color: #0000FF");

            for (Node node : col.getChildren()) {
                Circle c = (Circle) node;
                c.setFill(Color.WHITE);
            }
        }
    }
}
