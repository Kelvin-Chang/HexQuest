package Controller.buttons;

import Controller.Input.ViewController;

import javafx.event.ActionEvent;

public class GameplayViewSelectable extends Selectable {

    private ViewController viewController;

    public GameplayViewSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println("Switch to Gameplay View");

        viewController.switchToGamePlayView(false);
    }
}
