package gameengine.tile;

public class TileHandler {

    private static TileHandler OBJ = new TileHandler();

    public Tile[] tiles = new Tile[256];

    public Tile airTile;

    public Tile grassTileLe;
    public Tile grassTileMi;
    public Tile grassTileRi;

    public Tile dirtTileLe;
    public Tile dirtTileMi;
    public Tile dirtTileRi;

    public TileHandler() {
        initTiles();
    }

    public static TileHandler getInstance(){
        return OBJ;
    }

    private void initTiles() {
        airTile = new AirTile(0);
        tiles[0] = airTile;
        grassTileLe = new GrassTileLe(1);
        tiles[1] = grassTileLe;
        grassTileMi = new GrassTileMi(2);
        tiles[2] = grassTileMi;
        grassTileRi = new GrassTileRi(3);
        tiles[3] = grassTileRi;

        dirtTileLe = new DirtTileLe(4);
        tiles[4] = dirtTileLe;
        dirtTileMi = new DirtTileMi(5);
        tiles[5] = dirtTileMi;
        dirtTileRi = new DirtTileRi(6);
        tiles[6] = dirtTileRi;
    }
}
