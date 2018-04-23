package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.GameplayViewSelectable;
import Controller.buttons.LevelUpSkillSelectable;
import Controller.buttons.Selectable;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;


public class SkillView extends AbstractView {

    private ViewController viewController;
    private CharacterEntity characterEntity;
    private SkillType skillType;
    private Skill skill;
    private BorderPane borderPane;
    private Button levelUpSkillButton;

    public SkillView(ViewController viewController, CharacterEntity characterEntity) {
        this.viewController = viewController;
        this.characterEntity = characterEntity;

        borderPane = borderPane(characterEntity);
        this.getChildren().add(borderPane);
    }


    private Text topPaneText() {
        Text t = new Text();
        t.setText("Skills");
        t.setFont(Font.font("Elephant", 50));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }

    private Text topPaneSkillText(CharacterEntity characterEntity) {
        Text t = new Text();
        t.setText("Skillpoints: " + characterEntity.getUnusedSkillPoints());
        t.setFont(Font.font("Elephant", 16));
        t.setFill(Paint.valueOf("#ff00ff"));

        return t;
    }


    private VBox topPane() {
        VBox vbox = new VBox();
        vbox.setPrefSize(1000,130);
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setAlignment(Pos.BOTTOM_CENTER);
        vbox.getChildren().add(topPaneText());
        vbox.getChildren().add(topPaneSkillText(characterEntity));

        return vbox;
    }

    private ArrayList<RadioButton> centerPaneRadioButtons(CharacterEntity character) {
        ToggleGroup skillToggleGroup = new ToggleGroup();

        ArrayList<RadioButton> options = new ArrayList<RadioButton>();

        HashMap<SkillType, Skill> skillHashMap = characterEntity.getSkills();
        Set<SkillType> skillKeys = characterEntity.getSkills().keySet();


        for (SkillType key: skillKeys) {
            RadioButton rb = new RadioButton();

            rb.setUserData(key);

//            rb.setUserData(skillHashMap.get(key));
            rb.setText(skillHashMap.get(key).getName() + ": " + skillHashMap.get(key).getSkillLevel());

            rb.setToggleGroup(skillToggleGroup);

            options.add(rb);

        }

        skillToggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if(newValue != null){
                    // TODO: see if it is possible to avoid casting
                    skillType = (SkillType) skillToggleGroup.getSelectedToggle().getUserData();

                    refresh(character);

                    if (character.getUnusedSkillPoints() <= 0) {
                        levelUpSkillButton.setDisable(false);
                    }

                    else {
                        levelUpSkillButton.setDisable(true);
                    }
                }
            }
        });

        // No initially selected item

        return options;
    }


    private VBox centerPane(CharacterEntity character) {
        ArrayList<RadioButton> options = centerPaneRadioButtons(character);
        VBox vbox = new VBox();
        vbox.setSpacing(30);
        vbox.setPrefSize(1000,598);

        vbox.setAlignment(Pos.TOP_CENTER);

        for(RadioButton clickable: options) {

            // sets selectable style
            clickable.getStyleClass().add("button2");

            // add to vbox
            vbox.getChildren().add(clickable);
        }

        return vbox;
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


    private ArrayList<Selectable> bottomPaneButtons(ViewController viewController, CharacterEntity character) {
        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new LevelUpSkillSelectable("Level Up Skill", skillType, character));
            add(new GameplayViewSelectable("Back to Game", viewController));
        }};

        return options;
    }

    private HBox bottomPane(CharacterEntity character) {

        ArrayList<Selectable> options = bottomPaneButtons(viewController, character);

        HBox hbox = new HBox();
        hbox.setMaxHeight(300);

        hbox.setSpacing(20);
        hbox.setPrefSize(1000,72);
        hbox.setAlignment(Pos.TOP_CENTER);

        levelUpSkillButton = new Button(options.get(0).getName());
        levelUpSkillButton.getStyleClass().add("button4");
        levelUpSkillButton.setOnAction(options.get(0));

        levelUpSkillButton.setDisable(true);


        Button gameplayButton = new Button(options.get(1).getName());
        gameplayButton.getStyleClass().add("button4");
        gameplayButton.setOnAction(options.get(1));

        hbox.getChildren().add(levelUpSkillButton);
        hbox.getChildren().add(gameplayButton);


        return hbox;
    }

    private BorderPane borderPane(CharacterEntity character) {

        // create new borderpane for formatting
        BorderPane bp = new BorderPane();

        bp.setTop(topPane());
        bp.setCenter(centerPane(character));

        bp.setBottom(bottomPane(character));
        bp.setLeft(leftPane());
        bp.setRight(rightPane());

        return bp;
    }

    private void refresh(CharacterEntity character) {
        borderPane.setTop(null);
        borderPane.setTop(topPane());
    }
}
