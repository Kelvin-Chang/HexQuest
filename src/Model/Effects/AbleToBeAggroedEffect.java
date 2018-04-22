package Model.Effects;

import Model.Entity.Character.NPC;

public class AbleToBeAggroedEffect implements NPCEffect {

    private boolean ableToBeAggroed;

    public AbleToBeAggroedEffect(boolean ableToBeAggroed) {
        this.ableToBeAggroed = ableToBeAggroed;
    }

    @Override
    public void trigger(NPC character) {
        //character.setAbleToBeAggroed(ableToBeAggroed);
    }
}
