package View.Zone;

import Model.AreaEffects.AreaEffect;
import Model.AreaEffects.River;
import View.SpriteBase;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

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
                graphicsContext.drawImage(sprites.getEffectSprite(3), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case "Teleport":
                graphicsContext.drawImage(sprites.getEffectSprite(4), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case "River":
                switch (currAE.getDir()) {
                    case UP:
                        graphicsContext.drawImage(sprites.getEffectSprite(5), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case UPRIGHT:
                        graphicsContext.drawImage(sprites.getEffectSprite(6), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case DOWNRIGHT:
                        graphicsContext.drawImage(sprites.getEffectSprite(7), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case DOWN:
                        graphicsContext.drawImage(sprites.getEffectSprite(8), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case DOWNLEFT:
                        graphicsContext.drawImage(sprites.getEffectSprite(9), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    case UPLEFT:
                        graphicsContext.drawImage(sprites.getEffectSprite(10), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }

    }


}
