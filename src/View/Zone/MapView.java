package View.Zone;

import java.awt.image.BufferedImage;

public class MapView {
    private TerrainView[][] terrainMap;
    private DecalView[][] DecalMap;
    private BufferedImage[][] bufferMap;
    private int col;
    private int rows;

    public MapView(DecalView[][] DecalMap, TerrainView[][] terrainMap){
        this.DecalMap = DecalMap;
        this.terrainMap = terrainMap;
    }
    public void display()
    {
        for(int i = 0; i < col; i++)
        {
            for(int j = 0; j < rows; j++)
            {
                if(DecalMap[i][j] != null)
                {
                    bufferMap[i][j] = DecalMap[i][j].getDecalImage();
                }
                else {
                    bufferMap[i][j] = terrainMap[i][j].getTerrainImage();
                }
            }
        }
    }
}
