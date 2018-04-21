package Controller;

import javafx.application.Application;

public class RunGame {
    public static void main(String[] args) {
        Application.launch(GameMediator.class, args);
        GameMediator gameMediator = new GameMediator();
    }
}
