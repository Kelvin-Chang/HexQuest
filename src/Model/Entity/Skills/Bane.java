package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.BANE;

public class Bane extends VariableEffectSkill {


    public Bane() {
        super("Bane");
    }

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlotRequiringSkill(BANE, this);
    }
}
