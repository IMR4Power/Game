package imr4power.ui;

import imr4power.ui.newGameDialog.NewGameDialog;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFrame extends Stage {
    public MainFrame() {
        this.setTitle("IMR4Power - Puissance 4");

        Scene scene = new WelcomeStage(this);

        this.setScene(scene);

        this.setMinWidth(325);
        this.setMinHeight(577);
        this.sizeToScene();

        this.setResizable(false);

        this.show();
    }

    public void openNewGame() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("newGameDialog/newGameDialog.fxml"));

            AnchorPane page = loader.load();

            Scene scene = new Scene(page);
            this.setScene(scene);
            this.sizeToScene();

            NewGameDialog ctrl = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
