package Model.Entity.Character;

import Model.Enums.Orientation;

import java.awt.*;
import java.util.ArrayList;

public class HostileNPCController {

    private ArrayList<CharacterEntity> npcs;
    private ArrayList<Orientation> nextMoves;
    private ArrayList<ArrayList<Point>> trails;

    public HostileNPCController (){
        this.npcs = new ArrayList<>();
        this.nextMoves = new ArrayList<>();
        trails = new ArrayList<>();
    }

    public void doOrientations(){
        for( int i = 0; i < npcs.size(); ++i){
            for(Orientation o : nextMoves) {
                switch (Orientation.correspondingNumber(o)) {
                    case 0:
                        npcs.get(i).addUpLeftToMovementQueue();
                        break;
                    case 1:
                        npcs.get(i).addUpToMovementQueue();
                        break;
                    case 2:
                        npcs.get(i).addUpRightToMovementQueue();
                        break;
                    case 3:
                        npcs.get(i).addDownLeftToMovementQueue();
                        break;
                    case 4:
                        npcs.get(i).addDownToMovementQueue();
                        break;
                    case 5:
                        npcs.get(i).addDownRightToMovementQueue();
                        break;

                }
            }
        }
    }

    public void addHostileNpc(CharacterEntity npc){
        npcs.add(npc);
    }


    public void addMove(CharacterEntity character, Orientation nextMove){
        int i = getNPCposition(character);
        if(i != -1 ) {
            if (nextMoves.size() == 0) {
                nextMoves.add(0 ,nextMove);
            }
        }
    }
    public void addMove(int i, Orientation nextMove){
        nextMoves.add(i,nextMove);
    }

    public void clearMoves(){
        nextMoves.clear();
    }

    public ArrayList<CharacterEntity> getNpcs() {
        return this.npcs;
    }

    public ArrayList<Orientation> getNextMoves() {
        return nextMoves;
    }

    public int getNPCposition(CharacterEntity characterEntity){
        for (int i = 0; i < npcs.size(); ++i){
            if (characterEntity == npcs.get(i))
                return i;
        }
        return -1;
    }
}
