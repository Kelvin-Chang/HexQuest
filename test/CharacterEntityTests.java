import Model.Entity.Character.Inventory;
import Model.Entity.Character.Player;
import Model.Entity.Character.PlayerFactory;
import Model.Enums.SkillType;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Items.TakeableItems.EquippableItems.UsableItems.BrawlItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.OneHandedItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.StaffItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.TwoHandedItem;
import Model.Items.TakeableItems.Key;
import Model.Map.Map;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class CharacterEntityTests {

    PlayerFactory playerFactory = new PlayerFactory();
    Player smasher;
    Player summoner;
    Map map;

    @Before
    public void setUp() {
        smasher = playerFactory.produceSmasher();
        summoner = playerFactory.produceSummoner();

        map = new Map();
        map.getCharacterMap().put(new Point(1,1), smasher);
        smasher.setCurrentMap(map);
        map.getCharacterMap().put(new Point(1,2), summoner);
        summoner.setCurrentMap(map);
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
        BrawlItem brawlItem = new BrawlItem(5);

        smasher.getInventory().equipItem(brawlItem, smasher);
        smasher.useSkill(SkillType.BRAWLSKILL);
        assertEquals(90, summoner.getCurrentHealth());
    }

    @Test
    public void testUsingOneHandedItem() {
        smasher.setAttack(5);
        smasher.setInventory(new Inventory());
        smasher.getSpecificSkill(SkillType.ONEHANDEDWEAPONSKILL).setSkillLevel(100);
        summoner.setCurrentHealth(100);
        summoner.setMaxHealth(100);
        OneHandedItem oneHandedItem = new OneHandedItem(5);

        smasher.getInventory().equipItem(oneHandedItem, smasher);
        smasher.useSkill(SkillType.ONEHANDEDWEAPONSKILL);
        assertEquals(90, summoner.getCurrentHealth());
    }

    @Test
    public void testUsingTwoHandedItem() {
        smasher.setAttack(5);
        smasher.setInventory(new Inventory());
        smasher.getSpecificSkill(SkillType.TWOHANDEDWEAPONSKILL).setSkillLevel(100);
        summoner.setCurrentHealth(100);
        summoner.setMaxHealth(100);
        TwoHandedItem twoHandedItem = new TwoHandedItem(5);

        smasher.getInventory().equipItem(twoHandedItem, smasher);
        smasher.useSkill(SkillType.TWOHANDEDWEAPONSKILL);
        assertEquals(90, summoner.getCurrentHealth());
    }

    @Test
    public void testUsingStaff() {
        summoner.setInventory(new Inventory());
        summoner.getSpecificSkill(SkillType.STAFFSKILL).setSkillLevel(100);
        StaffItem staffItem = new StaffItem(5);

        summoner.getInventory().equipItem(staffItem, summoner);
        summoner.useSkill(SkillType.STAFFSKILL);
    }

    @Test
    public void testEquippingNotEquippableItem() {
        smasher.setInventory(new Inventory());
        Key key = new Key();

        smasher.getInventory().equipItem(key, smasher);
    }

    @Test
    public void testEquippingArmor() {
        smasher.setInventory(new Inventory());
        smasher.setDefense(5);
        Armor armor = new Armor(5);

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
        Ring ring = new Ring(5);
        Armor armor = new Armor(5);

        summoner.getInventory().equipItem(ring, summoner);
        summoner.getInventory().equipItem(armor, summoner);
        assertEquals(15, summoner.getMaxMana());
        assertEquals(15, summoner.getDefense());
    }

}
