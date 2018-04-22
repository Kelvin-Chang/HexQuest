package Model.Entity.Skills;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;

public class BindWounds extends VariableEffectSkill {

    EffectFactory effectFactory = new EffectFactory();

    public BindWounds() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        Effect healthEffect = effectFactory.produceHealthModifierEffect(calculateChange(5));
        healthEffect.trigger(player);
    }
}
