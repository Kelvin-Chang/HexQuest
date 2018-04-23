package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.EffectShape;
import Model.Zone.HexFormulas;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.STAFF;

public class StaffItem extends UsableItem {

    private int damage;
    private Effect triggerEffect;

    public StaffItem(int damage) {
        super(STAFF);
        this.damage = damage;
        setName("Staff");
    }


    public void useItem(CharacterEntity player) {

        triggerEffect = getEffectFactory().produceHealthModifierEffect(-damage);

        HexFormulas hexFormulas = new HexFormulas();
        ArrayList<Point> effectedCoordinates = hexFormulas.getEffectedCoordinates(player.getLocation(), 1, player.getZone().getTerrainMap(), player.getOrientation(), EffectShape.LINEAR);

        player.effectEntities(effectedCoordinates, triggerEffect);
        System.out.println("Staff item used");
    }
}
