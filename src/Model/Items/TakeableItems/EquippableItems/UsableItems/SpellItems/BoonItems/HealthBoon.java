package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.EffectShape;

public class HealthBoon extends BoonItem {

    public HealthBoon(int manaCost, int healthChange) {
        super(manaCost, healthChange, EffectShape.LINEAR, 1);
    }

    @Override
    public void triggerItem(CharacterEntity player) {
        if (hasEnoughMana(player)) {
            Effect triggerEffect = getEffectFactory().produceHealthModifierEffect(calculateAppliedStatChange(player));

            player.effectEntities(getOwnLocation(player), triggerEffect);
            System.out.println("BoonItem used with enough mana");
        } else {
            System.out.println("BoonItem used, but not enough mana");
        }
    }

}