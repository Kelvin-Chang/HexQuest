package Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.BoonItems;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.VariableEffectSkill;
import Model.Enums.EffectShape;
import Model.Enums.SkillType;
import Model.Items.TakeableItems.EquippableItems.UsableItems.SpellItems.SpellItem;

import java.awt.*;
import java.util.ArrayList;

import static Model.Enums.ItemSlot.BOON;

public abstract class BoonItem extends SpellItem {

    private int statChange;

    public BoonItem(int manaCost, int statChange, EffectShape effectShape, int range) {
        super(BOON, manaCost, effectShape, range);
        this.statChange = statChange;
    }

    public int calculateAppliedStatChange(CharacterEntity player) {
        VariableEffectSkill boonSkill = (VariableEffectSkill) player.getSpecificSkill(SkillType.BOONSKILL);
        return boonSkill.calculateChange(statChange);
    }

    public ArrayList<Point> getOwnLocation(CharacterEntity player) {
        ArrayList<Point> location = new ArrayList<>();
        Point point = player.getLocation();
        location.add(point);
        return location;
    }

}