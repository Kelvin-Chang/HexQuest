package Model.Zone;

import Model.Entity.Entity;
//import Model.Zone.Terrain.Terrain;
import Model.Items.Item;
import Model.Zone.AreaEffect.AreaEffect;
import View.Zone.TileView;

public class Tile {
    private boolean isPassable;
    private Terrain terrain;
    private Item item;
    private boolean visited;
    private boolean inView;
    private Decal decal;
    private AreaEffect areaEffect;

    public Tile() {
        isPassable = true;
        //terrain = new Terrain();
        visited = false;
        inView = false;
    }

    public Tile(Terrain t) {
        terrain = t;
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
