package gameengine.world.levels;

import gameengine.graphics.ImageLoader;
import gameengine.tile.Tile;
import gameengine.tile.TileHandler;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public abstract class  World {

    // File path
    private String worldFilePath;

    //Background path
    private String backgroundPath;
    private BufferedImage background;

    //World Info
    private int width;
    private int height;

    private int[][] tiles;

    public static int xSpawn, ySpawn;

    protected boolean isHostile=false;

    public World(String worldFilePath, String backgroundPath) {
        this.worldFilePath = worldFilePath;
        this.backgroundPath = backgroundPath;
        init();
    }

    public void init(){
        InputStream inputStream = World.class.getResourceAsStream(worldFilePath);
        loadWorld(inputStream);
        background = ImageLoader.loadImage(backgroundPath);


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

    protected void loadWorld(InputStream inputStream) {
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

    public BufferedImage getBackground() {
        return background;
    }

    public boolean isHostile() {
        return isHostile;
    }
}
