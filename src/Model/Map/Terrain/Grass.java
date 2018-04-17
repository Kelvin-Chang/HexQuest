package Model.Map.Terrain;

public class Grass implements Terrain {
    private boolean isPassable;
    
    public Grass() {
        isPassable = true;

    }

    public boolean getPassable() {
        return isPassable;
    }
}
