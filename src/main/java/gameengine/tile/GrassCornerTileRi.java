package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassCornerTileRi extends Tile{
    public GrassCornerTileRi(int id) {
        super(id);
        this.texture= Assets.getInstance().grassCornerTileRight;
    }
}
