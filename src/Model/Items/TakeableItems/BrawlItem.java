package Model.Items.TakeableItems;

import Model.Entity.Character.Inventory;
import Model.Items.Item;

import static Model.Enums.ItemSlots.BRAWL;

public class BrawlItem extends Item implements TakeableItem {

    public BrawlItem() {}

    @Override
    public void equip(Inventory inventory) {
        inventory.setEquippedItemSlot(BRAWL, this);
    }

    @Override
    public void unequip(Inventory inventory) {
        inventory.clearEquippedItemSlot(BRAWL);
    }

    @Override
    public void effect(){
        System.out.println("Brawl item used");
    }
}
