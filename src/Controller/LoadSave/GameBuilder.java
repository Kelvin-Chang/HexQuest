package Controller.LoadSave;

import Model.Entity.Character.Player;
import Model.Items.InteractiveItem;
import Model.Items.ObstacleItem;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Zone.Decal;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.MainMenuView;
import View.Status.StatusView;
import View.Viewport;

import javax.swing.text.ZoneView;
import java.awt.*;

public class GameBuilder {

    private World world;
    private Viewport viewPort;
    private ZoneView mapView;
    private MainMenuView mainMenuView;
    private StatusView statusView;
    private Player player;


    public GameBuilder(){
//        mainMenuView = new MainMenuView();
    }

    public void setViewPort(Viewport viewPort) {
        this.viewPort = viewPort;
    }

    public World getWorld() {
        return world;
    }

    public void setMapView(ZoneView mapView) {
        this.mapView = mapView;
    }

    public void setStatusView(StatusView statusView) {
        this.statusView = statusView;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void initWorld(Integer currentMap) {
        world = new World(currentMap, player);
    }

    public void initZone(int id, int xSize, int ySize) {
        Zone zone = new Zone(id, xSize, ySize);
        world.addZone(zone);
    }

    public void initTile(String terrain, String areaEffect, String decal, String item, int x, int y, Integer mapID) {
        Zone zone = world.getZoneByID(mapID);
        Point point = new Point(x, y);

        switch (terrain) {
            case "grass":
                zone.add(point, Terrain.GRASS);
                break;
            case "mountain":
                zone.add(point, Terrain.MOUNTAIN);
                break;
            case "water":
                zone.add(point, Terrain.WATER);
            default:
                zone.add(point, Terrain.GRASS);
        }

        switch (areaEffect) {
            case "none":
                break;
            case "damage":
                break;
            case "death":
                break;
            case "heal":
                break;
            case "level":
                break;
            case "teleport":
                break;
        }

        switch (decal) {
            case "none":
                break;
            case "cross":
                zone.add(point, Decal.CROSS);
                break;
            case "skull":
                zone.add(point, Decal.SKULL);
                break;
        }

        switch (item) {
            case "interactive":
                zone.add(point, new InteractiveItem());
                break;
            case "obstacle":
                zone.add(point, new ObstacleItem("obstacle"));
                break;
            case "armor":
                zone.add(point, new Armor(10));
                break;
            case "ring":
                zone.add(point, new Ring(10));
                break;
        }
    }
}
