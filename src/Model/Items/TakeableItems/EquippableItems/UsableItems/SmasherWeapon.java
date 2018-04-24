package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Zone.HexFormulas;

import java.awt.*;
import java.util.ArrayList;

public class SmasherWeapon extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public SmasherWeapon(int damage, ItemSlot itemSlot, String name) {
        super(itemSlot);
        this.damage = damage;
        setName(name);
    }

    public void useItem(CharacterEntity player, Skill skill) {

        int healthChange = ((VariableEffectSkill)skill).calculateChange(damage + player.getAttack());

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-healthChange);

        HexFormulas hexFormulas = new HexFormulas();
        ArrayList<Point> effectedCoordinates = hexFormulas.getEffectedCoordinates(player.getLocation(), 1, player.getZone().getTerrainMap(), player.getOrientation(), EffectShape.LINEAR);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("Brawl item used");
    }

}
