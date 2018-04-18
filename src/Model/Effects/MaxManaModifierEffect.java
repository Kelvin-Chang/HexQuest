package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class MaxManaModifierEffect extends Effect {

    private int manaChange;

    public MaxManaModifierEffect(int manaChange) {
        this.manaChange = manaChange;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyMaxMana(manaChange);
    }

}
