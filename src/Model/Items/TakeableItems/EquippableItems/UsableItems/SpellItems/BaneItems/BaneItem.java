package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.SkillType;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.SpellItem;

import static Model.Enums.ItemSlot.BANE;

public abstract class BaneItem extends SpellItem {

    private int statChange;

    public BaneItem(int manaCost, int statChange, EffectShape effectShape, int range) {
        super(BANE, manaCost, effectShape, range);
        this.statChange = statChange;
    }

    public int calculateAppliedStatChange(CharacterEntity player) {
        VariableEffectSkill baneSkill = (VariableEffectSkill) player.getSpecificSkill(SkillType.BANESKILL);
        return baneSkill.calculateChange(statChange);
    }

}
