package Model.Items;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public class OneShotItem extends Item {

    Effect effect;

    public OneShotItem(Effect effect, String name){
        this.effect = effect;
        setName(name);
    }

    @Override
    public void trigger(CharacterEntity entity) {
        effect.trigger(entity);
    }
}
