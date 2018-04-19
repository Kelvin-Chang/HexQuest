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

        gameBuilder.initWorld(world.getString("currentMap"));

        JSONArray mapArray = world.getJSONArray("Maps");

        for(int i = 0; i < mapArray.length(); i++) {
            unpackMap(mapArray.getJSONObject(i));
        }
    }

    public void unpackMap(JSONObject map) {
        System.out.println("Unpacking map: " + map);

        JSONArray tileArray = map.getJSONArray("Tile");

        gameBuilder.initZone(map.getString("id"), map.getInt("rows"), map.getInt("columns"));

        for (int i = 0; i < tileArray.length(); i++) {
            unpackTile(tileArray.getJSONObject(i), map.getString("id"));
        }
    }

    public void unpackTile(JSONObject tile, String id) {
        System.out.println("Unpacking tile: " + tile);
        gameBuilder.initTile(tile.getString("terrain"), tile.getString("areaEffect"), tile.getString("decal"), tile.getString("item"), tile.getInt("x"), tile.getInt("y"), id);
    }

}
