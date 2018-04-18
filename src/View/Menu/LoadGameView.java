package View.Menu;

import View.buttons.*;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class LoadGameView extends AbstractView {

    public LoadGameView() {
        ViewController viewController = new ViewController();
        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new StartNewGameSelectable("Start", viewController));
            add(new MainMenuSelectable("Main Menu", viewController));
        }};

        for(Selectable clickable: options) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(clickable.getName());

            // sets button style
            button.getStyleClass().add("button1");

            button.setOnAction(clickable);
            grid.add(button, 5, 35 + options.indexOf(clickable));
        }

        this.getChildren().add(grid);
    }
}
