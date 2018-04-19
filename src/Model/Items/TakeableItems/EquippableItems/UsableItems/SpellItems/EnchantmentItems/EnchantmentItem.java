package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.EnchantmentItems;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.SkillType;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.SpellItem;

import static Model.Enums.ItemSlot.ENCHANTMENT;

public abstract class EnchantmentItem extends SpellItem {

    private int statChange;

    public EnchantmentItem(int manaCost, int statChange, EffectShape effectShape, int range) {
        super(ENCHANTMENT, manaCost, effectShape, range);
        this.statChange = statChange;
    }

    public int calculateAppliedStatChange(CharacterEntity player) {
        VariableEffectSkill baneSkill = (VariableEffectSkill) player.getSpecificSkill(SkillType.ENCHANTMENTSKILL);
        return baneSkill.calculateChange(statChange);
    }

}
