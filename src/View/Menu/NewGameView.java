package View.Menu;

import View.buttons.Button;
import View.buttons.MainMenuButton;
import View.buttons.StartNewGameButton;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;


public class NewGameView extends AbstractView{

    public NewGameView() {

        ViewController viewController = new ViewController();
        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        ArrayList<Button> options = new ArrayList<Button>() {{
            add(new StartNewGameButton("Start", viewController));
            add(new MainMenuButton("Main Menu", viewController));
        }};

        for(Button clickable: options) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(clickable.getName());

            // sets button style
            button.getStyleClass().add("button1");

            button.setOnAction(clickable);
            grid.add(button, 5, 35 + options.indexOf(clickable));
        }

        this.getChildren().add(grid);
    }
}
