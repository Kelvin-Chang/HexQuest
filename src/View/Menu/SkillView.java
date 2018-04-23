package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.GameplayViewSelectable;
import Controller.buttons.LevelUpSkillSelectable;
import Controller.buttons.Selectable;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.RadioButton;
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
    private BorderPane borderPane;

    public SkillView(ViewController viewController, CharacterEntity characterEntity) {
        this.viewController = viewController;
        this.characterEntity = characterEntity;

        borderPane = borderPane(characterEntity);
        this.getChildren().add(borderPane);
    }


    private StackPane centerPane(CharacterEntity character) {
        StackPane stackPane = new StackPane();
        stackPane.setMaxWidth(0);

        return stackPane;
    }


    private Text topPaneText() {
        Text t = new Text();
        t.setText("Skills");
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

    private ArrayList<RadioButton> centerPaneRadioButtons(CharacterEntity character) {
        ToggleGroup skillToggleGroup = new ToggleGroup();

        ArrayList<RadioButton> options = new ArrayList<RadioButton>();

        HashMap<SkillType, Skill> skillHashMap = character.getSkills();
        Set<SkillType> skillKeys = characterEntity.getSkills().keySet();


        for (SkillType key: skillKeys) {
            RadioButton rb = new RadioButton();

            rb.setUserData(skillHashMap.get(key));
//            rb.setText(skillHashMap.get(key).);


        }



        return options;
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
        borderPane.setCenter(null);
        borderPane.setCenter(centerPane(character));
    }
}
