package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Items.TakeableItems.EquippableItems.EquippableItem;

import static Model.Enums.ItemSlot.TWOHANDED;

public class TwoHandedItem extends UsableItem {

    int damage;

    public TwoHandedItem(int damage) {
        super(TWOHANDED);
        this.damage = damage;
        makeEquippingRelatedEffects();
    }

    @Override
    public void triggerItem(){
        System.out.println("TwoHanded item used");
    }

    @Override
    public void makeEquipEffect() {
        super.setEquipEffect(getEffectFactory().produceAttackModifierEffect(damage));
    }

    @Override
    public void makeUnequipEffect() {
        super.setUnequipEffect(getEffectFactory().produceAttackModifierEffect(-damage));
    }
}
