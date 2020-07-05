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
        return Objects.requireNonNullElseGet(singleton, MainFrame::new);
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
