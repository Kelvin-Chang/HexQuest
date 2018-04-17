package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class StartNewGameButton extends Button {

    // dont know if necessary
    private ViewController viewController;

    public StartNewGameButton() {

    }

    public StartNewGameButton(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        // load

    }


}
