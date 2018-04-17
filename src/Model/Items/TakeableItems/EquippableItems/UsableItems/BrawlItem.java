package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Items.TakeableItems.EquippableItems.EquippableItem;

import static Model.Enums.ItemSlot.BRAWL;

public class BrawlItem extends UsableItem {

    private int damage;

    public BrawlItem(int damage) {
        super(BRAWL);
        this.damage = damage;
        makeEquippingRelatedEffects();
    }

    @Override
    public void triggerItem(){
        System.out.println("Brawl item used");
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
