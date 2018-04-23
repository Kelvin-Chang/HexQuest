package Model.Items;

import Model.Effects.Effect;
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

    private RequirementFactory requirementFactory;
    private EffectFactory effectFactory;

    public ItemFactory() {
        requirementFactory = new RequirementFactory();
        effectFactory = new EffectFactory();
    }

    public static Key produceKeyItem() {
        return new Key();
    }

    public static Ring produceRingItem(int manaChange) {
        return new Ring(manaChange);
    }

    public static ObstacleItem produceObstableItem() {
        return new ObstacleItem("Blocker");
    }

    public static Armor produceArmorItem(int defense) {
        return new Armor(defense);
    }

    public static SmasherWeapon produceGauntlet(int damage) {
        return new SmasherWeapon(damage, ItemSlot.BRAWL, "Gauntlet");
    }

    public static SmasherWeapon produceBrassKnuckles(int damage) {
        return new SmasherWeapon(damage, ItemSlot.BRAWL, "Brass Knuckles");
    }

    public static SmasherWeapon produceBoxingGloves(int damage) {
        return new SmasherWeapon(damage, ItemSlot.BRAWL, "Boxing Gloves");
    }

    public static SmasherWeapon produceDagger(int damage) {
        return new SmasherWeapon(damage, ItemSlot.ONEHANDED, "Dagger");
    }

    public static SmasherWeapon produceCrowbar(int damage) {
        return new SmasherWeapon(damage, ItemSlot.ONEHANDED, "Crowbar");
    }

    public static SmasherWeapon produceMace(int damage) {
        return new SmasherWeapon(damage, ItemSlot.ONEHANDED, "Mace");
    }

    public static SmasherWeapon produceGreatSword(int damage) {
        return new SmasherWeapon(damage, ItemSlot.TWOHANDED, "Great Sword");
    }

    public static SmasherWeapon produceBattleAxe(int damage) {
        return new SmasherWeapon(damage, ItemSlot.TWOHANDED, "Battle Axe");
    }

    public static SmasherWeapon produceClub(int damage) {
        return new SmasherWeapon(damage, ItemSlot.TWOHANDED, "Club");
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

    public static RangedWeapon produceSniperRifle(int damage, EffectShape effectShape, int range) {
        return new RangedWeapon(damage, effectShape, range, "Sniper Rifle");
    }

    public static RangedWeapon produceShotun(int damage, EffectShape effectShape, int range) {
        return new RangedWeapon(damage, effectShape, range, "Shotgun");
    }

    public static RangedWeapon produceBlowDart(int damage, EffectShape effectShape, int range) {
        return new RangedWeapon(damage, effectShape, range, "Blow Dart");
    }

    public OneShotItem produceMoneyBag(int money) {
        return new OneShotItem(effectFactory.produceMoneyModifierEffect(money), "Money Bag");
    }

    public InteractiveArmor produceInteractiveArmor(int defense, Requirement requirement) {
        return new InteractiveArmor(defense, requirement);
    }
}
