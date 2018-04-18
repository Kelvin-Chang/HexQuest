package View.buttons;


import View.Menu.ViewController;
import javafx.event.ActionEvent;


public class NewGameSelectable extends Selectable {

    private ViewController viewController;

    public NewGameSelectable() {

    }

    public NewGameSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToNewGameView();
    }

}
