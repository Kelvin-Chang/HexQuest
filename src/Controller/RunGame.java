package Controller;

import View.Menu.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // prints out available text fonts
//        System.out.println(javafx.scene.text.Font.getFamilies());

        // create ViewController
        ViewController viewController = new ViewController();

        // pass existing initial stage into viewController to load it
        viewController.displayStage(primaryStage);

        // set the view in the stage to the main menu
        viewController.switchToMainMenuView();
    }
}
