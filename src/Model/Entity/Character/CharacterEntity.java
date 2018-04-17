package Model.Entity.Character;

import Model.Entity.Pet;
import Model.Entity.Skills.Skill;
import Model.Enums.Orientation;
import Model.Items.Item;
import Model.Map.World;

import java.util.ArrayList;

public class CharacterEntity {

    private int level;
    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;
    private int attack;
    private int defense;
    private int speed;
    private Inventory inventory;
    private Orientation orientation;
    private ArrayList<Skill> skills;
    private ArrayList<Item> useableItems;
    private World world;

    public CharacterEntity() {
        this.level = 0;
        this.maxHealth = 100;
        this.currentHealth = 100;
        this.maxMana = 100;
        this.currentMana = 100;
        this.attack = 1;
        this.defense = 1;
        this.speed = 1;
        this.inventory = new Inventory();
        this.orientation = Orientation.UP;
        this.skills = new ArrayList<Skill>();
        this.useableItems = new ArrayList<Item>();
        this.world = new World();
    }
    public CharacterEntity(World world){
        this();
        this.world = world;
    }

    public CharacterEntity(ArrayList<Skill> skillList) {
        this.skills = skillList;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }
    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }
    public void setCurrentMana(int currentMana) {
        this.currentMana = currentMana;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
    public void setUseableItems(ArrayList<Item> useableItems) {
        this.useableItems = useableItems;
    }

    public int getLevel() {
        return level;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public int getCurrentMana() {
        return currentMana;
    }
    public int getAttack() {
        return attack;
    }
    public int getDefense() {
        return defense;
    }
    public int getSpeed() {
        return speed;
    }
    public Inventory getInventory() {
        return inventory;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    public ArrayList<Skill> getSkills() {
        return skills;
    }
    public ArrayList<Item> getUseableItems() {
        return useableItems;
    }


    public void modifyHealth(int healthChange) {
        if (currentHealth + healthChange <= 0) {
            currentHealth = 0;
        } else if (currentHealth + healthChange >= maxHealth) {
            currentHealth = maxHealth;
        } else {
            currentHealth = currentHealth + healthChange;
        }
    }

    public void modifyMana(int manaChange) {
        if (currentMana + manaChange <= 0) {
            currentMana = 0;
        } else if (currentMana + manaChange >= maxMana) {
            currentMana = maxMana;
        } else {
            currentMana = currentMana + manaChange;
        }
    }
    public void move(){
        world.attemptMove(this);
    }

    public void levelUp() {
        level = level + 1;
    }

    public void modifySpeed(int speedChange) {
        if (speed + speedChange <= 0) {
            speed = 0;
        } else {
            speed = speed + speedChange;
        }
    }

    // refer to PlayerFactory to determine the order that the skills are in in the ArrayList
    public void useSkill(int skillIndex) {
        if ( !(skillIndex >= skills.size()) && !(skillIndex < 0) ) {
            skills.get(skillIndex).effect();
        }
    }

}
