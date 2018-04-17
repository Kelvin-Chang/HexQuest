package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.TWOHANDED;

public class TwoHandedWeapon extends Skill {

    public TwoHandedWeapon() {}

    @Override
    public void effect(CharacterEntity player) {
        player.useItemSlot(TWOHANDED);
    }
}
