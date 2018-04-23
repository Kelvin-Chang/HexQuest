package Controller.Input;

import Controller.GameMediator;
import Controller.LoadSave.ControllerConfigLoader;
import Controller.Renderer;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.MovementCommand;
import Model.Enums.SkillType;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class KeyInputController {

    private HashMap<KeyCode, SkillType> commmonCommandMap;
    private HashMap<KeyCode, SkillType> summonerCommandMap;
    private HashMap<KeyCode, SkillType> smasherCommandMap;
    private HashMap<KeyCode, SkillType> sneakCommandMap;
    private ArrayList<SkillType> availableActions;
    private PlayerController playerController;
    private ControllerConfigLoader controllerConfigLoader = new ControllerConfigLoader();
    private GameMediator gameMediator;
    private Renderer renderer;

    public KeyInputController(String pathToControllerConfig, ArrayList<SkillType> availableActions, PlayerController playerController, GameMediator gameMediator, Renderer renderer) {
        this.availableActions = availableActions;
        this.playerController = playerController;
        this.gameMediator = gameMediator;
        this.renderer = renderer;
        commmonCommandMap = new HashMap<>();
        summonerCommandMap = new HashMap<>();
        smasherCommandMap = new HashMap<>();
        sneakCommandMap = new HashMap<>();

        try {
            controllerConfigLoader.loadConfig(commmonCommandMap, summonerCommandMap, smasherCommandMap, sneakCommandMap);
        } catch (IOException e) {
            commmonCommandMap.put(KeyCode.Q, SkillType.MOVEUPLEFT);
            commmonCommandMap.put(KeyCode.W, SkillType.MOVEUP);
            commmonCommandMap.put(KeyCode.E, SkillType.MOVEUPRIGHT);
            commmonCommandMap.put(KeyCode.A, SkillType.MOVEDOWNLEFT);
            commmonCommandMap.put(KeyCode.S, SkillType.MOVEDOWN);
            commmonCommandMap.put(KeyCode.D, SkillType.MOVEDOWNRIGHT);
            commmonCommandMap.put(KeyCode.DIGIT1, SkillType.BINDWOUNDSSKILL);
            commmonCommandMap.put(KeyCode.DIGIT2, SkillType.BARGAINSKILL);
            commmonCommandMap.put(KeyCode.DIGIT3, SkillType.OBSERVATIONSKILL);
            commmonCommandMap.put(KeyCode.Z, SkillType.TOGGLECAMERA);
            commmonCommandMap.put(KeyCode.I, SkillType.CAMERAUP);
            commmonCommandMap.put(KeyCode.L, SkillType.CAMERARIGHT);
            commmonCommandMap.put(KeyCode.K, SkillType.CAMERADOWN);
            commmonCommandMap.put(KeyCode.J, SkillType.CAMERALEFT);

            summonerCommandMap.put(KeyCode.DIGIT4, SkillType.ENCHANTMENTSKILL);
            summonerCommandMap.put(KeyCode.DIGIT5, SkillType.BOONSKILL);
            summonerCommandMap.put(KeyCode.DIGIT6, SkillType.BANESKILL);
            summonerCommandMap.put(KeyCode.DIGIT7, SkillType.STAFFSKILL);

            smasherCommandMap.put(KeyCode.DIGIT4, SkillType.BRAWLSKILL);
            smasherCommandMap.put(KeyCode.DIGIT5, SkillType.ONEHANDEDWEAPONSKILL);
            smasherCommandMap.put(KeyCode.DIGIT6, SkillType.TWOHANDEDWEAPONSKILL);

            sneakCommandMap.put(KeyCode.DIGIT4, SkillType.PICKPOCKETSKILL);
            sneakCommandMap.put(KeyCode.DIGIT5, SkillType.REMOVETRAPSKILL);
            sneakCommandMap.put(KeyCode.DIGIT6, SkillType.CREEPSKILL);
            sneakCommandMap.put(KeyCode.DIGIT7, SkillType.RANGEDWEAPONSKILL);
        }

    }

    public void issueCommand(KeyCode keyCode) {
        if (commmonCommandMap.get(keyCode) != null || summonerCommandMap.get(keyCode) != null || smasherCommandMap.get(keyCode) != null || sneakCommandMap.get(keyCode) != null) {
            HashMap<KeyCode, SkillType> mapToSwitchOn = new HashMap<>();
            if (availableActions.contains(commmonCommandMap.get(keyCode))) {
                mapToSwitchOn = commmonCommandMap;
            } else if (availableActions.contains(summonerCommandMap.get(keyCode))) {
                mapToSwitchOn = summonerCommandMap;
            } else if (availableActions.contains(smasherCommandMap.get(keyCode))) {
                mapToSwitchOn = smasherCommandMap;
            } else if (availableActions.contains(sneakCommandMap.get(keyCode))) {
                mapToSwitchOn = sneakCommandMap;
            } {
                switch (mapToSwitchOn.get(keyCode)) {
                    case MOVEUP:
                        playerController.pressUp();
//                        renderer.resetCamera();
                        break;
                    case MOVEUPRIGHT:
                        playerController.pressUpRight();
//                        renderer.resetCamera();
                        break;
                    case MOVEDOWNRIGHT:
                        playerController.pressDownRight();
//                        renderer.resetCamera();
                        break;
                    case MOVEDOWN:
                        playerController.pressDown();
//                        renderer.resetCamera();
                        break;
                    case MOVEDOWNLEFT:
                        playerController.pressDownLeft();
//                        renderer.resetCamera();
                        break;
                    case MOVEUPLEFT:
                        playerController.pressUpLeft();
//                        renderer.resetCamera();
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
                    case TOGGLECAMERA:
                        renderer.toggleCamera();
                        break;
                    case CAMERAUP:
                        renderer.moveUp();
                        break;
                    case CAMERALEFT:
                        renderer.moveLeft();
                        break;
                    case CAMERADOWN:
                        renderer.moveDown();
                        break;
                    case CAMERARIGHT:
                        renderer.moveRight();
                        break;
                }
            }
        }
    }
}
