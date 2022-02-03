package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassPlattformTileRi extends Tile{
    public GrassPlattformTileRi(int id) {
        super(id);
        this.texture= Assets.getInstance().grassPlattformTileRight;
    }
}
