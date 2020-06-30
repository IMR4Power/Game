package application.ui.controller;

import application.model.entities.Player;
import application.ui.MainFrame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ScoreBoard {
	private ObservableList<Player> list;

	@FXML
	private Button back;

	//Constructeur
	public ScoreBoard() {
		list = FXCollections.observableArrayList();
	}

	public void initialize() {
		back.setOnMouseClicked(e -> MainFrame.getMainFrame().home());
	}
	
}
