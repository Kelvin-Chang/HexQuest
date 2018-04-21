package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;

public class LevelUp extends AreaEffect {

    boolean hasBeenTriggered;

    public LevelUp(){
        this.effect = EffectFactory.produceLevelUpEffect();
        hasBeenTriggered = false;
    }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        if(!hasBeenTriggered) {
            effect.trigger(characterEntity);
            this.hasBeenTriggered = true;
        }
    }
}
