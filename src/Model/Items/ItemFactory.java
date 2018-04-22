package Model.Items;

import Model.Effects.EffectFactory;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.InteractiveArmor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Items.TakeableItems.EquippableItems.UsableItems.RangedWeapon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SmasherWeapon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.DefenseBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.HealthBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.ManaBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.DefenseBoon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.HealthBoon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.ManaBoon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.EnchantmentItems.DecreaseBargainingEnchantment;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.EnchantmentItems.DecreaseBindWoundsEnchantment;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.EnchantmentItems.DecreaseObservationEnchantment;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.SpellItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.StaffItem;
import Model.Items.TakeableItems.Key;
import Model.Requirements.Requirement;
import Model.Requirements.RequirementFactory;

public class ItemFactory {

    private RequirementFactory requirementFactory = new RequirementFactory();

    public ItemFactory() {}

    public static Key produceKeyItem() {
        return new Key();
    }

    public static Ring produceRingItem(int manaChange) {
        return new Ring(manaChange);
    }

    public static OneShotItem produceDamageOneShot() {
        return new OneShotItem(EffectFactory.produceHealthModifierEffect(-10));
    }

    public static ObstacleItem produceObstableItem() {
        return new ObstacleItem("Blocker");
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

    public static SpellItem produceManaBane(int manaCost, int manaChange, EffectShape effectShape, int range) {
        return new ManaBane(manaCost, manaChange, effectShape, range);
    }

    public static SpellItem produceHealthBoon(int manaCost, int healthChange) {
        return new HealthBoon(manaCost, healthChange);
    }

    public static SpellItem produceDefenseBoon(int manaCost, int defenseChange) {
        return new DefenseBoon(manaCost, defenseChange);
    }

    public static SpellItem produceManaBoon(int manaCost, int manaChange) {
        return new ManaBoon(manaCost, manaChange);
    }

    public static SpellItem produceDecreaseBargainingEnchantment(int manaCost, int skillDecrease, EffectShape effectShape, int range) {
        return new DecreaseBargainingEnchantment(manaCost, skillDecrease, effectShape, range);
    }

    public static SpellItem produceDecreaseBindWoundsEnchantment(int manaCost, int skillDecrease, EffectShape effectShape, int range) {
        return new DecreaseBindWoundsEnchantment(manaCost, skillDecrease, effectShape, range);
    }

    public static SpellItem produceDecreaseObservationEnchantment(int manaCost, int skillDecrease, EffectShape effectShape, int range) {
        return new DecreaseObservationEnchantment(manaCost, skillDecrease, effectShape, range);
    }

    public static RangedWeapon produceRangedWeapon(int damage, EffectShape effectShape, int range) {
        return new RangedWeapon(damage, effectShape, range);
    }

    public InteractiveArmor produceInteractiveArmor(int defense, Requirement requirement) {
        return new InteractiveArmor(defense, requirement);
    }
}
