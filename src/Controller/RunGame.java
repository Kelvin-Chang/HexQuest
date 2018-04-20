package Controller;

import Controller.Input.ViewController;
import javafx.application.Application;
import javafx.stage.Stage;

public class RunGame {
    public static void main(String[] args) {
        GameMediator gameMediator = new GameMediator();
        GameMediator.launch(GameMediator.class, args);
    }
}
