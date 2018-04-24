package Model.Effects;

import Model.Entity.Character.CharacterEntity;
import Model.Enums.SkillType;

public class SkillModifierEffect implements Effect {

    private int skillChange;
    private SkillType skillType;

    public SkillModifierEffect(int skillChange, SkillType skillType) {
        this.skillChange = skillChange;
        this.skillType = skillType;
    }

    @Override
    public void trigger(CharacterEntity character) {
        character.modifySkillLevel(skillChange, skillType);
    }
}
