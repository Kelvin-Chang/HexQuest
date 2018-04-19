package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.EffectShape;
import Model.Zone.EffectedAreaCoordinatesCalculator;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.STAFF;

public class StaffItem extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public StaffItem(int damage) {
        super(STAFF);
        this.damage = damage;
    }

    @Override
    public void triggerItem(CharacterEntity player) {

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-damage);

        EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
        ArrayList<Point> effectedCoordinates =
                coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), EffectShape.LINEAR, 1);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("Staff item used");
    }
}
