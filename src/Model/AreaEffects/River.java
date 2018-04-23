package Model.AreaEffects;

import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class River extends AreaEffect {
    public River() {
        this.effect = EffectFactory.produceRiverEffect(Orientation.UP);
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
