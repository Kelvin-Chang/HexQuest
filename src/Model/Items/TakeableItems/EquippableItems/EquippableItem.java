package Model.Items.TakeableItems.EquippableItems;

import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.TakeableItem;

public abstract class EquippableItem extends TakeableItem {

    private ItemSlot itemSlot;
    private static final EffectFactory effectFactory = new EffectFactory();
    private Effect equipEffect;
    private Effect unequipEffect;

    public EquippableItem(ItemSlot itemSlot) {
        this.itemSlot = itemSlot;
    }

    @Override
    public void equip(Inventory inventory, CharacterEntity characterEntity) {
        inventory.setEquippedItemSlot(itemSlot, this);
        if (equipEffect != null) {
            equipEffect.trigger(characterEntity);
        }
    }

    public void unequip(Inventory inventory, CharacterEntity characterEntity) {
        inventory.clearEquippedItemSlot(itemSlot);
        if (unequipEffect != null) {
            unequipEffect.trigger(characterEntity);
        }
    }

    public void triggerItem() {};

    public static EffectFactory getEffectFactory() {
        return effectFactory;
    }
    //public abstract void makeEquipEffect();
    //public abstract void makeUnequipEffect();
//    public void makeEquippingRelatedEffects() {
//        makeEquipEffect();
//        makeUnequipEffect();
//    }
    public void setEquipEffect(Effect equipEffect) {
        this.equipEffect = equipEffect;
    }
    public void setUnequipEffect(Effect unequipEffect) {
        this.unequipEffect = unequipEffect;
    }
}
