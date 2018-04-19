package Model.Effects;

import Model.Entity.Character.CharacterEntity;


public class lvlupEffect extends Effect {

    private int healthChange;

    public lvlupEffect() {

    }

    @Override
    public void trigger(CharacterEntity character) {
        character.levelUp();
    }

}

