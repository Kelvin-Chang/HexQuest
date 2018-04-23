package Model.Zone;

import Model.AreaEffects.AreaEffect;
import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;
import Model.Items.Item;
import Model.Items.ObstacleItem;
import Model.Updateable;
import View.Zone.MapView;
import javafx.util.Pair;

import java.awt.*;
import java.util.*;

import static Model.Zone.HexFormulas.getNeighborPointFromOrientation;

public class Zone implements Updateable {
    private Pair size;

    private Map<Point, Terrain> terrainMap;
    private Map<Point, CharacterEntity> characterMap;
    private Map<Point, AreaEffect> areaEffectMap;
    private Map<Point, Effect> effectsMap;
    private Map<Point, Item> itemMap;
    private Map<Point, ObstacleItem> obstacleItemMap;
    private Map<Point, Decal> decalMap;

    private int id;
    private int rows;
    private int columns;
    private Point spawnPoint;

    public Zone(int id, int rows, int columns) {
        this.terrainMap = new HashMap<>();
        this.characterMap = new HashMap<>();
        this.areaEffectMap = new HashMap<>();
        this.effectsMap = new HashMap<>();
        this.itemMap = new HashMap<>();
        this.obstacleItemMap = new HashMap<>();
        this.decalMap = new HashMap<>();
        this.size = new Pair(0,0);
        this.spawnPoint = new Point(0,0);
        this.id = id;
        this.rows = rows;
        this.columns = columns;
    }

    public Zone() {
        this.terrainMap = new HashMap<>();
        this.characterMap = new HashMap<>();
        this.areaEffectMap = new HashMap<>();
        this.effectsMap = new HashMap<>();
        this.itemMap = new HashMap<>();
        this.obstacleItemMap = new HashMap<>();
        this.decalMap = new HashMap<>();
        this.size = new Pair(0,0);
        this.spawnPoint = new Point(0,0);
    }

    public void setId(int id) {
        this.id = id;
    }


    public void add(Point point, Terrain terrain) { terrainMap.put(point, terrain); }
    public void addPlayer(Point point, CharacterEntity entity) {
        characterMap.put(point, entity);
        entity.setZone(this);
        entity.setZoneId(this.id);
    }
    public void add(Point point, AreaEffect effect) { areaEffectMap.put(point, effect); }
    public void add(Point point, Item item) { itemMap.put(point, item); }
    public void add(Point point, ObstacleItem obstacle) { obstacleItemMap.put(point, obstacle); }
    public void add(Point point, Decal decal) { decalMap.put(point, decal); }
    public void add(Point point, Effect effects) { effectsMap.put(point, effects); }


    public void removeTerrain(Point point) { terrainMap.remove(point); }
    public void removeEntity(Point point) { characterMap.remove(point); }
    public void removeAreaEffect(Point point) { areaEffectMap.remove(point); }
    public void removeItem(Point point) { itemMap.remove(point); }
    public void removeItem(Item item) {
        for(Point point : getAllItemPoints())
        {
            if(getItem(point) == item)
            {
                itemMap.remove(point);
                return;
            }
        }
    }
    public int getID(){ return this.id; }
    public int getRows() { return rows; }
    public int getColumns() { return columns; }

    public Map<Point, AreaEffect> getAreaEffectMap() {
        return areaEffectMap;
    }

    public Map<Point, Effect> getEffectsMap() {
        return effectsMap;
    }

    public Map<Point, Decal> getDecalMap() {
        return decalMap;
    }

    public Map<Point, Item> getItemMap() {
        return itemMap;
    }

    public Map<Point, Terrain> getTerrainMap() {
        return terrainMap;
    }

    public Map<Point, ObstacleItem> getObstacleItemMap() {
        return obstacleItemMap;
    }

    public Terrain getTerrain(Point point) { return terrainMap.getOrDefault(point, Terrain.EMPTY); }
    public CharacterEntity getCharacterEntity(Point point) { return characterMap.get(point); }
    public AreaEffect getAreaEffect(Point point) { return areaEffectMap.get(point); }
    public Item getItem(Point point) { return itemMap.get(point); }
    public ObstacleItem getObstacleItem(Point point) { return obstacleItemMap.get(point); }
    public Decal getDecal(Point point) { return decalMap.get(point); }
    public Map<Point, CharacterEntity> getCharacterMap() {
        return characterMap;
    }
    public Point getSpawnPoint() { return spawnPoint; }
//    public Map<Point, Terrain> getTerrainMap() { return terrainMap;}
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
    public Collection<CharacterEntity> getAllCharacterEntitys() {return characterMap.values(); };
    public Collection<Point> getAllTerrainPoints() { return terrainMap.keySet(); }
    public Collection<Terrain> getAllTerrains() {return terrainMap.values(); }
    public Collection<Point> getAllAreaEffectPoints() { return areaEffectMap.keySet(); }
    public Collection<Point> getAllItemPoints() { return itemMap.keySet(); }
    public Collection<Point> getAllObstacleItemPoints() { return obstacleItemMap.keySet(); }
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

    public void doInteractions() {
        triggerAreaEffects();
        triggerItems();
        //
    }

    private void triggerAreaEffects() {
        ArrayList<Point> points = new ArrayList<>(characterMap.keySet());
        for(Point point : points) {
            CharacterEntity character = getCharacterEntity(point);

            AreaEffect effect = areaEffectMap.get(point);

            if (effect != null) {
                effect.trigger(character);
            }
        }
    }

    private void triggerItems() {
        ArrayList<Point> entities = new ArrayList<>(characterMap.keySet());
        for(Point point : entities) {
            CharacterEntity character = getCharacter(point);

            Item item = itemMap.get(point);

            if (item != null) {
                //boolean entityIsPlayer = character.equals(player);
                //TODO: change when introducing npcs
                item.trigger(character);
                removeItem(item);
            }
        }
    }
    //MOVEMENT STUFF
    public void attemptMove(CharacterEntity character) {
        if (!character.hasNextMove()) {
            return;
        }
        Orientation orientation = character.getNextMove();
        character.setOrientation(orientation);
        Point sourcePoint = getCharacterLocation(character);
        Point destination = getNeighborPointFromOrientation(sourcePoint, orientation);
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
        character.clearMovementQueue();
    }
    public boolean isValidMove(Point destination) {
        if(getObstacleItem(destination) != null) {
            return false;
        }
        if(getTerrain(destination) != Terrain.GRASS) {
            return false;
        }
        if(getCharacter(destination) != null) {
            return false;
        }
        return true;
    }

    public void update() {
        updateCharacterLocations();
        doInteractions();
    }

    public void updateCharacterLocations() {
        ArrayList<CharacterEntity> characterEntities = new ArrayList<>(getAllCharacterEntitys());
        for (CharacterEntity characterEntity : characterEntities) {
            attemptMove(characterEntity);
        }
    }
    //                                         NPC STUFF           /////





    public void updateAreaEffects() {

    }

    public void attach(MapView v) {

    }
    public void detach(MapView v) {

    }
}