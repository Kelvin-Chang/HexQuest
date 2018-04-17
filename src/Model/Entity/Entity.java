package Model.Entity;

import java.awt.*;

public class Entity {
    private int speed;
    private Point location;
    private Boolean isAlive;
    private int orientation;
    Entity(){
        location = new Point(0,0);
        orientation = 0;
        speed = 1;
    }

    public int getOrientation() {
        return orientation;
    }

    public int getSpeed() {
        return speed;
    }

    public Point getLocation() {
        return location;
    }
    public void moveNorth()
    {
        location.y++;
        orientation = 180;
    }
    public void moveSouth()
    {
        location.y--;
        orientation = 0;
    }
    public void moveNorthWest()
    {
        location.y++;
        location.x--;
        orientation = 240;
    }
    public void moveNorthEast()
    {
        location.y++;
        location.x++;
        orientation = 120;
    }
    public void moveSouthWest()
    {
        location.x--;
        location.y--;
        orientation = 300;
    }
    public void moveSouthEast()
    {
        location.y--;
        location.x++;
        orientation = 60;
    }

    

}
