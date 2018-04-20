package Controller;

import Controller.Input.ViewController;
import Controller.LoadSave.GameBuilder;
import Controller.Input.ViewController;

import Controller.LoadSave.GameLoader;
import Model.Zone.World;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GameMediator extends Application {

    private GameLoader gameLoader;
    private GameBuilder gameBuilder;
    private Timer timer;
    private World world;

    boolean loaded = false;

    public GameMediator() {
        gameBuilder = new GameBuilder();
        loadGame("resources/maps/map0.json");
    }

    public void loadGame(String saveFileLocation) {
        gameLoader = new GameLoader(gameBuilder);
        gameLoader.loadGame(saveFileLocation);
        world = gameBuilder.getWorld();
        System.out.println("Got world: " + world);
        startTimer();
    }

    public GameBuilder getGameBuilder() {
        return gameBuilder;
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

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new GameLoop(), 1000, 10);
    }


    private class GameLoop extends TimerTask {
        @Override
        public void run() {
            if(loaded) {
                System.out.println("Loop");
            }
        }
    }
}
