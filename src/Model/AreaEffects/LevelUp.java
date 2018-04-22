package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;

public class LevelUp extends AreaEffect {

    boolean hasNotBeenTriggered;

    public LevelUp(){
        this.effect = EffectFactory.produceLevelUpEffect();
        hasNotBeenTriggered = true;
    }

    public String toString() { return "Level"; }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        if(hasNotBeenTriggered) {
            effect.trigger(characterEntity);
            this.hasNotBeenTriggered = false;
        }
    }
}
