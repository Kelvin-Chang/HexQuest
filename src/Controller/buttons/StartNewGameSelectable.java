package Controller.buttons;

import Controller.Input.ViewController;
import javafx.event.ActionEvent;

public class StartNewGameSelectable extends Selectable {

    // dont know if necessary
    private ViewController viewController;
    private String characterChoice;

    public StartNewGameSelectable() {

    }

    public StartNewGameSelectable(String name, ViewController viewController, String characterChoice) {
        super(name);
        this.viewController = viewController;
        this.characterChoice = characterChoice;
    }

    @Override
    public void handle(ActionEvent event) {

        System.out.println(characterChoice);

        // load



    }


}
