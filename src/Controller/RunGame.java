package Controller;

import Controller.Input.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create ViewController
        ViewController viewController = new ViewController();

        // pass existing initial stage into viewController to load it
        viewController.displayStage(primaryStage);

        // set the view in the stage to the main menu
        viewController.switchToMainMenuView();
    }
}
