import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.PlayerFactory;
import Model.Zone.Terrain;
import Model.Zone.Zone;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class MovementTests {

    @Test
    public void CharacterMovement() {
        Zone zone = new Zone(0, 7, 7);
        CharacterEntity characterSmash = PlayerFactory.produceSmasher();

        for(int i = 0; i < 7; ++i){
            for(int j = 0; j < 7; ++j)
                zone.add(new Point(i,j), Terrain.GRASS);
        }

        zone.addPlayer(new Point(3,3), characterSmash);
        characterSmash.addDownToMovementQueue();
        zone.attemptMove(characterSmash);

        Assert.assertTrue(zone.getCharacterLocation(characterSmash).x == 3 && zone.getCharacterLocation(characterSmash).y==4);
        //System.out.println(characterSmash.getLocation());

        characterSmash.addDownToMovementQueue();
        zone.attemptMove(characterSmash);
        Assert.assertTrue(zone.getCharacterLocation(characterSmash).x == 3 && zone.getCharacterLocation(characterSmash).y==5);

        characterSmash.addUpLeftToMovementQueue();
        zone.attemptMove(characterSmash);
        Assert.assertTrue(zone.getCharacterLocation(characterSmash).x == 2 && zone.getCharacterLocation(characterSmash).y==5);

        characterSmash.addUpLeftToMovementQueue();
        zone.attemptMove(characterSmash);
        Assert.assertTrue(zone.getCharacterLocation(characterSmash).x == 1 && zone.getCharacterLocation(characterSmash).y==4);

        characterSmash.addUpRightToMovementQueue();
        zone.attemptMove(characterSmash);
        Assert.assertTrue(zone.getCharacterLocation(characterSmash).x == 2 && zone.getCharacterLocation(characterSmash).y==4);
    }
}
