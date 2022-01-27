package gameengine.entities;

import gameengine.tile.Tile;
import gameengine.world.World;

public abstract class Creature extends Entity {

    public static final int DEFAULT_CREATURE_WIDTH = 48;
    public static final int DEFAULT_CREATURE_HEIGHT = 48;


    //Movement
    protected float xAcc =3, yAcc =3;
    protected float xVel, yVel;
    protected float maxXVel=10,maxYVel=20;

    //Jumping
    protected boolean jumping=false;
    protected int jumpDelay=10;
    protected int jumpDelayTicks=0;
    //Falling
    protected boolean falling=true;

    //Next Position
    protected float xNextPos, yNextPos;


    public Creature(int x, int y, int width, int height) {
        super(x, y, width, height);

    }

    public void moveToNextPos() {
        if (!checkEntityCollision(xNextPos, 0)) {
            moveX();
        }
        if (!checkEntityCollision(0, yNextPos)) {
            moveY();
        }

    }

    public void moveX() {
        if (xVel > 0) {
            //Right
            int tx = (int) ( xNextPos + hitBox.x + hitBox.width+1);
            if (!isCollisionHorizontal(tx)) {
                xPos = xNextPos;
            } else {
                xPos = (tx / Tile.TILEWIDTH)* Tile.TILEWIDTH - hitBox.x - hitBox.width - 1;
                xVel = 0;
            }

        } else if (xVel < 0) {
            //Left
            int tx = (int) (xNextPos + hitBox.x);

            if (!isCollisionHorizontal(tx)) {
                xPos = xNextPos;
            } else {
                xPos = (tx / Tile.TILEWIDTH)* Tile.TILEWIDTH + Tile.TILEWIDTH - hitBox.x +1;
                xVel = 0;
            }

        }

    }

    public void moveY() {
        if (yVel >= 0) {
            //Down
            int ty = (int) ( yNextPos + hitBox.y + hitBox.height);
            if (!isCollisionVertical(ty)) {
                yPos = yNextPos;
            }else {
                yPos = (ty/Tile.TILEHEIGTH) * Tile.TILEHEIGTH - hitBox.y - hitBox.height - 1;
                yVel=0;
            }


        } else if (yVel < 0) {
            //UP
            int ty = (int) ( yNextPos + hitBox.y);
            if (!isCollisionVertical(ty)) {
                yPos= yNextPos;
            }else {
                yPos = (ty/Tile.TILEHEIGTH) * Tile.TILEHEIGTH + Tile.TILEHEIGTH - hitBox.y;
                yVel=0;
            }
        }
    }

    protected boolean isCollisionVertical(int ty){
        boolean collision = false;
        for(int x = (int) (xPos + hitBox.x); x < xPos + hitBox.x + hitBox.width; x+=Tile.TILEWIDTH){
            collision = collision || collisionWithTile(x, ty);
        }
        collision = collision || collisionWithTile((int) (xPos + hitBox.x + hitBox.width), ty);

        return collision;
    }
    protected boolean isCollisionHorizontal(int tx){
        boolean collision = false;
        for(int y = (int) (yPos + hitBox.y); y < yPos + hitBox.y + hitBox.height; y+=Tile.TILEHEIGTH){
            collision = collision || collisionWithTile(tx, y);
        }
        collision = collision || collisionWithTile(tx, (int) (yPos + hitBox.y + hitBox.height));

        return collision;
    }

    protected boolean collisionWithTile(int x, int y) {
        // Fehler?
        return World.getInstance().getTile(x / Tile.TILEWIDTH, y / Tile.TILEHEIGTH).isSolid();
    }



    protected void slowDownX(){
        if((xVel >=0 && xVel <=0.2 )||(xVel <=0 && xVel >=-0.2)){
            xVel =0;
        }else{
            xVel = xVel /1.3f;
        }
    }
}
