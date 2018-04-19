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
    static Point getNeighborPointFromOrientation(Point hex, Orientation directionYouAreMoving){
        int parity = hex.x & 1;
        Point dir = Orientation.oddq_directions[parity][correspondingNumber(directionYouAreMoving)];
        return new Point((int)(hex.getY() + dir.getY()), (int)(hex.getX() + dir.getX()));
    }

    static ArrayList<Point> getAllNeighborPoints(Point hex){
        ArrayList<Point> list = new ArrayList<>();
        int parity = hex.x & 1;

        for(int i = 0; i < 6; ++i){
            Point dir = Orientation.oddq_directions[parity][i];
            list.add(new Point((int)(hex.getY() + dir.getY()), (int)(hex.getX() + dir.getX())));
        }
        return list;
    }

    static ArrayList<Point> getAllLinearPoints(Point hex){
        ArrayList<Point> list = new ArrayList<>();
        int parity = hex.x & 1;


        return list;
    }

    static int distanceToPoint(Point src, Point dest){
        int x;

        return 0;
    }






     public static Point cubeToHex(Triple t){
        int col = t.first;
        int row = t.third + (t.first - (t.first&1)) / 2;
        return new Point(col, row);
     }

    public static Triple hexToCube(Point pt){
        int x = pt.x;
        int z = pt.y - (pt.x - (pt.x&1)) / 2;
        int y = -x-z;
        return new Triple(x, y, z);
    }

    static class Triple{

        final int first;
        final int second;
        final int third;

        Triple(int first, int second, int third) {
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
