package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import model.BoardParameters;
import model.Player;

/**
 * @author Kevin
 */
public class NewGameDialog {
    private final BoardParameters parameters;

    @FXML
    private Spinner<Integer> nbLignes;
    @FXML
    private Spinner<Integer> nbColonnes;
    @FXML
    private TableView<Player> joueurTableView;
    @FXML
    private TableColumn<Player, String> nomCol;
    @FXML
    private TableColumn<Player, Color> couleurCol;
    @FXML
    private Button btnJouer;
    @FXML
    private Button addPlayerBtn;
    @FXML
    private Button removePlayerBtn;

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
            warning.setContentText("Impossible de supprimer le jour. Il doit y avoir au moins deux jouers pour jouer.");
            warning.showAndWait();

            removePlayerBtn.setDisable(true);
        } else {
            Player j = joueurTableView.getSelectionModel().getSelectedItem();
            parameters.getPlayers().remove(j);

            if (addPlayerBtn.isDisable())
                addPlayerBtn.setDisable(false);
        }
    }

    public void initialize() {
        nomCol.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        couleurCol.setCellValueFactory(cellData -> cellData.getValue().getColorProperty());

        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        couleurCol.setCellFactory(ColorPickerTableCell::new);

        joueurTableView.setItems(parameters.getPlayers());

        parameters.getNbColProperty().bind(nbColonnes.valueProperty());
        parameters.getNbRowProperty().bind(nbLignes.valueProperty());

        btnJouer.setOnMouseClicked(e -> MainFrame.getMainFrame().startGame(parameters));
    }

}
