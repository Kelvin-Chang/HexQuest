package Model.Entity;

public class Mount extends Entity{
    private int speedMod;
    private boolean hasOwner;

    Mount(){
        speedMod = 1;
        hasOwner = false;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public int getSpeedMod() {
        return speedMod;
    }
}
