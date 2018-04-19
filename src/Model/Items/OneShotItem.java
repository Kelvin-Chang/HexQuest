package Model.Items;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public class OneShotItem extends Item {
    Effect effect;
    boolean hasBeenTriggered;

    OneShotItem(Effect effect){
        this.effect = effect;
        this.hasBeenTriggered = false;
    }

    @Override
    public void trigger(CharacterEntity entity) {
        if(!hasBeenTriggered) {
            effect.trigger(entity);
            this.hasBeenTriggered = true;
        }
    }
}
