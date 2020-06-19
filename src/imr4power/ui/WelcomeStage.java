package imr4power.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeStage extends Stage {

    private Button nouvellePartie, afficherScores, quitter;
    private VBox layout;

    public WelcomeStage() {
        iniLayout();

        Scene scene = new Scene(layout);

        initBoutons();

        this.setTitle("IMR4Power - Puissance 4");

        this.setScene(scene);
        this.sizeToScene();

        this.setMinWidth(325);
        this.setMinHeight(577);

        this.setResizable(false);
    }

    private void iniLayout() {
        layout = new VBox();

        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10.0));
    }

    private void initBoutons() {
        nouvellePartie = new Button("Nouvelle partie");
        afficherScores = new Button("Afficher le tableau des scores");
        quitter = new Button("Quitter");

        quitter.setOnMouseClicked( e -> System.exit(0));

        this.layout.getChildren().addAll(nouvellePartie, afficherScores, quitter);
    }
}
