package View.buttons;

import Controller.Input.ViewController;
import javafx.event.ActionEvent;

public class SettingsSelectable extends Selectable {

    private ViewController viewController;

    public SettingsSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToSettingsView();
    }
}
