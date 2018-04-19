//package Controller.LoadSave;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.Scanner;
//
//public class GameLoader {
//
//    private GameBuilder gb;
//
//    public GameLoader(GameBuilder gb) {
//        this.gb = gb;
//    }
//
//    public void loadGame(String savePath) {
//        File file = new File(savePath);
//
//        String saveData = null;
//
//        try {
//            saveData = new Scanner(file).useDelimiter("\\Z").next();
//        }
//        catch(FileNotFoundException e) {
//            System.out.println(e);
//        }
//
//        JSONObject jso = new JSONObject(saveData);
//
//        UnpackSave unpacksave = new UnpackSave(jso, gb);
//    }
//}
