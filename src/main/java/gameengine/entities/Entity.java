package gameengine.entities;

import gameengine.tile.Tile;
import gameengine.world.World;

import java.awt.*;

public abstract class Entity {

    public static final int DEFAULT_HEALTH = 5;
    public static final float GRAVITY = 2f;

    protected float xPos, yPos;
    protected int width, height;
    protected Rectangle hitBox;
    protected int health;
    protected boolean active = true;


    public Entity(int xPos, int yPos, int width, int height) {
        health = DEFAULT_HEALTH;
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.hitBox = new Rectangle(xPos, yPos,width,height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public boolean checkEntityCollision(float xOffset, float yOffset){
        // TODO
        return false;}

        protected boolean collisionWithTile(int x, int y) {
        // Fehler?
        return World.getInstance().getTile(x / Tile.TILEWIDTH, y / Tile.TILEHEIGTH).isSolid();
    }

    public float getXPos() {
        return xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public float getYPos() {
        return yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Rectangle getHitBox() {
        return new Rectangle((int) (xPos+hitBox.x),(int) ( yPos+ hitBox.y), hitBox.width, hitBox.height);
    }

    public void setHitBox(Rectangle hitBox) {
        this.hitBox = hitBox;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
