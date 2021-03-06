package application.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

class WelcomeScene extends Scene {
    private VBox layout;

    public WelcomeScene() {
        super(new VBox());

        iniLayout();

        initButtons();
    }

    private void iniLayout() {
        layout = (VBox)this.getRoot();

        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);
        layout.setPadding(new Insets(10.0));
    }

    private void initButtons() {
        Button newGame = new Button("Nouvelle partie");
        newGame.setOnMouseClicked(e -> MainFrame.getMainFrame().openNewGame());

        Button displayScores = new Button("Afficher le tableau des scores");
        displayScores.setOnMouseClicked(e -> MainFrame.getMainFrame().openScoreBoard());

        Button quit = new Button("Quitter");
        quit.setOnMouseClicked(e -> System.exit(0));

        this.layout.getChildren().addAll(newGame, displayScores, quit);
    }
}
