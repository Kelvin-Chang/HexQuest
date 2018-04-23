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
        renderMana(p.getCurrentMana(), p.getMaxMana());
        renderLevel(p.getLevel());
        renderExp(p.getExp());
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
    public void renderMana(int mp, int max) {
        float mana = (float)mp/(float)max * 100;
        BigDecimal manabd = new BigDecimal(Float.toString(mana));
        manabd = manabd.setScale(2, BigDecimal.ROUND_HALF_UP);
        gContext.setFill(Color.LIGHTCYAN);
        gContext.fillRect(canvas.getWidth()-305, 40, 290, 20);
        gContext.setFill(Color.BLACK);
        gContext.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gContext.fillText("Mana: " + Integer.toString(mp) + "/" + Integer.toString(max) +
                " (" + manabd + "%)", canvas.getWidth()-300, 55);

    }

    public void renderLevel(int level) {
        gContext.setFill(Color.LIGHTGOLDENRODYELLOW);
        gContext.fillRect(canvas.getWidth()-305, 65, 290, 20);
        gContext.setFill(Color.BLACK);
        gContext.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gContext.fillText("Level: " + level, canvas.getWidth()-300, 80);
    }

    public void renderExp(int xp) {
        float exptonext = (float)xp/(float)100 * 100;
        BigDecimal xpdb = new BigDecimal(Float.toString(exptonext));
        xpdb = xpdb.setScale(2, BigDecimal.ROUND_HALF_UP);
        gContext.setFill(Color.LIGHTGOLDENRODYELLOW);
        gContext.fillRect(canvas.getWidth()-305, 90, 290, 20);
        gContext.setFill(Color.BLACK);
        gContext.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        gContext.fillText("Experience: " + Integer.toString(xp) + "/100" +
                " (" + xpdb + "%)", canvas.getWidth()-300, 105);
    }
}
