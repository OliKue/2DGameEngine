package gameengine.entities.enemies;

import gameengine.Game;
import gameengine.entities.Creature;
import gameengine.graphics.Animation;
import gameengine.graphics.Assets;
import gameengine.graphics.GameCamera;

import java.awt.*;
import java.util.ArrayList;

public class Wraith extends Creature {

    private ArrayList<Animation> animations = new ArrayList<>();

    private final Animation animation_idle = new Animation(150, Assets.getInstance().wraith_01_idle);
    private final Animation animation_run = new Animation(100, Assets.getInstance().wraith_01_walk);
    private final Animation animation_attack = new Animation(100, Assets.getInstance().wraith_01_attack);

    private boolean ending = false;
    private int ticksUntilInactive = 50;
    private int tickCount;
    private final Animation animation_dying = new Animation(50, Assets.getInstance().wraith_01_dying);

    private Animation animation = animation_idle;

    private boolean facingLeft = false;

    public Wraith(int x, int y) {
        super(x, y, 130, 105);

        //Hitbox
        this.hitBox.x = 36;
        this.hitBox.width = 50;
        this.hitBox.y = 10;
        this.hitBox.height = 73;

        //Velocity
        this.xAcc = 0.5f;
        this.maxXVel = 10;

        this.yAcc = 0.5f;
        this.maxYVel = 20;

        //Add animations
        animations.add(animation_idle);
        animations.add(animation_run);
        animations.add(animation_dying);
        animations.add(animation_attack);

        // change Life
        this.life = 30;


    }

    @Override
    public void tick() {

        xNextPos = xPos + xVel;
        yNextPos = yPos + yVel;

        moveToNextPos();


        // Animation
        updateAnimation();


        if (ending) {
            tickCount++;
            if (tickCount > ticksUntilInactive) {
                this.active = false;
            }
        }

    }

    private void updateAnimation() {
        if (ending) {
            animation = animation_dying;
        } else if (xVel > xAcc || xVel < -xAcc) {
            animation = animation_run;
        } else {
            animation = animation_idle;
        }


        animation.tick();

        //Reset inactive
        for (Animation a : animations) {
            if (!(a == animation)) {
                a.reset();
            }
        }

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

        if (Game.DRAW_HITBOX) {
            g.drawRect(x + hitBox.x, y + hitBox.y, hitBox.width, hitBox.height);
        }
    }

    @Override
    public void die() {
        ending = true;
            }
}
