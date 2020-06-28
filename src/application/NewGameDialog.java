package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.paint.Color;
import model.Joueur;

/**
 * @author Kevin
 */
public class NewGameDialog {
    private final ObservableList<Joueur> list;
    private MainFrame mainFrame;

    @FXML
    private Spinner<Integer> nbLignes;
    @FXML
    private Spinner<Integer> nbColonnes;
    @FXML
    private TableView<Joueur> joueurTableView;
    @FXML
    private TableColumn<Joueur, String> nomCol;
    @FXML
    private TableColumn<Joueur, Color> couleurCol;
    @FXML
    private Button btnJouer;

    // Constructeur
    public NewGameDialog() {
        list = FXCollections.observableArrayList();

        list.add(new Joueur("Joueur 1", Color.RED));
        list.add(new Joueur("Joueur 2", Color.YELLOW));
    }

    @FXML
    public void addPlayer() {
        list.add(new Joueur("Nouveau joueur",
                Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255))));
    }

    @FXML
    public void removePlayer() {
        if (list.size() == 2) {
            Alert warning = new Alert(Alert.AlertType.WARNING);
            warning.setHeaderText(null);
            warning.setContentText("Impossible de supprimer le jour. Il doit y avoir au moins deux jouers pour jouer.");
            warning.showAndWait();
        } else {
            Joueur j = joueurTableView.getSelectionModel().getSelectedItem();
            list.remove(j);
        }
    }

    public void initialize() {
        nomCol.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        couleurCol.setCellValueFactory(cellData -> cellData.getValue().getColorProperty());

        nomCol.setCellFactory(TextFieldTableCell.forTableColumn());
        couleurCol.setCellFactory(ColorPickerTableCell::new);

        joueurTableView.setItems(list);

        mainFrame = MainFrame.getMainFrame();

        btnJouer.setOnMouseClicked(e -> {
            int row = nbLignes.getValue();
            int columns = nbColonnes.getValue();
            mainFrame.startGame(row, columns);
        });
    }

}
