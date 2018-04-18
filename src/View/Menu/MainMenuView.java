package View.Menu;

import View.buttons.*;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class MainMenuView extends AbstractView{

    private ViewController viewController;

    public MainMenuView() {
        viewController = new ViewController();
        // GridPane is unused for the formatting, might need for future code
//        GridPane grid = new GridPane();

//        grid.setVgap(10);
//        grid.setHgap(10);
//        grid.setPadding(new Insets(10,10,10,10));

//        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
//            add(new NewGameSelectable("New Game", viewController));
//            add(new LoadGameSelectable("Load Game", viewController));
//            add(new SettingsSelectable("Settings", viewController));
//            add(new ExitProgramSelectable("Exit", viewController));
//        }};



//        for(Selectable clickable: options) {
//            Button selectable = new Button(clickable.getName());
//
//            // sets selectable style
//            selectable.getStyleClass().add("button1");
//
//            selectable.setOnAction(clickable);
//            grid.add(selectable, 5, options.indexOf(clickable));
//        }

        /*
        this.getChildren().add(centerPane); is perfectly valid
        this.getChildren().add(mainMenuFormat()); is better because it allows more formatting options in the future
        by using a BorderPane
         */
        this.getChildren().add(borderPane());
    }

    // list of buttons
    private ArrayList<Selectable> createButtons(ViewController viewController) {

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
        ArrayList<Selectable> options = createButtons(viewController);
        VBox vbox = new VBox();
//        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        vbox.setPrefSize(1000,800);
        vbox.setAlignment(Pos.TOP_CENTER);

        // changes the vbox dimensions
//        vbox.setPrefSize(Double.MAX_VALUE, Double.MAX_VALUE);
//        vbox.setPrefSize(100,100);

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

    private Text gameTitle() {
        Text t = new Text();
        t.setText("Game Title");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }

    private BorderPane borderPane() {

        // TODO: add in game title to top pane, possibly move vbox from centerpane to bottom pane? (unnecessary move)

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        // commented out pane is the one being replaced by other pane formatting created through other functions

        Pane paneleft = new Pane();
        Pane paneright = new Pane();
//        Pane panecenter = new Pane();
        Pane panetop = new Pane();
        Pane panebottom = new Pane();

        // preferred widths but resize based on window size
//        paneleft.setPrefWidth(100);
//        paneright.setPrefWidth(100);
//        panecenter.setPrefWidth(100);
        panetop.setPrefHeight(100);
//        panebottom.setPrefHeight(100);

        // limits pane size to max
        paneleft.setMaxSize(0,0);
        paneright.setMaxSize(0,0);
//        panecenter.setMaxSize(0,0);
//        panetop.setMaxSize(0,0);
        panebottom.setMaxSize(0,0);

        bp.setLeft(paneleft);
        bp.setRight(paneright);
        bp.setTop(gameTitle());
        bp.setBottom(panebottom);

        bp.setCenter(centerPane());

        return bp;
    }
}
