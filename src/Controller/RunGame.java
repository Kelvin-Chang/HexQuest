package Controller;

import javafx.application.Application;

public class RunGame {
    public static void main(String[] args) {
//        MapGenerator map = new MapGenerator("a.json", 15, 15, 1);
        Application.launch(GameMediator.class, args);
        GameMediator gameMediator = new GameMediator();
    }
}
