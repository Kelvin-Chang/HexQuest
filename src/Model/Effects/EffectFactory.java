package Model.Effects;

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

    public Effect produceHealthModifierEffect(int healthChange) {
        return new HealthModifierEffect(healthChange);
    }

}
