package Model.Entity.Character;

import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends CharacterEntity {

    String playerClass;


    public Player(){

    }
    public Player(HashMap<SkillType, Skill> skillList) {
        super(skillList);
    }



    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }
}
