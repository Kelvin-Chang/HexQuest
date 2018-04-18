package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

public abstract class Skill {

    private int skillLevel;

    public abstract void activateSkill(CharacterEntity player);

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }
}
