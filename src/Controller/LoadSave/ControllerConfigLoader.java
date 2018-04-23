package Controller.LoadSave;

import Model.Enums.SkillType;
import javafx.scene.input.KeyCode;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import static javafx.scene.input.KeyCode.getKeyCode;

public class ControllerConfigLoader {

    Properties prop = new Properties();
    InputStream input = null;
    private final String filePath = System.getProperty("user.dir");

    public ControllerConfigLoader() {}

    public Properties getControllerConfig() throws IOException{
        try {
            input = new FileInputStream(filePath + "/resources/controllerConfig.properties");

            prop.load(input);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }

    public void loadConfig(HashMap<KeyCode, SkillType> commonCommands, HashMap<KeyCode, SkillType> summonerCommands, HashMap<KeyCode, SkillType> smasherCommands, HashMap<KeyCode, SkillType> sneakCommands) throws IOException {
        prop = getControllerConfig();

        commonCommands.put(getKeyCode(prop.getProperty("MOVEUPLEFT")), SkillType.MOVEUPLEFT);
        commonCommands.put(getKeyCode(prop.getProperty("MOVEUP")), SkillType.MOVEUP);
        commonCommands.put(getKeyCode(prop.getProperty("MOVEUPRIGHT")), SkillType.MOVEUPRIGHT);
        commonCommands.put(getKeyCode(prop.getProperty("MOVEDOWNLEFT")), SkillType.MOVEDOWNLEFT);
        commonCommands.put(getKeyCode(prop.getProperty("MOVEDOWN")), SkillType.MOVEDOWN);
        commonCommands.put(getKeyCode(prop.getProperty("MOVEDOWNRIGHT")), SkillType.MOVEDOWNRIGHT);
        commonCommands.put(getKeyCode(prop.getProperty("BINDWOUNDSSKILL")), SkillType.BINDWOUNDSSKILL);
        commonCommands.put(getKeyCode(prop.getProperty("BARGAINSKILL")), SkillType.BARGAINSKILL);
        commonCommands.put(getKeyCode(prop.getProperty("OBSERVATIONSKILL")), SkillType.OBSERVATIONSKILL);
        commonCommands.put(getKeyCode(prop.getProperty("TOGGLECAMERA")), SkillType.TOGGLECAMERA);
        commonCommands.put(getKeyCode(prop.getProperty("CAMERARIGHT")), SkillType.CAMERARIGHT);
        commonCommands.put(getKeyCode(prop.getProperty("CAMERAUP")), SkillType.CAMERAUP);
        commonCommands.put(getKeyCode(prop.getProperty("CAMERALEFT")), SkillType.CAMERALEFT);
        commonCommands.put(getKeyCode(prop.getProperty("CAMERADOWN")), SkillType.CAMERADOWN);

        summonerCommands.put(getKeyCode(prop.getProperty("ENCHANTMENTSKILL")), SkillType.ENCHANTMENTSKILL);
        summonerCommands.put(getKeyCode(prop.getProperty("BOONSKILL")), SkillType.BOONSKILL);
        summonerCommands.put(getKeyCode(prop.getProperty("BANESKILL")), SkillType.BANESKILL);
        summonerCommands.put(getKeyCode(prop.getProperty("STAFFSKILL")), SkillType.STAFFSKILL);

        smasherCommands.put(getKeyCode(prop.getProperty("BRAWLSKILL")), SkillType.BRAWLSKILL);
        smasherCommands.put(getKeyCode(prop.getProperty("ONEHANDEDWEAPONSKILL")), SkillType.ONEHANDEDWEAPONSKILL);
        smasherCommands.put(getKeyCode(prop.getProperty("TWOHANDEDWEAPONSKILL")), SkillType.TWOHANDEDWEAPONSKILL);

        sneakCommands.put(getKeyCode(prop.getProperty("PICKPOCKETSKILL")), SkillType.TWOHANDEDWEAPONSKILL);
        sneakCommands.put(getKeyCode(prop.getProperty("REMOVETRAPSKILL")), SkillType.TWOHANDEDWEAPONSKILL);
        sneakCommands.put(getKeyCode(prop.getProperty("CREEPSKILL")), SkillType.TWOHANDEDWEAPONSKILL);
        sneakCommands.put(getKeyCode(prop.getProperty("RANGEDWEAPONSKILL")), SkillType.TWOHANDEDWEAPONSKILL);

    }

}
