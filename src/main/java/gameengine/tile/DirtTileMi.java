package gameengine.tile;

import gameengine.graphics.Assets;

public class DirtTileMi extends Tile{
    public DirtTileMi(int id) {
        super(id);
        this.texture= Assets.getInstance().tile52;
    }
}
