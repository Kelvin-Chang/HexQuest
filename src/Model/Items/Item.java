package Model.Items;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public class Item {
    Effect effect;

    public void trigger(CharacterEntity entity) {
            effect.trigger(entity);
    }
}
