package Model.Items;

import Model.Effects.Effect;
import Model.Entity.Character.CharacterEntity;

public class InteractiveItem {

    Effect interactEffect;

    void fireUseEvent(CharacterEntity character){
        interactEffect.trigger(character);
    }
}
