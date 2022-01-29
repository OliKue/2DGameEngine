package gameengine.graphics;

import gameengine.Game;
import gameengine.entities.Entity;
import gameengine.tile.Tile;
import gameengine.world.WorldManager;

import java.awt.*;

public class GameCamera {
    private static final GameCamera OBJ = new GameCamera();

    public int xOffset, yOffset;

    private GameCamera() {
        this.xOffset = 0;
        this.yOffset = 0;
    }

    public static GameCamera getInstance(){
        return OBJ;
    }

    public void centerOnEntity(Entity e){
        xOffset = (int) (e.getXPos() - Game.width /2 + e.getWidth());
        yOffset = (int) (e.getYPos() - Game.height *3/4 +e.getHeight());

//        System.out.println("Pla x|y: "+e.getX()+" | "+ e.getY());
//        System.out.println("Cam x|y: "+xOffset+" | "+ yOffset);

    }

    public void move(int xAmt, int yAmt){
        xOffset += xAmt;
        yOffset += yAmt;
    }

    public void tick() {
    }


    public void render(Graphics g) {
        // Renderbereich einschränken
        int xStart = (xOffset / Tile.TILEWIDTH) - 1;
        int xEnd = (xStart + Game.width / Tile.TILEWIDTH) + 3;

        int yStart = (yOffset / Tile.TILEHEIGTH) - 1;
        int yEnd = (yStart + Game.height / Tile.TILEHEIGTH) + 3;


        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {

                WorldManager.getInstance().getTile(x, y).render(g, x * Tile.TILEWIDTH- GameCamera.getInstance().xOffset, y * Tile.TILEHEIGTH-GameCamera.getInstance().yOffset);
            }
        }


    }

}
