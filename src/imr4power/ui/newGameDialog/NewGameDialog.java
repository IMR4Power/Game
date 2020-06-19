package imr4power.ui.newGameDialog;

import imr4power.ui.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class NewGameDialog {
    private Stage stage;

    @FXML
    private Spinner<Integer> nbLignes;

    private Main main;

    public void setMain(Main m) {
        main = m;
    }

    public void initialize() {
    }

    public void setStage(Stage s) {
        stage = s;
    }

    public void checkBounnds() {

    }
}
