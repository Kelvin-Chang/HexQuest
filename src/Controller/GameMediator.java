package Controller;

import Controller.Input.KeyInputController;
import Controller.Input.PlayerController;
import Controller.Input.ViewController;
import Controller.LoadSave.GameBuilder;
import Controller.Input.ViewController;

import Controller.LoadSave.GameLoader;
import Model.DeathHandler;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.PlayerFactory;
import Model.Zone.World;
import View.Menu.GameplayView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.geom.Point2D;
import java.beans.EventHandler;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class GameMediator extends Application {

    private GameLoader gameLoader;
    private GameBuilder gameBuilder;
    private Timer timer;
    private World world;
    private KeyInputController keyInputController;
    private Scene scene;
    GameplayView gameplayView;
    private Renderer renderer;
    private ViewController viewController;
    private DeathHandler deathHandler;

    boolean loaded = false;

    public GameMediator() {
        gameBuilder = new GameBuilder();
//        keyInputController = new KeyInputController("", world.playerActions(), new PlayerController(world.getPlayer()), this);
        this.scene = scene;
//        scene.addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> keyInputController.issueCommand(keyEvent.getCode()));
//        loadGame("resources/maps/map0.json");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // create ViewController
        viewController = new ViewController(this);

        // pass existing initial stage into viewController to load it
        viewController.displayStage(primaryStage);
        scene = viewController.getScene();

        // set the view in the stage to the main menu
        viewController.switchToMainMenuView();
    }

    public void loadGame(String saveFileLocation) {
        gameLoader = new GameLoader(gameBuilder);
        gameLoader.loadGame(saveFileLocation);
        world = gameBuilder.getWorld();
        keyInputController = new KeyInputController("", world.playerActions(), new PlayerController(world.getPlayer()), this);
        Collection<Point> allPts = world.getCurrentZone().getAllTerrainPoints();
        renderer = new Renderer(world, viewController.getGameplayView());
        viewController.getScene().addEventFilter(KeyEvent.KEY_RELEASED, keyEvent -> keyInputController.issueCommand(keyEvent.getCode()));
        renderer.render();
        loaded = true;
        deathHandler = new DeathHandler(world.getPlayer(), renderer.getCanvas());
        startTimer();
        loaded = true;
    }

    public GameBuilder getGameBuilder() {
        return gameBuilder;
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new GameLoop(), 0, 60);
    }


    private class GameLoop extends TimerTask {
        @Override
        public void run() {
            if(loaded) {
                renderer.render();
                world.update();
                deathHandler.checkDeath();
            }

        }
    }

    public void bargainingToTakePlace(CharacterEntity bargainingPartner) {
        // TODO
    }

    public void pickPocketToTakePlace(CharacterEntity pickPocketTarget) {
        // TODO
    }

    public void talkingTakingPlace(CharacterEntity talkingPartner) {
        // TODO
    }

}
