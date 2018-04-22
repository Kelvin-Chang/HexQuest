package View.Menu;

import Controller.Input.ViewController;
import Controller.buttons.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GameplayView extends AbstractView {

    private ViewController viewController;

    private Canvas canvas;
    private BorderPane borderPane;
    private GraphicsContext graphicsContext;

    public GameplayView(ViewController viewController, Stage primaryStage) {
        this.viewController = viewController;
        createNewCanvas(primaryStage);
        this.graphicsContext = canvas.getGraphicsContext2D();
    }

    // TODO: format this view to hold buttons to access inventory and stuff

    private void createNewCanvas(Stage primaryStage) {
        canvas = new Canvas(1000, 728);
        canvas.setMouseTransparent(true);

        borderPane = new BorderPane();
        borderPane.setPrefSize(1000, 800);

        Pane p = new Pane();
        p.setPrefSize(100,600);
        //--------------------------------------------------------------------------------------------------------------

        HBox hbox = new HBox();

        hbox.setSpacing(10);
        hbox.setPrefSize(1000,72);
        hbox.setAlignment(Pos.TOP_CENTER);

        ArrayList<Selectable> options = new ArrayList<Selectable>() {{
            add(new ExitProgramSelectable("Exit", viewController));
        }};

        for(Selectable clickable: options) {
            Button selectable = new Button(clickable.getName());

            // sets selectable style
            selectable.getStyleClass().add("button2");

            // set action
            selectable.setOnAction(clickable);

            // add to vbox
            hbox.getChildren().add(selectable);
        }

        borderPane.setBottom(hbox);



        //--------------------------------------------------------------------------------------------------------------
        borderPane.setCenter(p);
        p.getChildren().add(canvas);


        this.getChildren().add(borderPane);
        primaryStage.setScene(viewController.getScene());
        graphicsContext = canvas.getGraphicsContext2D();
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public Canvas getCanvas() {
        return canvas;
    }

}
