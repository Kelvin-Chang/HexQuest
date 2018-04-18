package View.Menu;

import View.buttons.*;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class MainMenuView extends AbstractView{

    private ViewController viewController;

    public MainMenuView() {
        viewController = new ViewController();
        
        this.getChildren().add(borderPane());
    }

    // list of buttons
    private ArrayList<Selectable> centerPaneButtons(ViewController viewController) {

        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new NewGameSelectable("New Game", viewController));
            add(new LoadGameSelectable("Load Game", viewController));
            add(new SettingsSelectable("Settings", viewController));
            add(new ExitProgramSelectable("Exit", viewController));
        }};

        return options;
    }

    // creates vbox to hold buttons
    private VBox centerPane() {
        ArrayList<Selectable> options = centerPaneButtons(viewController);
        VBox vbox = new VBox();
//        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        vbox.setPrefSize(1000,500);
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
        t.setText("Game Title");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }


    private StackPane topPane() {
        StackPane stackPane = new StackPane();
        stackPane.setPrefSize(1000,300);
        stackPane.setAlignment(Pos.BOTTOM_CENTER);
        stackPane.getChildren().add(topPaneText());

        return stackPane;
    }

    private BorderPane borderPane() {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane());

        return bp;
    }
}
