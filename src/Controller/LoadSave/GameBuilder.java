package Controller.LoadSave;

import Model.AreaEffects.HealDamage;
import Model.AreaEffects.InstantDeath;
import Model.AreaEffects.LevelUp;
import Model.AreaEffects.TakeDamage;
import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Effects.LevelUpEffect;
import Model.Entity.Character.*;
import Model.Entity.Pet;
import Model.Enums.Orientation;
import Model.Items.ObstacleItem;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Zone.Decal;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.MainMenuView;
import View.Status.StatusView;
import View.Viewport;
import org.json.JSONArray;

import javax.swing.text.ZoneView;
import java.awt.*;

public class GameBuilder {

    private World world;
    private Viewport viewPort;
    private ZoneView mapView;
    private MainMenuView mainMenuView;
    private StatusView statusView;
    private Player player;


    public GameBuilder(){
//        mainMenuView = new MainMenuView();
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
        world = new World(currentMap);
    }

    public void initZone(int id, int xSize, int ySize) {
        Zone zone = new Zone(id, xSize, ySize);
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
            case "teleport":
                //TODO:
                //zone.add(point,EffectFactory.produceTeleportEffect())
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
        }
    }

    private void setCharAttributes(CharacterEntity charEnt, String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, String orientation, String pet, JSONArray inventory) {
        charEnt.setName(name);
        charEnt.setLevel(level);
        charEnt.setMaxHealth(maxHealth);
        charEnt.setCurrentHealth(currentHealth);
        charEnt.setMaxMana(maxMana);
        charEnt.setCurrentMana(currentMana);
        charEnt.setAttack(attack);
        charEnt.setDefense(defense);
        charEnt.setSpeed(speed);

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
        }

        System.out.println("Character initialized: " + charEnt);
    }

    public void initFriendlyNPC(String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, String orientation, String pet, JSONArray inventory, Point point) {
        FriendlyNPC npc = new FriendlyNPC();
        world.getCurrentZone().addPlayer(point, npc);
        setCharAttributes(npc, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, orientation, pet, inventory);
    }

    public void initHostileNPC(String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, String orientation, String pet, JSONArray inventory, Point point) {
        FriendlyNPC npc = new FriendlyNPC();
        world.getCurrentZone().addPlayer(point, npc);
        setCharAttributes(npc, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, orientation, pet, inventory);
    }

    public void initShopKeep(String name, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, String orientation, String pet, JSONArray inventory, Point point) {
        ShopKeep sk = new ShopKeep();
        world.getCurrentZone().addPlayer(point, sk);
        setCharAttributes(sk, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, orientation, pet, inventory);
    }

    public void initPet(String name) {

    }

    public void initMount(String name) {

    }

    public void initPlayer(String name, String charClass, int level, int maxHealth, int currentHealth, int maxMana, int currentMana, int attack, int defense, int speed, String orientation, String pet, JSONArray inventory, Point point) {
        switch (charClass) {
            case "smasher":
                player = PlayerFactory.produceSmasher();
            case "summoner":
                player = PlayerFactory.produceSummoner();
            case "sneak":
                player = PlayerFactory.produceSneak();
        }
        world.setPlayer(player);
        world.getCurrentZone().addPlayer(point, player);

        setCharAttributes(player, name, level, maxHealth, currentHealth, maxMana, currentMana, attack, defense, speed, orientation, pet, inventory);
    }
}
