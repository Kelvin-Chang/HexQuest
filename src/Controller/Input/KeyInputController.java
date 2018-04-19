package Controller.Input;

import javafx.event.EventType;
import javafx.scene.input.InputEvent;

public class KeyInputController extends InputEvent {

    public KeyInputController(EventType<? extends InputEvent> eventType) {
        super(eventType);
    }
}
