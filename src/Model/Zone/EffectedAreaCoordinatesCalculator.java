package Model.Zone;

import Model.Enums.EffectShape;
import Model.Enums.Orientation;

import java.awt.*;
import java.util.ArrayList;

public class EffectedAreaCoordinatesCalculator {

    public EffectedAreaCoordinatesCalculator() {}

    public ArrayList<Point> calculateCoordinates(Point origin, Orientation orientation, EffectShape effectShape, int range) {
        ArrayList<Point> area = new ArrayList<>();
        // TODO calculate effected area
        area.add(new Point(1,2));
        return area;
    }
}
