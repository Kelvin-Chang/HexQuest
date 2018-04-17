package Model.Entity.Character;

import Model.Entity.Pet;
import Model.Entity.Skills.Skill;
import Model.Enums.Orientation;
import Model.Items.Item;
import Model.Map.World;

import java.util.List;

public class CharacterEntity {

    private int level;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;
    private int attack;
    private int defense;
    private int speed;
    private Inventory inventory;
    private Orientation orientation;
    private List<Skill> skills;
    private List<Item> useableItems;
    private Pet pet;
    private World world;
    public CharacterEntity() {}

    public void setLevel(int level) {
        this.level = level;
    }
    public void setName(String name) {
        this.name = name;
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
    public void setPet(Pet pet) {
        this.pet = pet;
    }
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }
    public void setUseableItems(List<Item> useableItems) {
        this.useableItems = useableItems;
    }

    public int getLevel() {
        return level;
    }
    public String getName() {
        return name;
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
    public Pet getPet() {
        return pet;
    }
    public List<Skill> getSkills() {
        return skills;
    }
    public List<Item> getUseableItems() {
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
}
