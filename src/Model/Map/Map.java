package Model.Map;

import Model.Entity.Character.CharacterEntity;
import View.Map.MapView;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Map {
    private Tile[][] grid;
    private Point size;
    private HashMap<Point, CharacterEntity> characterMap;

    public Map(){
        grid = new Tile[5][5];
        size = new Point(5,5);
        characterMap = new HashMap<>();
    }

    public Map(Tile[][] g) {
        grid = g;
        size = new Point(grid.length, grid[0].length);
    }

    public HashMap<Point, CharacterEntity> getCharacterMap() {
        return characterMap;
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

    public Point characterLocation(CharacterEntity characterEntity) {
        return new Point(1,1);
    }

    public ArrayList<CharacterEntity> getEntitiesOnArea(ArrayList<Point> area) {
        ArrayList<CharacterEntity> entities = new ArrayList<>();
        for (Point point : area) {
            if (characterMap.get(point) != null) {
                entities.add(characterMap.get(point));
            }
        }
        return entities;
    }
}
