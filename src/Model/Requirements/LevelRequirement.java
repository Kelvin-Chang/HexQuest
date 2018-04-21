package Model.Requirements;

import Model.Entity.Character.CharacterEntity;

public class LevelRequirement implements Requirement {

    int levelRequirement;

    public LevelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
    }


    @Override
    public boolean characterMeetsRequirement(CharacterEntity characterEntity) {
        if (characterEntity.getLevel() >= levelRequirement) {
            return  true;
        }
        return false;
    }
}
