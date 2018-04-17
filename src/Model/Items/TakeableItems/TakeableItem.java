package Model.Items.TakeableItems;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Inventory;

public abstract class TakeableItem {

    public void equip(Inventory inventory, CharacterEntity characterEntity) {};

}
