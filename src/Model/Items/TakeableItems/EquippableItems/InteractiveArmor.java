package Model.Items.TakeableItems.EquippableItems;

import Model.Entity.Character.CharacterEntity;
import Model.Requirements.Requirement;

import static Model.Enums.ItemSlot.ARMOR;

public class InteractiveArmor extends EquippableItem implements HasEquipUnequipEffects {

    private int armor;
    private Requirement requirement;

    public InteractiveArmor(int armor, Requirement requirement) {
        super(ARMOR);
        this.armor = armor;
        this.requirement = requirement;
        makeEquipEffect();
        makeUnequipEffect();
        setName("Interactive Armor");
    }

    public void makeEquipEffect() {
        super.setEquipEffect(getEffectFactory().produceDefenseModifierEffect(armor));
    }

    public void makeUnequipEffect() {
        super.setUnequipEffect(getEffectFactory().produceDefenseModifierEffect(-armor));
    }

    @Override
    public void trigger(CharacterEntity characterEntity) {
        if (requirement.characterMeetsRequirement(characterEntity)) {
            characterEntity.addToInventory(this);
        }
    }
}
