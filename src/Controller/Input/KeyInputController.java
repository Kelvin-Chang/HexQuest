package Controller.Input;

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
                        playerController.pressBrawl();
                        break;
                    case ONEHANDEDWEAPONSKILL:
                        playerController.pressOneHanded();
                        break;
                    case TWOHANDEDWEAPONSKILL:
                        playerController.pressTwoHanded();
                        break;
                    case BANESKILL:
                        playerController.pressBane();
                        break;
                    case BOONSKILL:
                        playerController.pressBoon();
                        break;
                    case ENCHANTMENTSKILL:
                        playerController.pressEnchantment();
                        break;
                    case STAFFSKILL:
                        playerController.pressStaff();
                        break;
                    case CREEPSKILL:
                        playerController.pressCreep();
                        break;
                    case PICKPOCKETSKILL:
                        playerController.pressPickPocket();
                        break;
                    case REMOVETRAPSKILL:
                        playerController.pressRemoveTrap();
                        break;
                    case RANGEDWEAPONSKILL:
                        playerController.pressRangedWeapon();
                        break;
                    case BARGAINSKILL:
                        playerController.pressBargain();
                        break;
                    case BINDWOUNDSSKILL:
                        playerController.pressBindWounds();
                        break;
                    case OBSERVATIONSKILL:
                        playerController.pressObservation();
                        break;
                }
            }
        }
    }
}
