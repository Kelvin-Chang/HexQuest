package Controller.LoadSave;

import Model.Entity.Character.Player;
import View.Viewport;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnpackSave {

    private GameBuilder gameBuilder;

    private Player player;

    private Viewport viewport = new Viewport();

    public UnpackSave(JSONObject jso, GameBuilder gb) {
        this.gameBuilder = gb;

        unpackWorld(jso.getJSONObject("World"));
    }

    public void unpackWorld(JSONObject world) {
        System.out.println("Unpacking World: " + world);

        JSONArray mapArray = world.getJSONArray("Maps");

        for(int i = 0; i < mapArray.length(); i++) {
            unpackMap(mapArray.getJSONObject(i));
        }
    }

    public void unpackMap(JSONObject map) {
        System.out.println("Unpacking map: " + map);

        JSONArray tileArray = map.getJSONArray("Tile");

        for (int i = 0; i < tileArray.length(); i++) {
            unpackTile(tileArray.getJSONObject(i));
        }
        //gameBuilder.initMap(map.id, map.xSize, map.ySize);
    }

    public void unpackTile(JSONObject tile) {
        System.out.println("Unpacking tile: " + tile);

        //gameBuilder.initTile(map.terrain, map.areaEffect, map.decal, map.item, map.entity);
    }

}
