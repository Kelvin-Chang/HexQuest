package View.buttons;

import View.Menu.ViewController;
import javafx.event.ActionEvent;

public class ExitProgramSelectable extends Selectable {

    private ViewController viewController;

    public ExitProgramSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }
    @Override
    public void handle(ActionEvent event) {
        viewController.exitProgram();
    }
}
