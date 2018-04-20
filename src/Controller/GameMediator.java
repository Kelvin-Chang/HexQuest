package Controller;

import Controller.Input.ViewController;
import Controller.LoadSave.GameBuilder;
import Controller.Input.ViewController;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GameMediator extends Application {

    private GameBuilder gameBuilder;
    private Timer timer;

    boolean loaded = false;

    public GameMediator() {
        gameBuilder = new GameBuilder();

        startTimer();
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
