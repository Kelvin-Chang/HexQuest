package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.BANE;

public class Bane extends HealthChangingSkill {

    public Bane() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(BANE);
    }
}
