package Model.AreaEffects;

import Controller.GameMediator;
import Model.AreaEffects.AreaEffect;
import Model.Entity.Character.CharacterEntity;
import Model.Zone.World;

public class TeleportEffect extends AreaEffect {
    private Integer destWorld;
    CharacterEntity character;
    World gameWorld;

    public TeleportEffect(int dest, CharacterEntity character, World gameWorld){
        this.destWorld = dest;
        this.character = character;
        this.gameWorld = gameWorld;
    }
    @Override
    public void trigger(CharacterEntity character){
        System.out.println("Triggering teleport to zone: " + destWorld);
        System.out.println("Destination world: " + gameWorld.getZoneByID(1));
        character.setZoneId(destWorld);
        gameWorld.setCurrentZone(destWorld);
        gameWorld.getZoneByID(destWorld).addPlayer(gameWorld.getZoneByID(destWorld).getSpawnPoint(), character);

    }

    @Override
    public String toString() {
        return "Teleport";
    }

}
