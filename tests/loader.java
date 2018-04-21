import Controller.LoadSave.GameBuilder;
import Controller.LoadSave.GameLoader;
import Controller.LoadSave.UnpackSave;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static Model.Zone.HexFormulas.distanceToPoint;
//the loader and make sure the world,
// zone, and character are being loaded
public class loader {
    @Test
    public void loaderWorld(){
        Point x1 = new Point(0,0);
        Point y1 = new Point(5,0);
        GameBuilder builder = new GameBuilder();
        GameLoader load = new GameLoader(builder);
        load.loadGame("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/resources/maps/map0.json");
        Assert.assertTrue(builder.getPlayer()!=null);
        Assert.assertTrue(builder.getWorld()!=null);
//        Assert.assertTrue(builder.()!=null);
//        Assert.assertTrue(builder.getWorld()!=null);
//        Assert.assertTrue(builder.getPlayer()!=null);


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
