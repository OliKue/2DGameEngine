package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassTileRi extends Tile{
    public GrassTileRi(int id) {
        super(id);
        this.texture= Assets.getInstance().grassTileRight;
    }
}
