package gameengine.world;

import gameengine.tile.Tile;
import gameengine.tile.TileHandler;

import java.io.*;

public class WorldManager {

    private static final WorldManager OBJ = new WorldManager();

    private int width = 160;
    private int height = 9;

    private int[][] tiles;

    private WorldManager() {
        InputStream inputStream = WorldManager.class.getResourceAsStream("/worlds/world.txt");
        loadWorld(inputStream);
    }

    public static WorldManager getInstance() {
        return OBJ;
    }


    public Tile getTile(int x, int y) {

        if (x < 0 || x >= width) {
            return TileHandler.getInstance().dirtTileMi;
        }
        if (y < 0 || y >= height) {
            return TileHandler.getInstance().dirtTileMi;
        }

        Tile t = TileHandler.getInstance().tiles[tiles[x][y]];
        if (t == null) {
            //TODO: Throw Error
            return TileHandler.getInstance().airTile;
        } else {
            return t;
        }

    }

    private void loadWorld(InputStream inputStream) {
        String file = loadFileAsString(inputStream);
        String[] tokens = file.split("\\s+");
        width = Integer.parseInt(tokens[0]);
        height = Integer.parseInt(tokens[1]);
        tiles= new int[width][height];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Integer.parseInt(tokens[2+(x + y * width)]);
            }
        }
    }

    public static String loadFileAsString(InputStream inputStream) {
        StringBuilder builder = new StringBuilder();

        try {
            InputStreamReader inStreamReader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(inStreamReader);
            String line;

            while ((line = br.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return builder.toString();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
