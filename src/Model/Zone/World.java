package Model.Zone;

import Model.Entity.Character.Player;
import Model.Updateable;

import java.util.HashMap;
import java.util.Map;

public class World implements Updateable {
    public Integer currentZone;
    Player player;

    private Map<Integer, Zone> zoneHashMap = new HashMap<>();

    public World(Integer currentWorld){
        this.currentZone = currentWorld;
    }

    public World() {}

    public void addZone(Zone zone) {
        zoneHashMap.put(zone.getID(), zone);
    }

    public void setCurrentZone(int currentWorld) {
        this.currentZone = currentWorld;
    }

    public Zone getCurrentZone() {
        return this.getZoneByID(currentZone);
    }

    public Zone getZoneByID(Integer id) {
        return zoneHashMap.get(id);
    }

    @Override
    public void update() {
        zoneHashMap.get(currentZone).update();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
