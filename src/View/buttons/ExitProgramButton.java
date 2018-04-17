package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class ExitProgramButton extends Button{

    private ViewController viewController;

    public ExitProgramButton(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }
    @Override
    public void handle(ActionEvent event) {
        viewController.exitProgram();
    }
}
