package Controller.buttons;

import Controller.Input.ViewController;
import javafx.event.ActionEvent;

public class ShopkeeperSelectable extends Selectable {

    private ViewController viewController;

    public ShopkeeperSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToShopkeeperView();
    }
}
