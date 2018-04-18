package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;
import Model.Items.TriggerableItem;

public abstract class UsableItem extends EquippableItem implements TriggerableItem {

    public UsableItem(ItemSlot itemSlot) {
        super(itemSlot);
    }

}
