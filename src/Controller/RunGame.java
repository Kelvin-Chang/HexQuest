package Controller;

import View.Map.MapView;
import View.Menu.ViewController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class RunGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    private Stage mainStage;
    private Scene mainScene;


    @Override
    public void start(Stage primaryStage) throws Exception {
//        // create ViewController
//        ViewController viewController = new ViewController();
//
//        // pass existing initial stage into viewController to load it
//        viewController.displayStage(primaryStage);
//
//        // set the view in the stage to the main menu
//        viewController.switchToMainMenuView();
        mainStage=primaryStage;
        Group root = new Group();
        mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        Canvas canvas = new Canvas(800, 800);
        root.getChildren().add(canvas);
        MapView mv = new MapView(canvas);
        mv.render(10,10);
        mainStage.show();

    }
}
