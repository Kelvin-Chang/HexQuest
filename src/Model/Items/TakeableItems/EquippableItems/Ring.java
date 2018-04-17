package Model.Items.TakeableItems.EquippableItems;

import static Model.Enums.ItemSlot.RING;

public class Ring extends EquippableItem implements HasEquipUnequipEffects{

    private int manaChange;

    public Ring(int manaChange) {
        super(RING);
        this.manaChange = manaChange;
        makeEquipEffect();
        makeUnequipEffect();
    }

    public void makeEquipEffect() {
        super.setEquipEffect(getEffectFactory().produceManaModifierEffect(manaChange));
    }

    public void makeUnequipEffect() {
        super.setUnequipEffect(getEffectFactory().produceManaModifierEffect(-manaChange));
    }
}
