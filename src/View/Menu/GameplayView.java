package View.Menu;

import Controller.Input.ViewController;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameplayView extends AbstractView {

    private ViewController viewController;

    private Canvas canvas;
    private BorderPane borderPane;
    private GraphicsContext graphicsContext;

    public GameplayView(ViewController viewController, Stage primaryStage) {
        creatNewCavas(primaryStage);
        this.graphicsContext = canvas.getGraphicsContext2D();
        this.viewController = viewController;
    }

    // TODO: format this view to hold buttons to access inventory and stuff

    private void creatNewCavas(Stage primaryStage) {
        Scene scene = new Scene(this, 1000, 800);

        canvas = new Canvas(1000, 800);

        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 800);

        Pane p = new Pane();
        p.setPrefWidth(1000);
        p.setPrefHeight(800);

        borderPane.setCenter(p);
        p.getChildren().add(canvas);


        this.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        graphicsContext = canvas.getGraphicsContext2D();
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
