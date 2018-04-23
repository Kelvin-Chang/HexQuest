package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Zone.EffectedAreaCoordinatesCalculator;
import Model.Zone.HexFormulas;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.RANGED;

public class RangedWeapon extends UsableItem{

    private int damage;
    private EffectShape effectShape;
    private int range;
    private Effect triggerEffect;

    public RangedWeapon(int damage, EffectShape effectShape, int range, String name) {
        super(RANGED);
        this.damage = damage;
        this.effectShape = effectShape;
        this.range = range;
        setName(name);
    }

    public void useItem(CharacterEntity player, Skill skill) {

        int healthChange = ((VariableEffectSkill)skill).calculateChange(damage + player.getAttack());

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-healthChange);

        HexFormulas hexFormulas = new HexFormulas();
        ArrayList<Point> effectedCoordinates = hexFormulas.getEffectedCoordinates(player.getLocation(), range, player.getZone().getTerrainMap(), player.getOrientation(), effectShape);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("RangedWeapon used");
    }

}
