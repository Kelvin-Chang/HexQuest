package Controller.Input;

import Controller.GameMediator;
import Controller.Renderer;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.MovementCommand;
import Model.Enums.SkillType;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyInputController {

    private HashMap<KeyCode, SkillType> commandMap;
    private HashMap<KeyCode, MovementCommand> moveMap;
    private ArrayList<SkillType> availableActions;
    private PlayerController playerController;
    private GameMediator gameMediator;
    private Renderer renderer;

    public KeyInputController(String pathToControllerConfig, ArrayList<SkillType> availableActions, PlayerController playerController, GameMediator gameMediator, Renderer renderer) {
        this.availableActions = availableActions;
        this.playerController = playerController;
        this.gameMediator = gameMediator;
        this.renderer = renderer;

        // testing stuff
        commandMap = new HashMap<>();
        commandMap.put(KeyCode.Q, SkillType.MOVEUPLEFT);
        commandMap.put(KeyCode.W, SkillType.MOVEUP);
        commandMap.put(KeyCode.E, SkillType.MOVEUPRIGHT);
        commandMap.put(KeyCode.A, SkillType.MOVEDOWNLEFT);
        commandMap.put(KeyCode.S, SkillType.MOVEDOWN);
        commandMap.put(KeyCode.D, SkillType.MOVEDOWNRIGHT);
        commandMap.put(KeyCode.DIGIT1, SkillType.BINDWOUNDSSKILL);
        commandMap.put(KeyCode.DIGIT2, SkillType.BARGAINSKILL);
        commandMap.put(KeyCode.DIGIT3, SkillType.OBSERVATIONSKILL);

        commandMap.put(KeyCode.DIGIT4, SkillType.ENCHANTMENTSKILL);
        commandMap.put(KeyCode.DIGIT5, SkillType.BOONSKILL);
        commandMap.put(KeyCode.DIGIT6, SkillType.BANESKILL);
        commandMap.put(KeyCode.DIGIT7, SkillType.STAFFSKILL);
        commandMap.put(KeyCode.Z, SkillType.TOGGLECAMERA);
        commandMap.put(KeyCode.I, SkillType.CAMERAUP);
        commandMap.put(KeyCode.L, SkillType.CAMERARIGHT);
        commandMap.put(KeyCode.K, SkillType.CAMERADOWN);
        commandMap.put(KeyCode.J, SkillType.CAMERALEFT);

        moveMap = new HashMap<>();
//        moveMap.put(KeyCode.DEAD_TILDE, MovementCommand.TOGGLECAMERA);
//        moveMap.put(KeyCode.I, MovementCommand.CAMERAUP);
//        moveMap.put(KeyCode.L, MovementCommand.CAMERARIGHT);
//        moveMap.put(KeyCode.K, MovementCommand.CAMERADOWN);
//        moveMap.put(KeyCode.J, MovementCommand.CAMERALEFT);


    }

    public void issueCommand(KeyCode keyCode) {
//        if (moveMap.get(keyCode) != null) {
//            if (availableActions.contains(moveMap.get(keyCode))) {
//                switch (moveMap.get(keyCode)) {
//                    case TOGGLECAMERA:
//                        renderer.toggleCamera();
//                        break;
//                    case CAMERAUP:
//                        renderer.moveUp();
//                        break;
//                    case CAMERALEFT:
//                        renderer.moveLeft();
//                        break;
//                    case CAMERADOWN:
//                        renderer.moveDown();
//                        break;
//                    case CAMERARIGHT:
//                        renderer.moveRight();
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
        if (commandMap.get(keyCode) != null) {
            if (availableActions.contains(commandMap.get(keyCode))) {
                switch (commandMap.get(keyCode)) {
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
