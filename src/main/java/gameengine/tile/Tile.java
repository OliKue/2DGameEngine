package gameengine.tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    public static final int TILEWIDTH = 48, TILEHEIGTH = 48;

    protected BufferedImage texture;

    protected final int id;


    public Tile(int id) {
        this.id = id;
    }

    public void tick() {
    }

    public void render(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, null);
    }

    public boolean isSolid() {
        return true;
    }
}
