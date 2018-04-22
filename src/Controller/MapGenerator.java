package Controller;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MapGenerator {
    private String mapDir = "/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/resources/maps/";
    public MapGenerator(String mapName, int row, int cols, int id){
        this.mapDir += mapName;
        JSONObject World = new JSONObject();
        JSONObject inner = new JSONObject();
        JSONObject inner2 = new JSONObject();
        JSONObject curMap = new JSONObject();

        curMap.put("currentMap", 1);
        inner.put("currentMap", 1);
        JSONArray Map = new JSONArray();
//        JSONObject id = new JSONObject();
//        JSONObject rows = new JSONObject();
//        JSONObject columns = new JSONObject();
        JSONArray Tile = new JSONArray();
        for(int i = 0; i<row; i++)
        {

            for(int j = 0; j<cols; j++)
            {
                JSONObject tiles = new JSONObject();
                JSONObject type = new JSONObject();
                type.put("type","none");
                tiles.put("terrain", "grass");
                tiles.put("areaEffect", "none");
                tiles.put("item", "none");
                tiles.put("decal", "none");
                tiles.put("Entity", type);
                tiles.put("x", i);
                tiles.put("y", j);
                Tile.put(tiles);
            }
        }
        System.out.println((Tile.getJSONObject(1)).getClass().getSimpleName());
        System.out.println(Tile.getJSONObject(1));



//        JSONObject ids = new JSONObject();
//        JSONObject rows = new JSONObject();
//        JSONObject columns = new JSONObject();
//        inner2.put("Tile", Tile);
//        ids.append("id", id);
//        rows.append("rows", row);
//        columns.append("columns", cols);
//        Map.put(ids);
//        Map.put(rows);
//        Map.put(columns);
//        Map.put(inner2);
//        inner.put("Map",Map);
//        World.put("World", inner);

//        ids.append("id", id);
//        rows.append("rows", row);
//        columns.append("", cols);
        inner2.put("id",id);
        inner2.put("rows",row);
        inner2.put("columns",cols);
        inner2.put("Tile", Tile);
        Map.put(inner2);
        inner.put("Map",Map);
        System.out.println((inner2.getJSONArray("Tile")).getClass().getSimpleName());
//        System.out.println(inner2.getJSONArray("columns"));
//        System.out.println(inner2.getJSONArray("Tile").getJSONObject(0));
        World.put("World", inner);



        ObjectOutputStream file = null;

        try {
            file = new ObjectOutputStream(new FileOutputStream(this.mapDir));
            file.writeObject(World.toString());
            file.close();
//            System.out.println((World.toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
