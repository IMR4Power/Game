package application.ui;

import application.model.entities.BoardParameters;
import application.ui.controller.GameBoard;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Singleton of the window used for all the app
 */
public class MainFrame extends Stage {

    private static MainFrame singleton;

    /**
     * Private constructor for singleton. Creates a new window with the "Welcome" view
     */
    private MainFrame() {
        singleton = this;

        this.setTitle("IMR4Power - Puissance 4");
        this.home();

        this.show();
    }

    /**
     * Public accessor for the singleton instance
     *
     * @return The MainFrame instance of the app
     */
    public static MainFrame getMainFrame() {
        return Objects.requireNonNullElseGet(singleton, MainFrame::new);
    }

    /**
     * Displays the "Welcome" view.
     * <p>
     * This is a menu with 3 choices:
     * - New game
     * - Score board
     * - Quit
     */
    public void home() {
        Scene scene = new WelcomeScene();

        // Sets the scene and make the stage fit to it
        this.setScene(scene);
        this.sizeToScene();

        // Workaround because of problems on Linux with setResizable(false) not working with sizeToScene();
        if (System.getProperty("os.name").equals("Linux")) {
            this.setResizable(true);
        } else {
            this.setResizable(false);
        }
    }

    /**
     * Displays the "New Game" view.
     * <p>
     * This view lets the user to configure the game with:
     * - Number of rows
     * - Number of columns
     * - The players (between 2 and 4) with: a name and a color
     */
    public void openNewGame() {
        try {
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(MainFrame.class.getResource("/application/view/NewGameDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the "Score Board" view.
     * <p>
     * Displays a table with the saved scores of previous players. It shows:
     * - The player's name
     * - It's color
     * - It's score
     */
    public void openScoreBoard() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("/application/view/ScoreBoardDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Displays the "Game Board".
     * <p>
     * Displays the game with the grid and a panel on the right showing the players, their score for the game and the
     * current player to play.
     *
     * @param params Game parameters including: number of rows, number of columns, the player's list
     */
    public void startGame(BoardParameters params) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("/application/view/GameBoard.fxml"));

            SplitPane page = loader.load();
            Scene scene = new Scene(page);

            this.setScene(scene);
            this.sizeToScene();

            GameBoard ctrl = loader.getController();
            ctrl.startGame(params); // Launch the game
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
