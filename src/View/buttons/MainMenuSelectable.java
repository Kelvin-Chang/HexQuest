package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class MainMenuSelectable extends Selectable {
    private ViewController viewController;

    public MainMenuSelectable() {

    }

    public MainMenuSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToMainMenuView();
    }
}
