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

/**
 * Controller class for the ScoreBoard view
 */
public class ScoreBoard {
	/**
	 * List of the displayed players
	 */
	private final ObservableList<Player> list;

	@FXML
	private Button back;

	// Table view with its columns to display players scores
	@FXML
	private TableView<Player> playerTableView;
	@FXML
	private TableColumn<Player, String> nameColumn;
	@FXML
	private TableColumn<Player, Color> colorColumn;
	@FXML
	private TableColumn<Player, String> scoreColumn;

	/**
	 * Creates a new ScoreBoard initializing the list of players with the players in ScoreFile
	 */
	public ScoreBoard() {
		list = FXCollections.observableArrayList(ScoreFile.getScoreFile().getScores());
	}

	/**
	 * Called after ui has been initialized.
	 * Binds the table view to the player list.
	 * Then binds each column to the value it has to display
	 */
	public void initialize() {
		// Bind back button to go back to welcome menu
		back.setOnMouseClicked(e -> MainFrame.getMainFrame().home());

		// Bind each column to a player's value
		nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty()); // Player's name
		colorColumn.setCellValueFactory(cellData -> cellData.getValue().getColorProperty()); // Player's color
		scoreColumn.setCellValueFactory(cellData -> cellData.getValue().getScoreProperty().asString()); // Player's score

		nameColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Display it as a string
		colorColumn.setCellFactory(ColorPickerTableCell::new); // Display it as a color with the custom factory
		scoreColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Display it as a string

		playerTableView.setItems(list); // Binds the table view to the players list
	}

}
