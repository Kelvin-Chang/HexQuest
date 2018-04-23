package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.UsableItems.UsableItem;
import Model.Zone.HexFormulas;

import java.awt.*;
import java.util.ArrayList;

public abstract class SpellItem extends UsableItem {

    private int manaCost;
    private EffectShape effectShape;
    private int range;
    private static final EffectFactory effectFactory = new EffectFactory();
    private Effect manaChangeEffect;

    public SpellItem(ItemSlot itemSlot, int manaCost, EffectShape effectShape, int range) {
        super(itemSlot);
        this.manaCost = manaCost;
        this.effectShape = effectShape;
        this.range = range;
        this.manaChangeEffect = effectFactory.produceManaModifierEffect(-manaCost);
    }

    public int getManaCost() {
        return manaCost;
    }

    public void useItem(CharacterEntity player, Skill skill) {}

    public ArrayList<Point> getEffectedCoordinates(CharacterEntity player) {
        HexFormulas hexFormulas = new HexFormulas();
        return hexFormulas.getEffectedCoordinates(player.getLocation(), range, player.getZone().getTerrainMap(), player.getOrientation(), effectShape);
    }

    public boolean hasEnoughMana(CharacterEntity player) {
        if (player.hasEnoughManaToCastSpell(manaCost)) {
            manaChangeEffect.trigger(player);
            return true;
        }
        return false;
    }

}
