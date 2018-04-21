package Controller.Input;

import Controller.GameMediator;
import View.Menu.*;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ViewController {
    private Scene scene;
    private static Stage stage;
    private static ViewController viewController;
    private GameMediator gameMediator;

    public ViewController() {

    }

    // creates the scene in the window, to be called each time you switch scenes
    private void createScene(AbstractView view) {
        scene = new Scene(view, 1000, 800);
        scene.getStylesheets().add("assets/stylesheet");
        scene.setFill(Paint.valueOf("#1d1d1d"));
        stage.setScene(scene);
    }

    //TODO: make it so that the keyboard doesn't change which button is selected? the current bandage fix is .button:focused {outline:0;} which hides the selector
    /* Resources:
    https://stackoverflow.com/questions/15238928/javafx-how-to-change-the-focus-traversal-policy
    https://stackoverflow.com/questions/15338886/how-to-stop-arrow-keys-navigating-controls
     */

    // initializes a blank window
    public void displayStage(Stage primaryStage) {
        stage = primaryStage;
        stage.setWidth(1000);
        stage.setHeight(800);
        stage.centerOnScreen();
        stage.show();
    }

    public void switchToMainMenuView() {
        MainMenuView view = new MainMenuView();
        createScene(view);
    }

    public void switchToNewGameView() {
        NewGameView view = new NewGameView();
        createScene(view);
    }

    public void switchToLoadGameView() {
        LoadGameView view = new LoadGameView();
        createScene(view);
    }

    public void switchToSettingsView() {

    }


    public void switchToStartNewGameView() {
    }


    public void switchToGamePlayView() {
        GameplayView view = new GameplayView();
        createScene(view);
        gameMediator = new GameMediator(scene);
    }

    // swap to "exit view"
    public void exitProgram() {
        System.out.println("exiting");
        Platform.exit();
        System.exit(0);
    }
}
