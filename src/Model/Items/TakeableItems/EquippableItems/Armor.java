package Model.Items.TakeableItems.EquippableItems;

import static Model.Enums.ItemSlot.ARMOR;

public class Armor extends EquippableItem implements HasEquipUnequipEffects {

    private int armor;

    public Armor(int armor) {
        super(ARMOR);
        this.armor = armor;
        makeEquipEffect();
        makeUnequipEffect();
    }

    public void makeEquipEffect() {
        super.setEquipEffect(getEffectFactory().produceDefenseModifierEffect(armor));
    }

    public void makeUnequipEffect() {
        super.setUnequipEffect(getEffectFactory().produceDefenseModifierEffect(-armor));
    }
}
