package application.ui;

import application.model.entities.BoardParameters;
import application.model.entities.Player;
import application.ui.controller.GameBoard;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kevin
 */
public class MainFrame extends Stage {

    private static MainFrame singleton;

    private MainFrame() {
        singleton = this;
        this.setTitle("IMR4Power - Puissance 4");
        this.home();
        this.show();
    }

    public void home() {
        Scene scene = new WelcomeStage();
        this.setScene(scene);
        this.sizeToScene();
        if(System.getProperty("os.name").equals("Linux")){
            this.setResizable(true);
        } else {
            this.setResizable(false);
        }
    }

    public static MainFrame getMainFrame() {
        if (singleton != null)
            return singleton;
        else
            return new MainFrame();
    }

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

    public void startGame(int rows, int columns) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("/application/view/GameBoard.fxml"));

            SplitPane page = loader.load();
            Scene scene = new Scene(page);

            this.setScene(scene);
            this.sizeToScene();

            GameBoard ctrl = loader.getController();
            BoardParameters params = new BoardParameters(rows, columns);
            List<Player> players = new ArrayList<>();
            players.add(new Player("Jaune", Color.YELLOW));
            players.add(new Player("Rouge", Color.RED));
            ctrl.startGame(players, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame(BoardParameters params) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("/application/view/GameBoard.fxml"));

            SplitPane page = loader.load();
            Scene scene = new Scene(page);

            this.setScene(scene);
            this.sizeToScene();

            GameBoard ctrl = loader.getController();
            ctrl.startGame(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
