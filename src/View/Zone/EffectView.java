package View.Zone;

import Model.AreaEffects.AreaEffect;
import Model.Effects.Effect;
import View.SpriteBase;
import javafx.scene.canvas.GraphicsContext;

import java.awt.geom.Point2D;

public class EffectView {

    private GraphicsContext graphicsContext;
    private SpriteBase sprites;


    public EffectView(GraphicsContext graphicsContext, SpriteBase sprites) {
        this.graphicsContext = graphicsContext;
        this.sprites = sprites;
    }

    public void render(Effect effect, Point2D imageCoordinates, int radius) {
        switch (effect.toString()) {
            case "Heal":
                graphicsContext.drawImage(sprites.getEffectSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case "Damage":
                graphicsContext.drawImage(sprites.getEffectSprite(1), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
        }

    }

}
