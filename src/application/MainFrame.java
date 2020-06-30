package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.BoardParameters;
import model.Player;

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

        Scene scene = new WelcomeStage();

        this.setScene(scene);
        this.sizeToScene();

        this.setResizable(false);

        this.show();
	}
    
    public static MainFrame getMainFrame(){
        if(singleton != null) return singleton;
        else return new MainFrame();
    }

	public void openNewGame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("../FXML/NewGameDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();

            NewGameDialog ctrl = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void afficheTableauScore(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("../FXML/TableauScoreDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();

            NewGameDialog ctrl = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame(int rows, int columns) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainFrame.class.getResource("../FXML/GameBoard.fxml"));

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
            loader.setLocation(MainFrame.class.getResource("../FXML/GameBoard.fxml"));

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
