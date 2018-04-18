package Model.Entity.Character;

import Model.Entity.Skills.*;
import Model.Enums.SkillType;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerFactory {

    public PlayerFactory() {}

    public Player produceSmasher() {
        HashMap<SkillType, Skill> skillList = new HashMap<>();
        addCommonSkills(skillList);
        addSmasherSkills(skillList);
        return new Player(skillList);
    }

    public Player produceSummoner() {
        HashMap<SkillType, Skill> skillList = new HashMap<>();
        addCommonSkills(skillList);
        addSummonerSkills(skillList);
        return new Player(skillList);
    }

    public Player produceSneak() {
        HashMap<SkillType, Skill> skillList = new HashMap<>();
        addCommonSkills(skillList);
        addSneakSkills(skillList);
        return new Player(skillList);
    }

    private void addCommonSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.BINDWOUNDSSKILL, new BindWounds());
        skillList.put(SkillType.BARGAINSKILL, new Bargain());
        skillList.put(SkillType.OBSERVATIONSKILL, new Observation());
    }

    private void addSmasherSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.BRAWLSKILL, new Brawl());
        skillList.put(SkillType.ONEHANDEDWEAPONSKILL, new OneHandedWeapon());
        skillList.put(SkillType.TWOHANDEDWEAPONSKILL, new TwoHandedWeapon());
    }

    private void addSummonerSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.BANESKILL, new Bane());
        skillList.put(SkillType.BOONSKILL, new Boon());
        skillList.put(SkillType.ENCHANTMENTSKILL, new Enchantment());
        skillList.put(SkillType.STAFFSKILL, new Staff());
    }

    private void addSneakSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.CREEPSKILL, new Creep());
        skillList.put(SkillType.PICKPOCKETSKILL, new PickPocket());
        skillList.put(SkillType.RANGEDWEAPONSKILL, new RangedWeapon());
        skillList.put(SkillType.REMOVETRAPSKILL, new RemoveTrap());
    }
}
