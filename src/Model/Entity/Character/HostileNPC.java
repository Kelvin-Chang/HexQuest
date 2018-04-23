package Model.Entity.Character;

import Model.Zone.Zone;

public class HostileNPC extends NPC {


    private boolean aggroed;
    private boolean chasing;

    public HostileNPC(){
        super();
        this.aggroed = false;
        this.chasing = false;
    }

    public boolean isAggroed() {
        return aggroed;
    }

    public void setAggroed(boolean aggroed) {
        this.aggroed = aggroed;
    }

    public boolean isChasing() {
        return chasing;
    }

    public void setChasing(boolean chasing) {
        this.chasing = chasing;
    }

    public HostileNPC(Zone zone){
        super(zone);
    }


}
