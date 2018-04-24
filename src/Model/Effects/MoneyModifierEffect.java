package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public class MoneyModifierEffect implements Effect {

    private int moneyChange;

    public MoneyModifierEffect(int moneyChange) {
        this.moneyChange = moneyChange;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifyMoney(moneyChange);
    }

}
