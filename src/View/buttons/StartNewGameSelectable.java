package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class StartNewGameSelectable extends Selectable {

    // dont know if necessary
    private ViewController viewController;

    public StartNewGameSelectable() {

    }

    public StartNewGameSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        // load

    }


}
