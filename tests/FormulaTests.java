import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static Model.Zone.HexFormulas.distanceToPoint;

public class FormulaTests {

    @Test
    public void testDistanceFormula(){
        Point x1 = new Point(0,0);
        Point y1 = new Point(5,0);

        double z1 = distanceToPoint(x1,y1);
        System.out.println(z1);
        //Assert.assertTrue(z1 == 4);

        Point x2 = new Point(1,1);
        Point y2 = new Point(5,0);

        double z2 = distanceToPoint(x2,y2);
        System.out.println(z2);
        //Assert.assertTrue(z1 == 4);

        Point x3 = new Point(2,1);
        Point y3 = new Point(7,5);

        double z3 = distanceToPoint(x3,y3);
        System.out.println(z3);
        //Assert.assertTrue(z3 == 6);
    }
}
