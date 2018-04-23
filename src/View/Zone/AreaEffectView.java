package View.Zone;

import Model.AreaEffects.AreaEffect;
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
                graphicsContext.drawImage(sprites.getEffectSprite(5), imageCoordinates.getX(), imageCoordinates.getY(), 2*radius, 2*radius);
                break;
            default:
                break;
        }

    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    private void drawRotatedImage(Image image, double angle, double tlpx, double tlpy) {
        graphicsContext.save(); // saves the current state on stack, including the current transform
        rotate(graphicsContext, angle, tlpx + image.getWidth() / 2, tlpy + image.getHeight() / 2);
        graphicsContext.drawImage(image, tlpx, tlpy);
        graphicsContext.restore(); // back to original state (before rotation)
    }

}
