package gameengine.entities.projectiles;

import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.tile.Tile;

public class FireBow extends Projectile {

    private final Animation fire_flying;

    private boolean ending=false;
    private int ticksUntilInactive=10;
    private int tickCount;
    private final Animation fire_end;



    public FireBow(int x, int y, boolean facingLeft) {
        super(x, y, 128, 128);

        if(facingLeft) {
            this.fire_flying = new Animation(100, Assets.getInstance().fire_flying_left);
            this.fire_end = new Animation(100, Assets.getInstance().fire_end_left);
        }else{
            this.fire_flying = new Animation(100, Assets.getInstance().fire_flying_right);
            this.fire_end = new Animation(100, Assets.getInstance().fire_end_right);
        }
        this.animation = this.fire_flying;

        if(facingLeft) {
            this.xVel = -projectileSpeed;
        }else{
            this.xVel=projectileSpeed;
        }

        //Hitbox
        this.hitBox.x = 47;
        this.hitBox.width = 25;
        this.hitBox.y = 44;
        this.hitBox.height = 40;


    }
    @Override
    public void tick() {
        xNextPos = xPos + xVel;
        yNextPos = yPos + yVel;

        if (!checkEntityCollision(xNextPos, 0)) {
            moveX();
        }

        animation.tick();
        if(ending){
            tickCount++;
            if(tickCount>ticksUntilInactive){
                this.active=false;
            }
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
                this.animation = this.fire_end;
                ending=true;
            }

        } else if (xVel < 0) {
            //Left
            int tx = (int) (xNextPos + hitBox.x);

            if (!isCollisionHorizontal(tx)) {
                xPos = xNextPos;
            } else {
                xPos = (tx / Tile.TILEWIDTH)* Tile.TILEWIDTH + Tile.TILEWIDTH - hitBox.x +1;
                xVel = 0;
                this.animation = this.fire_end;
                ending=true;
            }

        }

    }

}