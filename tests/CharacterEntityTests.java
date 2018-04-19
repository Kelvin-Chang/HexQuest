import Model.Entity.Character.Inventory;
import Model.Entity.Character.Player;
import Model.Entity.Character.PlayerFactory;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Enums.SkillType;
import Model.Items.ItemFactory;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Items.TakeableItems.EquippableItems.UsableItems.*;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.BaneItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.DefenseBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BaneItems.HealthBane;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.BoonItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems.HealthBoon;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.SpellItem;
import Model.Items.TakeableItems.Key;
import Model.Zone.Zone;
import Model.Zone.World;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class CharacterEntityTests {

    PlayerFactory playerFactory = new PlayerFactory();
    Player smasher;
    Player summoner;
    Zone zone;
    ItemFactory itemFactory = new ItemFactory();
    World world;

    @Before
    public void setUp() {
        smasher = playerFactory.produceSmasher();
        summoner = playerFactory.produceSummoner();

        zone = new Zone("00", 4, 4);
        zone.getCharacterMap().put(new Point(1,1), summoner);
        smasher.setZone(zone);
        zone.getCharacterMap().put(new Point(1,2), smasher);
        summoner.setZone(zone);
    }

    @Test
    public void testLevelUp() {
        smasher.setLevel(9);

        smasher.levelUp();

        assertEquals(10, smasher.getLevel());
    }

    @Test
    public void testChangingHealthToBelowZero() {
        smasher.setCurrentHealth(100);

        smasher.modifyHealth(-101);

        assertEquals(0, smasher.getCurrentHealth());
    }

    @Test
    public void testChangingHealthToAboveMaxHealth() {
        smasher.setCurrentHealth(99);
        smasher.setMaxHealth(100);

        smasher.modifyHealth(100);

        assertEquals(100, smasher.getCurrentHealth());
    }

    @Test
    public void testChangingHealthToValidValue() {
        smasher.setCurrentHealth(50);
        smasher.setMaxHealth(100);

        smasher.modifyHealth(25);

        assertEquals(75, smasher.getCurrentHealth());
    }

    @Test
    public void testChangingManaToBelowZero() {
        smasher.setCurrentMana(100);

        smasher.modifyMana(-101);

        assertEquals(0, smasher.getCurrentMana());
    }

    @Test
    public void testChangingManaToAboveMaxMana() {
        smasher.setCurrentMana(99);
        smasher.setMaxMana(100);

        smasher.modifyMana(100);

        assertEquals(100, smasher.getCurrentMana());
    }

    @Test
    public void testChangingManaToValidValue() {
        smasher.setCurrentMana(50);
        smasher.setMaxMana(100);

        smasher.modifyMana(25);

        assertEquals(75, smasher.getCurrentMana());
    }

    @Test
    public void testChangingSpeedToBelowZero() {
        smasher.setSpeed(50);

        smasher.modifySpeed(-51);

        assertEquals(0, smasher.getSpeed());
    }

    @Test
    public void testChangingSpeedToValidValue() {
        smasher.setSpeed(50);

        smasher.modifySpeed(25);

        assertEquals(75, smasher.getSpeed());
    }

    @Test
    public void testUsingBrawlItem() {
        smasher.setAttack(5);
        smasher.setInventory(new Inventory());
        smasher.getSpecificSkill(SkillType.BRAWLSKILL).setSkillLevel(100);
        summoner.setCurrentHealth(100);
        summoner.setMaxHealth(100);
        SmasherWeapon brawlItem = itemFactory.produceBrawlItem(5);

        smasher.getInventory().equipItem(brawlItem, smasher);
        smasher.useSkill(SkillType.BRAWLSKILL);
        assertEquals(100, summoner.getCurrentHealth());
    }

    @Test
    public void testUsingOneHandedItem() {
        smasher.setAttack(5);
        smasher.setInventory(new Inventory());
        smasher.getSpecificSkill(SkillType.ONEHANDEDWEAPONSKILL).setSkillLevel(100);
        summoner.setCurrentHealth(100);
        summoner.setMaxHealth(100);
        SmasherWeapon oneHandedItem = itemFactory.produceOneHandedItem(5);

        smasher.getInventory().equipItem(oneHandedItem, smasher);
        smasher.useSkill(SkillType.ONEHANDEDWEAPONSKILL);
        assertEquals(100, summoner.getCurrentHealth());
    }

    @Test
    public void testUsingTwoHandedItem() {
        smasher.setAttack(5);
        smasher.setInventory(new Inventory());
        smasher.getSpecificSkill(SkillType.TWOHANDEDWEAPONSKILL).setSkillLevel(100);
        summoner.setCurrentHealth(100);
        summoner.setMaxHealth(100);
        SmasherWeapon twoHandedItem = itemFactory.produceTwoHandedItem(5);

        smasher.getInventory().equipItem(twoHandedItem, smasher);
        smasher.useSkill(SkillType.TWOHANDEDWEAPONSKILL);
        assertEquals(100, summoner.getCurrentHealth());
    }

    @Test
    public void testUsingStaffAsSummoner() {
        summoner.setInventory(new Inventory());
        summoner.getSpecificSkill(SkillType.STAFFSKILL).setSkillLevel(100);
        StaffItem staffItem = itemFactory.produceStaffItem(5);

        summoner.getInventory().equipItem(staffItem, summoner);
        summoner.useItemSlotNotRequiringSkill(ItemSlot.STAFF);
    }

    @Test
    public void testUsingStaffAsSmasher() {
        smasher.setInventory(new Inventory());
        StaffItem staffItem = itemFactory.produceStaffItem(5);

        smasher.getInventory().equipItem(staffItem, smasher);
        smasher.useItemSlotNotRequiringSkill(ItemSlot.STAFF);
    }

    @Test
    public void testEquippingNotEquippableItem() {
        smasher.setInventory(new Inventory());
        Key key = itemFactory.produceKeyItem();

        smasher.getInventory().equipItem(key, smasher);
    }

    @Test
    public void testEquippingArmor() {
        smasher.setInventory(new Inventory());
        smasher.setDefense(5);
        Armor armor = itemFactory.produceArmorItem(5);

        smasher.getInventory().equipItem(armor, smasher);
        assertEquals(10, smasher.getDefense());
    }

    @Test
    public void testEquippingRing() {
        summoner.setInventory(new Inventory());
        summoner.setMaxMana(10);
        Ring ring = new Ring(5);

        summoner.getInventory().equipItem(ring, summoner);
        assertEquals(15, summoner.getMaxMana());
    }

    @Test
    public void testEquippingRingAndArmor() {
        summoner.setInventory(new Inventory());
        summoner.setMaxMana(10);
        summoner.setDefense(10);
        Ring ring = itemFactory.produceRingItem(5);
        Armor armor = itemFactory.produceArmorItem(5);

        summoner.getInventory().equipItem(ring, summoner);
        summoner.getInventory().equipItem(armor, summoner);
        assertEquals(15, summoner.getMaxMana());
        assertEquals(15, summoner.getDefense());
    }

    @Test
    public void testUsingSpellWithoutEnoughMana() {
        summoner.setInventory(new Inventory());
        summoner.getSpecificSkill(SkillType.BANESKILL).setSkillLevel(100);
        summoner.setMaxMana(100);
        summoner.setCurrentMana(5);
        DefenseBane bane = new DefenseBane(50, 5, EffectShape.LINEAR, 2);

        summoner.getInventory().equipItem(bane, summoner);
        summoner.useSkill(SkillType.BANESKILL);
        assertEquals(5, summoner.getCurrentMana());
    }

    @Test
    public void testUsingDefenseReducingBaneItem() {
        summoner.setInventory(new Inventory());
        summoner.getSpecificSkill(SkillType.BANESKILL).setSkillLevel(100);
        summoner.setMaxMana(100);
        summoner.setCurrentMana(100);
        smasher.setDefense(100);
        SpellItem bane = itemFactory.produceDefenseBane(50, 5, EffectShape.LINEAR, 2);

        summoner.getInventory().equipItem(bane, summoner);
        summoner.useSkill(SkillType.BANESKILL);
        assertEquals(95, smasher.getDefense());
        assertEquals(50, summoner.getCurrentMana());
    }

    @Test
    public void testUsingHealthReducingBaneItem() {
        summoner.setInventory(new Inventory());
        summoner.getSpecificSkill(SkillType.BANESKILL).setSkillLevel(100);
        summoner.setMaxMana(100);
        summoner.setCurrentMana(100);
        smasher.setMaxHealth(100);
        smasher.setCurrentHealth(100);
        SpellItem bane = itemFactory.produceHealthBane(50, 5, EffectShape.LINEAR, 2);

        summoner.getInventory().equipItem(bane, summoner);
        summoner.useSkill(SkillType.BANESKILL);
        assertEquals(95, smasher.getCurrentHealth());
        assertEquals(50, summoner.getCurrentMana());
    }

    @Test
    public void testUsingHealthBoon() {
        summoner.setInventory(new Inventory());
        summoner.getSpecificSkill(SkillType.BOONSKILL).setSkillLevel(100);
        summoner.setMaxMana(100);
        summoner.setCurrentMana(100);
        summoner.setMaxHealth(100);
        summoner.setCurrentHealth(50);
        SpellItem boon = itemFactory.produceHealthBoon(50, 25);

        summoner.getInventory().equipItem(boon, summoner);
        summoner.useSkill(SkillType.BOONSKILL);
        assertEquals(75, summoner.getCurrentHealth());
        assertEquals(50, summoner.getCurrentMana());
    }

}
