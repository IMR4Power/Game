package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

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
            this.sizeToScene();;

            GameBoard ctrl = loader.getController();
            ctrl.createPlateau(row, columns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
