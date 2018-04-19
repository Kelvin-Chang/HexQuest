package Model.Items;

import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SmasherWeapon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.BaneItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.DefenseBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.HealthBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.BoonItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.HealthBoon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.SpellItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.StaffItem;
import Model.Items.TakeableItems.Key;

public class ItemFactory {

    public ItemFactory() {}

    public static Key produceKeyItem() {
        return new Key();
    }

    public static Ring produceRingItem(int manaChange) {
        return new Ring(manaChange);
    }

    public static Armor produceArmorItem(int defense) {
        return new Armor(defense);
    }

    public static SmasherWeapon produceBrawlItem(int damage) {
        return new SmasherWeapon(damage, ItemSlot.BRAWL);
    }

    public static SmasherWeapon produceOneHandedItem(int damage) {
        return new SmasherWeapon(damage, ItemSlot.ONEHANDED);
    }

    public static SmasherWeapon produceTwoHandedItem(int damage) {
        return new SmasherWeapon(damage, ItemSlot.TWOHANDED);
    }

    public static StaffItem produceStaffItem(int damage) {
        return new StaffItem(damage);
    }

    public static SpellItem produceDefenseBane(int manaCost, int defenseChange, EffectShape effectShape, int range) {
        return new DefenseBane(manaCost, defenseChange, effectShape, range);
    }

    public static SpellItem produceHealthBane(int manaCost, int healthChange, EffectShape effectShape, int range) {
        return new HealthBane(manaCost, healthChange, effectShape, range);
    }

    public static SpellItem produceHealthBoon(int manaCost, int healthChange) {
        return new HealthBoon(manaCost, healthChange);
    }
}
