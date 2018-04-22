package Model.Zone;

import Model.Entity.Character.Player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class FogOfWarHandler {
    HashMap<Zone, ArrayList<Point>> visited;
    HashMap<Zone, HashMap<Point, Terrain>> seenMap;
    Player player;
    Zone currentZone;
    
    public FogOfWarHandler(Player player) {
        visited = new HashMap<Zone, ArrayList<Point>>();
        seenMap = new HashMap<Zone, HashMap<Point, Terrain>>();
        this.player = player;
    }

    public void updateZone(Zone z) {
        currentZone = z;
//        if (visited.containsKey(currentZone)) {
            ArrayList<Point> vAdd = new ArrayList<Point>();
            HashMap<Point, Terrain> sAdd = new HashMap<Point, Terrain>();
            visited.putIfAbsent(currentZone, vAdd);
            seenMap.putIfAbsent(currentZone, sAdd);
//        }
    }

    public void updateOnTick() {
        for (int i = 0; i < visited.get(currentZone).size(); i++) {
            if (seenMap.get(currentZone).containsKey( visited.get(currentZone).get(i) ) ) {
                seenMap.get(currentZone).replace( visited.get(currentZone).get(i), currentZone.getTerrain(visited.get(currentZone).get(i)) );
            } else {
                seenMap.get(currentZone).put( visited.get(currentZone).get(i), currentZone.getTerrain(visited.get(currentZone).get(i)) );
            }
        }
    }

    public HashMap<Point,Terrain> getSeenTiles() {
        return seenMap.get(currentZone);
    }

    public ArrayList<Point> returnVisibleTiles() {
        ArrayList<Point> result = new ArrayList<>();
        result = HexFormulas.getRadialOfPointsFromRadius(player.getLocation(), 2, currentZone.getTerrainMap());
        visited.replace(currentZone, addTwoWithoutDupe(visited.get(currentZone), result)) ;
        return result;
    }

    public ArrayList<Point> returnSeenTiles() {
        return visited.get(currentZone);
    }

    public ArrayList<Point> addTwoWithoutDupe(ArrayList<Point> x, ArrayList<Point> y) {
        ArrayList<Point> result = new ArrayList<Point>(x);
        for (int i = 0; i < y.size(); i++) {
            if (!result.contains(y.get(i))) {
                result.add(y.get(i));
            }
        }
        return result;
    }

}
