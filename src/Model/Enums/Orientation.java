package Model.Enums;

import java.awt.*;

public enum Orientation {
    UP, UPRIGHT, DOWNRIGHT, DOWN, DOWNLEFT, UPLEFT;

    public static final Point oddq_directions[][] =

    {
        { new Point(-1, -1), new Point(0, -1), new Point(+1, -1),
                new Point(-1, 0), new Point(0, +1), new Point(+1, 0) },




        { new Point(-1, 0), new Point(0, -1), new Point(+1, 0),
             new Point(-1, +1), new Point(0, +1), new Point(+1, +1) }
    };

    public static int correspondingNumber(Orientation orientation) {
        switch (orientation) {
            case UPLEFT: return 0;
            case UP: return 1;
            case UPRIGHT: return 2;
            case DOWNLEFT: return 3;
            case DOWN: return 4;
            case DOWNRIGHT: return 5;

            default: return 6;
        }
    }
    public static Orientation getRequiredOrientationForMove(Point current, Point previous){
        int parity = previous.x & 1;
        for(int i = 0; i < 6; ++i){
            if(oddq_directions[parity][i].equals(new Point(current.x - previous.x, current.y - previous.y)) ) {
                switch (i) {
                    case 0:
                        return UPLEFT;
                    case 1:
                        return UP;
                    case 2:
                        return UPRIGHT;
                    case 3:
                        return DOWNLEFT;
                    case 4:
                        return DOWN;
                    case 5:
                        return DOWNRIGHT;

                }
            }
        }
        return null;
    }
}
