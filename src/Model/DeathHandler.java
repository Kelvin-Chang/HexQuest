package Model;

import Model.Entity.Character.Player;
import View.Status.GameOverView;
import javafx.scene.canvas.Canvas;

public class DeathHandler {
    private Player p;
    private Canvas canvas;

    public DeathHandler(Player p, Canvas c) {
        this.p = p;
        canvas = c;
    }

    public void checkDeath() {
        if (p.isDead()) {
            GameOverView g = new GameOverView(canvas);
            g.render();
        }
    }
}
