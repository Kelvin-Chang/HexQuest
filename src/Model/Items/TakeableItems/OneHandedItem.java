package Model.Items.TakeableItems;

import Model.Entity.Character.Inventory;

import static Model.Enums.ItemSlots.ONEHANDED;

public class OneHandedItem implements TakeableItem{

    public OneHandedItem() {}

    @Override
    public void equip(Inventory inventory) {
        inventory.setEquippedItemSlot(ONEHANDED, this);
    }

    @Override
    public void unequip(Inventory inventory) {
        inventory.clearEquippedItemSlot(ONEHANDED);
    }

    @Override
    public void effect(){
        System.out.println("OneHanded item used");
    }
}
