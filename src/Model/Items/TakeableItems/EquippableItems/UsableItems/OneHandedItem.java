package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.HealthChangingSkill;
import Model.Enums.EffectShape;
import Model.Enums.SkillType;
import Model.Map.EffectedAreaCoordinatesCalculator;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.ONEHANDED;

public class OneHandedItem extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public OneHandedItem(int damage) {
        super(ONEHANDED);
        this.damage = damage;
    }

    public void triggerItem(CharacterEntity player){

        HealthChangingSkill brawlSkill = (HealthChangingSkill) player.getSpecificSkill(SkillType.ONEHANDEDWEAPONSKILL);
        int healthChange = brawlSkill.calculateHealthChange(damage + player.getAttack());

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-healthChange);

        EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
        ArrayList<Point> effectedCoordinates =
                coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), EffectShape.LINEAR, 1);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("OneHanded item used");
    }

}
