package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.MainMenuSelectable;
import Controller.buttons.Selectable;
import Controller.buttons.StartNewGameSelectable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class NewGameView extends AbstractView {

    private ViewController viewController;
    private String characterChoice;

    public NewGameView(ViewController viewController) {

        this.viewController = viewController;

        this.getChildren().add(borderPane(this));
    }


    // creates vbox to hold buttons
    private StackPane centerPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }


    private Text topPaneText() {
        Text t = new Text();
        t.setText("New Game");
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


    private ArrayList<RadioButton> leftPaneRadioButtons() {

        // togglegroup for character selection
        ToggleGroup toggleGroup = new ToggleGroup();

        // radio buttons
        RadioButton tb1 = new RadioButton("Summoner");
        RadioButton tb2 = new RadioButton("Sneak");
        RadioButton tb3 = new RadioButton("Smasher");

        // data that each radio button holds
        tb1.setUserData("Summmoner");
        tb2.setUserData("Sneak");
        tb3.setUserData("Smasher");

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
                if(newValue != null){
                    characterChoice = (toggleGroup.getSelectedToggle()).getUserData().toString();
                    System.out.println(characterChoice);
                }
            }
        });

        // this is placed after the "changed" method to initialize the characterChoice to a non-null value
        // initializes an initial choice once the view is loaded
        tb1.setSelected(true);

        System.out.println("NewGameView: " + characterChoice);

        return options;
    }

    private VBox leftPane() {
        ArrayList<RadioButton> options = leftPaneRadioButtons();
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

    private StackPane rightPane() {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }

    private ArrayList<Selectable> bottomPaneButtons(ViewController viewController, NewGameView newGameView) {
        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new MainMenuSelectable("Main Menu", viewController));
            add(new StartNewGameSelectable("Start Game", viewController, newGameView));
        }};

        return options;
    }

    private HBox bottomPane(NewGameView newGameView) {

        ArrayList<Selectable> options = bottomPaneButtons(viewController, newGameView);

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

    private BorderPane borderPane(NewGameView newGameView) {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane());

        bp.setBottom(bottomPane(newGameView));
        bp.setLeft(leftPane());
        bp.setRight(rightPane());

        return bp;
    }

    // TODO: ANTI OOP
    public String getCharacterChoice() {
        return characterChoice;
    }
}

