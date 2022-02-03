package gameengine.world;

import gameengine.tile.Tile;
import gameengine.world.levels.BaseWorld;
import gameengine.world.levels.World;

import java.util.HashMap;
import java.util.Map;

public class WorldManager {

    private static final WorldManager OBJ = new WorldManager();

    private Map<WorldKey, World> worldMap = new HashMap<>();
    private WorldKey activeWorld = WorldKey.baseWorld;

    public enum WorldKey {
        baseWorld,
    }

    private WorldManager() {
        World baseWorld = new BaseWorld();
        worldMap.put(WorldKey.baseWorld, baseWorld);

    }
    public void changeWorld(WorldKey key) {
        activeWorld = key;
        BackgroundManager.getInstance().setBackground(getActiveWorld().getBackground());
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


}
