package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;
import Model.Updateable;

public abstract class AreaEffect {
    protected Effect effect;

    public abstract void trigger(CharacterEntity characterEntity);

    public abstract Orientation getDir();

    public abstract String toString();

    public Effect getEffect() { return effect; }
}