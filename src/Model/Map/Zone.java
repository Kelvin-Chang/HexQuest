package Model.Map;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Entity;
import Model.Enums.Orientation;
import Model.Items.Item;
import Model.Map.AreaEffect.AreaEffect;
import View.Map.MapView;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static Model.Enums.Orientation.correspondingNumber;

public class Zone {
    private Tile[][] grid;
    private Point size;

    private java.util.Map<Point, Terrain> terrainMap;
    private java.util.Map<Point, CharacterEntity> characterMap;
    private java.util.Map<Point, AreaEffect> effectMap;
    private java.util.Map<Point, Item> itemMap;
    //private java.util.Zone<Point, Obstacle> obstacleMap;
    private java.util.Map<Point, Decal> decalMap;

//    public Zone(){
//        grid = new Tile[5][5];
//        size = new Point(5,5);
//    }
    public void add(Point point, Terrain terrain) { terrainMap.put(point, terrain); }
    public void addPlayer(Point point, CharacterEntity entity) { characterMap.put(point, entity); }
    public void add(Point point, AreaEffect effect) { effectMap.put(point, effect); }
    public void add(Point point, Item item) { itemMap.put(point, item); }
    //public void add(Point point, Obstacle obstacle) { obstacleMap.put(point, obstacle); }
    public void add(Point point, Decal decal) { decalMap.put(point, decal); }

    public void removeTerrain(Point point) { terrainMap.remove(point); }
    public void removeEntity(Point point) { characterMap.remove(point); }
    public void removeAreaEffect(Point point) { effectMap.remove(point); }
    public void removeItem(Point point) { itemMap.remove(point); }
    public void removeItem(Item item) {
        for(Point point : getAllCharacterPoints())
        {
            if(getItem(point) == item)
            {
                itemMap.remove(point);
                return;
            }
        }
    }
    public Terrain getTerrain(Point point) { return terrainMap.getOrDefault(point, Terrain.EMPTY); }
    public CharacterEntity getCharacterEntity(Point point) { return characterMap.get(point); }
    public AreaEffect getAreaEffect(Point point) { return effectMap.get(point); }
    public Item getItem(Point point) { return itemMap.get(point); }
    //public Obstacle getObstacle(Point point) { return obstacleMap.get(point); }
    public Decal getDecal(Point point) { return decalMap.get(point); }
    public Map<Point, CharacterEntity> getCharacterMap() {
        return characterMap;
    }
    public Point getCharacterLocation(CharacterEntity character) {
        for(Point point : getAllCharacterPoints())
        {
            if(getCharacter(point) == character)
            {
                return point;
            }
        }
        return null;
    }


    public Collection<Point> getAllCharacterEntityPoints() { return characterMap.keySet(); }
    public Collection<Point> getAllTerrainPoints() { return terrainMap.keySet(); }
    public Collection<Point> getAllAreaEffectPoints() { return effectMap.keySet(); }
    public Collection<Point> getAllItemPoints() { return itemMap.keySet(); }
    //public Collection<Point> getAllObstaclePoints() { return obstacleMap.keySet(); }
    public Collection<Point> getAllDecalPoints() { return decalMap.keySet(); }

    public ArrayList<CharacterEntity> getEntitiesOnArea(ArrayList<Point> area) {
        ArrayList<CharacterEntity> entities = new ArrayList<>();
        for (Point point : area) {
            if (characterMap.get(point) != null) {
                entities.add(characterMap.get(point));
            }
        }
        return entities;
    }

    public Collection<Point> getAllCharacterPoints() { return characterMap.keySet(); }
    public CharacterEntity getCharacter(Point point) { return characterMap.get(point); }


    public void doInteractions(CharacterEntity player) {
        triggerAreaEffects();
        triggerItems(player);
    }

    private void triggerAreaEffects() {
        ArrayList<Point> points = new ArrayList<>(characterMap.keySet());
        for(Point point : points) {
            CharacterEntity character = getCharacterEntity(point);

            AreaEffect effect = effectMap.get(point);

            if (effect != null) {
                effect.trigger(character);
            }
        }
    }

    private void triggerItems(CharacterEntity player) {
        ArrayList<Point> entities = new ArrayList<>(characterMap.keySet());
        for(Point point : entities) {
            CharacterEntity character = getCharacter(point);

            Item item = itemMap.get(point);

            if (item != null) {
                boolean entityIsPlayer = character.equals(player);
                //TODO: change when introducing npcs
                item.trigger(character);
            }
        }
    }
    //MOVEMENT STUFF
    //

    //get destination point
    Point getNextPoint(Point hex, Orientation directionYouAreMoving){
        int parity = hex.x & 1;
        Point dir = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
        return new Point((int)(hex.getY() + dir.getY()), (int)(hex.getX() + dir.getX()));
    }


    public void attemptMove(CharacterEntity character){
        Orientation orientation = character.getOrientation();
        Point sourcePoint = getCharacterLocation(character);
        //System.out.println("dx: " + dx + " | dy: " + dy);
        Point destination = getNextPoint(sourcePoint, orientation);
        System.out.println("Entity at [" + (int) sourcePoint.getX() + "," + (int) sourcePoint.getY() + "] attempting move to ["
                + (int) destination.getX() + "," + (int) destination.getY() + "]");

        if (isValidMove(destination)) {
            moveCharacter(sourcePoint, destination);
        } else {
            if(characterMap.get(destination) != null) {
                //GameViewNotifier.notifyInteraction(characterMap.get(destination));
            }
            else
                System.out.println("Move is illegal, there is " + getTerrain(destination).toString() + " there.");
        }
    }
    public void moveCharacter(Point origin, Point destination) {
        CharacterEntity character = characterMap.get(origin);
        characterMap.remove(origin);
        characterMap.put(destination, character);
    }
    public boolean isValidMove(Point destination) {
        if(getTerrain(destination) != Terrain.GRASS) {
            return false;
        }
        if(getCharacter(destination) != null) {
            return false;
        }
        return true;
    }


    public Zone(Tile[][] g) {
        grid = g;
        size = new Point(grid.length, grid[0].length);
    }
    public Tile getTile(int x, int y) {
        try {
            return grid[x][y];
        } catch(IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }
        return null;
    }

    public void attach(MapView v) {

    }
    public void detach(MapView v) {

    }
}