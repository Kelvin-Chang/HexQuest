package Model.Entity.Character;

import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;

import java.util.ArrayList;
import java.util.HashMap;

public class Player extends CharacterEntity {

<<<<<<< HEAD
    public Player(ArrayList<Skill> skillList) {
=======

    Player(){

    }
    public Player(HashMap<SkillType, Skill> skillList) {
>>>>>>> develop
        super(skillList);
    }
}
