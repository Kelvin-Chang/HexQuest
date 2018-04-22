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

public class SmasherWeapon extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public SmasherWeapon(int damage, ItemSlot itemSlot) {
        super(itemSlot);
        this.damage = damage;
        setName("Smasher Weapon");
    }

    public void useItem(CharacterEntity player, Skill skill) {

        int healthChange = ((VariableEffectSkill)skill).calculateChange(damage + player.getAttack());

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-healthChange);

        EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
        ArrayList<Point> effectedCoordinates =
                coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), EffectShape.LINEAR, 1);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("Brawl item used");
    }

}
