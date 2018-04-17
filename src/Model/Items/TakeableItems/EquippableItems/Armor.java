package Model.Items.TakeableItems.EquippableItems;

import static Model.Enums.ItemSlot.ARMOR;

public class Armor extends EquippableItem {

    private int armor;

    public Armor(int armor) {
        super(ARMOR);
        this.armor = armor;
        makeEquippingRelatedEffects();
    }

    @Override
    public void makeEquipEffect() {
        super.setEquipEffect(getEffectFactory().produceDefenseModifierEffect(armor));
    }

    @Override
    public void makeUnequipEffect() {
        super.setUnequipEffect(getEffectFactory().produceDefenseModifierEffect(-armor));
    }
}
