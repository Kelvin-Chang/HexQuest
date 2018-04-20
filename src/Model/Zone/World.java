package Model.Zone;

import Model.Entity.Character.Player;

import java.util.HashMap;
import java.util.Map;

public class World {
    public Integer currentZone;
    Player player;

    private Map<Integer, Zone> zoneHashMap = new HashMap<>();

    public World(Integer currentWorld, Player player){
        this.currentZone = currentWorld;
        this.player = player;
    }

    public void addZone(Zone zone) {
        zoneHashMap.put(zone.getID(), zone);
    }

    public void setCurrentZone(int currentWorld) {
        this.currentZone = currentWorld;
    }

    public int getCurrentZone() {
        return this.currentZone;
    }

    public Zone getZoneByID(Integer id) {
        return zoneHashMap.get(id);
    }
}
