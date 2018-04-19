package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public abstract class Effect {
    public abstract void trigger(CharacterEntity character);
}
