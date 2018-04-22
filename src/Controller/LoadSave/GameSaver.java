package Controller.LoadSave;

import Model.AreaEffects.HealDamage;
import Model.AreaEffects.InstantDeath;
import Model.AreaEffects.LevelUp;
import Model.AreaEffects.TakeDamage;
import Model.Effects.Effect;
import Model.Effects.EffectFactory;
import Model.Effects.LevelUpEffect;
import Model.Entity.Character.*;
import Model.Entity.Pet;
import Model.Enums.Orientation;
import Model.Items.ObstacleItem;
import Model.Items.TakeableItems.EquippableItems.Armor;
import Model.Items.TakeableItems.EquippableItems.Ring;
import Model.Zone.Decal;
import Model.Zone.Terrain;
import Model.Zone.World;
import Model.Zone.Zone;
import View.Menu.MainMenuView;
import View.Status.StatusView;
import View.Viewport;
import org.json.JSONArray;
import Controller.MapGenerator;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;

public class GameSaver {
    private Zone curZone;
    private String mapName;
    HashMap<Point, String> TerrainString;
    HashMap<Point, String> AreaEffectString;
    HashMap<Point, String> ItemString;
    HashMap<Point, String> Decalstring;


    public GameSaver(World world)
    {
        this.curZone = world.getCurrentZone();
        mapName = "map" + String.valueOf(curZone.getID()) + ".json";

        MapGenerator map = new MapGenerator(mapName, curZone.getRows(), curZone.getColumns(), curZone.getID(), TerrainToString(), EntityToString(), AreaEffectToString(), ItemsToString(), DecalsToString());


    }
    public HashMap<Point, String> TerrainToString()
    {
        for(int i = 0; i < curZone.getRows(); i++)
        {
            for(int j = 0; j < curZone.getColumns(); j++)
            {
                switch(curZone.getTerrainMap().get(new Point(i,j))){
                    case GRASS:
                        TerrainString.put(new Point(i,j) , "GRASS");
                        break;
                    case MOUNTAIN:
                        TerrainString.put(new Point(i,j) , "MOUNTAIN");
                        break;
                    case WATER:
                        TerrainString.put(new Point(i,j) , "WATER");
                        break;
                    case EMPTY:
                        TerrainString.put(new Point(i,j) , "EMPTY");
                        break;
                }

            }
        }
        return TerrainString;
    }
    public HashMap<Point, String> EntityToString()
    {
        for(int i = 0; i < curZone.getRows(); i++)
        {
            for(int j = 0; j < curZone.getColumns(); j++)
            {
                switch(curZone.getTerrainMap().get(new Point(i,j))){
                    case GRASS:
                        TerrainString.put(new Point(i,j) , "GRASS");
                        break;
                    case MOUNTAIN:
                        TerrainString.put(new Point(i,j) , "MOUNTAIN");
                        break;
                    case WATER:
                        TerrainString.put(new Point(i,j) , "WATER");
                        break;
                    case EMPTY:
                        TerrainString.put(new Point(i,j) , "EMPTY");
                        break;
                }

            }
        }
        return TerrainString;
    }

    public HashMap<Point, String> AreaEffectToString()
    {
        for(int i = 0; i < curZone.getRows(); i++)
        {
            for(int j = 0; j < curZone.getColumns(); j++)
            {
                AreaEffectString.put(new Point(i,j) , curZone.getAreaEffect(new Point(i,j)).toString());
            }
        }
        return AreaEffectString;
    }

    public HashMap<Point, String> ItemsToString()
    {
        for(int i = 0; i < curZone.getRows(); i++)
        {
            for(int j = 0; j < curZone.getColumns(); j++)
            {
                ItemString.put(new Point(i,j) , curZone.getItem(new Point(i,j)).getName());
            }
        }
        return ItemString;
    }

    public HashMap<Point, String> DecalsToString()
    {
        for(int i = 0; i < curZone.getRows(); i++)
        {
            for(int j = 0; j < curZone.getColumns(); j++)
            {
                Decalstring.put(new Point(i,j) , curZone.getDecal(new Point(i,j)).toString());
            }
        }
        return Decalstring;
    }
}
