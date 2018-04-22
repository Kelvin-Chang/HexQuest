package Controller.Input;

import Controller.GameMediator;

import View.Menu.*;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ViewController {
    private Scene scene;
    private static Stage stage;
    private static ViewController viewController;
    GameMediator gameMediator;

    private GameplayView gameplayView;

    public ViewController(GameMediator gameMediator) {
        this.gameMediator = gameMediator;
        viewController = this;
    }

    // creates the scene in the window, to be called each time you switch scenes
    private void createScene(AbstractView view) {
        scene = new Scene(view, 1000, 800);
        scene.getStylesheets().add("assets/stylesheet");
        scene.setFill(Paint.valueOf("#1d1d1d"));
        stage.setScene(scene);
    }

    public Scene getScene() {
        return scene;
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
        MainMenuView view = new MainMenuView(viewController);
        createScene(view);
    }

    public void switchToNewGameView() {
        NewGameView view = new NewGameView(viewController);
        createScene(view);
    }

    public void switchToLoadGameView() {
        LoadGameView view = new LoadGameView(viewController);
        createScene(view);
    }

    public void switchToSettingsView() {
        SettingsView view = new SettingsView(viewController);
        createScene(view);
    }

    public void switchToGamePlayView(boolean fromStartGame) {
        gameplayView = new GameplayView(viewController, stage);
        createScene(gameplayView);
        gameMediator.loadGame("resources/maps/map0.json");
    }

    public void switchToGamePlayView(boolean fromStartGame, String filepath) {
        gameplayView = new GameplayView(viewController, stage);
        createScene(gameplayView);
        gameMediator.loadGame(filepath);
    }

    // swap to "exit view"
    public void exitProgram() {
        System.out.println("exiting");
        Platform.exit();
        System.exit(0);
    }

    public GameplayView getGameplayView() {
        return gameplayView;
    }

    // TODO: pause game loop either here or when the button is clicked (or somewhere else)
    // TODO: pretend there arent any OOP violations/fix the OOP violations
    public void switchToInventoryView() {
        InventoryView view = new InventoryView(viewController, gameMediator.getWorld().getPlayer());
        createScene(view);
    }

    public void switchToInGameMenuView() {
        InGameMenuView view = new InGameMenuView(viewController);
        createScene(view);
    }
}
