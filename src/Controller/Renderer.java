package Controller;

import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.Collection;

public class Renderer {

    private World world;

    // TODO: CHANGE TO ADD PROPER IMPLEMENTATION
    public Renderer(World world) {
        this.world = world;
    }

    public void render() {
        Zone zone = world.getCurrentZone();

        Collection<Point> zoneCollection = zone.getAllTerrainPoints();

        Point[] zoneArr = (Point[]) zoneCollection.toArray();

        for (int i = 0; i < zoneArr.length; i++) {
            Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);

            switch(zoneTerrain) {
                case GRASS:
                    break;
                case MOUNTAIN:
                    break;
                case WATER:
                    break;
                default:
                    break;
            }
        }
    }
}
