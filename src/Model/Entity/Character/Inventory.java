package Model.Entity.Character;

import Model.Entity.Skills.Skill;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.UsableItem;
import Model.Items.TakeableItems.TakeableItem;

import java.util.HashMap;

public class Inventory {

    private TakeableItem[] unequippedItems;
    private HashMap<ItemSlot, EquippableItem> equippedItems;
    private int unequippedItemBagSize;
    private int equippedItemBagSize;

    public Inventory() {
        this.equippedItemBagSize = 10;
        this.unequippedItemBagSize = 10;
        this.unequippedItems = new TakeableItem[unequippedItemBagSize];
        this.equippedItems = new HashMap<>();

    }

    public void addToInventory(TakeableItem item){
        int nextSpace = nextAvailableSpace();

        if(nextSpace != -1)
            unequippedItems[nextSpace] = item;
    }

    private int nextAvailableSpace(){
        for(int i = 0; i < unequippedItemBagSize; ++i){
            if (unequippedItems[i] != null)
                continue;
            return i;
        }
        return -1;
    }

    public boolean hasFreeSpace(){
        for(int i = 0; i < unequippedItemBagSize; i++) {
            if(unequippedItems[i] == null) {
                return true;
            }
        }

        return false;
    }
    public TakeableItem getItemAtSlot(int slot) {
        if(validSlot(slot) && itemExistsAtSlot(slot)) {
            return unequippedItems[slot];
        }
        return null;
    }
    private boolean validSlot(int slot) {
        if (slot > -1 && slot < unequippedItemBagSize) {
            return true;
        } else {
            return false;
        }
    }
    private boolean itemExistsAtSlot(int slot) {
        return unequippedItems[slot] != null;
    }

    public void equipItem(TakeableItem item, CharacterEntity characterEntity) {
        item.equip(this, characterEntity);
    }

    public void unequipItem(EquippableItem item, CharacterEntity characterEntity) {
        item.unequip(this, characterEntity);
    }

    public void useItemSlotRequiringSkill(ItemSlot slot, CharacterEntity characterEntity, Skill skill) {
        if (equippedItems.get(slot) != null) {
            UsableItem usableItem = (UsableItem) equippedItems.get(slot);
            usableItem.useItem(characterEntity, skill);
        }
    }

    public void useItemSlotNotRequiringSkill(ItemSlot slot, CharacterEntity characterEntity) {
        if (equippedItems.get(slot) != null) {
            UsableItem usableItem = (UsableItem) equippedItems.get(slot);
            usableItem.useItem(characterEntity);
        }
    }

    public void setEquippedItemSlot(ItemSlot slot, EquippableItem item) {
        if (equippedItems.get(slot) != null) {
            unequippedItems[nextAvailableSpace()] = (equippedItems.get(slot));
            equippedItems.put(slot, item);
        } else {
            equippedItems.put(slot, item);
        }
    }

    public void clearEquippedItemSlot(ItemSlot slot) {
        equippedItems.remove(slot);
    }

    public int getUnequippedItemBagSize() {
        return unequippedItemBagSize;
    }

    public int getEquippedItemBagSize() {
        return equippedItemBagSize;
    }

    public TakeableItem[] getUnequippedItems() {
        return unequippedItems;
    }

    public HashMap<ItemSlot, EquippableItem> getEquippedItems() {
        return equippedItems;
    }
}
