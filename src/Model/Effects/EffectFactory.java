package Model.Effects;

import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;
import Model.Enums.SkillType;
import Model.Zone.World;

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

    public static Effect produceInstantDeathEffect(){return new InstantDeathEffect();}
    
    public static Effect produceLevelUpEffect(){return new LevelUpEffect();}

    public static Effect produceMaxManaModifierEffect(int manaChange) {
        return new MaxManaModifierEffect(manaChange);
    }

    public static Effect produceHealthModifierEffect(int healthChange) {
        return new HealthModifierEffect(healthChange);
    }

    public static Effect produceMoneyModifierEffect(int moneyChange) {
        return new MoneyModifierEffect(moneyChange);
    }

    public static Effect produceRiverEffect(Orientation orientation) {return new RiverEffect(orientation); }

    public static Effect produceSkillModifierEffect(int skillChange, SkillType skillType) {
        return new SkillModifierEffect(skillChange, skillType);
    }

    public static NPCEffect produceAbleToBeAggroedEffect(boolean ableToBeAggroed) {
        return new AbleToBeAggroedEffect(ableToBeAggroed);
    }

}
