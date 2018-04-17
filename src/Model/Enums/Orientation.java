package Model.Enums;

import java.awt.*;

public enum Orientation {
    UP, UPRIGHT, DOWNRIGHT, DOWN, DOWNLEFT, UPLEFT;

    public static final Point oddq_directions[][] =

    {
        { new Point(-1, -1), new Point(-1, 0), new Point(-1, +1),
                new Point(0, -1), new Point(+1, 0), new Point(0, 1) },




        { new Point(0, -1), new Point(-1, 0), new Point(0, +1),
             new Point(+1, -1), new Point(+1, 0), new Point(+1, +1) }
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

}
