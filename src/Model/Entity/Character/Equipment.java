package Model.Entity.Character;

import Model.Items.TakeableItem;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
    TakeableItem armor;
    TakeableItem sword;
    TakeableItem shield;
    TakeableItem ring;

    Equipment(){
        this.armor = null;
        this.sword = null;
        this.shield = null;
        this.ring = null;
    }

    public void addToEquipment(TakeableItem item){

    }

    public void removeFromEquipment(TakeableItem item){

    }
}
