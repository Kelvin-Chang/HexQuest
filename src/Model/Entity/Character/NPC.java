package Model.Entity.Character;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import javafx.scene.control.Dialog;

import java.util.ArrayList;

public class NPC extends CharacterEntity {
    NPC(){
    }
    private boolean dead;
    private Effect effect;
    private ArrayList<ArrayList<String>> Dialogue;
    private int curSent;
    private boolean takedamage;

    @Override
    public boolean isDead() {
        return dead;
    }

    public void experience(Effect effect){
        this.effect = EffectFactory.produceLevelUpEffect();
    }

    public void trigger(Player characterEntity) {
        if(!dead) {
            effect.trigger(characterEntity);
            this.dead = true;
        }
    }

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

    public boolean takedamage(){
        if(getCurrentHealth() != getMaxHealth())
        {
            takedamage = true;
        }
        else{
            takedamage = false;
        }
        return takedamage;
    }
}

