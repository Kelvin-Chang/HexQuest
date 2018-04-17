package Controller.Input;

import Model.Entity.Character.Player;

public class PlayerController {
    private Player player;

    public PlayerController(Player player)
    {
        this.player = player;
    }

    public void pressUp() {
        this.player.setOrientation(Orientation.UP);
        this.player.move();
    }

    public void pressUpRight() {
        this.player.setOrientation(Orientation.UPRIGHT);
        this.player.move();
    }

    public void pressUpLeft() {
        this.player.setOrientation(Orientation.UPLEFT);
        this.player.move();
    }

    public void pressDown() {
        this.player.setOrientation(Orientation.DOWN);
        this.player.move();
    }

    public void pressDownRight() {
        this.player.setOrientation(Orientation.DOWNRIGHT);
        this.player.move();
    }

    public void pressDownLeft() {
        this.player.setOrientation(Orientation.DOWNLEFT);
        this.player.move();
    }
    /*
    public void setActiveSkill(int index)
    {
        List<Skill> skills = player.getSkills();
        if(index < skills.size())
            player.setActiveSkill(skills.get(index));
    }

    public void useActiveSkill() {
        player.useSkill(player.getActiveSkill());

    }

    public void useWeaponAttack() {
        player.useWeaponSkill();
    }
    */
}
