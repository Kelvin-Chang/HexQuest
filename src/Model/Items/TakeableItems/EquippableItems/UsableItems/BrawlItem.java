package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.EffectShape;
import Model.Map.EffectedAreaCoordinatesCalculator;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.BRAWL;

public class BrawlItem extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public BrawlItem(int damage) {
        super(BRAWL);
        this.damage = damage;
    }

    public void triggerItem(CharacterEntity player){

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-(damage + player.getAttack()));

        EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
        ArrayList<Point> effectedCoordinates =
                coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), EffectShape.LINEAR, 1);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("Brawl item used");

    }

}
