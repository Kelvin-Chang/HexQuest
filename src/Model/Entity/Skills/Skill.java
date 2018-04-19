package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import java.util.Random;

public abstract class Skill {

    private static final Random random = new Random();
    private int skillLevel;

    public static Random getRandom() {
        return random;
    }

    public abstract void activateSkill(CharacterEntity player);

    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public boolean skillSuccessful() {
        if (skillLevel >= RANDOM_NUMBER()) {
            return true;
        }
        return false;
    }

    private int RANDOM_NUMBER() {
        return random.nextInt(101);
    }
}
