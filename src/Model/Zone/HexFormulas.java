package Model.Zone;

import Model.Enums.Orientation;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.Orientation.correspondingNumber;

                                    //POINTS ARE (X,Y) where
                                    //X IS THE COLUMN NUMBER
                                    //AND Y IS THE ROW NUMBER

public class HexFormulas {

    //get neighbor point point
    public static Point getNeighborPointFromOrientation(Point hex, Orientation directionYouAreMoving){
        int parity = hex.x & 1;
        Point dir = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
        return new Point((int)(hex.getY() + dir.getY()), (int)(hex.getX() + dir.getX()));
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

    public static ArrayList<Point> getAllLinearPoints(Point hex){
        ArrayList<Point> list = new ArrayList<>();
        int parity = hex.x & 1;


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
}
