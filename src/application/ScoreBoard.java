/**
 * 
 */
package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Player;

/**
 * @author enora
 */
public class ScoreBoard {
	private MainFrame main;
	private ObservableList<Player> list;
	@FXML
	private Button retour;

	//Constructeur
	public ScoreBoard() {
		list = FXCollections.observableArrayList();
	}

	public void setMainFrame(MainFrame main) {
		this.main = main;
	}
	
	public void initialize() {
		retour.setOnMouseClicked(e -> main.home());
	}
	
}
