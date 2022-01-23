package gameengine.tile;

import gameengine.graphics.Assets;

public class GrassTileLe extends Tile{
    public GrassTileLe(int id) {
        super(id);
        this.texture= Assets.getInstance().tile31;
    }
}
