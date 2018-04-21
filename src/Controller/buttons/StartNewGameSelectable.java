package Controller.buttons;

import Controller.Input.ViewController;
import View.Menu.NewGameView;
import javafx.event.ActionEvent;

public class StartNewGameSelectable extends Selectable {

    // dont know if necessary
    private ViewController viewController;
    private String characterChoice;
    private NewGameView newGameView;

    public StartNewGameSelectable() {

    }

    public StartNewGameSelectable(String name, ViewController viewController, NewGameView newGameView) {
        super(name);
        this.viewController = viewController;
//        this.characterChoice = newGameView.getCharacterChoice();
        this.newGameView = newGameView;
    }

    @Override
    public void handle(ActionEvent event) {

        System.out.println("StartNewGameButton: " + newGameView.getCharacterChoice());

        // load

        viewController.switchToGamePlayView();
    }


}
