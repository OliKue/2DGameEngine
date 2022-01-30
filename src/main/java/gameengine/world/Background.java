package gameengine.world;

import gameengine.Game;
import gameengine.entities.EntityManager;
import gameengine.graphics.ImageLoader;
import gameengine.tile.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {

    private static Background OBJ = new Background();

    private Background() {
        this.background = ImageLoader.loadImage("/PNG/Backgrounds/Cartoon_Forest_BG_01/Cartoon_Forest_BG_01.png");
    }



    public static Background getInstance() {
        return OBJ;
    }


    private final BufferedImage background;
    private BufferedImage toDraw;

    public void tick() {
        calculateToDrawBackground();
    }

    private void calculateToDrawBackground() {
        float maxPixX = WorldManager.getInstance().getActiveWorld().getWidth() * Tile.TILEWIDTH;
        float maxPixY = WorldManager.getInstance().getActiveWorld().getHeight() * Tile.TILEHEIGTH;

        float playerX = EntityManager.getInstance().getPlayerHitboxXPos();
        float playerY = EntityManager.getInstance().getPlayerHitboxYPos();

        int xMid = (int) ((playerX / maxPixX) * (background.getWidth() - Game.width) + (Game.width / 2));
        int yMid = (int) ((playerY / maxPixY) * (background.getHeight() - Game.height) + (Game.height / 2));

        int x1 = xMid - Game.width / 2;
        int y1 = yMid - Game.height / 2;

        //Edges
        if(x1<0){
            x1=0;
        }
        if(x1+Game.width>background.getWidth()){
            x1 = background.getWidth()-Game.width;
        }
        if(y1<0){
            y1=0;
        }
        if(y1+Game.height>background.getHeight()){
            y1 = background.getHeight()-Game.height;
        }


        toDraw = background.getSubimage(x1, y1, Game.width, Game.height);

    }

    public void render(Graphics g) {
        g.drawImage(toDraw, 0, 0, null);
    }
}
