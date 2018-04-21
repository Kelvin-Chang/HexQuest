package Controller;

import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.GameplayView;
import View.SpriteBase;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.awt.Point;
import java.awt.geom.*;

import java.util.Collection;

public class Renderer {

    private World world;
    private GameplayView gameplayView;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private SpriteBase sprites;

    // sets the radius/size of tiles and stuff
    private int radius = 16;

    // TODO: CHANGE TO ADD PROPER IMPLEMENTATION
    public Renderer(World world, GameplayView gameplayView) {
        this.gameplayView = gameplayView;
        this.canvas = gameplayView.getCanvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.world = world;
        sprites = new SpriteBase();
    }

    public void render() {
        // clear canvas for each render
        graphicsContext.clearRect(0,0,1000,800);

        renderTiles();
        renderPlayer();

    }


    private void renderPlayer() {
        System.out.println("d");
        Point playerLocation = world.getPlayer().getLocation();
        Point2D imageCoordinates = calculateImageCoordinates((int) playerLocation.getX(),(int) playerLocation.getY());
        graphicsContext.drawImage(sprites.getCharacterSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2*radius, 2*radius);
    }

    private void renderTiles() {
        Zone zone = world.getCurrentZone();
        System.out.println("a");
        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
        System.out.println("b");
        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
        System.out.println("c");
        // initial radius and stuff
        double a = 0;
        double b = 0;

        for (int i = 0; i < zoneArr.length; i++) {
            System.out.println("1");
            Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
            System.out.println("2");
            Point2D imageCoordinates = calculateImageCoordinates((int) zoneArr[i].getX(),(int) zoneArr[i].getY());
            System.out.println("4");
            switch(zoneTerrain) {
                case GRASS:
                    graphicsContext.drawImage(sprites.getTileSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2*radius, 2*radius);
                    break;
                case MOUNTAIN:
                    graphicsContext.drawImage(sprites.getTileSprite(1), imageCoordinates.getX(), imageCoordinates.getY(), 2*radius, 2*radius);
                    break;
                case WATER:
                    graphicsContext.drawImage(sprites.getTileSprite(2), imageCoordinates.getX(), imageCoordinates.getY(), 2*radius, 2*radius);
                    break;
                default:
                    break;
            }
            System.out.println("5");
        }
    }

    private Point2D calculateImageCoordinates(int x, int y) {
        double a = 0, b = 0;

        if (x % 2 == 1) {
            a = radius * 1.5 * x;
            b = (2 * radius * y) + radius;
        }
        System.out.println("3");
        if (x % 2 == 0) {
            a = radius * 1.5 * x;
            b = radius * 2 * y;
        }

        return new Point2D.Double(a, b);
    }
}
