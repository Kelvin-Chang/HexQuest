package Model.Zone;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.HostileNPC;
import Model.Entity.Character.HostileNPCController;
import Model.Entity.Character.Player;
import Model.Entity.Skills.Skill;
import Model.Enums.Orientation;
import Model.Enums.SkillType;
import Model.Updateable;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.List;

import static Model.Zone.HexFormulas.distanceToPoint;
import static Model.Zone.HexFormulas.getNeighborPointFromOrientation;

public class World implements Updateable {


    private Integer currentZone;
    private Player player;
    private List<HostileNPCController> hostileNPCControllers;
    private ArrayList<CharacterEntity> friendlyNPCs;
    private Map<Integer, Zone> zoneHashMap = new HashMap<>();

    public World() {
        this.currentZone = 0;
        this.player = new Player();
        this.hostileNPCControllers = new ArrayList<>();
        this.friendlyNPCs = new ArrayList<>();
    }

    public World(Integer currentWorld){
        this.player = new Player();
        this.hostileNPCControllers = new ArrayList<>();
        this.friendlyNPCs = new ArrayList<>();
        this.currentZone = currentWorld;
    }

    public void addZone(Zone zone) {
        System.out.println("Adding zone to world: " + zone.getID());
        zoneHashMap.put(zone.getID(), zone);
        hostileNPCControllers.add(currentZone, new HostileNPCController());
    }
    public void setCurrentZone(int currentWorld) {
        System.out.println("New current world is " + currentWorld);
        this.currentZone = currentWorld;
    }

    public Zone getCurrentZone() {
        return this.getZoneByID(currentZone);
    }
    public int getCurrentZoneID() {
        return this.currentZone;
    }
    public Zone getZoneByID(Integer id) {
        return zoneHashMap.get(id);
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addHostileNPC(CharacterEntity npc){
        hostileNPCControllers.get(currentZone).addHostileNpc(npc);
    }

    @Override
    public void update() {
        zoneHashMap.get(currentZone).update();
        processNPCMovements();
    }


    public void processNPCMovements(){
        HostileNPCController controller = hostileNPCControllers.get(currentZone);
        for(int i = 0; i < controller.getNpcs().size(); ++i){
            controller.addMove(i, calculateNPCtoPlayerOrientation(getCurrentZone(), controller.getNpcs().get(i).getLocation()));
        }
        controller.doOrientations();
    }
    public ArrayList<SkillType> playerActions() {
        return player.getPlayerActions();
    }
//
//    public void getNextNPCMoves(){
//        Zone currentZone = zoneHashMap.get(getCurrentZone());
//        Map<Point, Terrain> map = currentZone.getTerrainMap();
//        HostileNPCController npcController = hostileNPCControllers.get(getCurrentZoneID());
//        Point center = currentZone.getCharacterLocation(player);
//
//
//    }


    //public List<Orientation> calculateNPCtoPlayerTrail(Zone currentZone, Point center){
    public Orientation calculateNPCtoPlayerOrientation(Zone currentZone, Point center){
        Queue<Point> frontier = new ArrayDeque<>();
        Map<Point, Point> came_from = new HashMap<>();
        frontier.add(center);
        came_from.put(center, null);

        while(!frontier.isEmpty()){
            Point p = frontier.poll();

            if (distanceToPoint(p, currentZone.getCharacterLocation(player)) == 1) {
                came_from.put(currentZone.getCharacterLocation(player) , p);
                break;
            }
            for(Orientation o : Orientation.values()){
                Point next = getNeighborPointFromOrientation(p, o);
                if(currentZone.getAllTerrainPoints().contains(next) && currentZone.isValidMove(next)) {
                    if (!came_from.containsKey(next)) {
                        frontier.add(next);
                        came_from.put(next, p);
                    }
                }
            }
        }

        Point backTrack = currentZone.getCharacterLocation(player);
        List<Point> path = new ArrayList<Point>();

        while(distanceToPoint(center, backTrack) != 0){
            path.add(backTrack);
            backTrack = came_from.get(backTrack);
        }
        path.add(center);
        Collections.reverse(path);

        //List<Orientation> orientationPath = new ArrayList<Orientation>();

        if (path.size() == 1)
            return null;
        else{
            for(int i = 0; i != path.size() - 1; ++i){
                //orientationPath.add(Orientation.getRequiredOrientationForMove(path.get(i+1), path.get(i)));
            }

        }
        return Orientation.getRequiredOrientationForMove(path.get(1), path.get(0));
        //return orientationPath;
    }


}
