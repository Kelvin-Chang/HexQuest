package Model.AreaEffects;

import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class River extends AreaEffect {
    public River(Orientation orientation) {
        this.effect = EffectFactory.produceRiverEffect(orientation);
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
