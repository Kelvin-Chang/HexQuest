package View.Zone;

import Model.AreaEffects.AreaEffect;
import View.SpriteBase;
import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class AreaEffectView {

    private GraphicsContext graphicsContext;
    private SpriteBase sprites;


    public AreaEffectView(GraphicsContext graphicsContext, SpriteBase sprites) {
        this.graphicsContext = graphicsContext;
        this.sprites = sprites;
    }

    public void render(AreaEffect currAE, Point2D imageCoordinates, int radius) {
        switch (currAE.toString()) {
            case "Heal":
                graphicsContext.drawImage(sprites.getEffectSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case "Damage":
                graphicsContext.drawImage(sprites.getEffectSprite(1), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case "Death":
                graphicsContext.drawImage(sprites.getEffectSprite(2), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case "Level":
                break;
            default:
                break;
        }

    }

}
