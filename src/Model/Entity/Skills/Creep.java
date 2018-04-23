package Model.Entity.Skills;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Effects.NPCEffect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.EffectShape;
import Model.Zone.EffectedAreaCoordinatesCalculator;

import java.awt.*;
import java.util.ArrayList;

public class Creep extends VariableEffectSkill {

    private boolean isCreeping;
    private Effect backStabEffect;
    private NPCEffect creepEffect;
    private EffectFactory effectFactory = new EffectFactory();

    public Creep() {
        super("Creep");
        isCreeping = false;
    }

    @Override
    public void activateSkill(CharacterEntity player) {
        if (isCreeping) {
            isCreeping = false;

            int healthChange = calculateChange(100 + player.getAttack());

            backStabEffect = effectFactory.produceHealthModifierEffect(-healthChange);

            EffectedAreaCoordinatesCalculator coordinatesCalculator = new EffectedAreaCoordinatesCalculator();
            ArrayList<Point> effectedCoordinates =
                    coordinatesCalculator.calculateCoordinates(player.getLocation(), player.getOrientation(), EffectShape.LINEAR, 1);

            player.effectEntities(effectedCoordinates, backStabEffect);

            creepEffect = effectFactory.produceAbleToBeAggroedEffect(true);
            player.effectAllEntities(creepEffect);
        } else {
            isCreeping = true;

            creepEffect = effectFactory.produceAbleToBeAggroedEffect(false);
            player.effectAllEntities(creepEffect);
        }
    }
}
