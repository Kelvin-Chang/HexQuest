package View.Zone;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public class TerrainView {
//    ArrayList<ArrayList<String>> terrainMap;
    String terrainMap;
    BufferedImage terrainImage;


//    public void terrian(ArrayList<ArrayList<String>> terrainMap){
////        this.terrainMap = terrainMap;
////    }
public void terrian(String terrainMap){
        this.terrainMap = terrainMap;
}

    public void extract(String str){
        try {
            File water = new File(str);
            this.terrainImage = ImageIO.read(water);
        }catch(IOException e){

        }
    }

//    public void classify(ArrayList<ArrayList<String>> terrainMap){
//        for(int h = 0; h < terrainMap.size(); h++) {
//            for(int i = 0; i < terrainMap.get(h).size(); i++) {
//                String ter = terrainMap.get(h).get(i);
//                switch (ter) {
//                    case "grass":
//                        extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/grass.png");
//                        break;
//                    case "water":
//                        extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/water.png");
//                        break;
//                    case "mountain":
//                        extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/mountain.png");
//                        break;
//                }
//            }
//        }
//    }
public void classify(String terrainMap){

    String ter = terrainMap;
    switch (ter) {
        case "grass":
            extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/grass.png");
            break;
        case "water":
            extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/water.png");
            break;
        case "mountain":
            extract("/Users/lorenzo/Documents/GitHub/OOP-Iteration-3/src/assets/mountain.png");
            break;
    }
}





}
