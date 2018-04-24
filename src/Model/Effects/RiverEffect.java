package Model.Effects;

import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;

public class RiverEffect implements Effect {

    private Orientation orientation;

    public RiverEffect(Orientation orientation) {
        this.orientation= orientation;
    }

    public void trigger(CharacterEntity characterEntity) {
        switch (orientation) {
            case UP:
                characterEntity.addUpToMovementQueue();
                break;
            case DOWN:
                characterEntity.addDownToMovementQueue();
                break;
            case UPLEFT:
                characterEntity.addUpLeftToMovementQueue();
                break;
            case UPRIGHT:
                characterEntity.addUpRightToMovementQueue();
                break;
            case DOWNLEFT:
                characterEntity.addDownLeftToMovementQueue();
                break;
            case DOWNRIGHT:
                characterEntity.addDownRightToMovementQueue();
                break;
            default:
                break;
        }
    }
}
