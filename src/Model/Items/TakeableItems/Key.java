package Model.Items.TakeableItems;

import Model.Entity.Character.CharacterEntity;

public class Key extends TakeableItem{

    public Key() {}

    public void trigger(CharacterEntity characterEntity){
        characterEntity.addToInventory(this);
    }

}
