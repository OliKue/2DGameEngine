package gameengine.tile;

import gameengine.graphics.Assets;

public class DirtTileLe extends Tile{
    public DirtTileLe(int id) {
        super(id);
        this.texture= Assets.getInstance().tile55;
    }
}
