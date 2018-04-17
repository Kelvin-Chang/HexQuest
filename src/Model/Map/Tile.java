package Model.Map;

import Model.Entity.Entity;
import Model.Map.Terrain.Terrain;
import Model.Item.Item;
import View.Map.TileView;

public class Tile {
    private boolean isPassable;
    private Terrain terrain;
    private Item item;
    private boolean visited;
    private boolean inView;
    private Decal decal;

    public Tile() {
        isPassable = true;
        terrain = new Terrain();
        decal = new Decal();
        visited = false;
        inView = false;
    }

    public Tile(Terrain t, Decal d, Item i) {
        item = i;
        terrain = t;
        decal = d;
    }

    public void enter(Entity e) {

    }
    public void exit(Entity e) {

    }
    public boolean canEnter(Entity e) {
        return isPassable;
    }
    public void detach(TileView v) {

    }
    public void attach(TileView v) {

    }
}
