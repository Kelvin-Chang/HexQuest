package Model.Zone;

import Model.Enums.EffectShape;
import Model.Enums.Orientation;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

import static Model.Enums.Orientation.correspondingNumber;

                                    //POINTS ARE (X,Y) where
                                    //X IS THE COLUMN NUMBER
                                    //AND Y IS THE ROW NUMBER

public class HexFormulas {

    //get neighbor point point
    public static Point getNeighborPointFromOrientation(Point hex, Orientation directionYouAreMoving){
        int parity = hex.x & 1;
        Point dir = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
        return new Point((int)(hex.getX() + dir.getX()), (int)(hex.getY() + dir.getY()));
    }

    public static ArrayList<Point> getAllNeighborPoints(Point hex){
        ArrayList<Point> list = new ArrayList<>();
        int parity = hex.x & 1;

        for(int i = 0; i < 6; ++i){
            Point dir = Orientation.oddq_directions[parity][i];
            list.add(new Point((int)(hex.getY() + dir.getY()), (int)(hex.getX() + dir.getX())));
        }
        return list;
    }

    public static ArrayList<Point> getLinearPoints(Point hex, Orientation directionYouAreMoving, int range){
        ArrayList<Point> list = new ArrayList<>();
        int parity = hex.x & 1;

        Point coordsToAdd = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
        Point p = new Point((int) (hex.getX() + coordsToAdd.getX()), (int) (hex.getY() + coordsToAdd.getY()));
        list.add(p);
        for (int i = 0; i < range-1; i++) {
            parity = p.x & 1;
            coordsToAdd = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
            p = new Point((int) (p.getX() + coordsToAdd.getX()), (int) (p.getY() + coordsToAdd.getY()));
            list.add(p); //UNTIL YOU REACH THE END OF THE MAP OR HIT SOMETHING
        }
        return list;
    }

    public static ArrayList<Point> getAngularPoints(Point hex, int radius, Map<Point, Terrain> terrainMap, Orientation directionYouAreFacing) {
        ArrayList<Point> list = new ArrayList<>();

        rGetAngularPoints(hex, radius, terrainMap, directionYouAreFacing, list, radius);

        return list;
    }

    public static void rGetAngularPoints(Point hex, int radius, Map<Point, Terrain> terrainMap, Orientation directionYouAreFacing, ArrayList<Point> list, int decreasingRadius) {
        //BASE CASE:
        if (decreasingRadius == 0 /*|| terrainMap.keySet().contains()*/){

        }

    }
    public static ArrayList<Point> getRadialOfPointsFromRadius(Point hex, int radius, Map<Point, Terrain> terrainMap) {
        ArrayList<Point> list = new ArrayList<>();

        for(Point p: terrainMap.keySet()){
            if(distanceToPoint(hex, p) <= radius && terrainMap.getOrDefault(p, Terrain.EMPTY) != Terrain.EMPTY)
                list.add(p);
        }

        return list;
    }

    public static ArrayList<Point> getCircleOfPointsFromRadius(Point hex, int radius, Map<Point, Terrain> terrainMap){
        ArrayList<Point> list = new ArrayList<>();

        for(Point p: terrainMap.keySet()){
            if(distanceToPoint(hex, p) == radius && terrainMap.getOrDefault(p, Terrain.EMPTY) != Terrain.EMPTY)
                list.add(p);
        }

        return list;
    }
    public static double distanceToPoint(Point src, Point dest){
        Triple ac = hexToCube(src);
        Triple bc = hexToCube(dest);
        return cube_distance(ac,bc);

    }
    static int checkOdd(double val){
        if(val % 2 == 0)
            return 0;
        else return 1;
    }

    public static double cube_distance(Triple a, Triple b){
            return Math.max(  Math.max(Math.abs(a.first - b.first), Math.abs(a.second - b.second)),   Math.abs(a.third - b.third));

    }
     public static Point cubeToHex(Triple t){
        double col = t.first;
        double row = t.third + (t.first - (checkOdd(t.first))) / 2;
        return new Point((int)col, (int)row);
     }

    public static Triple hexToCube(Point pt){
        double x = pt.x;
        double z = pt.y - ((pt.x - (pt.x & 1 )) / 2);
        double y = (-x)-z;
        return new Triple(x, y, z);
    }

    static class Triple{

        final double first;
        final double second;
        final double third;

        Triple(double first, double second, double third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Triple)) {
                return false;
            }
            Triple p = (Triple) o;
            return (first ==p.first && second == p.second && third == p.third);
        }

        private boolean equals(Object x, Object y) {
            return (x == null && y == null) || (x != null && x.equals(y));
        }

    }

    public ArrayList<Point> getEffectedCoordinates(Point hex, int range, Map<Point, Terrain> terrainMap, Orientation orientation, EffectShape effectShape) {
        switch (effectShape) {
            case LINEAR:
                return getLinearPoints(hex, orientation, range);
            case RADIAL:
                return getRadialOfPointsFromRadius(hex, range, terrainMap);
            case ANGULAR:
                return new ArrayList<Point>();
        }
        return new ArrayList<>();
    }
}
