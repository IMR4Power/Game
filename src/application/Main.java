package application;
	
import application.ui.MainFrame;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage = MainFrame.getMainFrame();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
