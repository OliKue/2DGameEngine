package gameengine.world;

import gameengine.entities.EntityManager;
import gameengine.entities.staticEntities.Portal;
import gameengine.tile.Tile;

import java.util.HashMap;
import java.util.Map;

public class WorldManager {

    private static final WorldManager OBJ = new WorldManager();

    private Map<WorldKey, World> worldMap = new HashMap<>();
    private WorldKey activeWorld = WorldKey.firstWorld;

    public enum WorldKey {
        firstWorld,
        secondWorld
    }

    private WorldManager() {
        World firstWorld = new World("/worlds/firstWorld.txt");
        worldMap.put(WorldKey.firstWorld, firstWorld);
        World secondWorld = new World("/worlds/secondWorld.txt");
        worldMap.put(WorldKey.secondWorld, secondWorld);

        Portal firstToSecond = new Portal(firstWorld.getWidth() * Tile.TILEWIDTH - 100, firstWorld.getHeight()* Tile.TILEHEIGTH - 60-48, WorldKey.firstWorld, WorldKey.secondWorld, 250, secondWorld.getHeight() * Tile.TILEHEIGTH - 200);
        EntityManager.getInstance().addEntity(firstToSecond);

        Portal secondToFirst = new Portal(secondWorld.getWidth() * Tile.TILEWIDTH - 100, secondWorld.getHeight()* Tile.TILEHEIGTH - 60-48, WorldKey.secondWorld, WorldKey.firstWorld, 250, firstWorld.getHeight() * Tile.TILEHEIGTH - 200);
        EntityManager.getInstance().addEntity(secondToFirst);
    }

    public static WorldManager getInstance() {
        return OBJ;
    }

    public Tile getTile(int x, int y) {
        return worldMap.get(activeWorld).getTile(x, y);
    }

    public World getActiveWorld() {
        return worldMap.get(activeWorld);
    }

    public WorldKey getActiveWorldKey() {
        return activeWorld;
    }

    public void changeWorld(WorldKey key) {
        activeWorld = key;
    }
}
