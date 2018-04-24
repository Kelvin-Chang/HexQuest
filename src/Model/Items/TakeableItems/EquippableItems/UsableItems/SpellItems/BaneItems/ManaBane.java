package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.EffectShape;

public class ManaBane extends BaneItem {

    public ManaBane(int manaCost, int defenseChange, EffectShape effectShape, int range) {
        super(manaCost, defenseChange, effectShape, range);
        setName("Mana Bane");
    }

    @Override
    public void useItem(CharacterEntity player, Skill skill) {
        if (hasEnoughMana(player)) {
            Effect triggerEffect = getEffectFactory().produceManaModifierEffect(-calculateAppliedStatChange(player));

            player.effectEntities(getEffectedCoordinates(player), triggerEffect);
            System.out.println("BaneItem used with enough mana");
        } else {
            System.out.println("BaneItem used, but not enough mana");
        }
    }

}
