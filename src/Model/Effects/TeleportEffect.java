package Model.Effects;

import Model.Entity.Character.CharacterEntity;
import Model.Zone.World;

public class TeleportEffect implements Effect {
    private int destWorld;
    CharacterEntity character;
    World gameWorld;

    TeleportEffect(int dest, CharacterEntity character, World gameWorld){
        this.destWorld = dest;
        this.character = character;
        this.gameWorld = gameWorld;
    }
    @Override
    public void trigger(CharacterEntity character){
        character.setZoneId(destWorld);
        gameWorld.setCurrentZone(destWorld);
        gameWorld.getZoneByID(destWorld).addPlayer(gameWorld.getZoneByID(destWorld).getSpawnPoint(), character);
    }

}
