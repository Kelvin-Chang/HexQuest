package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;
import Model.Updateable;

public abstract class AreaEffect {
    protected Effect effect;

    public abstract void trigger(CharacterEntity characterEntity);

    public abstract String toString();

    public Effect getEffect() { return effect; }
}