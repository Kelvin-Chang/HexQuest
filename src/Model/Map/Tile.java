package Model.Map;

import Model.Entity.Entity;
import Model.Items.Item;
import Model.Map.AreaEffect.AreaEffect;
import View.Map.TileView;

public class Tile {
    private boolean isPassable = false;
    private Terrain terrain;
    private Item item;
    private AreaEffect areaEffect;
    private boolean visited;
    private boolean inView;
    private Decal decal;

    private int xCoord;
    private int yCoord;

    public Tile(int x, int y, Terrain t) {
        this.xCoord = x;
        this.yCoord = y;
        this.terrain = t;

        if(terrain == Terrain.GRASS) {
            isPassable = true;
        }
    }

//    public Tile(Terrain t, Decal d, Item i) {
//        item = i;
//        terrain = t;
//        decal = d;
//        inView = false;
//        if(terrain == Terrain.GRASS) {
//            isPassable = true;
//        }
//    }

    public void enter(Entity e) {

    }
    public void exit(Entity e) {

    }
    public boolean canEnter(Entity e) {
        return isPassable;
    }

    public void setDecal(Decal d) {
        this.decal = d;
    }

    public void setAreaEffect(AreaEffect a) {
        this.areaEffect = a;
    }

    public void setItem(Item i) {
        this.item = i;
    }

    public void

    public void detach(TileView v) {

    }
    public void attach(TileView v) {

    }
}
