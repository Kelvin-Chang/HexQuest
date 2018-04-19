package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class LevelUpEffect extends Effect {


    public LevelUpEffect() {}

    @Override
    public void trigger(CharacterEntity character) {
        character.levelUp();
    }

}
