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
        this.character.setOrientation(Orientation.UP);
        this.character.move();
    }

    public void pressUpRight() {
        this.character.setOrientation(Orientation.UPRIGHT);
        this.character.move();
    }

    public void pressUpLeft() {
        this.character.setOrientation(Orientation.UPLEFT);
        this.character.move();
    }

    public void pressDown() {
        this.character.setOrientation(Orientation.DOWN);
        this.character.move();
    }

    public void pressDownRight() {
        this.character.setOrientation(Orientation.DOWNRIGHT);
        this.character.move();
    }

    public void pressDownLeft() {
        this.character.setOrientation(Orientation.DOWNLEFT);
        this.character.move();
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
