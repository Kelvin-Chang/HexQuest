package View.buttons;


import View.Menu.ViewController;
import javafx.event.ActionEvent;


public class NewGameButton extends Button {

    private ViewController viewController;

    public NewGameButton() {

    }

    public NewGameButton(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToNewGameView();
    }

}
