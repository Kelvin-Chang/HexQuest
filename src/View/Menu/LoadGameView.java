package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.MainMenuSelectable;
import Controller.buttons.Selectable;
import Controller.buttons.StartLoadGameSelectable;
import Controller.buttons.StartNewGameSelectable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class LoadGameView extends AbstractView {

    private ViewController viewController;
    private String saveFileLocation;

    public LoadGameView(ViewController viewController) {
        this.viewController = viewController;

        this.getChildren().add(borderPane(this));
    }


    private ArrayList<RadioButton> centerPaneRadioButtons() {

        // togglegroup for character selection
        ToggleGroup toggleGroup = new ToggleGroup();

        // radio buttons
        RadioButton tb1 = new RadioButton("Save Slot 1");
        RadioButton tb2 = new RadioButton("Save Slot 2");
        RadioButton tb3 = new RadioButton("Save Slot 3");

        // TODO: replace "Save Slot #" with json file path
        // data that each radio button holds
        tb1.setUserData("Save Slot 1");
        tb2.setUserData("Save Slot 2");
        tb3.setUserData("Save Slot 3");

        tb1.setToggleGroup(toggleGroup);
        tb2.setToggleGroup(toggleGroup);
        tb3.setToggleGroup(toggleGroup);

        ArrayList<RadioButton> options = new ArrayList<RadioButton>() {{
            add(tb1);
            add(tb2);
            add(tb3);
        }};
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (newValue != null) {
                    saveFileLocation = (toggleGroup.getSelectedToggle()).getUserData().toString();
                    System.out.println(saveFileLocation);
                }
            }
        });

        // this is placed after the "changed" method to initialize the characterChoice to a non-null value
        // initializes an initial choice once the view is loaded
        tb1.setSelected(true);

        System.out.println("LoadGameView: " + saveFileLocation);

        return options;
    }

    // creates vbox to hold buttons
    private VBox centerPane() {
        ArrayList<RadioButton> options = centerPaneRadioButtons();
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setPrefSize(400,300);
        vbox.setAlignment(Pos.TOP_CENTER);

        for(RadioButton clickable: options) {

            // sets selectable style
            clickable.getStyleClass().add("button2");

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

    private ArrayList<Selectable> bottomPaneButtons(ViewController viewController, LoadGameView loadGameView) {
        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new MainMenuSelectable("Main Menu", viewController));
            add(new StartLoadGameSelectable("Start Game", viewController, loadGameView));
        }};

        return options;
    }

    private HBox bottomPane(LoadGameView loadGameView) {

        ArrayList<Selectable> options = bottomPaneButtons(viewController, loadGameView);

        HBox hbox = new HBox();
        hbox.setMaxHeight(300);

        hbox.setSpacing(10);
        hbox.setPrefSize(1000,500);
        hbox.setAlignment(Pos.TOP_CENTER);

        for(Selectable clickable: options) {
            Button selectable = new Button(clickable.getName());
            selectable.getStyleClass().add("button1");
            selectable.setOnAction(clickable);

            hbox.getChildren().add(selectable);
        }

        return hbox;
    }

    private BorderPane borderPane(LoadGameView loadGameView) {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane());

        bp.setBottom(bottomPane(loadGameView));
        bp.setLeft(leftPane());
        bp.setRight(rightPane());

        return bp;
    }

    // TODO: ANTI OOP
    public String getSaveFileChoice() {
        return saveFileLocation;
    }


}
