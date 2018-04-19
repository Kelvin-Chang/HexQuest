package Model.Effects;

import Model.Enums.SkillType;

public class EffectFactory {

    public EffectFactory() {}

    public Effect produceAttackModifierEffect(int attackChange) {
        return new AttackModifierEffect(attackChange);
    }

    public Effect produceDefenseModifierEffect(int defenseChange) {
        return new DefenseModifierEffect(defenseChange);
    }

    public Effect produceManaModifierEffect(int manaChange) {
        return new ManaModifierEffect(manaChange);
    }

    public Effect produceMaxManaModifierEffect(int manaChange) {
        return new MaxManaModifierEffect(manaChange);
    }

    public Effect produceHealthModifierEffect(int healthChange) {
        return new HealthModifierEffect(healthChange);
    }

    public Effect produceSkillModifierEffect(int skillChange, SkillType skillType) {
        return new SkillModifierEffect(skillChange, skillType);
    }

}
