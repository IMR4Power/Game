package imr4power.ui.newGameDialog;

import imr4power.ui.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

public class NewGameDialog {
    private Stage stage;

    class Joueur {
        private StringProperty nom;
        private StringProperty couleur;

        public Joueur() {
        }

        public Joueur(String nom, String couleur) {
            this.nom = new SimpleStringProperty(nom);
            this.couleur = new SimpleStringProperty(couleur);
        }

        public StringProperty getNom() {
            return nom;
        }

        public void setNom(StringProperty nom) {
            this.nom = nom;
        }

        public StringProperty getCouleur() {
            return couleur;
        }

        public void setCouleur(StringProperty couleur) {
            this.couleur = couleur;
        }
    }

    private ObservableList<Joueur> list;

    @FXML
    private Spinner<Integer> nbLignes;

    @FXML
    private TableView<Joueur> joueurTableView;

    @FXML
    private TableColumn<Joueur, String> nomCol;

    @FXML
    private TableColumn<Joueur, String> couleurCol;

    private Main main;

    public NewGameDialog() {
        list = FXCollections.observableArrayList();

        list.add(new Joueur("Joueur 1", "Rouge"));
        list.add(new Joueur("Joueur 2", "Jaune"));
    }

    public void setMain(Main m) {
        main = m;
    }

    @FXML
    public void initialize() {
        nomCol.setCellValueFactory(cellData -> cellData.getValue().getNom());
        couleurCol.setCellValueFactory(cellData -> cellData.getValue().getCouleur());

        nomCol.setCellFactory(TextFieldTableCell.<Joueur>forTableColumn());
        couleurCol.setCellFactory(TextFieldTableCell.<Joueur>forTableColumn());

        joueurTableView.setItems(list);
    }

    public void setStage(Stage s) {
        stage = s;
    }

    public void checkBounnds() {

    }

    public void addPlayer() {
        list.add(new Joueur("Nouveau joueur", "Random"));
    }
}
