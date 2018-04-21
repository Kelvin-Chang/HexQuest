package Model.Requirements;

public class RequirementFactory {

    public RequirementFactory() {}

    public Requirement produceLevelRequirement(int levelRequirement) {
        return new LevelRequirement(levelRequirement);
    }

}
