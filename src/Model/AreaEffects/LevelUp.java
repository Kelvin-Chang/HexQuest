package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class LevelUp extends AreaEffect {

    boolean hasNotBeenTriggered;

    public LevelUp(){
        this.effect = EffectFactory.produceLevelUpEffect();
        hasNotBeenTriggered = true;
    }

    @Override
    public Orientation getDir() {
        return null;
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
