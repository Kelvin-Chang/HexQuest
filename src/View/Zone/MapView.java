package View.Zone;

import Model.Zone.Terrain;
import Model.Zone.Zone;
import View.SpriteBase;
import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Collection;

public class MapView {
    private GraphicsContext graphicsContext;
    SpriteBase sprites;

    public MapView(GraphicsContext graphicsContext, SpriteBase sprites) {
        this.graphicsContext  = graphicsContext;
        this.sprites = sprites;
    }

    public void render(Terrain zoneTerrain, Point2D imageCoordinates, int radius) {
        switch (zoneTerrain) {
            case GRASS:
//                    System.out.println("drew Grass" + zoneArr[i].getX() + ", " + zoneArr[i].getY());
                graphicsContext.drawImage(sprites.getTileSprite(0), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case MOUNTAIN:
//                    System.out.println("drew Mountain" + zoneArr[i].getX() + ", " + zoneArr[i].getY());
                graphicsContext.drawImage(sprites.getTileSprite(1), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            case WATER:
//                    System.out.println("drew Water" + zoneArr[i].getX() + ", " + zoneArr[i].getY());
                graphicsContext.drawImage(sprites.getTileSprite(2), imageCoordinates.getX(), imageCoordinates.getY(), 2 * radius, 2 * radius);
                break;
            default:
                break;
        }
    }
}

