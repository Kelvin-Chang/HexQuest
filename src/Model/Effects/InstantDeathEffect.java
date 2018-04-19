package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class InstantDeathEffect extends Effect {


    public InstantDeathEffect() {}

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyHealth(-character.getCurrentHealth());
    }

}
