package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class AttackModifierEffect extends Effect {

    private int attackChange;

    public AttackModifierEffect(int attackChange) {
        this.attackChange = attackChange;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyAttack(attackChange);
    }

}
