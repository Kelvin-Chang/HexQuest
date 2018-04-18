package Model.Entity.Character;

import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends CharacterEntity {


    Player(){

    }
    public Player(HashMap<SkillType, Skill> skillList) {
        super(skillList);
    }
}
