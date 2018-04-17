package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;

public abstract class UsableItem extends EquippableItem {

    public UsableItem(ItemSlot itemSlot) {
        super(itemSlot);
    }

}
