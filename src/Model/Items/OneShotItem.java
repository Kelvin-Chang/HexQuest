package Model.Items;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public class OneShotItem extends Item {

    Effect effect;

    OneShotItem(Effect effect){
        this.effect = effect;
    }

    @Override
    public void trigger(CharacterEntity entity) {
        effect.trigger(entity);
    }
}
