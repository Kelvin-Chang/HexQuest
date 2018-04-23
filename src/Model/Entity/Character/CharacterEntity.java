package Model.Entity.Character;

import Model.Effects.Effect;
import Model.Effects.NPCEffect;
import Model.Entity.Pet;
import Model.Entity.Skills.Skill;
import Model.Enums.EffectShape;
import Model.Enums.ItemSlot;
import Model.Enums.Orientation;
import Model.Enums.SkillType;
import Model.Items.Item;
import Model.Items.TakeableItems.TakeableItem;
import Model.Zone.HexFormulas;
import Model.Zone.Zone;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public abstract class CharacterEntity {

    private int level;
    private int exp;
    private String name;
    private String skillclass;
    private int maxHealth;
    private int currentHealth;
    private int maxMana;
    private int currentMana;
    private int attack;
    private int defense;
    private int speed;
    private Inventory inventory;
    private Orientation orientation;
    private Queue<Orientation> movementQueue;
    private HashMap<SkillType, Skill> skills;
    private ArrayList<Item> useableItems;
    private Pet pet;
    private Zone zone;
    private boolean aggroed;
    private boolean chasing;
    private int unusedSkillPoints;

    private int money;

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
        this.zone = new Zone(0, 4,4);
        this.movementQueue = new LinkedList<>();
        this.aggroed = false;
        this.chasing = false;
        this.unusedSkillPoints = 0;
    }

    public String getSkillClass(){
        return this.skillclass;
    }
    public void setSkillClass(String str){
        this.skillclass = str;
    }

    public CharacterEntity(Zone zone){
        this();
        this.zone = zone;
    }

    public CharacterEntity(HashMap<SkillType, Skill> skillList) {
        this();
        this.skills = skillList;
        this.movementQueue = new LinkedList<>();
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
    public void setMoney(int money) {
        this.money = money;
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
    public void setMovementQueue(LinkedList<Orientation> movementQueue) {
        this.movementQueue = movementQueue;
    }

    public int getExp() {return exp;}
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
    public int getMoney() {
        return money;
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
    public String getPetName(){return pet.getName();}
    public HashMap<SkillType, Skill> getSkills() {
        return skills;
    }
    public ArrayList<Item> getUseableItems() {
        return useableItems;
    }
    public Zone getZone() { return zone;    }

    public Point getLocation() {
        return zone.getCharacterLocation(this);
    }

    public Skill getSpecificSkill(SkillType skillType) {
        return skills.get(skillType);
    }

    public void setSkillLevel(SkillType skillType, int level) {
        CharacterEntity test = this;
        skills.get(skillType).setSkillLevel(level);
    }

    public ArrayList<SkillType> getPlayerActions() {
        ArrayList<SkillType> actions = new ArrayList<>(skills.keySet());
        actions.add(SkillType.MOVEUP);
        actions.add(SkillType.MOVEUPRIGHT);
        actions.add(SkillType.MOVEDOWNRIGHT);
        actions.add(SkillType.MOVEDOWN);
        actions.add(SkillType.MOVEDOWNLEFT);
        actions.add(SkillType.MOVEUPLEFT);
        actions.add(SkillType.TALK);

        actions.add(SkillType.TOGGLECAMERA);
        actions.add(SkillType.CAMERAUP);
        actions.add(SkillType.CAMERALEFT);
        actions.add(SkillType.CAMERADOWN);
        actions.add(SkillType.CAMERARIGHT);
        return actions;
    }
    
    public boolean isDead(){
        if(currentHealth == 0 )
            return true;
        return false;
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

    public void modifySkillLevel(int skillChange, SkillType skillType) {
        skills.get(skillType).updateSkillLevel(skillChange);
    }

    public void modifyMoney(int moneyChange) {
        if (money + moneyChange <= 0) {
            money = 0;
        } else {
            money = money + moneyChange;
        }
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

    public void useSkill(SkillType skillType) {
        if (skills.get(skillType) != null) {
            if (skills.get(skillType).skillSuccessful()) {
                skills.get(skillType).activateSkill(this);
            }
        }
    }

    public void addToInventory(TakeableItem item){
        this.inventory.addToInventory(item);
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

    public CharacterEntity getInteractionPartner() {
        HexFormulas hexFormulas = new HexFormulas();
        ArrayList<Point> bargainSpot =  hexFormulas.getEffectedCoordinates(getLocation(), 1, getZone().getTerrainMap(), orientation, EffectShape.LINEAR);

        ArrayList<CharacterEntity> bargainPartner = zone.getEntitiesOnArea(bargainSpot);
        if (!bargainPartner.isEmpty()) {
            return bargainPartner.remove(0);
        }
        return null;
    }

    public void effectEntities(ArrayList<Point> area, Effect effect) {
        for (Point point : area) {
            if (point.getX() != getLocation().getX() || point.getY() != getLocation().getY()) {
                zone.add(point, effect);
            }
        }
        ArrayList<CharacterEntity> entities = zone.getEntitiesOnArea(area);
        for (CharacterEntity entity: entities) {
            if (entity.getLocation() != getLocation()) {
                effect.trigger(entity);
                System.out.println(entity.getCurrentHealth());
            }
        }
    }

    public void effectAllEntities(NPCEffect effect, Point playerLocation) {
        for (CharacterEntity entity : zone.getAllCharacterEntitys()) {
            if (entity.getLocation() != playerLocation) {
                effect.trigger((NPC) entity);
            }
        }
    }

    public void addUpToMovementQueue() {
        movementQueue.clear();
        orientation = Orientation.UP;
        movementQueue.add(Orientation.UP);
    }

    public void addUpRightToMovementQueue() {
        movementQueue.clear();
        orientation = Orientation.UPRIGHT;
        movementQueue.add(Orientation.UPRIGHT);
    }

    public void addDownRightToMovementQueue() {
        movementQueue.clear();
        orientation = Orientation.DOWNRIGHT;
        movementQueue.add(Orientation.DOWNRIGHT);
    }

    public void addDownToMovementQueue() {
        movementQueue.clear();
        orientation = Orientation.DOWN;
        movementQueue.add(Orientation.DOWN);
    }

    public void addDownLeftToMovementQueue() {
        movementQueue.clear();
        orientation = Orientation.DOWNLEFT;
        movementQueue.add(Orientation.DOWNLEFT);
    }

    public void addUpLeftToMovementQueue() {
        movementQueue.clear();
        orientation = Orientation.UPLEFT;
        movementQueue.add(Orientation.UPLEFT);
    }

    public void clearMovementQueue(){ movementQueue.clear();}

    public boolean hasNextMove() {
        Queue<Orientation>  q = movementQueue;
        if (movementQueue.isEmpty()) {
            return false;
        }
        return true;
    }

    public Orientation getNextMove() {
        return movementQueue.poll();
    }

    public boolean isChasing() {
        return chasing;
    }

    public void setChasing(boolean chasing) {
        this.chasing = chasing;
    }

    public int getUnusedSkillPoints() {
        return unusedSkillPoints;
    }

    public void setUnusedSkillPoints(int unusedSkillPoints) {
        this.unusedSkillPoints = unusedSkillPoints;
    }

}
