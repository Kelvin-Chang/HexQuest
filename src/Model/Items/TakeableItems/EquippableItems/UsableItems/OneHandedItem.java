package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.ONEHANDED;

public class OneHandedItem extends UsableItem {

    int damage;

    public OneHandedItem(int damage) {
        super(ONEHANDED);
        this.damage = damage;
    }

    public void triggerItem(CharacterEntity player){
        System.out.println("OneHanded item used");
    }

}
