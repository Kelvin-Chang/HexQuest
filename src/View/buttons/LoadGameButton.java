package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class LoadGameButton extends Button {

    private ViewController viewController;


    public LoadGameButton(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToLoadGameView();;
    }
}
