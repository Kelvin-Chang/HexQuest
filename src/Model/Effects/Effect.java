package Model.Effects;

import Model.Entity.Character.CharacterEntity;

public interface Effect {
    void trigger(CharacterEntity character);
}
