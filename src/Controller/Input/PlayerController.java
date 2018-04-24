package Controller.Input;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Player;
import Model.Enums.SkillType;

public class PlayerController {

    private CharacterEntity character;

    public PlayerController(Player player)
    {
        this.character = player;
    }

    public void pressUp() {
        this.character.addUpToMovementQueue();
        System.out.println("Up pressed");
    }

    public void pressUpRight() {
        this.character.addUpRightToMovementQueue();
        System.out.println("UpRight pressed");
    }

    public void pressUpLeft() {
        this.character.addUpLeftToMovementQueue();
        System.out.println("UpLeft pressed");
    }

    public void pressDown() {
        this.character.addDownToMovementQueue();
        System.out.println("Down pressed");
    }

    public void pressDownRight() {
        this.character.addDownRightToMovementQueue();
        System.out.println("DownRight pressed");
    }

    public void pressDownLeft() {
        this.character.addDownLeftToMovementQueue();
        System.out.println("DownLeft pressed");
    }

    public CharacterEntity pressBargain() {
        System.out.println("Bargain pressed");
        CharacterEntity bargainPartner = this.character.getInteractionPartner();
        if (bargainPartner != null) {
            return bargainPartner;
        } else {
            return null;
        }
    }

    public void pressBindWounds() {
        this.character.useSkill(SkillType.BINDWOUNDSSKILL);
        System.out.println("BindWounds pressed");
    }

    public void pressObservation() {
        this.character.useSkill(SkillType.OBSERVATIONSKILL);
        System.out.println("Observation pressed");
    }

    public void pressBrawl() {
        this.character.useSkill(SkillType.BRAWLSKILL);
        System.out.println("Brawl pressed");
    }

    public void pressOneHanded() {
        this.character.useSkill(SkillType.ONEHANDEDWEAPONSKILL);
        System.out.println("OneHanded pressed");
    }

    public void pressTwoHanded() {
        this.character.useSkill(SkillType.TWOHANDEDWEAPONSKILL);
        System.out.println("TwoHanded pressed");
    }

    public void pressBane() {
        this.character.useSkill(SkillType.BANESKILL);
        System.out.println("Bane pressed");
    }

    public void pressBoon() {
        this.character.useSkill(SkillType.BOONSKILL);
        System.out.println("Boon pressed");
    }

    public void pressEnchantment() {
        this.character.useSkill(SkillType.ENCHANTMENTSKILL);
        System.out.println("Enchantment pressed");
    }

    public void pressStaff() {
        this.character.useSkill(SkillType.STAFFSKILL);
        System.out.println("Staff pressed");
    }

    public void pressPickPocket() {
        System.out.println("PickPocket pressed");
        character.useSkill(SkillType.PICKPOCKETSKILL);
    }

    public void pressRemoveTrap() {
        this.character.useSkill(SkillType.REMOVETRAPSKILL);
        System.out.println("RemoveTrap pressed");
    }

    public void pressCreep() {
        this.character.useSkill(SkillType.CREEPSKILL);
        System.out.println("Creep pressed");
    }

    public void pressRangedWeapon() {
        this.character.useSkill(SkillType.RANGEDWEAPONSKILL);
        System.out.println("RangedWeapon pressed");
    }

    public CharacterEntity pressTalk() {
        System.out.println("Talk pressed");
        CharacterEntity pickPocketTarget = this.character.getInteractionPartner();
        if (pickPocketTarget != null) {
            return pickPocketTarget;
        } else {
            return null;
        }
    }

}
