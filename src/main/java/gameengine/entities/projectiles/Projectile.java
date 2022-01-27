package gameengine.entities.projectiles;

import gameengine.entities.Creature;
import gameengine.graphics.Animation;
import gameengine.graphics.GameCamera;

import java.awt.*;

public abstract class Projectile extends Creature {

    protected float projectileSpeed=12f;

    protected Animation animation;

    public Projectile(int x, int y, int width, int height) {
        super(x, y, width, height);
    }



    @Override
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), (int) xPos - GameCamera.getInstance().xOffset, (int) yPos - GameCamera.getInstance().yOffset, null);
    }

}
