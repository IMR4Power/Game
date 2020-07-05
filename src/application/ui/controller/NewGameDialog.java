package application.ui.controller;

import application.model.entities.BoardParameters;
import application.model.entities.Player;
import application.ui.MainFrame;
import application.ui.controller.customTableViewCell.ColorPickerTableCell;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;

/**
 * Class controller for the newGameDialog view
 */
public class NewGameDialog {
    private final BoardParameters parameters;

    @FXML
    private Spinner<Integer> nbRows;
    @FXML
    private Spinner<Integer> nbColumns;
    @FXML
    private TableView<Player> playerTableView;
    @FXML
    private TableColumn<Player, String> nameColumn;
    @FXML
    private TableColumn<Player, Color> colorColumn;
    @FXML
    private Button playBtn;
    @FXML
    private Button addPlayerBtn;
    @FXML
    private Button removePlayerBtn;
    @FXML
    private Button back;

    /**
     * Creates a new NewGameDialog with a new boardParameters
     */
    public NewGameDialog() {
        parameters = new BoardParameters();
    }

    /**
     * Adds a player in the list.
     * <p>
     * Checks if the list isn't full (not more than 4 players).
     * If the list is full, displays a modal telling the user and disable the addPlayer button. Else add a new user
     * with name "Nouveau Joueur" and a random color
     */
    @FXML
    public void addPlayer() {
        if (parameters.getPlayers().size() == 4) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText(null);
            warning.setContentText("Impossible de rajouter un joueur. Il ne peut en avoir que 4 maximum.");
            warning.showAndWait();

            addPlayerBtn.setDisable(true);
        } else {
            parameters.getPlayers().add(new Player("Nouveau joueur",
                    Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255))));

            if (removePlayerBtn.isDisable())
                removePlayerBtn.setDisable(false);
        }
    }

    /**
     * Removes a player in the list.
     * <p>
     * Checks if the list isn't at minimum (not less than 2 players).
     * If the list is at minimum, displays a modal telling the user and disable the removePlayer button. Else removes the selected user in the list.
     * If no user is selected, does nothing
     */
    @FXML
    public void removePlayer() {
        if (parameters.getPlayers().size() == 2) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText(null);
            warning.setContentText("Impossible de supprimer le jour. Il doit y avoir au moins deux joueurs pour jouer.");
            warning.showAndWait();

            removePlayerBtn.setDisable(true);
        } else {
            Player j = playerTableView.getSelectionModel().getSelectedItem();
            parameters.getPlayers().remove(j);

            if (addPlayerBtn.isDisable())
                addPlayerBtn.setDisable(false);
        }
    }

    /**
     * Called after ui has been initialized.
     * <p>
     * Binds the table view to player list of game board parameters and each column to a players data
     * Binds too the spinner values to rows and columns number of game board parameters
     * Add a callback on back button
     */
    public void initialize() {
        // Binds the data which will be used by each column
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        colorColumn.setCellValueFactory(cellData -> cellData.getValue().getColorProperty());

        // Sets how the data are displayed and updated for each column
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn()); // Handles string property
        colorColumn.setCellFactory(ColorPickerTableCell::new); // Custom class to handle colors in the table

        playerTableView.setItems(parameters.getPlayers()); // Set the list of player which will be used by the table view

        // Binds the spinner's values to corresponding attributes of the game board parameters
        parameters.getNbColProperty().bind(nbColumns.valueProperty());
        parameters.getNbRowProperty().bind(nbRows.valueProperty());

        // on click, change the displayed view and start the game
        playBtn.setOnMouseClicked(e -> MainFrame.getMainFrame().startGame(parameters));

        // on click, return to welcome menu
        back.setOnMouseClicked(e -> MainFrame.getMainFrame().home());
    }

}
