package Model.Entity.Character;

import Model.Entity.Skills.Skill;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;
import Model.Items.TakeableItems.EquippableItems.UsableItems.UsableItem;
import Model.Items.TakeableItems.TakeableItem;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    private ArrayList<TakeableItem> unequippedItems;
    private HashMap<ItemSlot, EquippableItem> equippedItems;

    public Inventory() {
        unequippedItems = new ArrayList<TakeableItem>();
        equippedItems = new HashMap<ItemSlot, EquippableItem>();
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
            usableItem.triggerItem(characterEntity, skill);
        }
    }

    public void useItemSlotNotRequiringSkill(ItemSlot slot, CharacterEntity characterEntity) {
        if (equippedItems.get(slot) != null) {
            UsableItem usableItem = (UsableItem) equippedItems.get(slot);
            usableItem.triggerItem(characterEntity);
        }
    }

    public void setEquippedItemSlot(ItemSlot slot, EquippableItem item) {
        if (equippedItems.get(slot) != null) {
            unequippedItems.add(equippedItems.get(slot));
            equippedItems.put(slot, item);
        } else {
            equippedItems.put(slot, item);
        }
    }

    public void clearEquippedItemSlot(ItemSlot slot) {
        equippedItems.remove(slot);
    }
}
