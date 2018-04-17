import Model.Entity.Character.Inventory;
import Model.Entity.Character.Player;
import Model.Entity.Character.PlayerFactory;
import Model.Items.TakeableItems.BrawlItem;
import Model.Items.TakeableItems.OneHandedItem;
import Model.Items.TakeableItems.TwoHandedItem;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterEntityTests {
    PlayerFactory playerFactory = new PlayerFactory();
    Player smasher;

    @Before
    public void setUp() {
        smasher = playerFactory.produceSmasher();
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
        smasher.setInventory(new Inventory());
        BrawlItem brawlItem = new BrawlItem();

        smasher.getInventory().equipItem(brawlItem);
        smasher.useSkill(3);
    }

    @Test
    public void testUsingOneHandedItem() {
        smasher.setInventory(new Inventory());
        OneHandedItem oneHandedItem = new OneHandedItem();

        smasher.getInventory().equipItem(oneHandedItem);
        smasher.useSkill(4);
    }

    @Test
    public void testUsingTwoHandedItem() {
        smasher.setInventory(new Inventory());
        TwoHandedItem twoHandedItem = new TwoHandedItem();

        smasher.getInventory().equipItem(twoHandedItem);
        smasher.useSkill(5);
    }

}
