package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public interface Effect {
    public abstract void trigger(CharacterEntity character);
}
