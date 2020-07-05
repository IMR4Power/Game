package application;

import application.ui.MainFrame;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class which launches the app
 */
public class Main extends Application {
    /**
     * Launch the app's main window
     *
     * @param primaryStage The primary stage created by JavaFX
     * @see MainFrame
     */
    @Override
    public void start(Stage primaryStage) {
        primaryStage = MainFrame.getMainFrame();
        primaryStage.show();
    }

    /**
     * Called when program starts. Launch the Application
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
