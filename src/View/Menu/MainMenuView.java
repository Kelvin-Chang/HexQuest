package View.Menu;

import View.buttons.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class MainMenuView extends AbstractView{

    private ViewController viewController;

    public MainMenuView() {
        viewController = new ViewController();
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

        this.getChildren().add(mainMenuFormat());
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
    private VBox buttonVbox() {
        ArrayList<Selectable> options = createButtons(viewController);
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);
        vbox.setAlignment(Pos.CENTER);

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

    private BorderPane mainMenuFormat() {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        Pane paneleft = new Pane();
        Pane paneright = new Pane();
        Pane panecenter = new Pane();
        Pane panetop = new Pane();
        Pane panebottom = new Pane();

        paneleft.setPrefWidth(100);
        paneright.setPrefWidth(100);
        panetop.setPrefHeight(100);
        panebottom.setPrefHeight(100);

        bp.setLeft(paneleft);
        bp.setRight(paneright);
        bp.setTop(panetop);
        bp.setBottom(panebottom);

        bp.setCenter(buttonVbox());

        return bp;
    }
}
