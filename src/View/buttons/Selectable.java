package View.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public abstract class Selectable implements EventHandler<ActionEvent> {

    private String name;

    public Selectable() {}

    // set the name for the button label
    public Selectable(String name) {
        this.name = name;
    }

    // returns the label of the button
    public String getName() {
        return name;
    }

    // template handle function for mouseclicks
    @Override
    public void handle(ActionEvent event) {

    }
}
