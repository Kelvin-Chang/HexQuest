package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;

public class TakeDamage extends AreaEffect {

    public TakeDamage(){
        this.effect = EffectFactory.produceHealthModifierEffect(-1);
    }

    public String toString() { return "Damage"; }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        effect.trigger(characterEntity);
    }
}
