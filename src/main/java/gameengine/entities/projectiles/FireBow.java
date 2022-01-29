package gameengine.entities.projectiles;

import gameengine.entities.Creature;
import gameengine.entities.Entity;
import gameengine.entities.EntityManager;
import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.tile.Tile;

public class FireBow extends Projectile {

    private final Animation fire_flying = new Animation(100, Assets.getInstance().fire_flying);

    private boolean ending = false;
    private int ticksUntilInactive = 10;
    private int tickCount;
    private final Animation fire_end = new Animation(100, Assets.getInstance().fire_end);;


    public FireBow(int x, int y, boolean facingLeft) {
        super(x, y, 128, 128, facingLeft);

        this.animation = this.fire_flying;

        if (facingLeft) {
            this.xVel = -projectileSpeed;
        } else {
            this.xVel = projectileSpeed;
        }

        //Hitbox
        this.hitBox.x = 55;
        this.hitBox.width = 25;
        this.hitBox.y = 53;
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
        if (ending) {
            tickCount++;
            if (tickCount > ticksUntilInactive) {
                this.active = false;
            }
        }

        checkDmg();

    }

    private void checkDmg() {
        for (Entity e : EntityManager.getInstance().getEntities()) {
            if (e.equals(this)|| !(e instanceof Creature))
                continue;
            if (e.getHitBox().intersects(getHitBox())||getHitBox().intersects(e.getHitBox())) {
                ((Creature) e).applyDmg(dmg);
                this.dmg = 0;
                xVel = 0;
                this.animation = this.fire_end;
                ending=true;
            }
        }
    }

    public void moveX() {
        if (xVel > 0) {
            //Right
            int tx = (int) (xNextPos + hitBox.x + hitBox.width + 1);
            if (!isCollisionHorizontal(tx)) {
                xPos = xNextPos;
            } else {
                xPos = (tx / Tile.TILEWIDTH) * Tile.TILEWIDTH - hitBox.x - hitBox.width - 1;
                xVel = 0;
                this.animation = this.fire_end;
                ending = true;
            }

        } else if (xVel < 0) {
            //Left
            int tx = (int) (xNextPos + hitBox.x);

            if (!isCollisionHorizontal(tx)) {
                xPos = xNextPos;
            } else {
                xPos = (tx / Tile.TILEWIDTH) * Tile.TILEWIDTH + Tile.TILEWIDTH - hitBox.x + 1;
                xVel = 0;
                this.animation = this.fire_end;
                ending = true;
            }

        }

    }

}
