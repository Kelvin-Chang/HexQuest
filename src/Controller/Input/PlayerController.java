package Controller.Input;

import Model.Entity.Character.CharacterEntity;
import Model.Entity.Character.Player;
import Model.Enums.Orientation;

public class PlayerController {
    private CharacterEntity character;

    public PlayerController(Player player)
    {
        this.character = player;
    }

    public void pressUp() {
        System.out.println("please work");
        this.character.addUpToMovementQueue();
    }

    public void pressUpRight() {
        this.character.addUpRightToMovementQueue();
    }

    public void pressUpLeft() {
        this.character.addUpLeftToMovementQueue();
    }

    public void pressDown() {
        this.character.addDownToMovementQueue();
    }

    public void pressDownRight() {
        this.character.addDownRightToMovementQueue();
    }

    public void pressDownLeft() {
        this.character.addDownLeftToMovementQueue();
    }
    /*
    public void setActiveSkill(int index)
    {
        List<Skill> skills = character.getSkills();
        if(index < skills.size())
            character.setActiveSkill(skills.get(index));
    }

    public void useActiveSkill() {
        character.useSkill(character.getActiveSkill());

    }

    public void useWeaponAttack() {
        character.useWeaponSkill();
    }
    */
}
