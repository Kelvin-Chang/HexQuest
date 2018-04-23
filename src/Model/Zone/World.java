package Model.Zone;

import Model.Entity.Character.*;
import Model.Entity.Skills.Skill;
import Model.Enums.Orientation;
import Model.Enums.SkillType;
import Model.Updateable;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.ZoneId;
import java.util.*;
import java.util.List;

import static Model.Zone.HexFormulas.distanceToPoint;
import static Model.Zone.HexFormulas.getNeighborPointFromOrientation;
import static Model.Zone.HexFormulas.getRadialOfPointsFromRadius;

public class World implements Updateable {


    private Integer currentZone;
    private Player player;
    private HashMap<Integer, HostileNPCController> hostileNPCControllers;
    private HashMap<Integer, FriendlyNPCController> friendlyNPCControllers;
    private Map<Integer, Zone> zoneHashMap;

    public World() {
        this.currentZone = 0;
        this.player = new Player();
        this.hostileNPCControllers = new HashMap<>();
        this.friendlyNPCControllers = new HashMap<>();
        this.zoneHashMap = new HashMap<Integer, Zone>();
    }


    public void addZone(Zone zone) {
        System.out.println("Adding zone to world: " + zone.getID());
        zoneHashMap.put(zone.getID(), zone);
        hostileNPCControllers.put(currentZone, new HostileNPCController());
    }
    public void setCurrentZone(int currentZone) {
        System.out.println("New current world is " + currentZone);
        this.currentZone = currentZone;
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
        processHostileNPCMovements();
    }


    public void processHostileNPCMovements(){
        HostileNPCController controller = hostileNPCControllers.get(currentZone);
        CharacterEntity npc = getCurrentZone().getCharacter(new Point(2,5));

        System.out.println(npc);
        System.out.println(currentZone);
        if(getCurrentZone().getCharacterEntity(new Point(2,5) )== null)
            System.out.println("Moved");
        ArrayList<Point> pointsInIR = getRadialOfPointsFromRadius(getZoneByID(currentZone).getCharacterLocation(player),3, getCurrentZone().getTerrainMap());
        for(CharacterEntity character : controller.getNpcs()){
            for(Point p : pointsInIR) {
                if (getCurrentZone().getCharacterEntity(p) == character) {
                    if (character.isChasing() && distanceToPoint(getPlayer().getLocation(), p) == 2){
                        controller.addMove(character, calculateNPCtoPlayerOrientation(getCurrentZone(), p));
                        break;
                    }

                    else if (character.isChasing() == true && distanceToPoint(getPlayer().getLocation(), p) == 1){
                        controller.addMove(character, calculateNPCtoPlayerOrientation(getCurrentZone(), p));
                        character.useSkill(SkillType.BRAWLSKILL);
                        break;
                    }
                    else {
                        character.setChasing(true);
                        break;
                    }
                }
            }
        }

        controller.doOrientations();
    }

    public void processFriendlyNPCMovements(){
        FriendlyNPCController controller = friendlyNPCControllers.get(currentZone);
        ArrayList<Point> pointsInIR = getRadialOfPointsFromRadius(player.getLocation(),3, getCurrentZone().getTerrainMap());
        for(CharacterEntity character : controller.getNpcs()){

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
