package View.Menu;

import View.buttons.*;
import com.sun.org.apache.bcel.internal.generic.Select;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

import java.util.ArrayList;

public class MainMenuView extends AbstractView{

    public MainMenuView() {
        ViewController viewController = new ViewController();
        GridPane grid = new GridPane();

        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10,10,10,10));

        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new NewGameSelectable("New Game", viewController));
            add(new LoadGameSelectable("Load Game", viewController));
            add(new SettingsSelectable("Settings", viewController));
            add(new ExitProgramSelectable("Exit", viewController));
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
