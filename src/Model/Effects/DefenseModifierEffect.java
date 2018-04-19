package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class DefenseModifierEffect implements Effect {

    private int defenseChange;

    public DefenseModifierEffect(int defenseChange) {
        this.defenseChange = defenseChange;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyDefense(defenseChange);
    }

}
