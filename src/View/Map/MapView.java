package View.Map;

//import Model.*;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import java.awt.Point;
import java.io.File;
import java.util.ArrayList;

public class MapView {
    private GraphicsContext gContext;
    private Canvas canvas;

    private Polygon hexagon = new Polygon(-16,0, -8,14, 8,14, 16,0, 8,-14, -8,-14);
    private Point cameraLocation;
    private final int radius = 16;

    public MapView(Canvas c) {
        hexagon.setFill(Color.GREEN);
        hexagon.setStroke(Color.BLACK);
        canvas = c;
        gContext = canvas.getGraphicsContext2D();
        cameraLocation = new Point(0,0);
    }

    public void render(int x, int y) {
        gContext.setFill(Color.BLACK);
        gContext.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        double a, b;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i % 2 == 1) {
                    a = radius*2*i;
                    b = (2*radius*j)+(radius);
                } else {
                    a = radius*2*i;
                    b = radius*2*j;
                }
                gContext.drawImage(getImage(System.getProperty("user.dir") + "/src/assets/tile.png"), a, b, 2*radius, 2*radius);
            }
        }


    }

    private void renderTiles() {
        gContext.setStroke(Color.BLACK);
        gContext.setLineWidth(1);

    }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }
}
