package Model.Zone;

import java.util.HashMap;
import java.util.List;

public class World {
    public String currentWorld;
    private HashMap<String, Zone> zoneHashMap = new HashMap<>();

    public World(String currentWorld){
        this.currentWorld = currentWorld;
    }

    public void addZone(Zone zone) {
        zoneHashMap.put(zone.getID(), zone);
    }

    public void setCurrenZone(String currentWorld) {
        this.currentWorld = currentWorld;
    }

    public String getCurrentZone() {
        return this.currentWorld;
    }

    public Zone getZoneByID(String id) {
        return zoneHashMap.get(id);
    }
}
