import Model.AreaEffects.AreaEffect;
//import Model.AreaEffects.Teleport;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Player;
import Model.Entity.Character.PlayerFactory;
import Model.Effects.*;
import Model.Items.ItemFactory;
import Model.Zone.Terrain;
import Model.Zone.Zone;
import Model.Zone.World;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Area;

public class ZoneTest {

    @Test
    public void TerrainPlacing(){
        Zone zone = new Zone(0, 4, 4);

        zone.add(new Point(0,0), Terrain.GRASS);
        zone.add(new Point(0,1), Terrain.GRASS);
        zone.add(new Point(1,0), Terrain.GRASS);
        zone.add(new Point(1,1), Terrain.GRASS);

        Assert.assertTrue(zone.getTerrain(new Point(0,0)) == Terrain.GRASS);
        Assert.assertTrue(zone.getTerrain(new Point(0,1)) == Terrain.GRASS);
        Assert.assertTrue(zone.getTerrain(new Point(1,0)) == Terrain.GRASS);
        Assert.assertTrue(zone.getTerrain(new Point(1,1)) == Terrain.GRASS);

        Assert.assertTrue(zone.getTerrain(new Point(1,2)) == Terrain.EMPTY);
        Assert.assertTrue(zone.getTerrain(new Point(2,1)) == Terrain.EMPTY);

        zone.removeTerrain(new Point(0,0));
        Assert.assertTrue(zone.getTerrain(new Point(0,0)) == Terrain.EMPTY);

        zone.add(new Point(0,0), Terrain.MOUNTAIN);
        Assert.assertTrue(zone.getTerrain(new Point(0,0)) == Terrain.MOUNTAIN);
    }

    @Test
    public void ItemPlacing(){
        Zone zone = new Zone(0, 4, 4);

        zone.add(new Point(0,0), Terrain.GRASS);
        zone.add(new Point(0,1), Terrain.GRASS);
        zone.add(new Point(1,0), Terrain.GRASS);
        zone.add(new Point(1,1), Terrain.GRASS);

        zone.add(new Point(0,0), ItemFactory.produceKeyItem());
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(0,1) ) == null);
        Assert.assertTrue(  zone.getItem(new Point(1,1) ) == null);
        Assert.assertTrue(  zone.getItem(new Point(1,0) ) == null);

        zone.add(new Point(0,1), ItemFactory.produceRingItem(10));
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(0,1) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(1,1) ) == null);
        Assert.assertTrue(  zone.getItem(new Point(1,0) ) == null);

        zone.add(new Point(1,0), ItemFactory.produceArmorItem(10));
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(0,1) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(1,1) ) == null);
        Assert.assertTrue(  zone.getItem(new Point(1,0) ) != null);

        zone.add(new Point(1,1), ItemFactory.produceBrawlItem(10));
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(0,1) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(1,1) ) != null);
        Assert.assertTrue(  zone.getItem(new Point(1,0) ) != null);

    }

    @Test
    public void CharacterPlacing(){
        Zone zone = new Zone(0, 4, 4);
        CharacterEntity characterSmash = PlayerFactory.produceSmasher();
        CharacterEntity characterSummon = PlayerFactory.produceSummoner();
        CharacterEntity characterSneak = PlayerFactory.produceSneak();

        zone.add(new Point(0,0), Terrain.GRASS);
        zone.add(new Point(0,1), Terrain.GRASS);
        zone.add(new Point(1,0), Terrain.GRASS);
        zone.add(new Point(1,1), Terrain.GRASS);

        zone.addPlayer(new Point(0,0), characterSmash);
        zone.addPlayer(new Point(0,1), characterSummon);
        zone.addPlayer(new Point(1,0), characterSneak);

        Assert.assertTrue(zone.getCharacter(new Point(0,0)) != null);
        Assert.assertTrue(zone.getCharacter(new Point(1,0)) != null);
        Assert.assertTrue(zone.getCharacter(new Point(0,1)) != null);

        zone.getCharacter(new Point(0,0)).move();
        Assert.assertTrue(zone.getCharacter(new Point(0,0)) != null);
        zone.moveCharacter(new Point(0,0), new Point(1,1));
        Assert.assertTrue(zone.getCharacter(new Point(0,0)) == null);
        Assert.assertTrue(zone.getCharacter(new Point(1,1)) != null);

    }

    @Test
    public void CharacterOnItem(){
        Zone zone = new Zone();
        Player characterSmash = PlayerFactory.produceSmasher();
        zone.add(new Point(0,0), Terrain.GRASS);
        zone.add(new Point(0,1), Terrain.GRASS);
        zone.add(new Point(1,0), Terrain.GRASS);
        zone.add(new Point(1,1), Terrain.GRASS);

        zone.add(new Point(0,0), ItemFactory.produceKeyItem());
        zone.addPlayer(new Point(0,0), characterSmash);
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) != null);
        Assert.assertTrue(zone.getCharacter(new Point(0,0)) != null);

        zone.doInteractions(characterSmash);
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) == null);
        Assert.assertTrue(characterSmash.getInventory().getItemAtSlot(0) != null);

        zone.add(new Point(0,0), ItemFactory.produceDamageOneShot());
        zone.doInteractions(characterSmash);
        Assert.assertTrue(characterSmash.getCurrentHealth() == 90);
        Assert.assertTrue(  zone.getItem(new Point(0,0) ) == null);

        zone.add(new Point(0,1), ItemFactory.produceObstableItem());
        Assert.assertTrue(zone.getCharacter(new Point(0,0)) != null);
        Assert.assertTrue(!zone.isValidMove(new Point(0,1)));

    }

    @Test
    public void zonete(){
        Zone zone = new Zone(0, 1, 1);
        Zone zoneone = new Zone(1, 1, 1);
        Point p = new Point(0,0);
        Player characterSmash = PlayerFactory.produceSmasher();
        World world = new World(0, characterSmash);
        world.addZone(zone);
        world.addZone(zoneone);
        Effect effect = null;
        zone.add(p, Terrain.GRASS);
        int x = characterSmash.getLevel();
//        Teleport teleport = new Teleport(effect,1, characterSmash, world);
//        zone.add((new Point(0,0)), EffectFactory.produceLevelUpEffect());
        zone.add((new Point(0,0)), EffectFactory.produceTeleportEffect(1, characterSmash, world) );
//        zone.addPlayer(new Point(0,0), characterSmash);


//world 2 zones tiles on of the tiles put, add teleport effect with character
//  zoneone



        zoneone.add(new Point(0,0), Terrain.GRASS);
//        Assert.assertTrue(characterSmash.getZoneId()== 1);
        Assert.assertTrue(characterSmash.getZoneId() == 0);
//world 2 zones tiles on of the tiles put, add teleport effect with character
//  zoneone

    }
}
