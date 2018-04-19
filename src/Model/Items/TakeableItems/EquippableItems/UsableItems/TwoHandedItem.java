package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.SkillType;
import Model.Map.EffectedAreaCoordinatesCalculator;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.TWOHANDED;

public class TwoHandedItem extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public TwoHandedItem(int damage) {
        super(TWOHANDED);
        this.damage = damage;
    }

    public void triggerItem(CharacterEntity player){

        VariableEffectSkill brawlSkill = (VariableEffectSkill) player.getSpecificSkill(SkillType.TWOHANDEDWEAPONSKILL);
        int healthChange = brawlSkill.calculateChange(damage + player.getAttack());

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-healthChange);

        EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
        ArrayList<Point> effectedCoordinates =
                coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), EffectShape.LINEAR, 1);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("TwoHanded item used");
    }

}
