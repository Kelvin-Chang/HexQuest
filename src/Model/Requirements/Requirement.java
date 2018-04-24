package Model.Requirements;

import Model.Entity.Character.CharacterEntity;

public interface Requirement {

    boolean characterMeetsRequirement(CharacterEntity characterEntity);

}
