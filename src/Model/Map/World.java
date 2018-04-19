package Model.Map;

import java.awt.*;
import java.util.ArrayList;

public class World {
    private ArrayList<Map> maps;
    private Map currentMap;
    private Point offset;

    public World() {
        maps = new ArrayList<Map>();
        currentMap = new Map();
        offset = new Point(0,0);
    }

    public void MapTransition(Map m) {
        currentMap = m;
    }


}
