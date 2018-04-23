package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;


public class Trap {
    // traps are like-a (but not) a oneshot item that have an invisibility boolean and a settable damage value
    // the states for this skill are:
    //                                  - the trap is detected, and revealed on the map
    //                                  - the trap is not detected
    //                                  - the detected trap is disarmed, and no damage is taken
    //                                  - the detected trap is not disarmed, and an amount of damage is decreased
    //                                    (which depends on the trapEscape attribute)

    private Effect effect;
    private int strength;
    private boolean isVisible;
    private boolean hasNotFired;

    public Trap(Effect event, int strength) {
        this.effect = event;
        this.strength = strength;
        this.isVisible = false;
        this.hasNotFired = true;
    }

    public void fireTrap(CharacterEntity entity){
        if(hasNotFired) {
            effect.trigger(entity);
            isVisible = true;
            hasNotFired = false;
        }
    }

    public void disarm(CharacterEntity entity, int successChance) {
        if(isVisible) { // we want to disarm the trap
            if(strength > successChance) { // failure
                isVisible = true;
                fireTrap(entity);
            } else { // success
                isVisible = true;
                hasNotFired = false;
            }
        } else { // we want to detect the trap
            if(strength < successChance) { // success
                isVisible = true;
            }
        }
    }

    public boolean getIsVisible() {
        return this.isVisible;
    }

    public boolean getHasNotFired() {
        return this.hasNotFired;
    }

    public Effect getEvent() {
        return effect;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void setHasNotFired(boolean hasNotFired) {
        this.hasNotFired = hasNotFired;
    }

    public int getStrength() {
        return strength;
    }


}
