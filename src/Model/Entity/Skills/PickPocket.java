package Model.Entity.Skills;

import Model.Entity.Character.CharacterEntity;

public class PickPocket extends Skill {

    public PickPocket() {
        super("PickPocket");
    }

    @Override
    public void activateSkill(CharacterEntity player) {
        CharacterEntity pickPocketPartner = player.getInteractionPartner();
        if (pickPocketPartner != null) {
            player.pickPocket(pickPocketPartner);
        }
    }
}
