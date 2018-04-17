package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public abstract class Effect {

    protected Effect effect;

    public void trigger(CharacterEntity character){ }

    public Effect getEffect() { return effect; }
}
