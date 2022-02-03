package gameengine.tile;

import gameengine.graphics.Assets;

public class DirtTileRi extends Tile{
    public DirtTileRi(int id) {
        super(id);
        this.texture= Assets.getInstance().dirtTileRight;
    }
}
