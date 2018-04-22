package View.Zone.Items;

import javafx.scene.canvas.GraphicsContext;
import View.SpriteBase;

import java.awt.geom.Point2D;

public class ObstacleView extends ItemView {

    private GraphicsContext graphicsContext;
    private SpriteBase sprites;

    public ObstacleView(GraphicsContext graphicsContext, SpriteBase sprites) {
        this.graphicsContext = graphicsContext;
        this.sprites = sprites;
    }

    public void render(Point2D imageCoordinates, int radius) {
        graphicsContext.drawImage(sprites.getObstacleSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
    }
}
