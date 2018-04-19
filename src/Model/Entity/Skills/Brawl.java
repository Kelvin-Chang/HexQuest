package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.BRAWL;

public class Brawl extends VariableEffectSkill {

    public Brawl() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(BRAWL);
    }
}
