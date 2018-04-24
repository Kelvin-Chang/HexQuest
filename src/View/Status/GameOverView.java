package View.Status;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameOverView {
    private Canvas canvas;
    private GraphicsContext gContext;

    public GameOverView(Canvas c) {
        canvas = c;
        gContext = c.getGraphicsContext2D();
    }

    public void render() {
        gContext.setFill(Color.WHITE);
        gContext.fillRect(0,0, canvas.getWidth(),canvas.getHeight());

        gContext.setFill(Color.BLACK);
        gContext.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        gContext.fillText("Game Over", canvas.getWidth()*.25, canvas.getHeight()*.3);

    }
}
