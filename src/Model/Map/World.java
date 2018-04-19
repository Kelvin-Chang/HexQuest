package Model.Map;

import java.awt.*;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static Model.Enums.Orientation.correspondingNumber;
>>>>>>> develop

public class World {
    private ArrayList<Map> maps;
    private Map currentMap;
    private Point offset;

    public World() {
        maps = new ArrayList<Map>();
        currentMap = new Map();
        offset = new Point(0,0);
    }

<<<<<<< HEAD
    public void MapTransition(Map m) {
        currentMap = m;
    }


=======
    public Map<Point, CharacterEntity> getCharacterMap() {
        return characterMap;
    }

    //get destination point
    Point oddq_offset_neighbor(Point hex, Orientation directionYouAreMoving){
        int parity = hex.x & 1;
        Point dir = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
        return new Point((int)(hex.getY() + dir.getY()), (int)(hex.getX() + dir.getX()));
    }


    public void attemptMove(CharacterEntity character){
        Orientation orientation = character.getOrientation();
        Point sourcePoint = getCharacterLocation(character);
        //System.out.println("dx: " + dx + " | dy: " + dy);
        Point destination = oddq_offset_neighbor(sourcePoint, orientation);
        System.out.println("Entity at [" + (int) sourcePoint.getX() + "," + (int) sourcePoint.getY() + "] attempting move to ["
                + (int) destination.getX() + "," + (int) destination.getY() + "]");

        if (isValidMove(destination)) {
            moveCharacter(sourcePoint, destination);
        } else {
            if(characterMap.get(destination) != null) {
                //GameViewNotifier.notifyInteraction(characterMap.get(destination));
            }
            else
                System.out.println("Move is illegal, there is " + getTerrain(destination).toString() + " there.");
        }
    }
    public void moveCharacter(Point origin, Point destination) {
        CharacterEntity character = characterMap.get(origin);
        characterMap.remove(origin);
        characterMap.put(destination, character);
    }
    public boolean isValidMove(Point destination) {
        if(getTerrain(destination) != Terrain.GRASS) {
            return false;
        }
        if(getCharacter(destination) != null) {
            return false;
        }
        return true;
    }

    public Point getCharacterLocation(CharacterEntity character) {
        for(Point point : getAllCharacterPoints())
        {
            if(getCharacter(point) == character)
            {
                return point;
            }
        }
        return null;
    }

    public ArrayList<CharacterEntity> getEntitiesOnArea(ArrayList<Point> area) {
        ArrayList<CharacterEntity> entities = new ArrayList<>();
        for (Point point : area) {
            if (characterMap.get(point) != null) {
                entities.add(characterMap.get(point));
            }
        }
        return entities;
    }

    public Collection<Point> getAllCharacterPoints() { return characterMap.keySet(); }
    public Terrain getTerrain(Point point) { return terrainMap.getOrDefault(point, Terrain.EMPTY); }
    public CharacterEntity getCharacter(Point point) { return characterMap.get(point); }
>>>>>>> develop
}
