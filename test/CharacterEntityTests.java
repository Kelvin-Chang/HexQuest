import Model.Entity.Character.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterEntityTests {
    Player character;

    @Before
    public void setUp() {
        character = new Player();
    }

    @Test
    public void testChangingHealthToBelowZero() {
        character.setCurrentHealth(100);

        character.modifyHealth(-101);

        assertEquals(0, character.getCurrentHealth());
    }

    @Test
    public void testChangingHealthToAboveMaxHealth() {
        character.setCurrentHealth(99);
        character.setMaxHealth(100);

        character.modifyHealth(100);

        assertEquals(100, character.getCurrentHealth());
    }

    @Test
    public void testChangingHealthToValidValue() {
        character.setCurrentHealth(50);
        character.setMaxHealth(100);

        character.modifyHealth(25);

        assertEquals(75, character.getCurrentHealth());
    }

    @Test
    public void testChangingManaToBelowZero() {
        character.setCurrentMana(100);

        character.modifyMana(-101);

        assertEquals(0, character.getCurrentMana());
    }

    @Test
    public void testChangingManaToAboveMaxMana() {
        character.setCurrentMana(99);
        character.setMaxMana(100);

        character.modifyMana(100);

        assertEquals(100, character.getCurrentMana());
    }

    @Test
    public void testChangingManaToValidValue() {
        character.setCurrentMana(50);
        character.setMaxMana(100);

        character.modifyMana(25);

        assertEquals(75, character.getCurrentMana());
    }



}
