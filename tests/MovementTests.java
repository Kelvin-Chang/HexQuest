import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.PlayerFactory;
import Model.Zone.Zone;
import org.junit.Test;

public class MovementTests {

    @Test
    public void CharacterPlacing() {
        Zone zone = new Zone(0, 4, 4);
        CharacterEntity characterSmash = PlayerFactory.produceSmasher();


    }
}
