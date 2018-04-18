package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.TWOHANDED;

public class TwoHandedWeapon extends VariableEffectSkill {

    public TwoHandedWeapon() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(TWOHANDED);
    }
}
