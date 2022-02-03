package gameengine.world.levels;

import gameengine.entities.EntityManager;
import gameengine.entities.staticEntities.Portal;
import gameengine.tile.Tile;
import gameengine.world.WorldManager;

public class ForestWorld extends World {

    // PATHs
    private static final String WORLD_FILE_PATH = "/worlds/forestWorld.txt";
    private static final String BACKGROUND_PATH = "/PNG/Backgrounds/Cartoon_Forest_BG_02/Cartoon_Forest_BG_02.png";

    // Spawn
    public static final int xSpawn = 400;
    public static final int ySpawn = 2400;


    public ForestWorld() {
        super(WORLD_FILE_PATH, BACKGROUND_PATH);

        // Add Portals
        Portal portalToBase = new Portal(getWidth()* Tile.TILEWIDTH - 128 , getHeight()*Tile.TILEHEIGTH - 148,
                WorldManager.WorldKey.forestWorld, WorldManager.WorldKey.baseWorld,
                BaseWorld.xSpawn, BaseWorld.ySpawn);
        EntityManager.getInstance().addEntity(portalToBase);
    }

}
