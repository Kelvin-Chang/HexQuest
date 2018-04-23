package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.ONEHANDED;

public class OneHandedWeapon extends VariableEffectSkill {

    public OneHandedWeapon() {
        super("OneHandedWeapon");
    }

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlotRequiringSkill(ONEHANDED, this);
    }
}
