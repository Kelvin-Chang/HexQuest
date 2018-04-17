package Model.Items.TakeableItems.EquippableItems.UsableItems;

import static Model.Enums.ItemSlot.BRAWL;

public class BrawlItem extends UsableItem {

    private int damage;

    public BrawlItem(int damage) {
        super(BRAWL);
        this.damage = damage;
    }

    public void triggerItem(){
        System.out.println("Brawl item used");
    }

}
