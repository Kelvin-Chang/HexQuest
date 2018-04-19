package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.STAFF;

public class Staff extends VariableEffectSkill {

    public Staff() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlotNotRequiringSkill(STAFF);
    }
}