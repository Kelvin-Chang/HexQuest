package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.EffectShape;

public class HealthBane extends BaneItem {

    public HealthBane(int manaCost, int defenseChange, EffectShape effectShape, int range) {
        super(manaCost, defenseChange, effectShape, range);
        setName("Health Bane");
    }

    @Override
    public void useItem(CharacterEntity player, Skill skill) {
        if (hasEnoughMana(player)) {
            Effect triggerEffect = getEffectFactory().produceHealthModifierEffect(-calculateAppliedStatChange(player));

            player.effectEntities(getEffectedCoordinates(player), triggerEffect);
            System.out.println("BaneItem used with enough mana");
        } else {
            System.out.println("BaneItem used, but not enough mana");
        }
    }

}