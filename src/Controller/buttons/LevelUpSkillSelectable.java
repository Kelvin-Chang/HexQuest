package Controller.buttons;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;
import javafx.event.ActionEvent;

import java.util.HashMap;

public class LevelUpSkillSelectable extends Selectable {

    private SkillType skillType;
    private CharacterEntity characterEntity;


    public LevelUpSkillSelectable() {

    }

    public LevelUpSkillSelectable(String name, SkillType skillType, CharacterEntity characterEntity) {
        super(name);
        this.skillType = skillType;
        this.characterEntity = characterEntity;
    }

    @Override
    public void handle(ActionEvent event) {
        characterEntity.getSkills().get(skillType).updateSkillLevel(1);
        characterEntity.setUnusedSkillPoints(characterEntity.getUnusedSkillPoints() - 1);
    }

}
