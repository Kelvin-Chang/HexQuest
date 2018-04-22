package Controller.LoadSave;

import Model.Entity.Character.Player;
import Model.Zone.World;
import View.Viewport;
import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.*;

public class UnpackSave {

    private GameBuilder gameBuilder;

    private Player player;

    private World world;

    private Viewport viewport = new Viewport();

    public UnpackSave(JSONObject jso, GameBuilder gb) {
        this.gameBuilder = gb;
        this.world = world;
        unpackWorld(jso.getJSONObject("World"));
    }

    public void unpackWorld(JSONObject world) {
        gameBuilder.initWorld(world.getInt("currentMap"));

        JSONArray mapArray = world.getJSONArray("Map");

        for(int i = 0; i < mapArray.length(); i++) {
            unpackMap(mapArray.getJSONObject(i));
        }
    }

    public void unpackMap(JSONObject map) {
        JSONArray tileArray = map.getJSONArray("Tile");

        gameBuilder.initZone(map.getInt("id"), map.getInt("rows"), map.getInt("columns"));

        for (int i = 0; i < tileArray.length(); i++) {
            unpackTile(tileArray.getJSONObject(i), map.getInt("id"));
        }
    }

    public void unpackTile(JSONObject tile, Integer id) {
        gameBuilder.initTile(tile.getString("terrain"), tile.getString("areaEffect"), tile.getString("decal"), tile.getString("item"), tile.getInt("x"), tile.getInt("y"), id);
        JSONObject entity = tile.getJSONObject("Entity");

        if(!entity.getString("type").equals("none")) {
            switch (entity.getString("type")) {
                case "player":
                    gameBuilder.initPlayer(entity.getString("name"), entity.getString("class"), entity.getInt("level"), entity.getInt("maxHealth"), entity.getInt("currentHealth"), entity.getInt("maxMana"), entity.getInt("maxMana"), entity.getInt("attack"), entity.getInt("defense"), entity.getInt("speed"), entity.getString("orientation"), entity.getString("pet"), entity.getJSONArray("Inventory"), entity.getJSONArray("Skills"), new Point(tile.getInt("x"), tile.getInt("y")));
                    break;
                case "HostileNPC":
                    gameBuilder.initHostileNPC(entity.getString("name"), entity.getInt("level"), entity.getInt("maxHealth"), entity.getInt("currentHealth"), entity.getInt("maxMana"), entity.getInt("maxMana"), entity.getInt("attack"), entity.getInt("defense"), entity.getInt("speed"), entity.getString("orientation"), entity.getString("pet"), entity.getJSONArray("Inventory"), entity.getJSONArray("Skills"), new Point(tile.getInt("x"), tile.getInt("y")));
                    break;
                case "FriendlyNPC":
                    gameBuilder.initFriendlyNPC(entity.getString("name"), entity.getInt("level"), entity.getInt("maxHealth"), entity.getInt("currentHealth"), entity.getInt("maxMana"), entity.getInt("maxMana"), entity.getInt("attack"), entity.getInt("defense"), entity.getInt("speed"), entity.getString("orientation"), entity.getString("pet"), entity.getJSONArray("Inventory"), entity.getJSONArray("Skills"), new Point(tile.getInt("x"), tile.getInt("y")));
                    break;
                case "shopKeep":
                    gameBuilder.initShopKeep(entity.getString("name"), entity.getInt("level"), entity.getInt("maxHealth"), entity.getInt("currentHealth"), entity.getInt("maxMana"), entity.getInt("maxMana"), entity.getInt("attack"), entity.getInt("defense"), entity.getInt("speed"), entity.getString("orientation"), entity.getString("pet"), entity.getJSONArray("Inventory"), entity.getJSONArray("Skills"), new Point(tile.getInt("x"), tile.getInt("y")));
                    break;
                case "mount":
                    gameBuilder.initMount(entity.getString("name"));
                    break;
                case "pet":
                    gameBuilder.initMount(entity.getString("name"));
                    break;
            }
        }
    }

}
