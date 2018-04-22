package Model.Entity.Character;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Effects.NPCEffect;
import javafx.scene.control.Dialog;

import java.util.ArrayList;

public abstract class NPC extends CharacterEntity {

    NPCEffect ableToBeAggroed;

    public NPC(){
        super();
    }

}

