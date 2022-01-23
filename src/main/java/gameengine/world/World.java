package gameengine.world;

import gameengine.tile.Tile;
import gameengine.tile.TileHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class World {

    private static final World OBJ = new World();

    private int width = 160;
    private int height = 9;

    private int[][] tiles;

    private World() {
        String path = World.class.getResource("/world.txt").getPath();
        loadWorld(path);
    }

    public static World getInstance() {
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

    private void loadWorld(String path) {
        String file = loadFileAsString(path);
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

    public static String loadFileAsString(String path) {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
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
