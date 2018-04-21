package View;

import java.io.File;
import javafx.scene.image.Image;
import java.util.ArrayList;

public class SpriteBase {
    private ArrayList<Image> tileSprites;
    private ArrayList<Image> characterSprites;

    private final String filePath = System.getProperty("user.dir");

    public SpriteBase() {
        tileSprites = new ArrayList<Image>();
        characterSprites = new ArrayList<Image>();

        startUp();
    }

    private void startUp() {
        characterSprites.add(getImage(filePath + "/src/assets/character.png"));

        tileSprites.add(getImage(filePath + "/src/assets/grass.png"));
        tileSprites.add(getImage(filePath + "/src/assets/mountain.png"));
        tileSprites.add(getImage(filePath + "/src/assets/water.png"));

    }

    public Image getTileSprite(int ID) {
        return tileSprites.get(ID);
    }

    public Image getCharacterSprite(int ID) {
        return characterSprites.get(ID);
    }

    private Image getImage(String fp) {
        File file = new File(fp);
        Image image = new Image(file.toURI().toString());
        return image;
    }
}
