package Controller.buttons;

import Controller.Input.ViewController;
import javafx.event.ActionEvent;

public class InventorySelectable extends Selectable{

    private ViewController viewController;


    public InventorySelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToInventoryView();
    }
}
