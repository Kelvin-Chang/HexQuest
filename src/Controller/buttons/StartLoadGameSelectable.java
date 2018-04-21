package Controller.buttons;

import Controller.Input.ViewController;
import View.Menu.LoadGameView;
import View.Menu.NewGameView;
import javafx.event.ActionEvent;

public class StartLoadGameSelectable extends Selectable {

    // dont know if necessary
    private ViewController viewController;
    private String characterChoice;
    private LoadGameView loadGameView;

    public StartLoadGameSelectable() {

    }

    public StartLoadGameSelectable(String name, ViewController viewController, LoadGameView loadGameView) {
        super(name);
        this.viewController = viewController;
//        this.characterChoice = newGameView.getCharacterChoice();
        this.loadGameView = loadGameView;
    }

    @Override
    public void handle(ActionEvent event) {

        System.out.println("StartNewGameButton: " + loadGameView.getSaveFileChoice());

        // load



    }


}
