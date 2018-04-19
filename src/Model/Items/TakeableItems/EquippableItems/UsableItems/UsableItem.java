package Model.Items.TakeableItems.EquippableItems.UsableItems;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Skills.Skill;
import Model.Enums.ItemSlot;
import Model.Items.TakeableItems.EquippableItems.EquippableItem;

public abstract class UsableItem extends EquippableItem {

    public UsableItem(ItemSlot itemSlot) {
        super(itemSlot);
    }

    public void triggerItem(CharacterEntity characterEntity) {}

    public void triggerItem(CharacterEntity characterEntity, Skill skill) {}

}
