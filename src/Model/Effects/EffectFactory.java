package Model.Effects;

import Model.Enums.SkillType;

public class EffectFactory {

    public EffectFactory() {}

    public static Effect produceAttackModifierEffect(int attackChange) {
        return new AttackModifierEffect(attackChange);
    }

    public static Effect produceDefenseModifierEffect(int defenseChange) {
        return new DefenseModifierEffect(defenseChange);
    }

    public static Effect produceManaModifierEffect(int manaChange) {
        return new ManaModifierEffect(manaChange);
    }

    public static Effect produceMaxManaModifierEffect(int manaChange) {
        return new MaxManaModifierEffect(manaChange);
    }

    public static Effect produceHealthModifierEffect(int healthChange) {
        return new HealthModifierEffect(healthChange);
    }
    public static Effect producelvlupEffect() {
        return new lvlupEffect();
    }

    public static Effect produceSkillModifierEffect(int skillChange, SkillType skillType) {
        return new SkillModifierEffect(skillChange, skillType);
    }

}
