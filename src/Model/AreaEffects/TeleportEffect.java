package Model.AreaEffects;

import Controller.GameMediator;
import Model.AreaEffects.AreaEffect;
import Model.Entity.Character.CharacterEntity;
import Model.Enums.Orientation;
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
    public Orientation getDir() {
        return null;
    }
    @Override
    public void trigger(CharacterEntity character){
            System.out.println("destworld: " + destWorld);
            System.out.println("gameWorld zoneid spawnpoint: " + gameWorld.getZoneByID(destWorld).getSpawnPoint());
            System.out.println("Character: " + character);
            gameWorld.setCurrentZone(destWorld);
            gameWorld.getZoneByID(destWorld).addPlayer(gameWorld.getZoneByID(destWorld).getSpawnPoint(), character);

    }

    @Override
    public String toString() {
        return "Teleport";
    }

}
