package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public abstract class AreaEffect
{
    protected Effect effect;

    public abstract void trigger(CharacterEntity characterEntity);

    public Effect getEffect() { return effect; }
}