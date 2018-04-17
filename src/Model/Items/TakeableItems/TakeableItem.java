package Model.Items.TakeableItems;

import Model.Entity.Character.Inventory;

public interface TakeableItem {

    void equip(Inventory inventory);
    void unequip(Inventory inventory);
    void effect();
}
