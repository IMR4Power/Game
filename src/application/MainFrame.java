package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author enora
 *
 */
public class MainFrame extends Stage {
	
	public MainFrame() {
		this.setTitle("IMR4Power - Puissance 4");
		this.home();
        this.show();
	}
	
	public void home() {
		Scene scene = new WelcomeStage(this);
        this.setScene(scene);
        this.setResizable(true);		
	}
	
	public void openNewGame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../FXML/newGameDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();

            NewGameDialog ctrl = loader.getController();
            ctrl.setMainFrame(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }
	
	public void openScoreBoard(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("../FXML/ScoreBoardDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();

            ScoreBoard ctrl = loader.getController();
            ctrl.setMainFrame(this);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
