package Controller.LoadSave;

import Model.AreaEffects.*;
import Model.Effects.HealthModifierEffect;
import Model.Entity.Character.*;
import Model.Entity.Pet;
import Model.Enums.EffectShape;
import Model.Enums.Orientation;
import Model.Enums.SkillType;
import Model.Items.ItemFactory;
import Model.Items.ObstacleItem;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Requirements.RequirementFactory;
import Model.Zone.Decal;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.MainMenuView;
import View.Status.StatusView;
import View.Viewport;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.text.ZoneView;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class GameBuilder {

    private World world;
    private Viewport viewPort;
    private ZoneView mapView;
    private MainMenuView mainMenuView;
    private StatusView statusView;
    private Player player;
    private ItemFactory itemFactory = new ItemFactory();
    private RequirementFactory requirementFactory = new RequirementFactory();


    public GameBuilder(World world){
//        mainMenuView = new MainMenuView();
        this.world = world;
    }

    public void setViewPort(Viewport viewPort) {
        this.viewPort = viewPort;
    }

    public World getWorld() {
        return world;
    }

    public Player getPlayer() {
        return player;
    }

    public void setMapView(ZoneView mapView) {
        this.mapView = mapView;
    }

    public void setStatusView(StatusView statusView) {
        this.statusView = statusView;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void initWorld(Integer currentMap) {

        world.setCurrentZone(currentMap);
    }

    public void initZone(int id, int xSize, int ySize) {
        Zone zone = new Zone(id, xSize, ySize);
        System.out.println("Init zone with ID: " + id);
        world.addZone(zone);
    }

    public void initTile(String terrain, String areaEffect, String decal, String item, int x, int y, Integer mapID) {
        Zone zone = world.getZoneByID(mapID);
        Point point = new Point(x, y);

        switch (terrain) {
            case "grass":
                zone.add(point, Terrain.GRASS);
                break;
            case "mountain":
                zone.add(point, Terrain.MOUNTAIN);
                break;
            case "water":
                zone.add(point, Terrain.WATER);
                break;
            default:
                zone.add(point, Terrain.GRASS);
        }

        switch (areaEffect) {
            case "none":
                break;
            case "damage":
                zone.add(point, new TakeDamage());
                break;
            case "death":
                zone.add(point, new InstantDeath());
                break;
            case "heal":
                zone.add(point, new HealDamage());
                break;
            case "level":
                zone.add(point, new LevelUp());
                break;
            case "teleport0":
                zone.add(point, new TeleportEffect(0, player, world));
                break;
            case "teleport1":
                zone.add(point, new TeleportEffect(1, player, world));
                break;
            case "teleport2":
                zone.add(point, new TeleportEffect(2, player, world));
                break;
            case "teleport3":
                zone.add(point, new TeleportEffect(3, player, world));
                break;
            case "river-up":
                zone.add(point, new River(Orientation.UP));
                break;
            case "river-down":
                zone.add(point, new River(Orientation.DOWN));
                break;
            case "river-upleft":
                zone.add(point, new River(Orientation.UPLEFT));
                break;
            case "river-upright":
                zone.add(point, new River(Orientation.UPRIGHT));
                break;
            case "river-downleft":
                zone.add(point, new River(Orientation.DOWNLEFT));
                break;
            case "river-downright":
                zone.add(point, new River(Orientation.DOWNRIGHT));
                break;
            case "trap":
                zone.add(point, new Trap(new HealthModifierEffect(-50), 10));
                break;
        }

        switch (decal) {
            case "none":
                break;
            case "cross":
                zone.add(point, Decal.CROSS);
                break;
            case "skull":
                zone.add(point, Decal.SKULL);
                break;
        }

        switch (item) {
            case "obstacle":
                zone.add(point, new ObstacleItem("obstacle"));
                break;
            case "armor":
                zone.add(point, new Armor(10));
                break;
            case "ring":
                zone.add(point, new Ring(10));
                break;
            case "healthBoon":
                zone.add(point, itemFactory.produceHealthBoon(10, 5));
                break;
            case "defenseBoon":
                zone.add(point, itemFactory.produceDefenseBoon(10, 5));
                break;
            case "manaBoon":
                zone.add(point, itemFactory.produceManaBoon(10, 11));
                break;
            case "healthBane":
                zone.add(point, itemFactory.produceHealthBane(10, 5, EffectShape.LINEAR, 1));
                break;
            case "defenseBane":
                zone.add(point, itemFactory.produceDefenseBane(10, 5, EffectShape.LINEAR, 1));
                break;
            case "manaBane":
                zone.add(point, itemFactory.produceManaBane(10, 5, EffectShape.LINEAR, 1));
                break;
            case "bargainingEnchantment":
                zone.add(point, itemFactory.produceDecreaseBargainingEnchantment(10, 5, EffectShape.LINEAR, 1));
                break;
            case "bindWoundsEnchantment":
                zone.add(point, itemFactory.produceDecreaseBindWoundsEnchantment(10, 5, EffectShape.LINEAR, 1));
                break;
            case "observationEnchantment":
                zone.add(point, itemFactory.produceDecreaseObservationEnchantment(10, 5, EffectShape.LINEAR, 1));
                break;
            case "staff":
                zone.add(point, itemFactory.produceStaffItem(2));
                break;
            case "gauntlet":
                zone.add(point, itemFactory.produceGauntlet(6));
                break;
            case "brassKnuckles":
                zone.add(point, itemFactory.produceBrassKnuckles(5));
                break;
            case "boxingGloves":
                zone.add(point, itemFactory.produceBoxingGloves(4));
                break;
            case "dagger":
                zone.add(point, itemFactory.produceDagger(16));
                break;
            case "crowbar":
                zone.add(point, itemFactory.produceCrowbar(15));
                break;
            case "mace":
                zone.add(point, itemFactory.produceMace(14));
                break;
            case "greatSword":
                zone.add(point, itemFactory.produceGreatSword(26));
                break;
            case "battleAxe":
                zone.add(point, itemFactory.produceBattleAxe(25));
                break;
            case "club":
                zone.add(point, itemFactory.produceClub(5));
                break;
            case "sniperRifle":
                zone.add(point, itemFactory.produceSniperRifle(50, EffectShape.LINEAR, 10));
                break;
            case "shotgun":
                zone.add(point, itemFactory.produceShotun(15, EffectShape.RADIAL, 5));
                break;
            case "blowDart":
                zone.add(point, itemFactory.produceBlowDart(10, EffectShape.LINEAR, 5));
                break;
            case "moneyBag":
                zone.add(point, itemFactory.produceMoneyBag(1000));
                break;
            case "specialArmor":
                zone.add(point, itemFactory.produceInteractiveArmor(50, requirementFactory.produceLevelRequirement(2)));
                break;
        }
    }

    private void setCharAttributes(CharacterEntity charEnt, String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, int money, String orientation, String pet, JSONArray inventory, JSONArray skills) {
        charEnt.setName(name);
        charEnt.setLevel(level);
        charEnt.setMaxHealth(maxHealth);
        charEnt.setCurrentHealth(currentHealth);
        charEnt.setMaxMana(maxMana);
        charEnt.setCurrentMana(currentMana);
        charEnt.setAttack(attack);
        charEnt.setDefense(defense);
        charEnt.setSpeed(speed);
        charEnt.setMoney(money);
        setSkills(charEnt, skills);

        switch (orientation) {
            case "up":
                charEnt.setOrientation(Orientation.UP);
                break;
            case "down":
                charEnt.setOrientation(Orientation.DOWN);
                break;
            case "upleft":
                charEnt.setOrientation(Orientation.UPLEFT);
                break;
            case "upright":
                charEnt.setOrientation(Orientation.UPRIGHT);
                break;
            case "downleft":
                charEnt.setOrientation(Orientation.DOWNLEFT);
                break;
            case "downright":
                charEnt.setOrientation(Orientation.DOWNRIGHT);
                break;
        }

        switch (pet) {
            case "none":
                break;
            case "cat":
                charEnt.setPet(new Pet());
                break;
            default:
                break;
        }
    }

    private void setSkills(CharacterEntity charEnt, JSONArray skills) {
        Iterator<Object> iterator = skills.iterator();
        while(iterator.hasNext()){
            JSONObject skill = (JSONObject) iterator.next();
            for(String skillName : skill.keySet()){
                switch (skillName) {
                    case "bindWounds":
                        charEnt.setSkillLevel(SkillType.BINDWOUNDSSKILL, skill.getInt(skillName));
                        break;
                    case "bargain":
                        charEnt.setSkillLevel(SkillType.BARGAINSKILL, skill.getInt(skillName));
                        break;
                    case "observation":
                        charEnt.setSkillLevel(SkillType.OBSERVATIONSKILL, skill.getInt(skillName));
                        break;
                    case "brawl":
                        charEnt.setSkillLevel(SkillType.BRAWLSKILL, skill.getInt(skillName));
                        break;
                    case "oneHanded":
                        charEnt.setSkillLevel(SkillType.ONEHANDEDWEAPONSKILL, skill.getInt(skillName));
                        break;
                    case "twoHanded":
                        charEnt.setSkillLevel(SkillType.TWOHANDEDWEAPONSKILL, skill.getInt(skillName));
                        break;
                    case "bane":
                        charEnt.setSkillLevel(SkillType.BANESKILL, skill.getInt(skillName));
                        break;
                    case "boon":
                        charEnt.setSkillLevel(SkillType.BOONSKILL, skill.getInt(skillName));
                        break;
                    case "enchantment":
                        charEnt.setSkillLevel(SkillType.ENCHANTMENTSKILL, skill.getInt(skillName));
                        break;
                    case "staff":
                        charEnt.setSkillLevel(SkillType.STAFFSKILL, skill.getInt(skillName));
                        break;
                    case "pickPocket":
                        charEnt.setSkillLevel(SkillType.PICKPOCKETSKILL, skill.getInt(skillName));
                        break;
                    case "removeTrap":
                        charEnt.setSkillLevel(SkillType.REMOVETRAPSKILL, skill.getInt(skillName));
                        break;
                    case "creep":
                        charEnt.setSkillLevel(SkillType.CREEPSKILL, skill.getInt(skillName));
                        break;
                    case "ranged":
                        charEnt.setSkillLevel(SkillType.RANGEDWEAPONSKILL, skill.getInt(skillName));
                        break;
                }
            }
        }
    }

    public void initFriendlyNPC(String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, int money, String orientation, String pet, JSONArray inventory, JSONArray skills, Point point) {
        CharacterEntity npc = new FriendlyNPC();
        world.getCurrentZone().addPlayer(point, npc);
        setCharAttributes(npc, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, money, orientation, pet, inventory, skills);
    }

    public void initHostileNPC(String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, int money, String orientation, String pet, JSONArray inventory, JSONArray skills, Point point) {
        CharacterEntity npc = new HostileNPC();
        System.out.println("NPC Current zone is " + world.getCurrentZone());
        world.getCurrentZone().addPlayer(point, npc);
        world.addHostileNPC(npc);
        setCharAttributes(npc, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, money, orientation, pet, inventory, skills);
    }

    public void initShopKeep(String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, int money, String orientation, String pet, JSONArray inventory, JSONArray skills, Point point) {
        ShopKeep sk = new ShopKeep();
        world.getCurrentZone().addPlayer(point, sk);
        setCharAttributes(sk, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, money, orientation, pet, inventory, skills);
    }

    public void initPet(String name) {

    }

    public void initMount(String name) {

    }

    public void initPlayer(String name, String charClass, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, int money, String orientation, String pet, JSONArray inventory, JSONArray skills, Point point) {
        System.out.println("Current zone is " + world.getCurrentZone());
        switch (charClass) {
            case "smasher":
                player = PlayerFactory.produceSmasher();
                player.setPlayerClass(charClass);
                player.setSkillClass(charClass);
                break;
            case "summoner":
                player = PlayerFactory.produceSummoner();
                player.setPlayerClass(charClass);
                player.setSkillClass(charClass);
                break;
            case "sneak":
                player = PlayerFactory.produceSneak();
                player.setPlayerClass(charClass);
                player.setSkillClass(charClass);
                break;
        }
        world.setPlayer(player);
        world.getCurrentZone().addPlayer(point, player);

        setCharAttributes(player, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, money, orientation, pet, inventory, skills);
    }
}
