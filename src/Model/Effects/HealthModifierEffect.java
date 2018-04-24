package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class HealthModifierEffect implements Effect {

    private int healthChange;

    public HealthModifierEffect(int healthChange) {
        this.healthChange = healthChange;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyHealth(healthChange);
    }

    @Override
    public String toString() {
        if (healthChange >=0 ) {
            return "Heal";
        } else {
            return "Damage";
        }
    }

}
