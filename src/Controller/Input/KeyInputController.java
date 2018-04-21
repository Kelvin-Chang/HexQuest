package Controller.Input;

import Model.Entity.Character.Player;
import Model.Enums.SkillType;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyInputController {

    private HashMap<KeyCode, SkillType> commandMap;
    private ArrayList<SkillType> availableActions;
    private PlayerController playerController;

    public KeyInputController(String pathToControllerConfig, ArrayList<SkillType> availableActions, PlayerController playerController) {
        this.availableActions = availableActions;
        this.playerController = playerController;

        // testing stuff
        commandMap = new HashMap<>();
        commandMap.put(KeyCode.A, SkillType.MOVEUP);
    }

    public void issueCommand(KeyCode keyCode) {
        if (commandMap.get(keyCode) != null) {
            if (availableActions.contains(commandMap.get(keyCode))) {
                switch (commandMap.get(keyCode)) {
                    case MOVEUP:
                        playerController.pressUp();
                        break;
                    case MOVEUPRIGHT:
                        playerController.pressUpRight();
                        break;
                    case MOVEDOWNRIGHT:
                        playerController.pressDownRight();
                        break;
                    case MOVEDOWN:
                        playerController.pressDown();
                        break;
                    case MOVEDOWNLEFT:
                        playerController.pressDownLeft();
                        break;
                    case MOVEUPLEFT:
                        playerController.pressUpLeft();
                        break;
                    case BRAWLSKILL:
                        break;
                    case ONEHANDEDWEAPONSKILL:
                        break;
                    case TWOHANDEDWEAPONSKILL:
                        break;
                    case BANESKILL:
                        break;
                    case BOONSKILL:
                        break;
                    case ENCHANTMENTSKILL:
                        break;
                    case STAFFSKILL:
                        break;
                    case CREEPSKILL:
                        break;
                    case PICKPOCKETSKILL:
                        break;
                    case REMOVETRAPSKILL:
                        break;
                    case RANGEDWEAPONSKILL:
                        break;
                    case BARGAINSKILL:
                        break;
                    case BINDWOUNDSSKILL:
                        break;
                    case OBSERVATIONSKILL:
                        break;
                }
            }
        }
    }
}
