package Model.Items.TakeableItems;

import Model.Entity.Character.Inventory;

import static Model.Enums.ItemSlots.TWOHANDED;

public class TwoHandedItem implements TakeableItem {

    public TwoHandedItem() {}

    @Override
    public void equip(Inventory inventory) {
        inventory.setEquippedItemSlot(TWOHANDED, this);
    }

    @Override
    public void unequip(Inventory inventory) {
        inventory.clearEquippedItemSlot(TWOHANDED);
    }

    @Override
    public void effect(){
        System.out.println("TwoHanded item used");
    }
}
