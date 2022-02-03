package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassCornerTileLe extends Tile{
    public GrassCornerTileLe(int id) {
        super(id);
        this.texture= Assets.getInstance().grassCornerTileLeft;
    }
}
