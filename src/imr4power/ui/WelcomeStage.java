package imr4power.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class WelcomeStage extends Scene {

    private Button nouvellePartie, afficherScores, quitter;
    private VBox layout;
    private MainFrame main;

    public WelcomeStage(MainFrame m) {
        super(new VBox());

        main = m;

        iniLayout();

        initBoutons();
    }

    private void iniLayout() {
        layout = (VBox)this.getRoot();

        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10.0));
    }

    private void initBoutons() {
        nouvellePartie = new Button("Nouvelle partie");

        nouvellePartie.setOnMouseClicked(e -> {
            Power4 test = new Power4(this);
        });

        afficherScores = new Button("Afficher le tableau des scores");
        quitter = new Button("Quitter");

        nouvellePartie.setOnMouseClicked(e -> main.openNewGame());
        quitter.setOnMouseClicked( e -> System.exit(0));

        this.layout.getChildren().addAll(nouvellePartie, afficherScores, quitter);
    }
}
