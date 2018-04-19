package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Zone.EffectedAreaCoordinatesCalculator;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.RANGED;

public class RangedWeapon extends UsableItem{

    private int damage;
    private EffectShape effectShape;
    private int range;
    private Effect triggerEffect;

    public RangedWeapon(int damage, EffectShape effectShape, int range) {
        super(RANGED);
        this.damage = damage;
        this.effectShape = effectShape;
        this.range = range;
    }

    public void triggerItem(CharacterEntity player, Skill skill) {

        int healthChange = ((VariableEffectSkill)skill).calculateChange(damage + player.getAttack());

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-healthChange);

        EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
        ArrayList<Point> effectedCoordinates =
                coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), effectShape, range);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("RangedWeapon used");
    }

}
