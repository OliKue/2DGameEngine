package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassPlattformTileLe extends Tile{
    public GrassPlattformTileLe(int id) {
        super(id);
        this.texture= Assets.getInstance().grassPlattformTileLeft;
    }
}
