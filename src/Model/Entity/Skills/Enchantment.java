package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.ENCHANTMENT;

public class Enchantment extends VariableEffectSkill {

    public Enchantment() {
        super("Enchantment");
    }

    @Override
    public void activateSkill(CharacterEntity player) {
        player.useItemSlotRequiringSkill(ENCHANTMENT, this);
    }
}
