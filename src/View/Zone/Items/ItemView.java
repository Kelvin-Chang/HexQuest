package View.Zone.Items;

import View.SpriteBase;
import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class ItemView {

    private GraphicsContext graphicsContext;
    private SpriteBase sprites;

    public ItemView(GraphicsContext graphicsContext, SpriteBase sprites) {
        this.graphicsContext = graphicsContext;
        this.sprites = sprites;
    }

    public void render(String name, Point2D imageCoordinates, int radius) {
        graphicsContext.drawImage(sprites.getItemSprite(name), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
    }
}
