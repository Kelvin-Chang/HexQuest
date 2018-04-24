package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

public class Observation extends VariableEffectSkill {

    private int observation;

    public Observation() {
        super("Observation");
        observation = 0;
    }

    @Override
    public void activateSkill(CharacterEntity player) {
        CharacterEntity entityToBeObservered = player.getInteractionPartner();
        if (entityToBeObservered != null) {
            int deviation = calculateDeviation(entityToBeObservered.getCurrentHealth());
            observation = entityToBeObservered.getCurrentHealth() + deviation;
            System.out.println(observation);
        }
    }

    public int getObservation() {
        return observation;
    }
}
