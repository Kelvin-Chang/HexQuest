package Model.Entity.Character;

import Model.Entity.Skills.*;

import java.util.ArrayList;

public class PlayerFactory {

    public PlayerFactory() {}

    public Player produceSmasher() {
        ArrayList<Skill> skillList = new ArrayList<>();
        addCommonSkills(skillList);
        addSmasherSkills(skillList);
        return new Player(skillList);
    }

    public Player produceSummoner() {
        ArrayList<Skill> skillList = new ArrayList<>();
        addCommonSkills(skillList);
        addSummonerSkills(skillList);
        return new Player(skillList);
    }

    public Player produceSneak() {
        ArrayList<Skill> skillList = new ArrayList<>();
        addCommonSkills(skillList);
        addSneakSkills(skillList);
        return new Player(skillList);
    }

    private void addCommonSkills(ArrayList<Skill> skillList) {
        skillList.add(new BindWounds());
        skillList.add(new Bargain());
        skillList.add(new Observation());
    }

    private void addSmasherSkills(ArrayList<Skill> skillList) {
        skillList.add(new Brawl());
        skillList.add(new OneHandedWeapon());
        skillList.add(new TwoHandedWeapon());
    }

    private void addSummonerSkills(ArrayList<Skill> skillList) {
        skillList.add(new Bane());
        skillList.add(new Boon());
        skillList.add(new Enchantment());
    }

    private void addSneakSkills(ArrayList<Skill> skillList) {
        skillList.add(new Creep());
        skillList.add(new PickPocket());
        skillList.add(new RangedWeapon());
        skillList.add(new RemoveTrap());
    }
}
