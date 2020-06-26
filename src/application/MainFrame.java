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

        Scene scene = new WelcomeStage(this);

        this.setScene(scene);
        //this.sizeToScene();

        this.setResizable(true);

        this.show();
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
}
