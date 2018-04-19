package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.ENCHANTMENT;

public class Enchantment extends Skill {

    public Enchantment() {}

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlot(ENCHANTMENT);
    }
}
