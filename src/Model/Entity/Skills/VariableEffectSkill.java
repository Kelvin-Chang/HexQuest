package Model.Entity.Skills;

public abstract class VariableEffectSkill extends Skill {

    public int calculateChange(int change) {
        double percent = percentOfChangeToBeDealt();
        int healthChange = (int) (percent * change);
        return healthChange;
    }

    protected double percentOfChangeToBeDealt() {
        double percent = (double) ( getRandom().nextInt(101 - getSkillLevel()) + getSkillLevel() ) / 100;
        return percent;
    }

}
