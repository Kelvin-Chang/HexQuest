package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Items.TakeableItems.EquippableItems.EquippableItem;

import static Model.Enums.ItemSlot.ONEHANDED;

public class OneHandedItem extends UsableItem {

    int damage;

    public OneHandedItem(int damage) {
        super(ONEHANDED);
        this.damage = damage;
        makeEquippingRelatedEffects();
    }

    @Override
    public void triggerItem(){
        System.out.println("OneHanded item used");
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
