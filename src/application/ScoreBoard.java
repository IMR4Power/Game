/**
 * 
 */
package application;

import model.Joueur;
import application.Main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * @author enora
 *
 */
public class ScoreBoard {
	private MainFrame main;
	private ObservableList<Joueur> list;
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
