package Model.AreaEffects;

import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class River extends AreaEffect {
    private Orientation dir;

    public River(Orientation orientation) {
        dir = orientation;
        this.effect = EffectFactory.produceRiverEffect(orientation);
    }

    public Orientation getDir() {
        return dir;
    }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        effect.trigger(characterEntity);
    }

    @Override
    public String toString() {
        return "River";
    }
}
