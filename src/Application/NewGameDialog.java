package application;

import application.Main;
import Model.Joueur;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

/**
 * @author enora
 *
 */
public class NewGameDialog {
	private Stage stage;
	private ObservableList<Joueur> list;
	@FXML
	private Spinner<Integer> nbLignes;
	@FXML
	private Spinner<Integer> nbColonnes;
	@FXML
	private TableView<Joueur> joueurTableView;
	@FXML
	private TableColumn<Joueur, String> nomCol;
	@FXML
	private TableColumn<Joueur, String> couleurCol;
	private Main main;
	
	//Constructeur
    public NewGameDialog() {
        list = FXCollections.observableArrayList();

        list.add(new Joueur("Joueur 1", "Rouge"));
        list.add(new Joueur("Joueur 2", "Jaune"));
    }	
	
    @FXML
    public void addPlayer() {
        list.add(new Joueur("Nouveau joueur", "Random"));
    }
    
    public void setMain(Main m) {
        main = m;
    }
    
    public void setStage(Stage s) {
        stage = s;
    }
    
    public void initialize() {
        nomCol.setCellValueFactory(cellData -> cellData.getValue().getName());
        /* @TODO la couleur est de type Color et non StringProperty */
        //couleurCol.setCellValueFactory(cellData -> cellData.getValue().getColor());

        nomCol.setCellFactory(TextFieldTableCell.<Joueur>forTableColumn());
        couleurCol.setCellFactory(TextFieldTableCell.<Joueur>forTableColumn());

        joueurTableView.setItems(list);
    }
    
}
