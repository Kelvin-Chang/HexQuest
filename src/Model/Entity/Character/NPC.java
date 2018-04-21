package Model.Entity.Character;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import javafx.scene.control.Dialog;

import java.util.ArrayList;

public class NPC extends CharacterEntity {
    public NPC(){
        super();
    }

    private ArrayList<ArrayList<String>> Dialogue;

    public void setDialogue(ArrayList<ArrayList<String>> dialogue) {
        Dialogue = dialogue;
    }

    public String getDialogue(int curSent){
        String message = " ";
        for(int i = 0; i < Dialogue.get(curSent).size(); i++ )
        {
            message += Dialogue.get(curSent).get(i);
            message += " ";
        }
        return message;
    }

}

