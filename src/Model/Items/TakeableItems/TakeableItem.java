package Model.Items.TakeableItems;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;
import Model.Items.Item;

public abstract class TakeableItem extends Item {

    public void equip(Inventory inventory, CharacterEntity characterEntity) {};

}
