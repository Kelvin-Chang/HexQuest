package Model.AreaEffects;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class HealDamage extends AreaEffect {

    public HealDamage(){
        this.effect = EffectFactory.produceHealthModifierEffect(10);
    }

    public String toString() { return "Heal"; }

    @Override
    public Orientation getDir() {
        return null;
    }
    @Override
    public void trigger(CharacterEntity characterEntity) {
        effect.trigger(characterEntity);
    }
}
