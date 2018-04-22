package Model.Zone;

import Model.Entity.Character.Player;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class FogOfWarHandler {
    HashMap<Zone, ArrayList<Point>> visited;
    Player player;
    Zone currentZone;
    
    public FogOfWarHandler(Player player) {
        visited = new HashMap<Zone, ArrayList<Point>>();
        this.player = player;
    }

    public void updateZone(Zone z) {
        currentZone = z;
        ArrayList<Point> toAdd = new ArrayList<Point>();
        visited.putIfAbsent(currentZone, toAdd);
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
