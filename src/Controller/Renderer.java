package Controller;

import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.GameplayView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.Point;
import java.io.File;
import java.lang.reflect.Array;
import java.util.Collection;

public class Renderer {

    private World world;
    private GameplayView gameplayView;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    Zone zone;
    Collection<Point> zoneCollection;
    Point[] zoneArr;
    Image grassTile;
    Image playerSprite;

    // TODO: CHANGE TO ADD PROPER IMPLEMENTATION
    public Renderer(World world, GameplayView gameplayView) {
        this.gameplayView = gameplayView;
        this.canvas = gameplayView.getCanvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.world = world;
        zone = world.getCurrentZone();
        zoneCollection = zone.getAllTerrainPoints();
        zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
        File grass = new File(System.getProperty("user.dir") + "/src/assets/grass.png");
        grassTile = new Image(grass.toURI().toString());
        File playa = new File(System.getProperty("user.dir") + "/src/assets/character.png");
        grassTile = new Image(playa.toURI().toString());
    }


    public void render() {
        // initial radius and stuff
        int radius = 16;
        double a = 0;
        double b = 0;

        for (int i = 0; i < zoneArr.length; i++) {
            Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
            int x = (int) zoneArr[i].getX();
            int y = (int) zoneArr[i].getY();

            if (x % 2 == 1) {
                a = radius * 2 * x;
                b = (2 * radius * y) + radius;
            }

            else if (x % 2 == 0) {
                a = radius * 2 * x;
                b = radius * 2 * y;
            }

            switch(zoneTerrain) {
                case GRASS:
                    graphicsContext.drawImage(grassTile, a, b, 2 * radius, 2 * radius);
                    break;
                case MOUNTAIN:
                    graphicsContext.drawImage(grassTile, a, b, 2 * radius, 2 * radius);
                    break;
                case WATER:
                    graphicsContext.drawImage(grassTile, a, b, 2 * radius, 2 * radius);
                    break;
                default:
                    break;
            }
        }

        Point playerLocation = world.getPlayer().getLocation();
        int x = (int)playerLocation.getX();
        int y = (int)playerLocation.getY();
        if (x % 2 == 1) {
            a = radius * 2 * x;
            b = (2 * radius * y) + radius;
        }

        else {
            a = radius * 2 * x;
            b = radius * 2 * y;
        }
        
        graphicsContext.drawImage(playerSprite, a, b, 2*radius, 2*radius);
    }

}
