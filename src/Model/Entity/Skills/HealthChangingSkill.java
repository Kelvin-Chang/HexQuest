package Model.Entity.Skills;

public abstract class HealthChangingSkill extends Skill {

    public int calculateHealthChange(int maxHealthChange) {
        double percent = percentOfMaxHealthChangeToBeDealt();
        int healthChange = (int) (percent * maxHealthChange);
        return healthChange;
    }

    protected double percentOfMaxHealthChangeToBeDealt() {
        double percent = (double) ( getRandom().nextInt(101 - getSkillLevel()) + getSkillLevel() ) / 100;
        return percent;
    }

}
