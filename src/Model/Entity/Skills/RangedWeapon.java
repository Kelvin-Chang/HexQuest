package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.RANGED;

public class RangedWeapon extends VariableEffectSkill {

    public RangedWeapon() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlotRequiringSkill(RANGED, this);
    }
}
