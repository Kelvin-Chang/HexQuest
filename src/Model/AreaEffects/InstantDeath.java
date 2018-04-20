package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;

public class InstantDeath extends AreaEffect {

    InstantDeath(){
        this.effect = EffectFactory.produceInstantDeathEffect();
    }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        effect.trigger(characterEntity);
    }
}
