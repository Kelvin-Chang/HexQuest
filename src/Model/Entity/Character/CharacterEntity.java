package Model.Entity.Character;

import Model.Effects.Effect;
import Model.Entity.Pet;
import Model.Entity.Skills.Skill;
import Model.Enums.ItemSlot;
import Model.Enums.Orientation;
import Model.Enums.SkillType;
import Model.Items.Item;
import Model.Items.TakeableItems.TakeableItem;
import Model.Zone.World;
import Model.Zone.Zone;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class CharacterEntity {

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
    private HashMap<SkillType, Skill> skills;
    private ArrayList<Item> useableItems;
    private Pet pet;
    private Zone zone;

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
        this.skills = new HashMap<>();
        this.useableItems = new ArrayList<Item>();
        this.zone = new Zone();
    }
    public CharacterEntity(Zone zone){
        this();
        this.zone = zone;
    }

    public CharacterEntity(HashMap<SkillType, Skill> skillList) {
        this.skills = skillList;
    }

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
    public void setSkills(HashMap<SkillType, Skill> skills) {
        this.skills = skills;
    }
    public void setUseableItems(ArrayList<Item> useableItems) {
        this.useableItems = useableItems;
    }
    public void setZone(Zone zone) {
        this.zone = zone;
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
    public HashMap<SkillType, Skill> getSkills() {
        return skills;
    }
    public ArrayList<Item> getUseableItems() {
        return useableItems;
    }
    public Zone getZone() {
        return zone;
    }

    public Point getLocation() {
        return zone.getCharacterLocation(this);
    }

    public Skill getSpecificSkill(SkillType skillType) {
        return skills.get(skillType);
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

    public void modifyMaxMana(int manaChange) {
        if (maxMana + manaChange <= 0) {
            maxMana = 0;
        } else {
            maxMana = maxMana + manaChange;
        }
    }

    public boolean hasEnoughManaToCastSpell(int manaCost) {
        if (currentMana >= manaCost) {
            return true;
        }
        return false;
    }

    public void modifyAttack(int attackChange) {
        if (attack + attackChange <= 0) {
            attack = 0;
        } else {
            attack = attack + attackChange;
        }
    }

    public void modifyDefense(int defenseChange) {
        if (defense + defenseChange <= 0) {
            defense = 0;
        } else {
            defense = defense + defenseChange;
        }
    }

    public void move(){}

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
    public void useSkill(SkillType skillType) {
        if (skills.get(skillType) != null) {
            if (skills.get(skillType).skillSuccessful()) {
                skills.get(skillType).activateSkill(this);
            }
        }
    }

    public void useItemSlotRequiringSkill(ItemSlot slot, Skill skill) {
        inventory.useItemSlotRequiringSkill(slot, this, skill);
    }

    public void useItemSlotNotRequiringSkill(ItemSlot slot) {
        inventory.useItemSlotNotRequiringSkill(slot, this);
    }

    public void equipItem(TakeableItem item) {
        inventory.equipItem(item, this);
    }

    public void effectEntities(ArrayList<Point> area, Effect effect) {
        ArrayList<CharacterEntity> entities = zone.getEntitiesOnArea(area);
        for (CharacterEntity entity: entities) {
            effect.trigger(entity);
        }
    }

}
