package Controller.buttons;

import Controller.Input.ViewController;
import javafx.event.ActionEvent;

public class SkillSelectable extends Selectable{
    private ViewController viewController;

    public SkillSelectable() {

    }

    public SkillSelectable(String name, ViewController viewController) {
        super(name);
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        viewController.switchToSkillView();
    }
}
