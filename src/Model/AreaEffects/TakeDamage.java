package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;

public class TakeDamage extends AreaEffect {

    TakeDamage(Effect effect){
        this.effect = EffectFactory.produceHealthModifierEffect(-10);
    }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        effect.trigger(characterEntity);
    }
}
