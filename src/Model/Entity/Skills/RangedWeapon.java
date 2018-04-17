package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.RANGED;

public class RangedWeapon extends Skill {

    public RangedWeapon() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(RANGED);
    }
}
