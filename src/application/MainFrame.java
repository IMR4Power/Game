package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.BoardParameters;
import model.Joueur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author enora
 *
 */
public class MainFrame extends Stage {
    private static MainFrame singleton;

	private MainFrame() {
        singleton = this;
		this.setTitle("IMR4Power - Puissance 4");

        Scene scene = new WelcomeStage(this);

        this.setScene(scene);
        //this.sizeToScene();

        this.setResizable(true);

        this.show();
	}
    
    public static MainFrame getMainFrame(){
        if(singleton != null) return singleton;
        else return new MainFrame();
    }

	public void openNewGame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../FXML/NewGameDialog.fxml"));

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
            loader.setLocation(Main.class.getResource("../FXML/TableauScoreDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();

            NewGameDialog ctrl = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame(int row, int columns){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../FXML/GameBoard.fxml"));

            SplitPane page = loader.load();
            Scene scene = new Scene(page);
            
            this.setScene(scene);
            this.sizeToScene();

            GameBoard ctrl = loader.getController();
            BoardParameters params = new BoardParameters(row, columns);
            List<Joueur> joueurs = new ArrayList<>();
            joueurs.add(new Joueur("Jaune", Color.YELLOW));
            joueurs.add(new Joueur("Rouge", Color.RED));
            ctrl.StartGame(joueurs, params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame(BoardParameters params) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../FXML/GameBoard.fxml"));

            SplitPane page = loader.load();
            Scene scene = new Scene(page);

            this.setScene(scene);
            this.sizeToScene();

            GameBoard ctrl = loader.getController();
            ctrl.StartGame(params);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
