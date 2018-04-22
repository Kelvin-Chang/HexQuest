package Controller;

import Model.AreaEffects.AreaEffect;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.GameplayView;
import View.SpriteBase;
import View.Status.StatusView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.awt.geom.*;

import java.util.Collection;

public class Renderer {

    private World world;
    private GameplayView gameplayView;
    private StatusView statusView;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private SpriteBase sprites;

    // sets the radius/size of tiles and stuff
    private final int radius = 32;

    // TODO: CHANGE TO ADD PROPER IMPLEMENTATION
    public Renderer(World world, GameplayView gameplayView) {
        this.gameplayView = gameplayView;
        this.canvas = gameplayView.getCanvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.world = world;
        sprites = new SpriteBase();
        statusView = new StatusView(canvas);
    }

    public void render() {
        // clear canvas for each render
//        graphicsContext.clearRect(0,0,1000,800);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());
        renderTiles();
        renderPlayer();
        statusView.render(world.getPlayer());

    }


    private void renderPlayer() {
        Point playerLocation = world.getPlayer().getLocation();
        Point2D imageCoordinates = calculateImageCoordinates((int) playerLocation.getX(),(int) playerLocation.getY());
        graphicsContext.drawImage(sprites.getCharacterSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2*radius, 2*radius);
    }

    private void renderTiles() {
        Zone zone = world.getCurrentZone();
        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
        for (int i = 0; i < zoneArr.length; i++) {
            Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
            Point2D imageCoordinates = calculateImageCoordinates((int) zoneArr[i].getX(), (int) zoneArr[i].getY());
            switch (zoneTerrain) {
                case GRASS:
//                    System.out.println("drew Grass" + zoneArr[i].getX() + ", " + zoneArr[i].getY());
                    graphicsContext.drawImage(sprites.getTileSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                    break;
                case MOUNTAIN:
//                    System.out.println("drew Mountain" + zoneArr[i].getX() + ", " + zoneArr[i].getY());
                    graphicsContext.drawImage(sprites.getTileSprite(1), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                    break;
                case WATER:
//                    System.out.println("drew Water" + zoneArr[i].getX() + ", " + zoneArr[i].getY());
                    graphicsContext.drawImage(sprites.getTileSprite(2), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                    break;
                default:
                    break;
            }

            if (zone.getAreaEffect(zoneArr[i]) != null) {
                AreaEffect currAE = zone.getAreaEffect(zoneArr[i]);
                switch (currAE.toString()) {
                    case "Heal":
                        graphicsContext.drawImage(sprites.getEffectSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case "Damage":
                        graphicsContext.drawImage(sprites.getEffectSprite(1), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case "Death":
                        graphicsContext.drawImage(sprites.getEffectSprite(2), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case "Level":
                        break;
                    default:
                        break;
                }
            }
        }
//        System.out.println("end");
    }

    private Point2D calculateImageCoordinates(int x, int y) {
        double a = 0, b = 0;

        if (x % 2 == 1) {
            a = radius * 1.5 * x;
            b = (2 * radius * y) + radius;
        }
        if (x % 2 == 0) {
            a = radius * 1.5 * x;
            b = radius * 2 * y;
        }


        return new Point2D.Double(a, b);
    }
}
