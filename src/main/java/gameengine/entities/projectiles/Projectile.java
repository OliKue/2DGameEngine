package gameengine.entities.projectiles;

import gameengine.Game;
import gameengine.entities.Creature;
import gameengine.entities.Entity;
import gameengine.graphics.Animation;
import gameengine.graphics.GameCamera;
import gameengine.tile.Tile;
import gameengine.world.WorldManager;

import java.awt.*;

public abstract class Projectile extends Entity {

    private final boolean facingLeft;
    protected float projectileSpeed=12f;

    protected Animation animation;
    protected int dmg = 10;

    protected float xAcc =0, yAcc =0;
    protected float xVel=0, yVel=0;
    protected float maxXVel=10,maxYVel=20;

    //Next Position
    protected float xNextPos, yNextPos;

    public Projectile(int x, int y, int width, int height, boolean facingLeft, WorldManager.WorldKey world) {
        super(x, y, width, height, world);
        this.facingLeft=facingLeft;
    }



    @Override
    public void render(Graphics g) {
        int x = (int) xPos - GameCamera.getInstance().xOffset;
        int y = (int) yPos - GameCamera.getInstance().yOffset;

        if (facingLeft) {
            g.drawImage(animation.getCurrentFrame(), x + width, y, -width, height, null);
        } else {
            g.drawImage(animation.getCurrentFrame(), x, y, width, height, null);
        }
        if(Game.DRAW_HITBOX){
            g.drawRect(x+hitBox.x,y+hitBox.y, hitBox.width,hitBox.height);
        }
    }

    protected boolean isCollisionVertical(int ty){
        boolean collision = false;
        for(int x = (int) (xPos + hitBox.x); x < xPos + hitBox.x + hitBox.width; x+= Tile.TILEWIDTH){
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

}
