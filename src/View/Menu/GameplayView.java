package View.Menu;

import Controller.Input.ViewController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class GameplayView extends AbstractView {

    private ViewController viewController;
    private Canvas canvas;
    private GraphicsContext graphicsContext;

    public GameplayView(ViewController viewController) {
        this.canvas = new Canvas();
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.viewController = viewController;
    }

    // TODO: format this view to hold buttons to access inventory and stuff
}
