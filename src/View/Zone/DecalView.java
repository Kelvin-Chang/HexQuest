package View.Zone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DecalView {
    BufferedImage DecalImage;
    String DecalName;
    public void terrian(String DecalName){
        this.DecalName = DecalName;
    }
    public void extract(String str){
        try {
            File water = new File(str);
            this.DecalImage = ImageIO.read(water);
        }catch(IOException e){

        }
    }
    public void classify(String terrainMap){

        String ter = terrainMap;
        switch (ter) {
            case "sword":
                extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/sword.png");
                break;
            case "potion":
                extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/potion.png");
                break;
        }
    }

    public BufferedImage getDecalImage() {
        return DecalImage;
    }
}
