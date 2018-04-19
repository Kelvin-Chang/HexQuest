package View.Menu;

import View.buttons.MainMenuSelectable;
import View.buttons.Selectable;
import View.buttons.StartNewGameSelectable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class NewGameView extends AbstractView {

    private ViewController viewController;

    public NewGameView() {

        viewController = new ViewController();

        this.getChildren().add(borderPane());
    }

    // list of buttons
    private ArrayList<Selectable> leftPaneButtons(ViewController viewController) {

        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new StartNewGameSelectable("Start", viewController));
            add(new MainMenuSelectable("Main Menu", viewController));
        }};

        return options;
    }

    // creates vbox to hold buttons
    private StackPane centerPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }


//    private Text topPaneText() {
//        Text t = new Text();
//        t.setText("Game Title");
//        t.setFont(Font.font("Elephant", 50));
//        t.setFill(Paint.valueOf("#ff00ff"));
//
//        return t;
//    }


    private StackPane topPane() {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1000,300);
        stackPane.setAlignment(Pos.BOTTOM_CENTER);
//        stackPane.getChildren().add(topPaneText());

        return stackPane;
    }

    // following panes set the panes to size 0 so the borderpane is essentially two panes stacked on top of each other
    private VBox leftPane() {
        ArrayList<Selectable> options = leftPaneButtons(viewController);
        VBox vbox = new VBox();
//        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        vbox.setPrefSize(400,500);
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
