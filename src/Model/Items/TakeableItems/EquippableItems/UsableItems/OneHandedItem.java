package Model.Items.TakeableItems.EquippableItems.UsableItems;

import static Model.Enums.ItemSlot.ONEHANDED;

public class OneHandedItem extends UsableItem {

    int damage;

    public OneHandedItem(int damage) {
        super(ONEHANDED);
        this.damage = damage;
    }

    public void triggerItem(){
        System.out.println("OneHanded item used");
    }

}
