package imr4power.ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage = new WelcomeStage();
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
