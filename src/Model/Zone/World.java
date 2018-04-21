package Model.Zone;

import Model.Entity.Character.Player;
import Model.Entity.Skills.Skill;
import Model.Enums.SkillType;
import Model.Updateable;

import java.util.ArrayList;
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

    public Player getPlayer() {
        return player;
    }

    @Override
    public void update() {
        zoneHashMap.get(currentZone).update();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public ArrayList<SkillType> playerActions() {
        return player.getPlayerActions();
    }
}
