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
    private Point cameraPosition;
    private boolean cameraControl;

    // sets the radius/size of tiles and stuff
    private final int radius = 32;

    public Renderer(World world, GameplayView gameplayView) {
        this.gameplayView = gameplayView;
        this.canvas = gameplayView.getCanvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.world = world;
        cameraPosition = world.getPlayer().getLocation();
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

        if (!cameraControl) {
            cameraPosition = world.getPlayer().getLocation();
        }
        fow.updateOnTick();
        renderSeenTiles(cameraPosition);
        renderVisibleTiles(cameraPosition);
        renderPlayer(cameraPosition);
        renderOtherEntities(cameraPosition);
        renderObstacles(cameraPosition);
        renderItems(cameraPosition);
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

    public void renderVisibleTiles(Point cameraPosition) {
        int size = fow.returnVisibleTiles().size();
        Point[] visible = fow.returnVisibleTiles().toArray(new Point[size]);
        Zone zone = world.getCurrentZone();
        Collection<Point> zoneCollection = zone.getAllTerrainPoints();
        Point[] zoneArr = zoneCollection.toArray(new Point[zoneCollection.size()]);
        for (int i = 0; i < zoneArr.length; i++) {
            for (int j = 0; j < visible.length; j++) {
                if (zoneArr[i] == visible[j]) {
                    Terrain zoneTerrain = zone.getTerrain(zoneArr[i]);
                    Point2D imageCoordinates = calculateImageCoordinates((int) zoneArr[i].getX(), (int) zoneArr[i].getY(), radius, cameraPosition);
                    mapView.render(zoneTerrain, imageCoordinates, radius);
                    if (zone.getAreaEffect(zoneArr[i]) != null) {
                        AreaEffect currAE = zone.getAreaEffect(zoneArr[i]);
                        areaEffectView.render(currAE, imageCoordinates, radius);
                    }
                }
            }
        }
    }

    public void renderSeenTiles(Point cameraPosition) {
        int size = fow.returnSeenTiles().size();
        int tsize = fow.getSeenTiles().size();
        Point[] seen = fow.returnSeenTiles().toArray(new Point[size]);
        HashMap<Point, Terrain> tiles = fow.getSeenTiles();
        graphicsContext.setGlobalAlpha(.75);
        graphicsContext.setEffect(new BoxBlur(radius *.25, radius * .25, 1));

        for (int i = 0; i < size; i++) {
            Point currP = seen[i];
            Terrain currT = tiles.get(currP);
            Point2D imageCoordinates = calculateImageCoordinates((int)currP.getX(), (int)currP.getY(), radius, cameraPosition);
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

    public void renderObstacles(Point cameraPosition) {
        Zone zone = world.getCurrentZone();
        Collection<Point> obstacleCollection = zone.getAllObstacleItemPoints();
        Point[] obstacleArr = obstacleCollection.toArray(new Point[obstacleCollection.size()]);
        for (int i = 0; i < obstacleArr.length; i++) {
            if (isVisible(obstacleArr[i])){
                ObstacleItem obstacle = zone.getObstacleItem(obstacleArr[i]);
                Point2D imageCoordinates = calculateImageCoordinates((int) obstacleArr[i].getX(), (int) obstacleArr[i].getY(), radius, cameraPosition);
                obstacleView.render(imageCoordinates, radius);
            } else if (isSeen(obstacleArr[i])) {
                graphicsContext.setGlobalAlpha(.75);
                graphicsContext.setEffect(new BoxBlur(radius *.25, radius * .25, 1));
                ObstacleItem obstacle = zone.getObstacleItem(obstacleArr[i]);
                Point2D imageCoordinates = calculateImageCoordinates((int) obstacleArr[i].getX(), (int) obstacleArr[i].getY(), radius, cameraPosition);
                obstacleView.render(imageCoordinates, radius);
            } else {

            }
            graphicsContext.setGlobalAlpha(1);
            graphicsContext.setEffect(null);
        }
    }

    private void renderPlayer(Point cameraPosition) {
        Point playerLocation = world.getPlayer().getLocation();
        Point2D imageCoordinates = calculateImageCoordinates((int) playerLocation.getX(),(int) playerLocation.getY(), radius, cameraPosition);
        graphicsContext.drawImage(sprites.getCharacterSprite(0), imageCoordinates.getX() + 10, imageCoordinates.getY() + 10, 1.5*radius, 1.5*radius);
    }

    private void renderOtherEntities(Point cameraPosition) {
        Map<Point, CharacterEntity> characterMap = world.getCurrentZone().getCharacterMap();
        for (Point characterLocation : characterMap.keySet()) {
            if (isVisible(characterLocation)) {
                if (characterLocation != world.getPlayer().getLocation()) {
                    Point2D imageCoordinates = calculateImageCoordinates((int) characterLocation.getX(),(int) characterLocation.getY(), radius, cameraPosition);
                    graphicsContext.drawImage(sprites.getCharacterSprite(1), imageCoordinates.getX()+10, imageCoordinates.getY()+10, 1.5*radius, 1.5*radius);
                }
            } else if (isSeen(characterLocation)) {
                graphicsContext.setGlobalAlpha(.75);
                graphicsContext.setEffect(new BoxBlur(radius *.25, radius * .25, 1));
                if (characterLocation != world.getPlayer().getLocation()) {
                    Point2D imageCoordinates = calculateImageCoordinates((int) characterLocation.getX(),(int) characterLocation.getY(), radius, cameraPosition);
                    graphicsContext.drawImage(sprites.getCharacterSprite(1), imageCoordinates.getX()+10, imageCoordinates.getY()+10, 1.5*radius, 1.5*radius);
                }
            } else {

            }
            graphicsContext.setGlobalAlpha(1);
            graphicsContext.setEffect(null);
        }
    }

    private void renderItems(Point cameraPosition) {
        Zone zone = world.getCurrentZone();
        Collection<Point> obstacleCollection = zone.getAllItemPoints();
        Point[] itemArray = obstacleCollection.toArray(new Point[obstacleCollection.size()]);
        for (int i = 0; i < itemArray.length; i++) {
            if (isVisible(itemArray[i])) {
                Item item = zone.getItem(itemArray[i]);
                Point2D imageCoordinates = calculateImageCoordinates((int) itemArray[i].getX(), (int) itemArray[i].getY(), radius, cameraPosition);
                itemView.render(item.getName(), imageCoordinates, radius);
            } else if (isSeen(itemArray[i])) {
                graphicsContext.setGlobalAlpha(.75);
                graphicsContext.setEffect(new BoxBlur(radius *.25, radius * .25, 1));
                Item item = zone.getItem(itemArray[i]);
                Point2D imageCoordinates = calculateImageCoordinates((int) itemArray[i].getX(), (int) itemArray[i].getY(), radius, cameraPosition);
                itemView.render(item.getName(), imageCoordinates, radius);
            } else {

            }
            graphicsContext.setGlobalAlpha(1);
            graphicsContext.setEffect(null);

        }
    }

    public void updateMap(Zone z) {
        fow.updateZone(z);
    }

    private boolean isVisible(Point p) {
        if (fow.returnVisibleTiles().contains(p)) return true;
        else return false;
    }
    private boolean isSeen(Point p) {
        if (fow.returnSeenTiles().contains(p)) return true;
        else return false;
    }
    private Point2D calculateImageCoordinates(int x, int y, int radius, Point cameraPosition) {
        double a = 0, b = 0;

        if (x % 2 == 1) {
            a = (radius * 1.5 * x) - (cameraPosition.getX()*1.5*radius) + (int)(canvas.getWidth()/2);
            b = (2 * radius * y + radius) - (cameraPosition.getY()*1.5*radius) + (int)(canvas.getHeight()/2);
        }
        if (x % 2 == 0) {
            a = radius * 1.5 * x - (cameraPosition.getX()*1.5*radius) + (int)(canvas.getWidth()/2);
            b = radius * 2 * y - (cameraPosition.getY()*1.5*radius) + (int)(canvas.getHeight()/2);
        }


        return new Point2D.Double(a, b);
    }
    public void toggleCamera() {
        System.out.println("Camera control toggled: " + cameraControl);
        cameraControl = !cameraControl;
    }

    public void moveUp() {
        if (cameraPosition.getY() >= 0) {
            System.out.println("Moving Up: " + cameraControl);

            cameraPosition = new Point((int)cameraPosition.getX(), (int)cameraPosition.getY()-1);
        }
    }
    public void moveRight() {
        if (cameraPosition.getX() <= world.getCurrentZone().getColumns()) {
            System.out.println("Moving Right: " + cameraControl);

            cameraPosition = new Point((int)cameraPosition.getX()+1, (int)cameraPosition.getY());
        }
    }
    public void moveDown() {
        if (cameraPosition.getY() <= world.getCurrentZone().getRows()) {
            System.out.println("Moving Down: " + cameraControl);

            cameraPosition = new Point((int)cameraPosition.getX(), (int)cameraPosition.getY()+1);
        }
    }
    public void moveLeft() {
        if (cameraPosition.getX() >= 0) {
            System.out.println("Moving Left: " + cameraControl);

            cameraPosition = new Point((int)cameraPosition.getX()-1, (int)cameraPosition.getY());
        }
    }

    public void resetCamera() {
        cameraPosition = world.getPlayer().getLocation();
    }
//    private Point2D calculateImageCoordinates(int x, int y, int radius) {
//        double a = 0, b = 0;
//
//        if (x % 2 == 1) {
//            a = radius * 1.5 * x;
//            b = (2 * radius * y) + radius;
//        }
//        if (x % 2 == 0) {
//            a = radius * 1.5 * x;
//            b = radius * 2 * y;
//        }
//
//
//        return new Point2D.Double(a, b);
//    }
}
