package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class InstantDeath extends AreaEffect {

    public InstantDeath(){
        this.effect = EffectFactory.produceInstantDeathEffect();
    }

    public String toString() { return "Death"; }

    @Override
    public Orientation getDir() {
        return null;
    }
    @Override
    public void trigger(CharacterEntity characterEntity) {
        effect.trigger(characterEntity);
    }
}
