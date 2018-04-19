package Model.Entity.Character;

import Model.Entity.Skills.*;
import Model.Enums.SkillType;

import java.util.ArrayList;
import java.util.HashMap;

public class PlayerFactory {

    public PlayerFactory() {}

    public static Player produceSmasher() {
        HashMap<SkillType, Skill> skillList = new HashMap<>();
        addCommonSkills(skillList);
        addSmasherSkills(skillList);
        return new Player(skillList);
    }

    public static Player produceSummoner() {
        HashMap<SkillType, Skill> skillList = new HashMap<>();
        addCommonSkills(skillList);
        addSummonerSkills(skillList);
        return new Player(skillList);
    }

    public static Player produceSneak() {
        HashMap<SkillType, Skill> skillList = new HashMap<>();
        addCommonSkills(skillList);
        addSneakSkills(skillList);
        return new Player(skillList);
    }

    private static void addCommonSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.BINDWOUNDSSKILL, new BindWounds());
        skillList.put(SkillType.BARGAINSKILL, new Bargain());
        skillList.put(SkillType.OBSERVATIONSKILL, new Observation());
    }

    private static void addSmasherSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.BRAWLSKILL, new Brawl());
        skillList.put(SkillType.ONEHANDEDWEAPONSKILL, new OneHandedWeapon());
        skillList.put(SkillType.TWOHANDEDWEAPONSKILL, new TwoHandedWeapon());
    }

    private static void addSummonerSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.BANESKILL, new Bane());
        skillList.put(SkillType.BOONSKILL, new Boon());
        skillList.put(SkillType.ENCHANTMENTSKILL, new Enchantment());
        skillList.put(SkillType.STAFFSKILL, new Staff());
    }

    private static void addSneakSkills(HashMap<SkillType, Skill> skillList) {
        skillList.put(SkillType.CREEPSKILL, new Creep());
        skillList.put(SkillType.PICKPOCKETSKILL, new PickPocket());
        skillList.put(SkillType.RANGEDWEAPONSKILL, new RangedWeapon());
        skillList.put(SkillType.REMOVETRAPSKILL, new RemoveTrap());
    }
}
