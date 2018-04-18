package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Entity.Character.CharacterEntity;

import static Model.Enums.ItemSlot.TWOHANDED;

public class TwoHandedItem extends UsableItem {

    int damage;

    public TwoHandedItem(int damage) {
        super(TWOHANDED);
        this.damage = damage;
    }

    public void triggerItem(CharacterEntity player){
        System.out.println("TwoHanded item used");
    }

}
