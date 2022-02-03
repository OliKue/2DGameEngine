package gameengine.world.levels;

import gameengine.entities.EntityManager;
import gameengine.entities.staticEntities.Portal;
import gameengine.tile.Tile;
import gameengine.world.WorldManager;

public class BaseWorld extends World {

    // PATHs
    private static final String WORLD_FILE_PATH = "/worlds/baseWorld.txt";
    private static final String BACKGROUND_PATH = "/PNG/Backgrounds/Cartoon_Forest_BG_01/Cartoon_Forest_BG_01.png";

    // Spawn
    public static final int xSpawn = 400;
    public static final int ySpawn = 1400;

    public BaseWorld() {
        super(WORLD_FILE_PATH, BACKGROUND_PATH);

        // Add Portals
        Portal portalToForest = new Portal(getWidth()* Tile.TILEWIDTH - 128 , getHeight()*Tile.TILEHEIGTH - 148,
                WorldManager.WorldKey.baseWorld, WorldManager.WorldKey.forestWorld,
                ForestWorld.xSpawn, ForestWorld.ySpawn);

        EntityManager.getInstance().addEntity(portalToForest);
    }

}
