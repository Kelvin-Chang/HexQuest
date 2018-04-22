package Controller;

import Model.AreaEffects.AreaEffect;
import Model.Entity.Character.CharacterEntity;
import Model.Items.Item;
import Model.Items.ObstacleItem;
import Model.Zone.FogOfWarHandler;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.GameplayView;
import View.SpriteBase;
import View.Status.StatusView;
import View.Zone.AreaEffectView;
import View.Zone.Items.ItemView;
import View.Zone.Items.ObstacleView;
import View.Zone.MapView;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;

import java.awt.Point;
import java.awt.geom.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Renderer {

    private World world;
    private GameplayView gameplayView;
    private StatusView statusView;
    private Canvas canvas;
    private GraphicsContext graphicsContext;
    private SpriteBase sprites;
    private ObstacleView obstacleView;
    private ItemView itemView;
    private MapView mapView;
    private AreaEffectView areaEffectView;
    private FogOfWarHandler fow;

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
        mapView = new MapView(graphicsContext, sprites);
        obstacleView = new ObstacleView(graphicsContext, sprites);
        itemView = new ItemView(graphicsContext, sprites);
        areaEffectView = new AreaEffectView(graphicsContext, sprites);
        fow = new FogOfWarHandler(world.getPlayer());
        fow.updateZone(world.getCurrentZone());
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());
    }

    public void render() {
        // clear canvas for each render
//        graphicsContext.clearRect(0,0,1000,800);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());

        fow.updateOnTick();
        renderSeenTiles();
        renderVisibleTiles();
        renderPlayer();
        renderOtherEntities();
        renderObstacles();
        renderItems();
        statusView.render(world.getPlayer());

    }

    public void resetCanvas(GameplayView gameplayView) {
        this.gameplayView = gameplayView;
        this.canvas = gameplayView.getCanvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.world = world;
        sprites = new SpriteBase();
        statusView = new StatusView(canvas);
        mapView = new MapView(graphicsContext, sprites);
        obstacleView = new ObstacleView(graphicsContext, sprites);
        itemView = new ItemView(graphicsContext, sprites);
        areaEffectView = new AreaEffectView(graphicsContext, sprites);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillRect(0, 0, canvas.getWidth(),canvas.getHeight());
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void renderVisibleTiles() {
        int size = fow.returnVisibleTiles().size();
        Point[] visible = fow.returnVisibleTiles().toArray(new Point[size]);
        Zone zone = world.getCurrentZone();
        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
        for (int i = 0; i < zoneArr.length; i++) {
            for (int j = 0; j < visible.length; j++) {
                if (zoneArr[i] == visible[j]) {
                    Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
                    Point2D imageCoordinates = calculateImageCoordinates((int) zoneArr[i].getX(), (int) zoneArr[i].getY(), radius);
                    mapView.render(zoneTerrain, imageCoordinates, radius);
                    if (zone.getAreaEffect(zoneArr[i]) != null) {
                        AreaEffect currAE = zone.getAreaEffect(zoneArr[i]);
                        areaEffectView.render(currAE, imageCoordinates, radius);
                    }
                }
            }
        }
    }

    public void renderSeenTiles() {
        int size = fow.returnSeenTiles().size();
        int tsize = fow.getSeenTiles().size();
        Point[] seen = fow.returnSeenTiles().toArray(new Point[size]);
        HashMap<Point, Terrain> tiles = fow.getSeenTiles();
        graphicsContext.setGlobalAlpha(.75);
        graphicsContext.setEffect(new BoxBlur(radius *.25, radius * .25, 1));

        System.out.println("Tile: "+ tsize + " Point: " + size);
        for (int i = 0; i < size; i++) {
            Point currP = seen[i];
            Terrain currT = tiles.get(currP);
            Point2D imageCoordinates = calculateImageCoordinates((int)currP.getX(), (int)currP.getY(), radius);
            mapView.render(currT, imageCoordinates, radius);
            Zone zone = world.getCurrentZone();
            if (zone.getAreaEffect(currP) != null) {
                AreaEffect currAE = zone.getAreaEffect(currP);
                areaEffectView.render(currAE, imageCoordinates, radius);
            }
        }
        graphicsContext.setGlobalAlpha(1);
        graphicsContext.setEffect(null);
    }

//    public void renderSeenTiles() {
//        int size = fow.returnSeenTiles().size();
//        Point[] seen = fow.returnSeenTiles().toArray(new Point[size]);
//        Zone zone = world.getCurrentZone();
//        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
//        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
//        for (int i = 0; i < zoneArr.length; i++) {
//            for (int j = 0; j < seen.length; j++) {
//                if (zoneArr[i] == seen[j]) {
//                    Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
//                    Point2D imageCoordinates = calculateImageCoordinates((int) zoneArr[i].getX(), (int) zoneArr[i].getY(), radius);
//                    mapView.render(zoneTerrain, imageCoordinates, radius);
//                    if (zone.getAreaEffect(zoneArr[i]) != null) {
//                        AreaEffect currAE = zone.getAreaEffect(zoneArr[i]);
//                        areaEffectView.render(currAE, imageCoordinates, radius);
//                    }
//                }
//            }
//        }
//    }
//    public void renderTiles() {
//        Zone zone = world.getCurrentZone();
//        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
//        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
//        for (int i = 0; i < zoneArr.length; i++) {
//            Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
//            Point2D imageCoordinates = calculateImageCoordinates((int) zoneArr[i].getX(), (int) zoneArr[i].getY(), radius);
//            mapView.render(zoneTerrain, imageCoordinates, radius);
//            if (zone.getAreaEffect(zoneArr[i]) != null) {
//                AreaEffect currAE = zone.getAreaEffect(zoneArr[i]);
//                areaEffectView.render(currAE, imageCoordinates, radius);
//            }
//        }
//
//    }

    public void renderObstacles() {
        Zone zone = world.getCurrentZone();
        Collection<Point> obstacleCollection = zone.getAllObstacleItemPoints();
        Point[] obstacleArr = obstacleCollection.toArray(new Point[obstacleCollection.size()]);
        for (int i = 0; i < obstacleArr.length; i++) {
            ObstacleItem obstacle = zone.getObstacleItem(obstacleArr[i]);
            Point2D imageCoordinates = calculateImageCoordinates((int) obstacleArr[i].getX(), (int) obstacleArr[i].getY(), radius);
            obstacleView.render(imageCoordinates, radius);
        }
    }

    private void renderPlayer() {
        Point playerLocation = world.getPlayer().getLocation();
        Point2D imageCoordinates = calculateImageCoordinates((int) playerLocation.getX(),(int) playerLocation.getY(), radius);
        graphicsContext.drawImage(sprites.getCharacterSprite(0), imageCoordinates.getX() + 10, imageCoordinates.getY() + 10, 1.5*radius, 1.5*radius);
    }

    private void renderOtherEntities() {
        Map<Point, CharacterEntity> characterMap = world.getCurrentZone().getCharacterMap();
        for (Point characterLocation : characterMap.keySet()) {
            if (characterLocation != world.getPlayer().getLocation()) {
                Point2D imageCoordinates = calculateImageCoordinates((int) characterLocation.getX(),(int) characterLocation.getY(), radius);
                graphicsContext.drawImage(sprites.getCharacterSprite(1), imageCoordinates.getX()+10, imageCoordinates.getY()+10, 1.5*radius, 1.5*radius);
            }
        }
    }

    private void renderItems() {
        Zone zone = world.getCurrentZone();
        Collection<Point> obstacleCollection = zone.getAllItemPoints();
        Point[] itemArray = obstacleCollection.toArray(new Point[obstacleCollection.size()]);
        for (int i = 0; i < itemArray.length; i++) {
            Item item = zone.getItem(itemArray[i]);
            Point2D imageCoordinates = calculateImageCoordinates((int) itemArray[i].getX(), (int) itemArray[i].getY(), radius);
            itemView.render(item.getName(), imageCoordinates, radius);
        }
    }

    private Point2D calculateImageCoordinates(int x, int y, int radius) {
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
