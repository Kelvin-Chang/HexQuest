package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class AddToInventoryEffect implements Effect {
    Effect effect;


    @Override
    public void trigger(CharacterEntity character) {
        effect.trigger(character);
    }
}
