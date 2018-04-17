package Model.Entity.Character;

import Model.Enums.ItemSlots;
import Model.Items.TakeableItems.TakeableItem;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private ArrayList<TakeableItem> unequippedItems;
    private HashMap<ItemSlots, TakeableItem> equippedItems;

    public Inventory() {
        unequippedItems = new ArrayList<TakeableItem>();
        equippedItems = new HashMap<ItemSlots, TakeableItem>();
    }

    public void equipItem(TakeableItem item) {
        item.equip(this);
    }

    public void unequipItem(TakeableItem item) {
        item.unequip(this);
    }

    public void useItemSlot(ItemSlots slot) {
        if (equippedItems.get(slot) != null) {
            equippedItems.get(slot).effect();
        }
    }

    public void setEquippedItemSlot(ItemSlots slot, TakeableItem item) {
        if (equippedItems.get(slot) != null) {
            unequippedItems.add(equippedItems.get(slot));
            equippedItems.put(slot, item);
        } else {
            equippedItems.put(slot, item);
        }
    }

    public void clearEquippedItemSlot(ItemSlots slot) {
        equippedItems.remove(slot);
    }
}
