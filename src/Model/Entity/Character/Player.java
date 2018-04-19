package Model.Entity.Character;

import Model.Entity.Skills.Skill;

import java.util.ArrayList;

public class Player extends CharacterEntity {

    public Player(ArrayList<Skill> skillList) {
        super(skillList);
    }
}
