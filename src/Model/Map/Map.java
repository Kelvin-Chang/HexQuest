package Model.Map;

import View.Map.MapView;

import java.awt.*;

public class Map {
    private Tile[][] grid;
    private Point size;

    public Map(){
        grid = new Tile[5][5];
        size = new Point(5,5);
    }

    public Map(Tile[][] g) {
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
