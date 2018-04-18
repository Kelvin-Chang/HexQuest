package Controller.LoadSave;

import Model.Entity.Character.Player;
import Model.Entity.Entity;
import Model.Map.AreaEffect.AreaEffect;
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
        mapView = new MapView();
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

    public void initMap(int id, int xSize, int ySize) {
        Map map = new Map(id, xSize, ySize);
    }

    public void initTile(Terrain terrain, AreaEffect areaEffect, Decal decal, Model.Items.Item item, Entity entity) {
        //Tile tile = new Tile(terrain, areaEffect, decal, item);
    }
}
