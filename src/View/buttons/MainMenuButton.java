package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class MainMenuButton extends Button{
    private ViewController viewController;

    public MainMenuButton() {

    }

    public MainMenuButton(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToMainMenuView();
    }
}
