package Controller.buttons;

import Controller.Input.ViewController;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;
import javafx.event.ActionEvent;

import javax.swing.text.View;
import java.util.HashMap;

public class LevelUpSkillSelectable extends Selectable {

    private SkillType skillType;
    private CharacterEntity characterEntity;
    private ViewController viewController;


    public LevelUpSkillSelectable() {

    }

    public LevelUpSkillSelectable(String name, SkillType skillType, CharacterEntity characterEntity, ViewController viewController) {
        super(name);
        this.skillType = skillType;
        this.characterEntity = characterEntity;
        this.viewController = viewController;
    }

    @Override
    public void handle(ActionEvent event) {
        characterEntity.getSkills().get(skillType).updateSkillLevel(1);
        characterEntity.setUnusedSkillPoints(characterEntity.getUnusedSkillPoints() - 1);
        viewController.switchToSkillView();
    }

}
