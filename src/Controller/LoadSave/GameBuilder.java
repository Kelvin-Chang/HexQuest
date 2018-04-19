package Controller.LoadSave;

import Model.Entity.Character.Player;
import Model.Entity.Entity;
import Model.Items.InteractiveItem;
import Model.Items.Item;
import Model.Items.ObstacleItem;
import Model.Map.AreaEffect.*;
import Model.Map.Decal;
import Model.Map.Map;
import Model.Map.Terrain;
import Model.Map.Tile;
import View.Map.MapView;
import View.Menu.MainMenuView;
import View.Status.StatusView;
import View.Viewport;

public class GameBuilder {

    private Viewport viewPort;
    private MapView mapView;
    private MainMenuView mainMenuView;
    private StatusView statusView;
    private Player player;


    public GameBuilder(){
        mainMenuView = new MainMenuView();
//        mapView = new MapView();
    }

    public void setViewPort(Viewport viewPort) {
        this.viewPort = viewPort;
    }

    public void setMapView(MapView mapView) {
        this.mapView = mapView;
    }

    public void setStatusView(StatusView statusView) {
        this.statusView = statusView;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void initMap(String id, String xSize, String ySize) {
//        Map map = new Map(id, xSize, ySize);
    }

    public void initTile(String terrain, String areaEffect, String decal, String item, int x, int y) {
        Tile tile;

        switch (terrain) {
            case "grass":
                tile = new Tile(Terrain.GRASS);
                break;
            case "mountain":
                tile = new Tile(Terrain.MOUNTAIN);
                break;
            case "water":
                tile = new Tile(Terrain.WATER);
            default:
                tile = new Tile(Terrain.GRASS);
        }

//        switch (areaEffect) {
//            case "none":
//                break;
//            case "damage":
//                tile.setAreaEffect(new Damage());
//                break;
//            case "death":
//                tile.setAreaEffect(new Death());
//                break;
//            case "heal":
//                tile.setAreaEffect(new Heal());
//                break;
//            case "level":
//                tile.setAreaEffect(new River());
//                break;
//            case "teleport":
//                tile.setAreaEffect(new Teleport());
//                break;
//        }
//
//        switch (decal) {
//            case "none":
//                break;
//            case "cross":
//                tile.setDecal(Decal.CROSS);
//                break;
//            case "skull":
//                tile.setDecal(Decal.SKULL);
//                break;
//        }
//
//        switch (item) {
//            case "interactive":
////                tile.setItem(new InteractiveItem());
//                break;
//            case "obstacle":
//                tile.setItem(new ObstacleItem());
//                break;
//        }
    }
}
