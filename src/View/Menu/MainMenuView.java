package View.Menu;

import View.buttons.*;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MainMenuView extends AbstractView{

    public MainMenuView() {
        ViewController viewController = new ViewController();
        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        ArrayList<Button> options = new ArrayList<Button>() {{
            add(new NewGameButton("New Game", viewController));
            add(new LoadGameButton("Load Game", viewController));
            add(new SettingsButton("Settings", viewController));
            add(new ExitProgramButton("Exit", viewController));
        }};

        for(Button clickable: options) {
            javafx.scene.control.Button button = new javafx.scene.control.Button(clickable.getName());

            // sets button style
            button.getStyleClass().add("button1");

            button.setOnAction(clickable);
            grid.add(button, 5, options.indexOf(clickable));
        }

        this.getChildren().add(grid);
    }
}
