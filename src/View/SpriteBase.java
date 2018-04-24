package View;

import java.io.File;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.HashMap;

public class SpriteBase {
    private ArrayList<Image> tileSprites;
    private ArrayList<Image> characterSprites;
    private ArrayList<Image> effectSprites;
    private ArrayList<Image> obstacleSprites;
    private ArrayList<Image> miscSprites;
    private HashMap<String, Image> itemSprites;

    private final String filePath = System.getProperty("user.dir");

    public SpriteBase() {
        tileSprites = new ArrayList<Image>();
        characterSprites = new ArrayList<Image>();
        effectSprites = new ArrayList<Image>();
        obstacleSprites = new ArrayList<Image>();
        miscSprites = new ArrayList<Image>();
        itemSprites = new HashMap<>();

        startUp();
    }

    private void startUp() {
        characterSprites.add(getImage(filePath + "/src/assets/character.png"));
        characterSprites.add(getImage(filePath + "/src/assets/character1.png"));
        characterSprites.add(getImage(filePath + "/src/assets/character3.png"));
        characterSprites.add(getImage(filePath + "/src/assets/character4.png"));

        tileSprites.add(getImage(filePath + "/src/assets/grass.png"));
        tileSprites.add(getImage(filePath + "/src/assets/mountain.png"));
        tileSprites.add(getImage(filePath + "/src/assets/water.png"));

        effectSprites.add(getImage(filePath + "/src/assets/AEdecals/heal.png"));
        effectSprites.add(getImage(filePath + "/src/assets/AEdecals/damage.png"));
        effectSprites.add(getImage(filePath + "/src/assets/AEdecals/death.png"));
        effectSprites.add(getImage(filePath + "/src/assets/AEdecals/levelUp.png"));
        effectSprites.add(getImage(filePath + "/src/assets/amulet.png"));
        effectSprites.add(getImage(filePath + "/src/assets/river.png"));
        effectSprites.add(getImage(filePath + "/src/assets/river1.png"));
        effectSprites.add(getImage(filePath + "/src/assets/river2.png"));
        effectSprites.add(getImage(filePath + "/src/assets/river3.png"));
        effectSprites.add(getImage(filePath + "/src/assets/river4.png"));
        effectSprites.add(getImage(filePath + "/src/assets/river5.png"));


        obstacleSprites.add(getImage(filePath + "/src/assets/obstacle.png"));

        miscSprites.add(getImage(filePath + "/src/assets/arrow.png"));

        itemSprites.put("Health Bane", getImage(filePath + "/src/assets/Items/healthBane.png"));
        itemSprites.put("Defense Bane", getImage(filePath + "/src/assets/Items/defenseBane.png"));
        itemSprites.put("Mana Bane", getImage(filePath + "/src/assets/Items/manaBane.png"));
        itemSprites.put("Health Boon", getImage(filePath + "/src/assets/Items/healthBoon.png"));
        itemSprites.put("Defense Boon", getImage(filePath + "/src/assets/Items/defenseBoon.png"));
        itemSprites.put("Mana Boon", getImage(filePath + "/src/assets/Items/manaBoon.png"));
        itemSprites.put("Bargaining Enchantment", getImage(filePath + "/src/assets/Items/bargainingEnchantment.png"));
        itemSprites.put("Bind Wounds Enchantment", getImage(filePath + "/src/assets/Items/bindWoundsEnchantment.png"));
        itemSprites.put("Observation Enchantment", getImage(filePath + "/src/assets/Items/observationEnchantment.png"));
        itemSprites.put("Staff", getImage(filePath + "/src/assets/Items/staff.png"));
        itemSprites.put("Gauntlet", getImage(filePath + "/src/assets/Items/gauntlet.png"));
        itemSprites.put("Brass Knuckles", getImage(filePath + "/src/assets/Items/brassKnuckles.png"));
        itemSprites.put("Boxing Gloves", getImage(filePath + "/src/assets/Items/boxingGloves.png"));
        itemSprites.put("Dagger", getImage(filePath + "/src/assets/Items/dagger.png"));
        itemSprites.put("Crowbar", getImage(filePath + "/src/assets/Items/crowbar.png"));
        itemSprites.put("Mace", getImage(filePath + "/src/assets/Items/mace.png"));
        itemSprites.put("Great Sword", getImage(filePath + "/src/assets/Items/greatSword.png"));
        itemSprites.put("Battle Axe", getImage(filePath + "/src/assets/Items/battleAxe.png"));
        itemSprites.put("Club", getImage(filePath + "/src/assets/Items/club.png"));
        itemSprites.put("Sniper Rifle", getImage(filePath + "/src/assets/Items/sniperRifle.png"));
        itemSprites.put("Shotgun", getImage(filePath + "/src/assets/Items/shotgun.png"));
        itemSprites.put("Blow Dart", getImage(filePath + "/src/assets/Items/blowDart.png"));
        itemSprites.put("Armor", getImage(filePath + "/src/assets/Items/armor.png"));
        itemSprites.put("Special Armor", getImage(filePath + "/src/assets/Items/specialArmor.png"));
        itemSprites.put("Money Bag", getImage(filePath + "/src/assets/items/moneyBag.png"));
    }

    public Image getTileSprite(int ID) {
        return tileSprites.get(ID);
    }

    public Image getCharacterSprite(int ID) {
        return characterSprites.get(ID);
    }

    public Image getEffectSprite(int ID) {return effectSprites.get(ID);}

    public Image getObstacleSprite(int ID) { return obstacleSprites.get(ID); }

    public Image getItemSprite(String name) { return itemSprites.get(name); }

    public Image getMiscSprite(int ID) { return miscSprites.get(ID); }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }
}
