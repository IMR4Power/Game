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
 * @author Kevin
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

    // Constructeur
    public NewGameDialog() {
        parameters = new BoardParameters();
    }

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

    public void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        colorColumn.setCellValueFactory(cellData -> cellData.getValue().getColorProperty());

        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        colorColumn.setCellFactory(ColorPickerTableCell::new);

        playerTableView.setItems(parameters.getPlayers());

        parameters.getNbColProperty().bind(nbColumns.valueProperty());
        parameters.getNbRowProperty().bind(nbRows.valueProperty());

        playBtn.setOnMouseClicked(e -> MainFrame.getMainFrame().startGame(parameters));

        back.setOnMouseClicked(e -> MainFrame.getMainFrame().home());
    }

}
