package Controller.Input;

import Controller.GameMediator;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.SkillType;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyInputController {

    private HashMap<KeyCode, SkillType> commandMap;
    private ArrayList<SkillType> availableActions;
    private PlayerController playerController;
    private GameMediator gameMediator;

    public KeyInputController(String pathToControllerConfig, ArrayList<SkillType> availableActions, PlayerController playerController, GameMediator gameMediator) {
        this.availableActions = availableActions;
        this.playerController = playerController;
        this.gameMediator = gameMediator;

        // testing stuff
        commandMap = new HashMap<>();
        commandMap.put(KeyCode.Q, SkillType.MOVEUPLEFT);
        commandMap.put(KeyCode.W, SkillType.MOVEUP);
        commandMap.put(KeyCode.E, SkillType.MOVEUPRIGHT);
        commandMap.put(KeyCode.A, SkillType.MOVEDOWNLEFT);
        commandMap.put(KeyCode.S, SkillType.MOVEDOWN);
        commandMap.put(KeyCode.D, SkillType.MOVEDOWNRIGHT);

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
                        CharacterEntity pickPocketTarget = playerController.pressPickPocket();
                        if (pickPocketTarget != null) {
                            gameMediator.pickPocketToTakePlace(pickPocketTarget);
                        }
                        break;
                    case REMOVETRAPSKILL:
                        playerController.pressRemoveTrap();
                        break;
                    case RANGEDWEAPONSKILL:
                        playerController.pressRangedWeapon();
                        break;
                    case BARGAINSKILL:
                        CharacterEntity bargainPartner = playerController.pressBargain();
                        if (bargainPartner != null) {
                            gameMediator.bargainingToTakePlace(bargainPartner);
                        }
                        break;
                    case BINDWOUNDSSKILL:
                        playerController.pressBindWounds();
                        break;
                    case OBSERVATIONSKILL:
                        playerController.pressObservation();
                        break;
                    case TALK:
                        CharacterEntity talkingPartner = playerController.pressBargain();
                        if (talkingPartner != null) {
                            gameMediator.talkingTakingPlace(talkingPartner);
                        }
                        break;
                }
            }
        }
    }
}
