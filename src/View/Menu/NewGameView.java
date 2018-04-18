package View.Menu;

import View.buttons.Selectable;
import View.buttons.MainMenuSelectable;
import View.buttons.StartNewGameSelectable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


public class NewGameView extends AbstractView{

    public NewGameView() {

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
            Button selectable = new Button(clickable.getName());

            // sets selectable style
            selectable.getStyleClass().add("button1");

            selectable.setOnAction(clickable);
            grid.add(selectable, 5, options.indexOf(clickable));
        }

        this.getChildren().add(grid);
    }
}
