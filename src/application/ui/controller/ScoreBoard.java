package application.ui.controller;

import application.model.ScoreFile;
import application.model.entities.Player;
import application.ui.MainFrame;
import application.ui.controller.customTableViewCell.ColorPickerTableCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;

public class ScoreBoard {
	private final ObservableList<Player> list;

	@FXML
	private Button back;

	@FXML
	private TableView<Player> playerTableView;
	@FXML
	private TableColumn<Player, String> nameColumn;
	@FXML
	private TableColumn<Player, Color> colorColumn;
	@FXML
	private TableColumn<Player, String> scoreColumn;

	//Constructeur
	public ScoreBoard() {
		list = FXCollections.observableArrayList(ScoreFile.getScoreFile().getScores());
	}

	public void initialize() {
		back.setOnMouseClicked(e -> MainFrame.getMainFrame().home());

		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
		colorColumn.setCellValueFactory(cellData -> cellData.getValue().getColorProperty());
		scoreColumn.setCellValueFactory(cellData -> cellData.getValue().getScoreProperty().asString());

		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
		colorColumn.setCellFactory(ColorPickerTableCell::new);
		scoreColumn.setCellFactory(TextFieldTableCell.forTableColumn());

		playerTableView.setItems(list);
	}
	
}
