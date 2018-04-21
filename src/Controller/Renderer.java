package Controller;

import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.GameplayView;
import View.SpriteBase;
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
    private SpriteBase sprites;

    // TODO: CHANGE TO ADD PROPER IMPLEMENTATION
    public Renderer(World world, GameplayView gameplayView) {
        this.gameplayView = gameplayView;
        this.canvas = gameplayView.getCanvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.world = world;
        sprites = new SpriteBase();
    }

    public void render() {
        Zone zone = world.getCurrentZone();
        System.out.println("a");
        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
        System.out.println("b");
        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
        System.out.println("c");
        // initial radius and stuff
        int radius = 16;
        double a = 0;
        double b = 0;

        for (int i = 0; i < zoneArr.length; i++) {
            System.out.println("1");
            Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
            int x = (int) zoneArr[i].getX();
            int y = (int) zoneArr[i].getY();
            System.out.println("2");
            if (x % 2 == 1) {
                a = radius * 1.5 * x;
                b = (2 * radius * y) + radius;
            }
            System.out.println("3");
            if (x % 2 == 0) {
                a = radius * 1.5 * x;
                b = radius * 2 * y;
            }
            System.out.println("4");
            switch(zoneTerrain) {
                case GRASS:
                    graphicsContext.drawImage(sprites.getTileSprite(0), a, b, 2*radius, 2*radius);
                    break;
                case MOUNTAIN:
                    graphicsContext.drawImage(sprites.getTileSprite(1), a, b, 2*radius, 2*radius);
                    break;
                case WATER:
                    graphicsContext.drawImage(sprites.getTileSprite(2), a, b, 2*radius, 2*radius);
                    break;
                default:
                    break;
            }
            System.out.println("5");
        }
        System.out.println("d");
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
        graphicsContext.drawImage(sprites.getCharacterSprite(0), a, b, 2*radius, 2*radius);
    }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }

}
