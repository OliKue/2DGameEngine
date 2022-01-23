package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassTileMi extends Tile{
    public GrassTileMi(int id) {
        super(id);
        this.texture= Assets.getInstance().tile32;
    }
}
