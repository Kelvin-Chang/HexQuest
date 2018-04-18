package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.BANE;
import static Model.Enums.ItemSlot.STAFF;

public class Staff extends HealthChangingSkill {

    public Staff() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(STAFF);
    }
}