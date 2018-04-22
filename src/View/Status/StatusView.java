package View.Status;

import Model.Entity.Character.Player;
import View.ElementBorder;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.math.BigDecimal;

public class StatusView {
    private Canvas canvas;
    private GraphicsContext gContext;

    public StatusView(Canvas c) {
        canvas = c;
        gContext = c.getGraphicsContext2D();
    }

    public void render(Player p) {
        gContext.setTextAlign(TextAlignment.LEFT);
        gContext.setTextBaseline(VPos.BASELINE);

        renderStatusBackground();
        renderHealth(p.getCurrentHealth(), p.getMaxHealth());
//        renderMana(p.getCurrentMana(), p.getMaxMana());
//        renderExp(p.getExp());
    }
    public void renderStatusBackground() {
        gContext.setFill(Color.WHITE);
        gContext.fillRect(canvas.getWidth()-310, 10, 300, 150 );
        ElementBorder b = new ElementBorder((int)canvas.getWidth()-310, (int)canvas.getWidth()-10, 10, 160);
        gContext.setStroke(Color.BLACK);
        gContext.setLineWidth(1.5);
        gContext.strokeLine(b.getLeft(),b.getTop(),b.getRight(),b.getTop());
        gContext.strokeLine(b.getLeft(),b.getTop(),b.getLeft(),b.getBottom());
        gContext.strokeLine(b.getRight(),b.getTop(),b.getRight(),b.getBottom());
        gContext.strokeLine(b.getLeft(),b.getBottom(),b.getRight(),b.getBottom());

    }
    public void renderHealth(int hp, int max) {
        float health = (float)hp/(float)max * 100;
        BigDecimal healthbd = new BigDecimal(Float.toString(health));
        healthbd = healthbd.setScale(2, BigDecimal.ROUND_HALF_UP);


        gContext.setFill(Color.GREY);
        gContext.fillRect(canvas.getWidth()-305, 15, 290, 20);
        gContext.setFill(Color.BLACK);
        gContext.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gContext.fillText("Health: " + Integer.toString(hp) + "/" + Integer.toString(max) +
                " (" + healthbd + "%)", canvas.getWidth()-300, 30);

    }
}
