package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class InGameMenuView extends AbstractView {
    private ViewController viewController;

    public InGameMenuView(ViewController viewController) {
        this.viewController = viewController;

        this.getChildren().add(borderPane());
    }

    // list of buttons
    private ArrayList<Selectable> centerPaneButtons(ViewController viewController) {

        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new GameplayViewSelectable("Back to Game", viewController));
            add(new MainMenuSelectable("Main Menu", viewController));
            add(new ExitProgramSelectable("Exit", viewController));
        }};

        return options;
    }

    // creates vbox to hold buttons
    private VBox centerPane() {
        ArrayList<Selectable> options = centerPaneButtons(viewController);
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPrefSize(1000,700);
        vbox.setAlignment(Pos.TOP_CENTER);

        for(Selectable clickable: options) {
            Button selectable = new Button(clickable.getName());

            // sets selectable style
            selectable.getStyleClass().add("button1");

            // set action
            selectable.setOnAction(clickable);

            // add to vbox
            vbox.getChildren().add(selectable);
        }

        return vbox;
    }

    private Text topPaneText() {
        Text t = new Text();
        t.setText("Menu");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }


    private StackPane topPane() {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1000,100);
        stackPane.setPadding(new Insets(10,10,10,10));
        stackPane.setAlignment(Pos.BOTTOM_CENTER);
        stackPane.getChildren().add(topPaneText());

        return stackPane;
    }

    // following panes set the panes to size 0 so the borderpane is essentially two panes stacked on top of each other
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

    private StackPane bottomPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxHeight(0);

        return stackPane;
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
