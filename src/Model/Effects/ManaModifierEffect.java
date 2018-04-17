package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class ManaModifierEffect extends Effect {

    private int manaChange;

    public ManaModifierEffect(int manaChange) {
        this.manaChange = manaChange;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyMana(manaChange);
    }

}
