package View.Menu;

import View.buttons.MainMenuSelectable;
import View.buttons.Selectable;
import View.buttons.StartNewGameSelectable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class LoadGameView extends AbstractView {

    ViewController viewController;

    public LoadGameView() {
        viewController = new ViewController();

        this.getChildren().add(borderPane());
    }

        private ArrayList<ToggleButton> centerPaneToggleButtons() {
        ToggleGroup toggleGroup = new ToggleGroup();
        ToggleButton tb1 = new ToggleButton("Save Slot 1");
        ToggleButton tb2 = new ToggleButton("Save Slot 2");
        ToggleButton tb3 = new ToggleButton("Save Slot 3");

        tb1.setSelected(true);

        tb1.setToggleGroup(toggleGroup);
        tb2.setToggleGroup(toggleGroup);
        tb3.setToggleGroup(toggleGroup);

        ArrayList<ToggleButton> options = new ArrayList<ToggleButton>() {{
            add(tb1);
            add(tb2);
            add(tb3);
        }};

        return options;
    }

    // creates vbox to hold buttons
    private VBox centerPane() {
        ArrayList<ToggleButton> options = centerPaneToggleButtons();
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setPrefSize(400,300);
        vbox.setAlignment(Pos.TOP_CENTER);

        for(ToggleButton clickable: options) {

            // sets selectable style
            clickable.getStyleClass().add("button3");

            // add to vbox
            vbox.getChildren().add(clickable);
        }

        return vbox;
    }

    private Text topPaneText() {
        Text t = new Text();
        t.setText("Load Game");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }

    private StackPane topPane() {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1000,300);
        stackPane.setPadding(new Insets(10,10,10,10));
        stackPane.setAlignment(Pos.BOTTOM_CENTER);
        stackPane.getChildren().add(topPaneText());

        return stackPane;
    }

    private StackPane leftPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);
        return stackPane;
    }

    private StackPane rightPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }

    private ArrayList<Selectable> bottomPaneButtons(ViewController viewController) {
        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new MainMenuSelectable("Main Menu", viewController));
            add(new StartNewGameSelectable("Start Game", viewController));
        }};

        return options;
    }

    private HBox bottomPane() {

        ArrayList<Selectable> options = bottomPaneButtons(viewController);

        HBox hbox = new HBox();
        hbox.setMaxHeight(300);

        hbox.setSpacing(10);
        hbox.setPrefSize(1000,500);
        hbox.setAlignment(Pos.TOP_CENTER);

        for(Selectable clickable: options) {
            Button selectable = new Button(clickable.getName());

            // sets selectable style
            selectable.getStyleClass().add("button1");

            // set action
            selectable.setOnAction(clickable);

            // add to vbox
            hbox.getChildren().add(selectable);
        }

        return hbox;
    }

    private BorderPane borderPane() {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane());

        bp.setBottom(bottomPane());
        bp.setLeft(leftPane());
        bp.setRight(rightPane());

        return bp;
    }



}
