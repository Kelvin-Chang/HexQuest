package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.BOON;

public class Boon extends VariableEffectSkill {

    public Boon() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(BOON);
    }
}
