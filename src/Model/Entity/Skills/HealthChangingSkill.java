package Model.Entity.Skills;

import java.util.Random;

public abstract class HealthChangingSkill extends Skill {

    private static final Random random = new Random();

    public int calculateHealthChange(int maxHealthChange) {
        return (int) percentOfMaxHealthChangeToBeDealt() * maxHealthChange;
    }

    protected double percentOfMaxHealthChangeToBeDealt() {
        return (double) ( random.nextInt(101 - getSkillLevel()) + getSkillLevel() ) / 100;
    }

}
