package gameengine.tile;

import gameengine.graphics.Assets;

public class AirTile extends Tile{
    public AirTile(int id) {
        super(id);
        this.texture= Assets.getInstance().tile12;
    }

    @Override
    public boolean isSolid() {
        return false;
    }
}
